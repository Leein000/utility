package kr.kro.habaek.utility.scheduler.objectes.interfaces

import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.scheduler.BukkitTask
import org.bukkit.inventory.Inventory

interface RunTask {
    val runnable : Runnable
    val delay : Long

    fun run(pl: JavaPlugin, delay: Long): BukkitTask {
        return Bukkit.getScheduler().runTaskLater(pl, runnable, delay)
    }
}