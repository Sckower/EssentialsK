package github.gilbertokpl.essentialsk.loops

import github.gilbertokpl.essentialsk.configs.OtherConfig
import github.gilbertokpl.essentialsk.util.PlayerUtil
import github.gilbertokpl.essentialsk.util.ReflectUtil
import github.gilbertokpl.essentialsk.util.TaskUtil
import java.util.concurrent.TimeUnit

object Announcements {

    private var maxValue = 0

    private var locValues = 1

    fun start(values: Int, time: Int) {
        maxValue = values
        locValues = 1

        TaskUtil.getAnnounceExecutor().scheduleWithFixedDelay({

            val online = PlayerUtil.getIntOnlinePlayers(false)

            ReflectUtil.getPlayers().forEach {
                it.sendMessage(
                    OtherConfig.announcementsListAnnounce[locValues]!!.replace(
                        "%players_online%",
                        online.toString()
                    )
                )
            }
            if (locValues == maxValue) {
                locValues = 1
            } else {
                locValues += 1
            }
        }, time.toLong(), time.toLong(), TimeUnit.MINUTES)
    }
}
