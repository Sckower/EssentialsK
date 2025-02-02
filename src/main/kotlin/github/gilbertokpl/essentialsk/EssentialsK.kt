package github.gilbertokpl.essentialsk

import github.gilbertokpl.essentialsk.manager.EColor
import github.gilbertokpl.essentialsk.util.*
import github.slimjar.app.builder.ApplicationBuilder
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import java.io.File
import java.time.Duration
import java.time.Instant
import java.util.concurrent.CompletableFuture

class EssentialsK : JavaPlugin() {

    override fun onLoad() {

        val startInstant = Instant.now()
        println(
            "${EColor.CYAN.color}[${name}]${EColor.RESET.color} " +
                    "${EColor.YELLOW.color}Carregando Livrarias, porfavor aguarde, primeira vez pode demorar até 1 minuto...${EColor.RESET.color}"
        )

        ApplicationBuilder.appending("essentialsK").downloadDirectoryPath(
            File(this.dataFolder.path, "lib").toPath()
        ).build()

        instance = this

        val timeTakenMillis = Duration.between(startInstant, Instant.now()).toMillis()
        println(
            "${EColor.CYAN.color}[${name}]${EColor.RESET.color} " +
                    "${EColor.YELLOW.color}Livraria carregada em ${timeTakenMillis / 1000} segundos${EColor.RESET.color}"
        )

        super.onLoad()
    }

    override fun onEnable() {

        ManifestUtil.start()

        if (VersionUtil.check()) return

        MainUtil.startMetrics()

        ConfigUtil.start()

        SqlUtil.startSql()

        SqlUtil.startTables()

        MainUtil.startCommands()

        MaterialUtil.startMaterials()

        MainUtil.startInventories()

        MainUtil.startEvents()

        if (Bukkit.getBukkitVersion().contains("1.5.2") || Bukkit.getVersion().contains("1.5.2")) {
            lowVersion = true
        }

        TimeUtil.start()

        CompletableFuture.runAsync {
            DiscordUtil.startBot()
        }

        super.onEnable()
    }

    override fun onDisable() {

        TaskUtil.disable()

        DiscordUtil.jda = null

        super.onDisable()
    }

    companion object {
        lateinit var instance: EssentialsK
        var lowVersion = false
    }
}
