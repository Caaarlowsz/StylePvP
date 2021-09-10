package fodastico.user.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fodastico.user.Apis.APIs;
import fodastico.user.Managers.TituloAPI;

public class SetGroup implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		if (cmd.getName().equalsIgnoreCase("setgroup")) {
			if (!sender.hasPermission("kitpvp.setgroup")) {
				sender.sendMessage(
						"§e§lPERMISSAO §fVoc\u00ea n\u00e3o possui §4§lPERMISSAO §fpara executar este §3§lCOMANDO.");
				return true;
			}
			if (args.length == 0) {
				sender.sendMessage("§6§lGROUPSET §fUtilize: /setgroup <jogador> [grupo]");
				return true;
			}
			if (args.length == 1) {
				sender.sendMessage("§6§lGROUPSET §fUtilize: /setgroup <jogador> [grupo]");
				return true;
			}
			if (args.length == 2) {
				final String group = args[1];
				final Player player = Bukkit.getPlayer(args[0]);
				if (player == null) {
					sender.sendMessage("§6§lGROUPSET §fEste jogador n\u00e3o est\u00e1 §4§lONLINE§f!");
					return true;
				}
				if (group.equalsIgnoreCase("membro") || group.equalsIgnoreCase("normal")) {
					sender.sendMessage("§a§lGRUPO §fVoc\u00ea setou o §a§lGRUPO do jogador §e" + player.getName()
							+ "§e(" + player.getUniqueId() + "§e)" + " §fpara §7§lMEMBRO");
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"pex user " + player.getName() + " group set membro");
					TituloAPI.MandarTitulo(player, "§a§lGRUPO");
					TituloAPI.MandarSubTitulo(player, "§aAlterado para: §7§lMEMBRO");
					player.sendMessage("§a§lGRUPO §fSeu novo §a§lGRUPO \u00e9 §7§lMEMBRO");
					APIs.Normal(player);
					return true;
				}
				if (group.equalsIgnoreCase("youtuber") || group.equalsIgnoreCase("yt")) {
					sender.sendMessage("§a§lGRUPO §fVoc\u00ea setou o §a§lGRUPO do jogador §e" + player.getName()
							+ "§e(" + player.getUniqueId() + "§e)" + " §fpara §b§lYOUTUBER");
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"pex user " + player.getName() + " group set youtuber");
					TituloAPI.MandarTitulo(player, "§a§lGRUPO");
					TituloAPI.MandarSubTitulo(player, "§aAlterado para: §b§lYOUTUBER");
					player.sendMessage("§a§lGRUPO §fSeu novo §a§lGRUPO \u00e9 §b§lYOUTUBER");
					APIs.Youtuber(player);
					return true;
				}
				if (group.equalsIgnoreCase("ultimate")) {
					sender.sendMessage(
							"§6§lGROUPSET §fVoc\u00ea n\u00e3o pode setar §6§lVIP´s §fpor este §3§lCOMANDO. §fUtilize /vipset.");
					return true;
				}
				if (group.equalsIgnoreCase("beta")) {
					sender.sendMessage(
							"§6§lGROUPSET §fVoc\u00ea n\u00e3o pode setar §6§lVIP´s §fpor este §3§lCOMANDO. §fUtilize /vipset.");
					return true;
				}
				if (group.equalsIgnoreCase("premium")) {
					sender.sendMessage(
							"§6§lGROUPSET §fVoc\u00ea n\u00e3o pode setar §6§lVIP´s §fpor este §3§lCOMANDO. §fUtilize /vipset.");
					return true;
				}
				if (group.equalsIgnoreCase("light")) {
					sender.sendMessage(
							"§6§lGROUPSET §fVoc\u00ea n\u00e3o pode setar §6§lVIP´s §fpor este §3§lCOMANDO. §fUtilize /vipset.");
					return true;
				}
				if (group.equalsIgnoreCase("youtuber+") || group.equalsIgnoreCase("youtuberplus")
						|| group.equalsIgnoreCase("yt+") || group.equalsIgnoreCase("ytplus")) {
					sender.sendMessage("§a§lGRUPO §fVoc\u00ea setou o §a§lGRUPO do jogador §e" + player.getName()
							+ "§e(" + player.getUniqueId() + "§e)" + " §fpara §3§lYOUTUBER+");
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"pex user " + player.getName() + " group set youtuber+");
					TituloAPI.MandarTitulo(player, "§a§lGRUPO");
					TituloAPI.MandarSubTitulo(player, "§aAlterado para: §3§lYOUTUBER+");
					player.sendMessage("§a§lGRUPO §fSeu novo §a§lGRUPO \u00e9 §3§lYOUTUBER+");
					APIs.YoutuberPlus(player);
					return true;
				}
				if (group.equalsIgnoreCase("builder")) {
					sender.sendMessage("§a§lGRUPO §fVoc\u00ea setou o §a§lGRUPO do jogador §e" + player.getName()
							+ "§e(" + player.getUniqueId() + "§e)" + " §fpara §2§lBUILDER");
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"pex user " + player.getName() + " group set builder");
					TituloAPI.MandarTitulo(player, "§a§lGRUPO");
					TituloAPI.MandarSubTitulo(player, "§aAlterado para: §2§lBUILDER");
					player.sendMessage("§a§lGRUPO §fSeu novo §a§lGRUPO \u00e9 §2§lBUILDER");
					APIs.Builder(player);
					return true;
				}
				if (group.equalsIgnoreCase("ajudante") || group.equalsIgnoreCase("ajd")
						|| group.equalsIgnoreCase("helper")) {
					sender.sendMessage("§a§lGRUPO §fVoc\u00ea setou o §a§lGRUPO do jogador §e" + player.getName()
							+ "§e(" + player.getUniqueId() + "§e)" + " §fpara §9§lAJUDANTE");
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"pex user " + player.getName() + " group set ajudante");
					TituloAPI.MandarTitulo(player, "§a§lGRUPO");
					TituloAPI.MandarSubTitulo(player, "§aAlterado para: §9§lAJUDANTE");
					player.sendMessage("§a§lGRUPO §fSeu novo §a§lGRUPO \u00e9 §9§lAJUDANTE");
					APIs.Ajudante(player);
					return true;
				}
				if (group.equalsIgnoreCase("trial")) {
					sender.sendMessage("§a§lGRUPO §fVoc\u00ea setou o §a§lGRUPO do jogador §e" + player.getName()
							+ "§e(" + player.getUniqueId() + "§e)" + " §fpara §d§lTRIAL");
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"pex user " + player.getName() + " group set trial");
					TituloAPI.MandarTitulo(player, "§a§lGRUPO");
					TituloAPI.MandarSubTitulo(player, "§aAlterado para: §d§lTRIAL");
					player.sendMessage("§a§lGRUPO §fSeu novo §a§lGRUPO \u00e9 §d§lTRIAL");
					APIs.Trial(player);
					return true;
				}
				if (group.equalsIgnoreCase("mod") || group.equalsIgnoreCase("moderador")) {
					sender.sendMessage("§a§lGRUPO §fVoc\u00ea setou o §a§lGRUPO do jogador §e" + player.getName()
							+ "§e(" + player.getUniqueId() + "§e)" + " §fpara §5§lMOD");
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"pex user " + player.getName() + " group set mod");
					TituloAPI.MandarTitulo(player, "§a§lGRUPO");
					TituloAPI.MandarSubTitulo(player, "§aAlterado para: §5§lMOD");
					player.sendMessage("§a§lGRUPO §fSeu novo §a§lGRUPO \u00e9 §5§lMOD");
					APIs.Mod(player);
					return true;
				}
				if (group.equalsIgnoreCase("modgc") || group.equalsIgnoreCase("gcdetector")) {
					sender.sendMessage("§a§lGRUPO §fVoc\u00ea setou o §a§lGRUPO do jogador §e" + player.getName()
							+ "§e(" + player.getUniqueId() + "§e)" + " §fpara §5§lMODGC");
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"pex user " + player.getName() + " group set modgc");
					TituloAPI.MandarTitulo(player, "§a§lGRUPO");
					TituloAPI.MandarSubTitulo(player, "§aAlterado para: §5§lMODGC");
					player.sendMessage("§a§lGRUPO §fSeu novo §a§lGRUPO \u00e9 §5§lMODGC");
					APIs.ModGc(player);
					return true;
				}
				if (group.equalsIgnoreCase("mod+") || group.equalsIgnoreCase("modplus")
						|| group.equalsIgnoreCase("moderador+") || group.equalsIgnoreCase("moderadorplus")) {
					sender.sendMessage("§a§lGRUPO §fVoc\u00ea setou o §a§lGRUPO do jogador §e" + player.getName()
							+ "§e(" + player.getUniqueId() + "§e)" + " §fpara §5§lMOD+");
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"pex user " + player.getName() + " group set mod+");
					TituloAPI.MandarTitulo(player, "§a§lGRUPO");
					TituloAPI.MandarSubTitulo(player, "§aAlterado para: §5§lMOD+");
					player.sendMessage("§a§lGRUPO §fSeu novo §a§lGRUPO \u00e9 §5§lMOD+");
					APIs.ModPlus(player);
					return true;
				}
				if (group.equalsIgnoreCase("admin") || group.equalsIgnoreCase("administrador")) {
					sender.sendMessage("§a§lGRUPO §fVoc\u00ea setou o §a§lGRUPO do jogador §e" + player.getName()
							+ "§e(" + player.getUniqueId() + "§e)" + " §fpara §c§lADMIN");
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"pex user " + player.getName() + " group set admin");
					TituloAPI.MandarTitulo(player, "§a§lGRUPO");
					TituloAPI.MandarSubTitulo(player, "§aAlterado para: §c§lADMIN");
					player.sendMessage("§a§lGRUPO §fSeu novo §a§lGRUPO \u00e9 §c§lADMIN");
					APIs.Admin(player);
					return true;
				}
				if (group.equalsIgnoreCase("gerente")) {
					sender.sendMessage("§a§lGRUPO §fVoc\u00ea setou o §a§lGRUPO do jogador §e" + player.getName()
							+ "§e(" + player.getUniqueId() + "§e)" + " §fpara §c§lGERENTE");
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"pex user " + player.getName() + " group set gerente");
					TituloAPI.MandarTitulo(player, "§a§lGRUPO");
					TituloAPI.MandarSubTitulo(player, "§aAlterado para: §c§lGERENTE");
					player.sendMessage("§a§lGRUPO §fSeu novo §a§lGRUPO \u00e9 §c§lGERENTE");
					APIs.Gerente(player);
					return true;
				}
				if (group.equalsIgnoreCase("developer") || group.equalsIgnoreCase("dev")) {
					sender.sendMessage("§a§lGRUPO §fVoc\u00ea setou o §a§lGRUPO do jogador §e" + player.getName()
							+ "§e(" + player.getUniqueId() + "§e)" + " §fpara §3§lDEVELOPER");
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"pex user " + player.getName() + " group set dev");
					TituloAPI.MandarTitulo(player, "§a§lGRUPO");
					TituloAPI.MandarSubTitulo(player, "§aAlterado para: §3§lDEVELOPER");
					player.sendMessage("§a§lGRUPO §fSeu novo §a§lGRUPO \u00e9 §3§lDEVELOPER");
					APIs.Dev(player);
					return true;
				}
				if (group.equalsIgnoreCase("dono")) {
					sender.sendMessage("§a§lGRUPO §fVoc\u00ea setou o §a§lGRUPO do jogador §e" + player.getName()
							+ "§e(" + player.getUniqueId() + "§e)" + " §fpara §4§lDONO");
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"pex user " + player.getName() + " group set dono");
					TituloAPI.MandarTitulo(player, "§a§lGRUPO");
					TituloAPI.MandarSubTitulo(player, "§aAlterado para: §4§lDONO");
					player.sendMessage("§a§lGRUPO §fSeu novo §a§lGRUPO \u00e9 §4§lDONO");
					APIs.Dono(player);
					return true;
				}
				sender.sendMessage("§6§lGROUPSET §fEste §a§lGRUPO §fn\u00e3o existe.");
				return true;
			}
		}
		return false;
	}
}
