package fodastico.user.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class IpCheck implements CommandExecutor {
	public boolean onCommand(final CommandSender p, final Command cmd, final String label, final String[] args) {
		if (cmd.getName().equalsIgnoreCase("ipcheck")) {
			if (!p.hasPermission("kitpvp.ipcheck")) {
				p.sendMessage(
						"§e§lPERMISSAO §fVoc\u00ea n\u00e3o possui §4§lPERMISSAO §fpara executar este §3§lCOMANDO.");
				return true;
			}
			if (args.length == 0) {
				p.sendMessage("§6§lIPCHECK §7Utilize: /ipcheck <jogador>");
				return true;
			}
			final Player ip = Bukkit.getPlayer(args[0]);
			final String nameoff = args[0];
			if (ip == null) {
				p.sendMessage("§f§lOFFLINE §fO jogador §7(§e" + nameoff + "§7) est\u00e1 offline.");
				return true;
			}
			if (ip != null) {
				p.sendMessage("§6§lIPCHECK §fJogador: §7(§e" + ip.getName() + "§7)");
				p.sendMessage(" ");
				p.sendMessage("§6§lIP: §b" + ip.getAddress().getHostString());
				p.sendMessage(" ");
				return true;
			}
		}
		return false;
	}
}
