package me.Breugem.ChatFilter.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.Breugem.ChatFilter.Main;
import me.Breugem.ChatFilter.Listeners.Utils.Utils;

public class JoinListener implements Listener {
	
	private Main plugin;
	
	public JoinListener(Main plugin) {
		this.plugin = plugin;
		
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		
		if(!player.hasPlayedBefore()) {
			Bukkit.broadcastMessage(
					Utils.chat(plugin.getConfig().getString("firstJoin_message").replace("<player>", player.getName())));
		}else {
			Bukkit.broadcastMessage(
					Utils.chat(plugin.getConfig().getString("join_message").replace("<player>", player.getName())));
		}
	}
}
