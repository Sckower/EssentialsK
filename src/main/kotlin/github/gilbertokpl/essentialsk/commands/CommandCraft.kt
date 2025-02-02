package github.gilbertokpl.essentialsk.commands

import github.gilbertokpl.essentialsk.configs.MainConfig
import github.gilbertokpl.essentialsk.manager.CommandCreator
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class CommandCraft : CommandCreator {
    override val active: Boolean = MainConfig.craftActivated
    override val consoleCanUse: Boolean = false
    override val commandName = "craft"
    override val timeCoolDown: Long? = null
    override val permission: String = "essentialsk.commands.craft"
    override val minimumSize = 0
    override val maximumSize = 0
    override val commandUsage = listOf("/craft")

    override fun funCommand(s: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        (s as Player).openWorkbench(s.location, true)
        return false
    }
}
