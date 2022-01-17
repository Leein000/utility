package kr.kro.habaek.utility.time

import kr.kro.habaek.utility.string.remove
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.scheduler.BukkitTask
import org.bukkit.inventory.Inventory

class Time(val pl: JavaPlugin) {
    var day = 0
    var hour = 0
    var min = 0
    var sec = 0
    var tick = 0

    var task: BukkitTask? = null

    init {
        overflowCheck()
    }

    fun startStopwatch(): Boolean {
        if (task != null) return false
        overflowCheck()
        task = Bukkit.getScheduler().runTaskTimer(pl, Runnable {
            ++tick
            if (tick <= 20) return@Runnable
            tick = 0

            ++sec
            if (sec <= 60) return@Runnable
            sec = 0

            ++min
            if (min <= 60) return@Runnable
            min = 0

            ++hour
            if (hour <= 24) return@Runnable
            hour = 0

            ++day
        }, 0, 1)
        return true
    }

    fun startTimer(): Boolean {
        if (task != null) return false
        overflowCheck()
        task = Bukkit.getScheduler().runTaskTimer(pl, Runnable {
            if (day == 0 && hour == 0 && min == 0 && sec == 0 && tick == 0) {
                pause()
                return@Runnable
            }
            --tick
            if (tick >= 0) return@Runnable
            tick = 19

            --sec
            if (sec >= 0) return@Runnable
            sec = 59

            --min
            if (min >= 0) return@Runnable
            min = 59

            --hour
            if (hour >= 0) return@Runnable
            hour = 23

            --day
        }, 0, 1)
        return true
    }

    fun pause(): Boolean {
        task?.cancel() ?: return false
        task = null
        return true
    }

    fun clear(): Boolean {
        if (task != null) return false
        day = 0
        hour = 0
        min = 0
        sec = 0
        tick = 0
        return true
    }

    override fun toString(): String {
        if (day > 0) {
            if (tick % 2 == 0) return "$day D $ hour H $ min M $sec.${(tick / 20.0).toString().remove("0.")}0 $"
            return "$day D $hour H $min M $sec.${(tick / 20.0).toString().remove("0.")} s"
        }
        if (hour > 0) {
            if (tick % 2 == 0) return "$hour H $min M $sec.${(tick / 20.0).toString().remove("0.")}0 S"
            return "$hour H $min M $sec.${(tick / 20.0).toString().remove("0.")}0 S"
        }
        if (tick % 2 == 0) return "$min M $sec.${(tick / 20.0).toString().remove("0.")}0 S"
        return "$min M $sec.${(tick / 20.0).toString().remove("0.")}0 S"
    }
    fun toDay(): Double {
        return day + (hour / 24.0) + (min / (24.0 * 60)) + (sec / (24.0 * 60 * 60)) + (tick / (24 * 60 * 60 * 20))
    }
    fun toHour(): Double {
        return (day * 24) + hour + (min / 60) + (sec / (60.0 * 60)) + (tick / (60.0 * 60 * 20))
    }
    fun toMin(): Double {
        return (day * 24 * 60) + (hour * 60) + min + (sec /60.0) + (tick / (60.0 * 60 * 20))
    fun toSec(): Double {
        return (day * 24 * 60 * 60) + (hour * 60 * 60) + (min * 60) + sec + (tick / 20.0)
    }
    fun toTick(): Int {
        return (day * 24 * 60 * 60 * 20) + (hour * 60 * 60 * 20) + (min * 60 * 20) + (sec * 20) + tick
    }
    fun  setByDay(int: Int): Boolean {
    if (int < 0) return false
    day = int
    return true
    }
    fun setByHour(int : Int): Boolean {
        if (int < 0) return false
        hour = int
        overflowCheck()
        return true
    }
    fun setByMin(int : Int): Boolean {
        if (int < 0) return false
        min = int
        overflowCheck()
        return true
    }
    fun setBySec(int :Int) : Boolean {
        if (int < 0) return false
        sec = int
        overflowCheck()
        return true
    }
    fun setByTick(int : Int): Boolean {
        if (int <0) return false
        tick = int
        overflowCheck()
        return true
    }
    fun addDay(int : Int) : Boolean {
        if (int <= 0) return false
        day += int
        return true
    }
    fun addHour(int : Int) : Boolean {
        if (int <= 0) return false
        hour += int
        overflowCheck()
        return true
    }
    fun addMin(int : Int) : Boolean {
        if (int <= 0) return false
        min += int
        overflowCheck()
        return true
    }
    fun addSec(int : Int) : Boolean {
        if (int <= 0) return false
        sec += int
        overflowCheck()
        return true
    }
    fun addTick(int : Int) : Boolean {
        if (int <= 0) return false
        tick += int
        overflowCheck()
        return true
    }
    fun subDay(int : Int) : Boolean {
        if (int <= 0) return false
        day -= int
        if (day < 0) day = 0
        return true
    }
    fun subHour(int : Int): Boolean {
        if (int <= 0) return false
        day -= int
        if (int <= 0) hour = 0
        overflowCheck()
        return true
    }
    fun subMin(int : Int) : Boolean {
        if (int <= 0) return false
        min -= int
        if (min < 0) min = 0
        overflowCheck()
        return true
    }
    fun subSec(int : Int) : Boolean {
        if (int <= 0) return false
        sec -= int
        if (sec < 0) sec = 0
        overflowCheck()
        return true
    }
    fun subTick(int : Int) : Boolean {
        if (int <= 0) return false
        tick -= int
        if (tick < 0) tick = 0
        overflowCheck()
        return true
    }
    fun overflowCheck(){
        if (tick >= 20) {
            sec += tick / 20
            tick %= 20
        } else if (tick < 0) tick = 0
        if (sec >= 60) {
            min += sec / 60
            sec %= 60
        } else if (sec < 0) sec = 0
        if (min >= 60) {
            hour += min / 60
            min %= 60
        } else if (min < 0) min = 0
        if (hour >= 24) {
            day += hour / 24
            hour %= 24
        } else if (hour < 0) hour = 0
        if (day < 0) day = 0
    }
}