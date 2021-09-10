package fodastico.user.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fodastico.user.FullVIP.VipallAPI;

public class VipAll implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (!(sender instanceof Player)) {
			return true;
		}
		final Player p = (Player) sender;
		if (!cmd.getName().equalsIgnoreCase("vipall")) {
			return false;
		}
		if (!p.hasPermission("kitpvp.vipall")) {
			p.sendMessage("§e§lPERMISSAO §7Voc\u00ea n\u00e3o possui §4§lPERMISSAO §7para executar este §3§lCOMANDO.");
			return true;
		}
		if (args.length == 0) {
			p.sendMessage("§6§lFULLVIP §fUtilize: /vipall <on> <off>");
			return true;
		}
		if (args.length == 1) {
			if (args[0].equalsIgnoreCase("on")) {
				if (VipallAPI.vipall) {
					p.sendMessage("§6§lFULLVIP §fO modo §6§lFULLVIP §fj\u00e1 est\u00e1 §a§lATIVADO");
					return true;
				}
				p.sendMessage("§6§lFULLVIP §aVoc\u00ea ativou o modo §6§lFULLVIP");
				Bukkit.broadcastMessage(
						"§d§lATEN\u00c7AO §fO modo §6§lFULLVIP §ffoi §a§lATIVADO! §fTodos os jogadores possuem tags §6§lVIP´s §fe todos os §b§lKITS§f!");
				return VipallAPI.vipall = true;
			} else if (args[0].equalsIgnoreCase("off")) {
				if (!VipallAPI.vipall) {
					p.sendMessage("§6§lFULLVIP §fO modo §6§lFULLVIP §fj\u00e1 est\u00e1 §c§lDESATIVADO");
					return true;
				}
				p.sendMessage("§6§lFULLVIP §aVoc\u00ea §a§lATIVOU §fo modo §6§llFULLVIP");
				Bukkit.broadcastMessage("§d§lATEN\u00c7AO §fO modo §6§lFULLVIP §ffoi §c§lDESATIVADO!");
				VipallAPI.vipall = false;
				return true;
			}
		}
		return true;
	}
}
