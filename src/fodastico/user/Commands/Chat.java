package fodastico.user.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;

public class Chat implements CommandExecutor, Listener {
	public static boolean pausado;

	static {
		Chat.pausado = false;
	}

	public boolean onCommand(final CommandSender Sender, final Command Cmd, final String Label, final String[] Args) {
		if (Cmd.getName().equalsIgnoreCase("chat")) {
			if (!Sender.hasPermission("kitpvp.chat")) {
				Sender.sendMessage(
						"§e§lPERMISSAO §fVoc\u00ea n\u00e3o possui §4§lPERMISSAO §fpara executar este §3§lCOMANDO.");
				return true;
			}
			if (Args.length == 0) {
				Sender.sendMessage("§4§lCHAT §fAtive/Desative o chat: /chat <on> <off>");
				Sender.sendMessage("§4§lCHAT §fLimpe o chat: /cc");
				return true;
			}
			if (Args[0].equalsIgnoreCase("off")) {
				if (Chat.pausado = true) {
					Sender.sendMessage("§4§lCHAT §fO §c§lCHAT §fglobal j\u00e1 est\u00e1 §c§lDESATIVADO");
				}
				Sender.sendMessage("§4§lCHAT §fVoc\u00ea §c§lDESATIVOU §fo §c§lCHAT §fglobal.");
				Bukkit.getServer().broadcastMessage("§4§lCHAT §f§lO §c§lCHAT §fglobal do servidor foi §c§lDESATIVADO");
				Chat.pausado = true;
			} else if (Args[0].equalsIgnoreCase("on")) {
				if (Chat.pausado = false) {
					Sender.sendMessage("§4§lCHAT §fO §c§lCHAT §fglobal j\u00e1 est\u00e1 §2§lATIVADO");
				}
				Sender.sendMessage("§4§lCHAT §fVoc\u00ea §a§lATIVOU §fo §c§lCHAT §fglobal.");
				Bukkit.getServer().broadcastMessage("§4§lCHAT §f§lO §c§lCHAT §fglobal do servidor foi §a§lATIVADO");
				Chat.pausado = false;
			}
		}
		return true;
	}
}
