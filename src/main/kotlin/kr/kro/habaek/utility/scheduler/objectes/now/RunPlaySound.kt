package kr.kro.habaek.utility.scheduler.objectes.now

import kr.kro.habaek.utility.scheduler.objectes.interfaces.RunTask
import kr.kro.habaek.utility.sound.PlaySound
import org.bukkit.Location
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory

class RunPlaySound: RunTask {
    override val delay = 0L
    override val runnable : Runnable

    constructor(playSound: PlaySound, location: Location) {
        runnable = Runnable { playSound.play(location) }
    }
    constructor(playSound: PlaySound, player: Player) {
         runnable = Runnable { playSound.play(player) }
    }
    constructor(playSound: PlaySound, players: Collection<Player>) {
        runnable = Runnable { playSound.play(players) }
    }
}