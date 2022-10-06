package xyz.lightningmc.listeners

import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent

class InvClick : Listener{
    @EventHandler
    fun inventoryClickEvent(event: InventoryClickEvent) {
        if (event.currentItem == null)
            return
        val p = event.whoClicked as Player
        if (p.location.world.name == "Minigames_Lobby" && event.currentItem!!.type == Material.COMPASS)
            Bukkit.getServer().dispatchCommand(p, "cp Games")

    }
}