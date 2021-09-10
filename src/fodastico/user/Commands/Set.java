package fodastico.user.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fodastico.user.Warp.WarpsManager;

public class Set implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§cVoc\u00ea n\u00e3o \u00e9 um jogador.");
			return false;
		}
		final Player p = (Player) sender;
		final int y = p.getLocation().getBlockY();
		final int z = p.getLocation().getBlockZ();
		final int x = p.getLocation().getBlockX();
		if (cmd.getName().equalsIgnoreCase("set")) {
			if (!p.hasPermission("kitpvp.set")) {
				p.sendMessage(
						"§e§lPERMISSAO §fVoc\u00ea n\u00e3o possui §4§lPERMISSAO §fpara executar este §3§lCOMANDO.");
				return true;
			}
			if (args.length == 0) {
				p.sendMessage("§e§lLOCAL §fUtilize: /set <local>");
				p.sendMessage(
						"§e§lWARPS §fdispon\u00edveis: §a<spawn> <fps> <challenge> <1v1> <1v1loc1> <1v1loc2> <ss> <evento>");
				p.sendMessage("§e§lARENAS §f(Kit-PvP): §a<1> <2> <3> <4>");
				return true;
			}
			if (args[0].equalsIgnoreCase("spawn")) {
				p.getWorld().setSpawnLocation(x, y, z);
				WarpsManager.Set(p, "Spawn");
				p.sendMessage("§e§lLOCAL §fVoc\u00ea §c§lSETOU §fa §e§lWARP §7(§2SPAWN§7) §a§lCORRETAMENTE");
			} else if (args[0].equalsIgnoreCase("challenge")) {
				WarpsManager.Set(p, "Challenge");
				p.sendMessage("§e§lLOCAL §fVoc\u00ea §c§lSETOU §fa §e§lWARP §7(§2CHALLENGE§7) §a§lCORRETAMENTE");
			} else if (args[0].equalsIgnoreCase("fps")) {
				WarpsManager.Set(p, "Fps");
				p.sendMessage("§e§lLOCAL §fVoc\u00ea §c§lSETOU §fa §e§lWARP §7(§2FPS§7) §a§lCORRETAMENTE");
			} else if (args[0].equalsIgnoreCase("pot")) {
				WarpsManager.Set(p, "Pot");
				p.sendMessage("§e§lLOCAL §fVoc\u00ea §c§lSETOU §fa §e§lWARP §7(§2PotPvP§7) §a§lCORRETAMENTE");
			} else {
				if (args[0].equalsIgnoreCase("1v1")) {
					WarpsManager.Set(p, "1v1");
					p.sendMessage("§e§lLOCAL §fVoc\u00ea §c§lSETOU §fa §e§lWARP §7(§21V1§7) §a§lCORRETAMENTE");
					return true;
				}
				if (args[0].equalsIgnoreCase("1v1loc1")) {
					WarpsManager.Set(p, "1v1loc1");
					p.sendMessage("§e§lLOCAL §fVoc\u00ea §c§lSETOU §fo §6§lLOCAL §7(§21V1LOC1§7) §a§lCORRETAMENTE");
					return true;
				}
				if (args[0].equalsIgnoreCase("1v1loc2")) {
					WarpsManager.Set(p, "1v1loc2");
					p.sendMessage("§e§lLOCAL §fVoc\u00ea §c§lSETOU §fo §6§lLOCAL §7(§21V1LOC2§7) §a§lCORRETAMENTE");
					return true;
				}
				if (args[0].equalsIgnoreCase("ss")) {
					WarpsManager.Set(p, "Ss");
					p.sendMessage("§e§lLOCAL §fVoc\u00ea §c§lSETOU §fa §e§lWARP §7(§2SCREENSHARE§7) §a§lCORRETAMENTE");
				} else if (args[0].equalsIgnoreCase("evento")) {
					WarpsManager.Set(p, "Evento");
					p.sendMessage("§e§lLOCAL §fVoc\u00ea §c§lSETOU §fa §e§lWARP §7(§2EVENTO§7) §a§lCORRETAMENTE");
				} else {
					if (args[0].equalsIgnoreCase("1")) {
						WarpsManager.Set(p, "Arena1");
						p.sendMessage("§e§lLOCAL §fVoc\u00ea §c§lSETOU §fa §e§lARENA §7(§21§7) §a§lCORRETAMENTE");
						return true;
					}
					if (args[0].equalsIgnoreCase("2")) {
						WarpsManager.Set(p, "Arena2");
						p.sendMessage("§e§lLOCAL §fVoc\u00ea §c§lSETOU §fa §e§lARENA §7(§22§7) §a§lCORRETAMENTE");
						return true;
					}
					if (args[0].equalsIgnoreCase("3")) {
						WarpsManager.Set(p, "Arena3");
						p.sendMessage("§e§lLOCAL §fVoc\u00ea §c§lSETOU §fa §e§lARENA §7(§23§7) §a§lCORRETAMENTE");
						return true;
					}
					if (args[0].equalsIgnoreCase("textura")) {
						WarpsManager.Set(p, "Textura");
						p.sendMessage("§e§lLOCAL §fVoc\u00ea §c§lSETOU §fa §e§lWARP §7(§5TEXTURA§7) §a§lCORRETAMENTE");
					} else if (args[0].equalsIgnoreCase("4")) {
						WarpsManager.Set(p, "Arena4");
						p.sendMessage("§e§lLOCAL §fVoc\u00ea §c§lSETOU §fa §e§lARENA §7(§24§7) §a§lCORRETAMENTE");
						return true;
					}
				}
			}
		}
		return false;
	}
}
