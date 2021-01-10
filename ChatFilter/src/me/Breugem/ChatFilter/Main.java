package me.Breugem.ChatFilter;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import me.Breugem.ChatFilter.commands.HelloCommand;
import me.Breugem.ChatFilter.Listeners.ChatListener;
import me.Breugem.ChatFilter.Listeners.JoinListener;

public class Main extends JavaPlugin 
{
	private File customFilterFile;
	private FileConfiguration customFilter;
	
	@Override
	public void onEnable() 
	{
		saveDefaultConfig();
		createCustomConfig();
		
		new HelloCommand(this);
		new JoinListener(this);
		new ChatListener(this);
	}
	
	public FileConfiguration getCustomFilter() {
        return this.customFilter;
    }
	
    private void createCustomConfig() {
    	customFilterFile = new File(getDataFolder(), "customFilter.yml");
        if (!customFilterFile.exists()) {
        	customFilterFile.getParentFile().mkdirs();
            saveResource("customFilter.yml", false);
         }

        customFilter= new YamlConfiguration();
        try {
        	customFilter.load(customFilterFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }
}