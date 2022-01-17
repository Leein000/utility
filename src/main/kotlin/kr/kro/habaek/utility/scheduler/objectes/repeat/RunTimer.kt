package kr.kro.habaek.utility.scheduler.objectes.repeat

import kr.kro.habaek.utility.scheduler.objectes.interfaces.RunRepeat
import org.bukkit.inventory.Inventory

class RunTimer(override val runnable: Runnable, override val delay: Long, override val period: Long, override val key: String):
    RunRepeat {
}