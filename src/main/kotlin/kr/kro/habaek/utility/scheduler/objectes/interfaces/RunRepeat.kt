package kr.kro.habaek.utility.scheduler.objectes.interfaces

import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.scheduler.BukkitTask
import org.bukkit.inventory.Inventory

interface RunRepeat : RunTask {
    val period : Long
    val key : String

    override fun run(pl: JavaPlugin, delay: Long): BukkitTask {
        return Bukkit.getScheduler().runTaskTimer(pl, runnable, delay, period)
    }
}