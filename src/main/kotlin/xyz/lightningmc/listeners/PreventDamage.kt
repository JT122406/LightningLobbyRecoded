package xyz.lightningmc.listeners

import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageEvent

class PreventDamage:Listener {
    @EventHandler
    fun onPlayerDamage(e: EntityDamageEvent) {
        if (e.entity is Player && e.entity.world.name == "Minigames_Lobby")
            e.isCancelled = true
    }
}