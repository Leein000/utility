package kr.kro.habaek.utility.scheduler.objectes.now

import kr.kro.habaek.utility.scheduler.objectes.interfaces.RunTask

class RunNow(override val runnable: Runnable) : RunTask {
    override val delay = 0L
}