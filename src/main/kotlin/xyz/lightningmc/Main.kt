package xyz.lightningmc

import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import xyz.lightningmc.commands.*
import xyz.lightningmc.listeners.*

class LightningLobby : JavaPlugin() {
    override fun onEnable() {
        Bukkit.getServer().logger.info("Loading Lightning Lobby")
        this.getCommand("gmc")!!.setExecutor(Gmc())
        this.getCommand("gmc")!!.tabCompleter = gmtabcomplete()
        this.getCommand("gma")!!.setExecutor(Gma())
        this.getCommand("gma")!!.tabCompleter = gmtabcomplete()
        this.getCommand("gms")!!.setExecutor(Gms())
        this.getCommand("gms")!!.tabCompleter = gmtabcomplete()
        this.getCommand("gmsp")!!.setExecutor(Gmsp())
        this.getCommand("gmsp")!!.tabCompleter = gmtabcomplete()
        Bukkit.getServer().logger.info("Registered Commands")
        Bukkit.getPluginManager().registerEvents(PreventDrops(), this)
        Bukkit.getPluginManager().registerEvents(PreventInteractions(), this)
        Bukkit.getPluginManager().registerEvents(PreventDamage(), this)
        Bukkit.getPluginManager().registerEvents(InvClick(), this)
        Bukkit.getPluginManager().registerEvents(LobbyJoin(), this)
        Bukkit.getServer().logger.info("Registered Listeners")
        Bukkit.getServer().logger.info("Lightning Lobby Loaded")
    }

    override fun onDisable() {
        Bukkit.getServer().logger.info("Lightning Lobby Disabled")
    }
}