package kr.kro.habaek.utility.material

import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.Inventory

fun Material.item(): ItemStack {
    return ItemStack(this)
}

fun Material.isCrop(): Boolean {
    return when (this) {
        Material.WHEAT,
        Material.WHEAT_SEEDS,

        Material.CARROT,
        Material.CARROTS,

        Material.POTATO,
        Material.POTATOES,

        Material.BEETROOT,
        Material.BEETROOTS,

        Material.MELON,
        Material.MELON_SLICE,
        Material.MELON_SEEDS,
        Material.MELON_STEM,

        Material.PUMPKIN,
        Material.PUMPKIN_SEEDS,
        Material.PUMPKIN_STEM,

        Material.COCOA,
        Material.COCOA_BEANS,

        Material.SUGAR_CANE,

        Material.SWEET_BERRIES,
        Material.SWEET_BERRY_BUSH -> true
        else -> false
    }
}

fun Material.isOre(): Boolean {
    if (toString().contains("ORE")) return true
    return false
}

fun Material.isLog() : Boolean {
    if (toString().contains("LOG")) return true
    return false
}