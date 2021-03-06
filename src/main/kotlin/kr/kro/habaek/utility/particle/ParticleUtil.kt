package kr.kro.habaek.utility.particle

import org.bukkit.Location
import org.bukkit.Particle
import org.bukkit.entity.Player

class ParticleUtil {
    var particle = Particle.FLAME
    var count = 1
    var offsetX = 0.0
    var offsetY = 0.0
    var offsetZ = 0.0
    var speed = 0.0
    var data : Any? = null
    var force = false
    var players = mutableListOf<Player>()

    fun play(location: Location) {
        if (players.isEmpty()) return location.world!!.spawnParticle(particle, location, count, offsetX, offsetY, offsetZ, speed,  data, force)
        for (p in players) p.spawnParticle(particle, location, count, offsetX, offsetY, offsetZ, speed, data)
    }
}