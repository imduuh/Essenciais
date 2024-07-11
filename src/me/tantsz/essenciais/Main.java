package me.tantsz.essenciais;

import java.io.File;
import java.io.IOException;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.tantsz.essenciais.commands.Alert;

public class Main extends JavaPlugin {
	public static Main main;
	
	public static Main getMain() {
		return main;
		}
	
	public static String getConfigString(String msg) {
		return main.getConfig().getString(msg).replace("&", "§");
		}
	
	@Override
	public void onEnable() {
		main = this;
		getCommand("alert").setExecutor(new Alert());
		if (!(new File(getDataFolder(), "config.yml")).exists()) {
			saveDefaultConfig();
		}
		//Bukkit.getPluginManager().registerEvents((Listener)new Listeners(), (Plugin)this);
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("§eEssenciais: §aPlugin habilitado!");
		Bukkit.getConsoleSender().sendMessage("§eAuthor: §fTantsZ");
		Bukkit.getConsoleSender().sendMessage("§eVersao: §f1.0");
		Bukkit.getConsoleSender().sendMessage("");
		File database;
		if (!(database = new File(getDataFolder() + File.separator + "database.db")).exists()) {
			try {
				database.createNewFile();
				}
			catch (IOException e) {
				e.printStackTrace();
				} 
			}
		}

	@Override
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("§eEssencnais: §4Plugin desabilitado!");
		Bukkit.getConsoleSender().sendMessage("§eAuthor: §fTantsZ");
		Bukkit.getConsoleSender().sendMessage("§eVersao: §f1.0");
		Bukkit.getConsoleSender().sendMessage("");
	}
	
}