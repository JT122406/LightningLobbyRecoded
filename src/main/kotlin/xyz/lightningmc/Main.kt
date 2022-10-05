package xyz.lightningmc

import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import xyz.lightningmc.commands.*
import xyz.lightningmc.listeners.PreventDamage
import xyz.lightningmc.listeners.PreventDrops
import xyz.lightningmc.listeners.PreventInteractions

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
    }

    override fun onDisable() {
        Bukkit.getServer().logger.info("Lightning Lobby Disabled")
    }
}