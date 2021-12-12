package github.gilbertokpl.essentialsk.util

import github.gilbertokpl.essentialsk.EssentialsK
import github.gilbertokpl.essentialsk.manager.IInstance
import org.apache.commons.lang3.exception.ExceptionUtils
import java.util.concurrent.CompletableFuture
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit


class TaskUtil {

    internal val asyncExecutor = asyncFuture()

    internal val commandExecutor = commandExecutor()

    private val poolExecutor = Executors.newCachedThreadPool()

    private val poolExecutorTeleport = Executors.newCachedThreadPool()

    private val poolExecutorCoolDown = Executors.newCachedThreadPool()

    fun disable() {
        poolExecutor.shutdown()
    }

    fun getExecutor(): ExecutorService {
        return poolExecutor
    }

    fun coolDownExecutor(time: Int): (() -> Unit) -> Unit {
        return {
            CompletableFuture.runAsync({
                TimeUnit.SECONDS.sleep(time.toLong())
                try {
                    it()
                } catch (ex: Exception) {
                    FileLoggerUtil.getInstance().logError(ExceptionUtils.getStackTrace(ex))
                }
            }, poolExecutorCoolDown)
        }
    }

    fun teleportExecutor(time: Int): (() -> Unit) -> Unit {
        return {
            CompletableFuture.runAsync({
                TimeUnit.SECONDS.sleep(time.toLong())
                try {
                    EssentialsK.instance.server.scheduler.runTask(EssentialsK.instance, Runnable { it() })
                } catch (ex: Exception) {
                    FileLoggerUtil.getInstance().logError(ExceptionUtils.getStackTrace(ex))
                }
            }, poolExecutorTeleport)
        }
    }

    private fun commandExecutor(): (() -> Unit) -> Unit {
        return {
            try {
                it()
            } catch (ex: Exception) {
                FileLoggerUtil.getInstance().logError(ExceptionUtils.getStackTrace(ex))
            }
        }
    }

    private fun asyncFuture(): (() -> Unit) -> Unit {
        return {
            CompletableFuture.runAsync({
                try {
                    it()
                } catch (ex: Exception) {
                    FileLoggerUtil.getInstance().logError(ExceptionUtils.getStackTrace(ex))
                }
            }, poolExecutor)
        }
    }

    companion object : IInstance<TaskUtil> {
        private val instance = createInstance()
        override fun createInstance(): TaskUtil = TaskUtil()
        override fun getInstance(): TaskUtil {
            return instance
        }
    }
}