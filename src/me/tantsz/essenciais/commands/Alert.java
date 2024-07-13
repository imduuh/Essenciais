package me.tantsz.essenciais.commands;

import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import me.tantsz.essenciais.Main;
import me.tantsz.essenciais.utils.Utils;

public class Alert implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("alert")) {
			if (sender.hasPermission("essenciais.alert")) {
				if (args.length >= 1) {
					List<String> list = Main.getMain().getConfig().getStringList("Comandos.Alerta.Mensagem");
					for (String str: list) {
						Bukkit.broadcastMessage(str.replace("&","§").replace("{mensagem}",Utils.getMensagem(args)));
					}
				} else {
					sender.sendMessage(Main.getConfigString("Comandos.Alerta.Erro"));
					return true;
				}
			} else {
				sender.sendMessage(Main.getConfigString("Comandos.Alerta.Sem_Permissao"));
				return true;
			}
		}
		return false;
	}
}