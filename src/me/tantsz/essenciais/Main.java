package me.tantsz.essenciais;

import java.io.File;
import java.io.IOException;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import me.tantsz.essenciais.commands.Alert;
import me.tantsz.essenciais.commands.ClearChat;
import me.tantsz.essenciais.commands.ClearDrops;
import me.tantsz.essenciais.commands.ClearMobs;
import me.tantsz.essenciais.commands.Craft;
import me.tantsz.essenciais.commands.Online;

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
		commands();
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
	
	public void commands() {
		getCommand("alert").setExecutor(new Alert());
		getCommand("clearchat").setExecutor(new ClearChat());
		getCommand("cleardrops").setExecutor(new ClearDrops());
		getCommand("clearmobs").setExecutor(new ClearMobs());
		getCommand("craft").setExecutor(new Craft());
		getCommand("online").setExecutor(new Online());
	}
	
}