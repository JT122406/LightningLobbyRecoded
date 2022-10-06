package xyz.lightningmc.listeners

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.GameMode
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerChangedWorldEvent
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.inventory.ItemStack
import org.bukkit.plugin.java.JavaPlugin

class LobbyJoin : Listener {
    //Join Server event
    @EventHandler
    fun playerJoinEvent(event: PlayerJoinEvent) {
        val player = event.player
        val inv = player.inventory
        inv.clear()
        if (player.location.world.name == "Minigames_Lobby") {
            val compass = ItemStack(Material.COMPASS, 1)
            val commeta = compass.itemMeta
            commeta.displayName(Component.text("Games").color(NamedTextColor.DARK_BLUE))
            compass.itemMeta = commeta
            player.canPickupItems = false
            player.health = 20.0
            player.isInvisible = false
            player.gameMode = GameMode.ADVENTURE
            inv.setItem(4, compass)
        }
    }

    //Join world event
    @EventHandler
    fun playerChangedWorldEvent(event: PlayerChangedWorldEvent) {
        val player = event.player
        val inv = player.inventory
        inv.clear()
        if (player.location.world.name == "Minigames_Lobby") {
            val compass = ItemStack(Material.COMPASS, 1)
            val commeta = compass.itemMeta
            commeta.displayName(Component.text("Games").color(NamedTextColor.DARK_BLUE))
            compass.itemMeta = commeta
            player.canPickupItems = false
            player.health = 20.0
            player.isInvisible = false
            player.gameMode = GameMode.ADVENTURE
            inv.setItem(4, compass)
            //val itemsManager = ItemsManager(plugin)
            //val head = itemsManager.getHead(player)
            //itemsManager.setItems(player, head)
        }
    }


}