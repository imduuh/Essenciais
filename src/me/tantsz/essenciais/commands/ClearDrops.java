package me.tantsz.essenciais.commands;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import me.tantsz.essenciais.Main;

public class ClearDrops implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
		if (cmd.getName().equalsIgnoreCase("cleardrops")) {
			if (sender.hasPermission("essenciais.cleardrops")) {
				int n = 0;
				for (World w : Bukkit.getWorlds()) {
					for (Entity e : w.getEntities()) {
						if (e instanceof Item) {
							e.remove();
							n++;
							}
						}
					}
				sender.sendMessage(Main.getConfigString("Comandos.ClearDrops.Sucesso").replace("{quantidade}", Integer.toString(n)));
			} else {
				sender.sendMessage(Main.getConfigString("Comandos.ClearDrops.Sem_Permissao"));
				return true;
			}
		}
		return false;
	}
}