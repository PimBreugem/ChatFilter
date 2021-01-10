package me.Breugem.ChatFilter.commands;

import me.Breugem.ChatFilter.Main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelloCommand implements CommandExecutor {
	@SuppressWarnings("unused")
	private Main plugin;
	
	public HelloCommand(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("Hello").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player)) {
			sender.sendMessage("Only players may execute this command!");
			return true;
		}
		
		Player player = (Player) sender;
		
		if(player.hasPermission("chatfilter.use")) {
			player.sendMessage("Hello!");
			return true;
		}else {
			player.sendMessage("You do not have persmission to execute this command!");
		}
		
		return false;
	}
}
