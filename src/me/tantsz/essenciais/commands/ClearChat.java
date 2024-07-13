package me.tantsz.essenciais.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import me.tantsz.essenciais.Main;

public class ClearChat implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("clearchat")) {
			if (sender.hasPermission("essenciais.clearchat")) {
				for (int x = 0; x < 100; x++) {
					Bukkit.broadcastMessage(" ");
				}
				sender.sendMessage(Main.getConfigString("Comandos.ClearChat.Sucesso"));
			} else {
				sender.sendMessage(Main.getConfigString("Comandos.ClearChat.Sem_Permissao"));
				return true;
			}
		}
		return false;
	}

}
