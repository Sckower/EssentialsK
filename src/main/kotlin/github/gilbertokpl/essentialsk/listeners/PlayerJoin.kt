package github.gilbertokpl.essentialsk.listeners

import github.gilbertokpl.essentialsk.configs.MainConfig
import github.gilbertokpl.essentialsk.data.objects.PlayerDataV2
import github.gilbertokpl.essentialsk.util.FileLoggerUtil
import github.gilbertokpl.essentialsk.util.ReflectUtil
import org.apache.commons.lang3.exception.ExceptionUtils
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class PlayerJoin : Listener {
    @EventHandler(priority = EventPriority.HIGH)
    fun event(e: PlayerJoinEvent) {
        e.joinMessage = null

        try {
            PlayerDataV2.loadCache(e)
        } catch (e: Throwable) {
            FileLoggerUtil.logError(ExceptionUtils.getStackTrace(e))
        }

        if (MainConfig.vanishActivated) {
            try {
                vanishLoginEvent(e)
            } catch (e: Throwable) {
                FileLoggerUtil.logError(ExceptionUtils.getStackTrace(e))
            }
        }
    }

    private fun vanishLoginEvent(e: PlayerJoinEvent) {
        if (e.player.hasPermission("essentialsk.commands.vanish") ||
            e.player.hasPermission("essentialsk.bypass.vanish")
        ) return
        for (it in ReflectUtil.getPlayers()) {
            if (PlayerDataV2[it]?.vanishCache ?: continue) {
                @Suppress("DEPRECATION")
                e.player.hidePlayer(it)
            }
        }
    }
}
