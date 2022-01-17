package kr.kro.habaek.utility.item

import org.bukkit.inventory.ItemStack
import kr.kro.habaek.utility.material.item
import org.bukkit.inventory.ItemFlag

fun ItemStack.disPlay(): String {
    val meta = this.itemMeta
        if (meta!!.hasDisplayName()) return meta.displayName
        return type.name
    }

fun ItemStack.display(display: String): ItemStack {
    val meta = this.itemMeta
    meta!!.setDisplayName("§f$display")
    this.itemMeta = meta
    return this
}

fun ItemStack.clearDisplay(): ItemStack {
    val meta = this.itemMeta
    meta!!.setDisplayName("")
    this.itemMeta = meta
    return this
}

fun ItemStack.addPrefix(prefix: String): ItemStack {
    val meta = this.itemMeta
    val display = meta!!.displayName
    if (meta.hasDisplayName()) meta.setDisplayName("§f$prefix $display")
    else meta!!.setDisplayName(prefix)
    this.itemMeta = meta
    return this
}

fun ItemStack.addSuffix(suffix: String): ItemStack {
    val meta = this.itemMeta
    val display = meta!!.displayName
    if (meta.hasDisplayName()) meta.setDisplayName("$display $suffix")
    else meta.setDisplayName(suffix)
    this.itemMeta = meta
    return this
}

fun ItemStack.addLore(string: String): ItemStack {
    val meta = this.itemMeta
    val lore = meta!!.lore ?: mutableListOf()
    lore.add("§f$string")
    meta.lore = lore
    this.itemMeta = meta
    return this
}

fun ItemStack.clearLore(): ItemStack {
    val meta = this.itemMeta
    meta!!.lore = listOf()
    this.itemMeta = meta
    return this
}

fun ItemStack.amount(int : Int): ItemStack {
    this.amount = int
    return this
}

fun ItemStack.flagAll(): ItemStack {
    for (flag in ItemFlag.values()) addItemFlags(flag)
    return this
}

fun ItemStack.flagClear():ItemStack {
    for (flag in ItemFlag.values()) removeItemFlags(flag)
    return this
}

fun ItemStack.isSameItem(item: ItemStack): Boolean {
    return this.clone().amount(1) == item.clone().amount(1)
}

fun ItemStack.isDefaultItem(): Boolean {
    return this.isSameItem(this.type.item())
}