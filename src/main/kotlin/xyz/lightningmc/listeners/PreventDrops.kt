package xyz.lightningmc.listeners

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerDropItemEvent

class PreventDrops : Listener {
    @EventHandler
    fun onDrop(e: PlayerDropItemEvent) {
        if (e.player.location.world.name == "Minigames_Lobby") e.isCancelled = true
    }
}