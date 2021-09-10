package fodastico.user.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;

public class Cc implements CommandExecutor, Listener {
	public static boolean pausado;

	static {
		Cc.pausado = false;
	}

	public boolean onCommand(final CommandSender Sender, final Command Cmd, final String Label, final String[] Args) {
		if (Cmd.getName().equalsIgnoreCase("cc")) {
			if (!Sender.hasPermission("kitpvp.cc")) {
				Sender.sendMessage(
						"§e§lPERMISSAO §fVoc\u00ea n\u00e3o possui §4§lPERMISSAO §fpara executar este §3§lCOMANDO.");
				return true;
			}
			if (Args.length == 0) {
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("§6§lCHAT §fO §c§lCHAT §fglobal do servidor foi §e§lLIMPO.");
			}
		}
		return true;
	}
}
