package github.gilbertokpl.essentialsk.data.objects

import github.gilbertokpl.essentialsk.EssentialsK
import github.gilbertokpl.essentialsk.configs.GeneralLang
import github.gilbertokpl.essentialsk.util.FileLoggerUtil
import github.gilbertokpl.essentialsk.util.TaskUtil
import org.apache.commons.lang3.exception.ExceptionUtils
import org.bukkit.entity.Player
import java.util.concurrent.CompletableFuture
import java.util.concurrent.TimeUnit

data class TpaData(
    val p: Player,
    var otherPlayer: Player?,
    var wait: Boolean
) {
    companion object {
        private val tpaData = HashMap<Player, TpaData>()

        operator fun get(p: Player) = tpaData[p]

        fun remove(p: Player) {
            tpaData.remove(p)
        }

        fun checkTpa(p: Player): Boolean {
            return tpaData.contains(p)
        }

        fun checkOtherTpa(p: Player): Boolean {
            for (i in tpaData) {
                if (i.value.otherPlayer == p) {
                    return true
                }
            }
            return false
        }

        fun getTpa(p: Player): Player? {
            for (i in tpaData) {
                if (i.value.otherPlayer == p) {
                    return i.key
                }
            }
            return null
        }

        fun createNewTpa(pSender: Player, pReceived: Player, time: Int) {

            tpaData[pSender] = TpaData(pSender, pReceived, true)

            CompletableFuture.runAsync({
                TimeUnit.SECONDS.sleep(time.toLong())
                try {
                    val sender = tpaData[pSender] ?: return@runAsync
                    if (sender.wait) {
                        EssentialsK.instance.server.scheduler.runTask(EssentialsK.instance, Runnable {
                            pSender.sendMessage(GeneralLang.tpaRequestOtherDenyTime.replace("%player%", pReceived.name))
                        })
                        tpaData.remove(pSender)
                    }
                } catch (ex: Exception) {
                    FileLoggerUtil.logError(ExceptionUtils.getStackTrace(ex))
                    tpaData.remove(pSender)
                }
            }, TaskUtil.getTeleportExecutor())
        }

    }
}