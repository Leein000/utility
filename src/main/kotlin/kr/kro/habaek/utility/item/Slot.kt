package kr.kro.habaek.utility.item

import org.bukkit.inventory.ItemStack

class Slot(line: Int, number: Int, val item: ItemStack) {
    val get = line * 9 + number
}