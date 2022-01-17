package kr.kro.habaek.utility.string

import net.kyori.adventure.text.Component
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.entity.Player

fun String.toConsole() {
    if (this != "") println(this)
}
fun String.toServer() {
    if (this != "") Bukkit.broadcastMessage(this)
}
fun String.toPlayer(player: Player) {
    if (this != "") player.sendMessage(this)
}
fun String.toPlayers(players: Collection<Player>) {
    if (this != "") for (player in players) player.sendMessage(this)
}
fun String.toPlayerActionBar(player: Player) {
    if (this != "") player.sendActionBar(this)
}
fun String.toPlayersActionBar(players: Collection<Player>) {
    if (this != "") for (player in players) player.sendActionBar(this)
}
fun String.toComponent(): Component {
    return Component.text(this)
}
fun String.setUnderBar(): String {
    return this.replace(' ', '_')
}
fun  String.removeUnderBar(): String {
    return this.replace('_',' ')
}
fun String.remove(string: String): String {
    return this.replace(string, "")
}

fun String.convertFileName(): String {
    return this.remove('/').remove('\\').remove(':').remove('?').remove('*').remove('<').remove('>').remove('|').remove("\"")
}
fun String.unColor(): String {
    return ChatColor.stripColor(this)!!
}