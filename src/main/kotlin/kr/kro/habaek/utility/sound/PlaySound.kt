package kr.kro.habaek.utility.sound

import org.bukkit.Location
import org.bukkit.Sound
import org.bukkit.SoundCategory
import org.bukkit.inventory.Inventory
import org.bukkit.entity.Player

class PlaySound {
    var sound: Sound = Sound.BLOCK_STONE_BREAK
    var soundCategory: SoundCategory = SoundCategory.MASTER
    var volume: Float = 1.0F
    var pitch: Float = 1.0F

    fun play(location: Location) = location.world!!.playSound(location, sound, soundCategory, volume, pitch)

    fun play(player: Player) = player.playSound(player.location, sound, soundCategory, volume, pitch)

    fun play(players: Collection<Player>) {
        for (player in players) player.playSound(player.location, sound, soundCategory, volume, pitch)
    }

    fun setScale(scale: Scale) {
        pitch = scale.float
    }

    fun clone(): PlaySound {
        val playSound = PlaySound()
        playSound.sound = sound
        playSound.soundCategory = soundCategory
        playSound.volume = volume
        playSound.pitch = pitch
        return playSound
    }
}