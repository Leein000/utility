package kr.kro.habaek.utility.number

import java.text.DecimalFormat
import kotlin.math.pow
import kotlin.random.Random
import org.bukkit.inventory.Inventory

fun Long.addComma(): String {
    return DecimalFormat("###,###").format(this)
}

fun Double.percent(): Boolean {
    if (this <= 0) return false
    if (this >= 1) return true
    val split = toString().split('.').last()
    val length = split.length.toDouble()
    val tureInt = split.toInt()
    val maxInt = 10.0.pow(length).toInt()
    val randomInt = Random.nextInt(maxInt)
    if (randomInt < tureInt) return true
    return false
}