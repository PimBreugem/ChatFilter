package me.Breugem.ChatFilter.Listeners.Utils;

import org.bukkit.ChatColor;

public class Utils {

	public static String chat (String s) {
		return ChatColor.translateAlternateColorCodes('&', s);
	}
}
