package github.gilbertokpl.essentialsk.listeners

import github.gilbertokpl.essentialsk.configs.GeneralLang
import github.gilbertokpl.essentialsk.configs.MainConfig
import github.gilbertokpl.essentialsk.util.FileLoggerUtil
import org.apache.commons.lang3.exception.ExceptionUtils
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerPortalEvent

class PlayerPortal : Listener {
    @EventHandler
    fun event(e: PlayerPortalEvent) {
        if (MainConfig.antibugsBlockPlayerTeleportPortal) {
            try {
                blockPlayerTeleport(e)
            } catch (e: Throwable) {
                FileLoggerUtil.logError(ExceptionUtils.getStackTrace(e))
            }
        }
    }

    private fun blockPlayerTeleport(e: PlayerPortalEvent) {
        if (!e.player.hasPermission("essentialsk.bypass.teleportportal")) {
            e.player.sendMessage(GeneralLang.generalNotPermAction)
            e.isCancelled = true
        }
    }
}