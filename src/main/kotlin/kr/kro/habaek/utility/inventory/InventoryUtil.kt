package kr.kro.habaek.utility.inventory

import kr.kro.habaek.utility.item.isSameItem
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.PlayerInventory
import org.bukkit.inventory.Inventory

fun Inventory.getEmptySlot() : Int{
    val size = if (this is PlayerInventory) 9 * 4
    else this.size
    var empty = 0
    for (slot in 0 until size) if (getItem(slot) == null) ++empty
    return empty
}

fun Inventory.hasSameItem(item: ItemStack) : Boolean {
    for (slot in this) {
        if (slot == null) continue
        if (slot.isSameItem(item)) return true
    }
    return false
}

fun Inventory.getNotFullStackItemSlot(item: ItemStack) : List<Int> {
    val list = mutableListOf<Int>()
    if (item.maxStackSize <= 1) return list
    if (!this.hasSameItem(item)) return list
    for (slot in 0 until this.size) {
        val i = this.getItem(slot) ?: continue
        if (!i.isSameItem(item)) continue
        if (i.maxStackSize == i.amount) continue
        list.add(slot)
    }
    return list
}
fun Inventory.howManyToAdd(item: ItemStack): Int {
    val maxStack = item.maxStackSize
    var empty = maxStack * this.getEmptySlot()
    if (maxStack == 1) return empty
    val list = this.getNotFullStackItemSlot(item)
    if (list.isEmpty()) return empty
    for (slot in list) {
        val i = this.getItem(slot) ?: continue
        if (i.amount == maxStack) continue
        empty += maxStack - i.amount
    }
    return empty
}
fun Inventory.howManyHasSameItem(item: ItemStack) : Int {
    var has = 0
    for (i in this) {
        i ?: continue
        if (i.isSameItem(item)) has += i.amount
    }
    return has
}