package me.tantsz.essenciais.commands;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Animals;
import org.bukkit.entity.Creature;
import org.bukkit.entity.Entity;
import me.tantsz.essenciais.Main;

public class ClearMobs implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
		if (cmd.getName().equalsIgnoreCase("clearmobs")) {
			if (sender.hasPermission("essenciais.clearmobs")) {
				int n = 0;
				for (World w : Bukkit.getWorlds()) {
					for (Entity e : w.getEntities()) {
						if ((e instanceof Animals || e instanceof Creature) && !e.isDead()) {
							e.remove();
							n++;
							}
						}
					}
				sender.sendMessage(Main.getConfigString("Comandos.ClearMobs.Sucesso").replace("{quantidade}", Integer.toString(n)));
			} else {
				sender.sendMessage(Main.getConfigString("Comandos.ClearMobs.Sem_Permissao"));
				return true;
			}
		}
		return false;
	}
}