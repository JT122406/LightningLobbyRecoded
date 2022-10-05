package xyz.lightningmc.listeners

import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent

class PreventInteractions:Listener {
    @EventHandler
    fun blockInteractions(event: PlayerInteractEvent) {
        val player = event.player
        if (player.world.name == "Minigames_Lobby") {
            val clicked = player.inventory.itemInMainHand.type
            if ((event.action == Action.RIGHT_CLICK_AIR || Action.RIGHT_CLICK_BLOCK == event.action) && clicked == Material.COMPASS) {
                Bukkit.getServer().dispatchCommand(player, "cp Games")
            }
            event.isCancelled = true
        }}
}