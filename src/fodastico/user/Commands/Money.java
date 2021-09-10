package fodastico.user.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fodastico.user.Apis.MoneyAPI;

public class Money implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§cVoc\u00ea n\u00e3o \u00e9 um jogador.");
			return false;
		}
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("money")) {
			if (!p.hasPermission("kitpvp.money")) {
				p.sendMessage(
						"§e§lPERMISSAO §fVoc\u00ea n\u00e3o possui §4§lPERMISSAO §fpara executar este §3§lCOMANDO.");
				return true;
			}
			if (args.length < 3) {
				p.sendMessage("§6§lMOEDAS §fUtilize: /money <add/remove> (player) [quantidade]");
				return true;
			}
			final int tanto = Integer.valueOf(args[2]);
			final Player t = Bukkit.getPlayer(args[1]);
			if (t == null) {
				p.sendMessage("§f§lOFFLINE §fO jogador §7(§e" + args[1] + "§7) §fest\u00e1 offline");
				return true;
			}
			if (args[0].equalsIgnoreCase("add")) {
				try {
					MoneyAPI.addMoney(t, tanto);
					p.sendMessage("§6§lMOEDAS §fVoc\u00ea adiconou §6§l" + tanto
							+ " MOEDAS §fna §e§lCONTA §fdo jogador §7[§e" + t.getName() + "§7]§f!");
					t.sendMessage(
							"§6§lMOEDAS §fVoc\u00ea acabou de receber §6§l" + tanto + " MOEDAS §fna sua §e§lCONTA§f!");
					t.sendMessage("§6§lMOEDAS §eStaffer §7(§f" + p.getName() + "§7)§f.");
				} catch (Exception e) {
					p.sendMessage("§6§lMOEDAS §fUtilize apenas §9§lNUMEROS§f!");
				}
			} else {
				if (!args[0].equalsIgnoreCase("remove")) {
					p.sendMessage("§6§lMOEDAS §fUtilize: /money <add/remove> (player) [quantidade]");
					return true;
				}
				try {
					MoneyAPI.removeMoney(t, tanto);
					p.sendMessage("§6§lMOEDAS §fVoc\u00ea removeu §6§l" + tanto
							+ " MOEDAS §fda §e§lCONTA §fdo jogador §7[§e" + t.getName() + "§7]§a.");
					t.sendMessage("§6§lMOEDAS §fForam removidas §6§l" + tanto + " MOEDAS §fda sua §e§lCONTA§f!");
					t.sendMessage("§6§lMOEDAS §eStaffer §7(§f" + p.getName() + "§7)§c.");
				} catch (Exception e) {
					p.sendMessage("§6§lMOEDAS §fUtilize apenas §9§lNUMEROS§f!");
				}
			}
		}
		return false;
	}
}
