package kr.kro.habaek.utility.scheduler.objectes.later

import kr.kro.habaek.utility.scheduler.objectes.interfaces.RunTask
import org.bukkit.inventory.Inventory

class RunLater(override val runnable: Runnable, override val delay: Long): RunTask