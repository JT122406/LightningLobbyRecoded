package xyz.lightningmc.commands

import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter

class gmtabcomplete : TabCompleter {
    override fun onTabComplete(
        sender: CommandSender,
        command: Command,
        label: String,
        args: Array<out String>?
    ): MutableList<String>? {
        val list = mutableListOf<String>()
        if (args == null || args.isEmpty()) {
            list.add("gmc")
            list.add("gms")
            list.add("gma")
            list.add("gmsp")
            return list
        } else if(args.size == 1){
            for (player in Bukkit.getOnlinePlayers()){
                list.add(player.name)
            }
            return list
        }
        return null
    }
}