package kr.kro.habaek.utility.scheduler

import kr.kro.habaek.utility.scheduler.objectes.interfaces.RunRepeat
import kr.kro.habaek.utility.scheduler.objectes.interfaces.RunTask
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.scheduler.BukkitTask

class Scheduler(val pl: JavaPlugin) {
    private val runTasks = mutableListOf<RunTask>()
    private val repeats = hashMapOf<String, BukkitTask>()
    private val fields = hashMapOf<String, Any?>()

    fun play(){
        if (runTasks.isEmpty()) return
        var time = 0L
        for (runTask in runTasks) {
            time += runTask.delay
            if (runTask is RunRepeat) repeats[runTask.key] = runTask.run(pl, time)
            else runTask.run(pl,time)
        }
    }
    fun addRun(runTask : RunTask) {
        runTasks.add(runTask)
    }
    fun getRepeats(key: String) : BukkitTask? {
        return repeats[key]
    }
    fun cancelRepeats(key: String): Boolean {
        repeats[key]?.cancel() ?: return false
        repeats.remove(key)
        return true
    }
    fun <T> getField(key: String): T {
        return fields[key] as T
    }

    fun addField(key: String, any: Any?) {
        fields[key] = any
    }
    fun removeField(key: String) {
        fields.remove(key)
    }
}