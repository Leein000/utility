package kr.kro.habaek.utility.bool

import org.bukkit.inventory.Inventory

fun Boolean.addScript(script: String): BooleanScript {
    return BooleanScript(this, script)
}
fun Boolean.addScript(): BooleanScript {
    return BooleanScript(this, "")
}