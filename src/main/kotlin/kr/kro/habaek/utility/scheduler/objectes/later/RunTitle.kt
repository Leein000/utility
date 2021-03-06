package kr.kro.habaek.utility.scheduler.objectes.later

import kr.kro.habaek.utility.scheduler.objectes.interfaces.RunTask
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.scheduler.BukkitTask
import org.bukkit.inventory.Inventory

class RunTitle(players: Collection<Player>, val title: String, val subtitle: String, val fadeIn: Int, val stay: Int, val fadeOut: Int, val wait: Int):
    RunTask {
    override val runnable : Runnable = Runnable { for (p in players) p.sendTitle(title, subtitle, fadeIn, stay, fadeOut) }
    override val delay: Long = (fadeIn + stay + fadeOut + wait).toLong()

    override fun run(pl: JavaPlugin, delay: Long): BukkitTask {
        return Bukkit.getScheduler().runTaskLater(pl, runnable, delay - this.delay)
    }
}