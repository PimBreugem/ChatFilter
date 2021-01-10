package me.Breugem.ChatFilter.Listeners;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.Breugem.ChatFilter.Main;

public class ChatListener implements Listener{
	
	public Main plugin;
	
	public ChatListener(Main plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void checkWords(AsyncPlayerChatEvent event) {
		
		//Create filter list for all the filtered words
		List<String> filter = plugin.getConfig().getStringList("global_filtered");
		
		//Check if a person has extra filters and if so append the filter list
		String DisplayName = event.getPlayer().getPlayer().getDisplayName();
		if(idExists(DisplayName)) {
			filter.addAll(plugin.getConfig().getConfigurationSection("filter").getStringList(DisplayName));
		}
		
		for(String s : event.getMessage().split(" ")) {
			if(filter.contains(s.toLowerCase())) {
			
				event.setCancelled(true);
				event.getPlayer().sendMessage("Let op uw taalgebruik!");
				
			}
		}
	}
	
	public boolean idExists(String DisplayName) {
		if(plugin.getCustomFilter().getKeys(false).contains(DisplayName)) {
			return false;
		}else {
			return true;
		}
		
	}
}
