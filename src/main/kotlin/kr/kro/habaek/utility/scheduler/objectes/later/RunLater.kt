package kr.kro.habaek.utility.scheduler.objectes.later

import kr.kro.habaek.utility.scheduler.objectes.interfaces.RunTask

class RunLater(override val runnable: Runnable, override val delay: Long): RunTask