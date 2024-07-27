package me.tantsz.essenciais.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.tantsz.essenciais.Main;

public class Online implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
		if (cmd.getName().equalsIgnoreCase("online")) {
			sender.sendMessage(Main.getConfigString("Comandos.Online.Mensagem").replace("{quantidade}", String.valueOf(Bukkit.getServer().getOnlinePlayers().size())));
			return true;
		}
		return false;
	}	
}