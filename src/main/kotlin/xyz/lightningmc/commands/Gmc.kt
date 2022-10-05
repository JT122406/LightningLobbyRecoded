package xyz.lightningmc.commands

import org.bukkit.Bukkit
import org.bukkit.GameMode
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.ConsoleCommandSender
import org.bukkit.entity.Player

class Gmc : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>?): Boolean {
        if (sender is Player && sender.hasPermission("gamemode.change")){
            if (args == null || args.isEmpty()){
                sender.gameMode = GameMode.CREATIVE
                sender.sendMessage("Gamemode changed to Creative")
                return true
            }else{
                for (p1 in Bukkit.getOnlinePlayers()) if (p1.name.equals(args[0], ignoreCase = true)) {
                    p1.gameMode = GameMode.CREATIVE
                    p1.sendMessage("Gamemode changed to Creative")
                    sender.sendMessage("Updated " + p1.name + "'s gamemode to Creative")
                    return true
                }
                sender.sendMessage("Player doesn't exist")
                return false
            }
        }else if (sender is ConsoleCommandSender){
            for (p1 in Bukkit.getOnlinePlayers()) if (p1.name.equals(args?.get(0), ignoreCase = true)) {
                p1.gameMode = GameMode.CREATIVE
                p1.sendMessage("Gamemode changed to Creative")
                sender.sendMessage("Updated " + p1.name + "'s gamemode to Creative")
                return true
            }
            sender.sendMessage("Player doesn't exist")
            return false
        }
        return false
    }
}