package me.tantsz.essenciais.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import me.tantsz.essenciais.Main;

public class Craft implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
		if (cmd.getName().equalsIgnoreCase("craft")) {
			if (sender instanceof Player) {
				Player player = (Player)sender;
				if (player.hasPermission("essenciais.craft")) {
					player.openWorkbench(player.getLocation(), true);
				} else {
					player.sendMessage(Main.getConfigString("Comandos.Craft.Sem_Permissao"));
					return true;
				}
			} else {
				sender.sendMessage(Main.getConfigString("Comandos.Craft.Somente_Players"));
				return true;
			}
		}
		return false;
	}
}