package fodastico.user.Commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Sc implements Listener, CommandExecutor {
	public static ArrayList<String> inStaffChat;

	static {
		Sc.inStaffChat = new ArrayList<String>();
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§cVoc\u00ea n\u00e3o \u00e9 um jogador.");
			return false;
		}
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("sc")) {
			if (!p.hasPermission("kitpvp.sc")) {
				p.sendMessage(
						"§e§lPERMISSAO §fVoc\u00ea n\u00e3o possui §4§lPERMISSAO §fpara executar este §3§lCOMANDO.");
				return true;
			}
			if (inStaffChat(p)) {
				Sc.inStaffChat.remove(p.getName());
				Bukkit.broadcast("§b§lSTAFF-CHAT " + p.getDisplayName() + " §c§lSAIU §fdo §9§lSTAFF-CHAT§f!",
						"kitpvp.sc");
			} else {
				Sc.inStaffChat.add(p.getName());
				Bukkit.broadcast("§b§lSTAFF-CHAT " + p.getDisplayName() + " §a§lENTROU §fno §9§lSTAFF-CHAT§f!",
						"kitpvp.sc");
			}
		}
		return true;
	}

	public static boolean inStaffChat(final Player player) {
		return Sc.inStaffChat.contains(player.getName());
	}
}
