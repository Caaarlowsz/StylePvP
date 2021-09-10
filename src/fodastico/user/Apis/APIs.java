package fodastico.user.Apis;

import java.util.Arrays;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.nametagedit.plugin.NametagEdit;

import fodastico.user.Main;
import fodastico.user.FullVIP.VipallAPI;
import fodastico.user.ScoreBoard.ScoreBoard;

public class APIs {
	public static void AutomaticMessage() {
		final Random random = new Random();
		switch (random.nextInt(10)) {
		case 1: {
			Bukkit.broadcastMessage(Main.getInstance().getConfig().getString("AUTO-MSG1-LINE1").replace("&", "§"));
			Bukkit.broadcastMessage(Main.getInstance().getConfig().getString("AUTO-MSG1-LINE2").replace("&", "§"));
			Bukkit.broadcastMessage(Main.getInstance().getConfig().getString("AUTO-MSG1-LINE3").replace("&", "§"));
			break;
		}
		case 2: {
			Bukkit.broadcastMessage(Main.getInstance().getConfig().getString("AUTO-MSG2-LINE1").replace("&", "§"));
			Bukkit.broadcastMessage(Main.getInstance().getConfig().getString("AUTO-MSG2-LINE2").replace("&", "§"));
			Bukkit.broadcastMessage(Main.getInstance().getConfig().getString("AUTO-MSG2-LINE3").replace("&", "§"));
			break;
		}
		case 3: {
			Bukkit.broadcastMessage(Main.getInstance().getConfig().getString("AUTO-MSG3-LINE1").replace("&", "§"));
			Bukkit.broadcastMessage(Main.getInstance().getConfig().getString("AUTO-MSG3-LINE2").replace("&", "§"));
			Bukkit.broadcastMessage(Main.getInstance().getConfig().getString("AUTO-MSG3-LINE3").replace("&", "§"));
			break;
		}
		case 4: {
			Bukkit.broadcastMessage(Main.getInstance().getConfig().getString("AUTO-MSG4-LINE1").replace("&", "§"));
			Bukkit.broadcastMessage(Main.getInstance().getConfig().getString("AUTO-MSG4-LINE2").replace("&", "§"));
			Bukkit.broadcastMessage(Main.getInstance().getConfig().getString("AUTO-MSG4-LINE3").replace("&", "§"));
			break;
		}
		case 5: {
			Bukkit.broadcastMessage(Main.getInstance().getConfig().getString("AUTO-MSG5-LINE1").replace("&", "§"));
			Bukkit.broadcastMessage(Main.getInstance().getConfig().getString("AUTO-MSG5-LINE2").replace("&", "§"));
			Bukkit.broadcastMessage(Main.getInstance().getConfig().getString("AUTO-MSG5-LINE3").replace("&", "§"));
			break;
		}
		case 6: {
			Bukkit.broadcastMessage(Main.getInstance().getConfig().getString("AUTO-MSG6-LINE1").replace("&", "§"));
			Bukkit.broadcastMessage(Main.getInstance().getConfig().getString("AUTO-MSG6-LINE2").replace("&", "§"));
			Bukkit.broadcastMessage(Main.getInstance().getConfig().getString("AUTO-MSG6-LINE3").replace("&", "§"));
			break;
		}
		case 7: {
			Bukkit.broadcastMessage(Main.getInstance().getConfig().getString("AUTO-MSG7-LINE1").replace("&", "§"));
			Bukkit.broadcastMessage(Main.getInstance().getConfig().getString("AUTO-MSG7-LINE2").replace("&", "§"));
			Bukkit.broadcastMessage(Main.getInstance().getConfig().getString("AUTO-MSG7-LINE3").replace("&", "§"));
			break;
		}
		case 8: {
			Bukkit.broadcastMessage(Main.getInstance().getConfig().getString("AUTO-MSG8-LINE1").replace("&", "§"));
			Bukkit.broadcastMessage(Main.getInstance().getConfig().getString("AUTO-MSG8-LINE2").replace("&", "§"));
			Bukkit.broadcastMessage(Main.getInstance().getConfig().getString("AUTO-MSG8-LINE3").replace("&", "§"));
			break;
		}
		case 9: {
			Bukkit.broadcastMessage(Main.getInstance().getConfig().getString("AUTO-MSG9-LINE1").replace("&", "§"));
			Bukkit.broadcastMessage(Main.getInstance().getConfig().getString("AUTO-MSG9-LINE2").replace("&", "§"));
			Bukkit.broadcastMessage(Main.getInstance().getConfig().getString("AUTO-MSG9-LINE3").replace("&", "§"));
			break;
		}
		case 10: {
			Bukkit.broadcastMessage(Main.getInstance().getConfig().getString("AUTO-MSG10-LINE1").replace("&", "§"));
			Bukkit.broadcastMessage(Main.getInstance().getConfig().getString("AUTO-MSG10-LINE2").replace("&", "§"));
			Bukkit.broadcastMessage(Main.getInstance().getConfig().getString("AUTO-MSG10-LINE3").replace("&", "§"));
			break;
		}
		}
	}

	public static String getMod(final String name) {
		if (name.length() == 16) {
			final String shorts = name.substring(0, name.length() - 4);
			return shorts;
		}
		if (name.length() == 15) {
			final String shorts = name.substring(0, name.length() - 3);
			return shorts;
		}
		if (name.length() == 14) {
			final String shorts = name.substring(0, name.length() - 2);
			return shorts;
		}
		if (name.length() == 13) {
			final String shorts = name.substring(0, name.length() - 1);
			return shorts;
		}
		return name;
	}

	public static String Grupo(final Player p) {
		if (p.hasPermission("*")) {
			return "§4§lDONO";
		}
		if (p.hasPermission("rank.dev") && p.hasPermission("*")) {
			return "§3§lDEV";
		}
		if (p.hasPermission("rank.gerente")) {
			return "§c§lGERENTE";
		}
		if (p.hasPermission("rank.admin")) {
			return "§c§lADMIN";
		}
		if (p.hasPermission("rank.mod+")) {
			return "§5§lMOD+";
		}
		if (p.hasPermission("rank.modgc")) {
			return "§5§lMODGC";
		}
		if (p.hasPermission("rank.mod")) {
			return "§5§lMOD";
		}
		if (p.hasPermission("rank.trial")) {
			return "§5§lTRIAL";
		}
		if (p.hasPermission("rank.builder")) {
			return "§2§lBUILDER";
		}
		if (p.hasPermission("rank.ajudante")) {
			return "§9§lAJUDANTE";
		}
		if (p.hasPermission("rank.youtuber+")) {
			return "§3§lYOUTUBER+";
		}
		if (p.hasPermission("rank.youtuber")) {
			return "§b§lYOUTUBER";
		}
		if (p.hasPermission("rank.ultimate") || VipallAPI.vipall) {
			return "§d§lULTIMATE";
		}
		if (p.hasPermission("rank.beta")) {
			return "§1§lBETA";
		}
		if (p.hasPermission("rank.premium")) {
			return "§6§lPREMIUM";
		}
		if (p.hasPermission("rank.light")) {
			return "§a§lLIGHT";
		}
		return "§7§lMEMBRO";
	}

	public static void Dono(final Player p) {
		p.sendMessage("§9§lTAGS ATUAIS §fVoc\u00ea est\u00e1 §b§lUTILIZANDO §fa tag: §4§lDONO");
		p.setDisplayName("§4§lDONO §4" + p.getName() + ScoreBoard.getRankNick(p));
		NametagEdit.getApi().setPrefix(p, "§4§lDONO §4");
		NametagEdit.getApi().setSuffix(p, ScoreBoard.getRankNick(p));
	}

	public static void Dev(final Player p) {
		p.sendMessage("§9§lTAGS ATUAIS §fVoc\u00ea est\u00e1 §b§lUTILIZANDO §fa tag: §3§lDEV");
		p.setDisplayName("§3§lDEV §3" + p.getName() + ScoreBoard.getRankNick(p));
		NametagEdit.getApi().setPrefix(p, "§3§lDEV §3");
		NametagEdit.getApi().setSuffix(p, ScoreBoard.getRankNick(p));
	}

	public static void Gerente(final Player p) {
		p.sendMessage("§9§lTAGS ATUAIS §fVoc\u00ea est\u00e1 §b§lUTILIZANDO §fa tag: §c§lGERENTE");
		p.setDisplayName("§c§lGERENTE §c" + p.getName() + ScoreBoard.getRankNick(p));
		NametagEdit.getApi().setPrefix(p, "§c§lGERENTE §c");
		NametagEdit.getApi().setSuffix(p, ScoreBoard.getRankNick(p));
	}

	public static void Admin(final Player p) {
		p.sendMessage("§9§lTAGS ATUAIS §fVoc\u00ea est\u00e1 §b§lUTILIZANDO §fa tag: §c§lADMIN");
		p.setDisplayName("§c§lADMIN §c" + p.getName() + ScoreBoard.getRankNick(p));
		NametagEdit.getApi().setPrefix(p, "§c§lADMIN §c");
		NametagEdit.getApi().setSuffix(p, ScoreBoard.getRankNick(p));
	}

	public static void ModPlus(final Player p) {
		p.sendMessage("§9§lTAGS ATUAIS §fVoc\u00ea est\u00e1 §b§lUTILIZANDO §fa tag: §5§lMOD+");
		p.setDisplayName("§5§lMOD+ §5" + p.getName() + ScoreBoard.getRankNick(p));
		NametagEdit.getApi().setPrefix(p, "§5§lMOD+ §5");
		NametagEdit.getApi().setSuffix(p, ScoreBoard.getRankNick(p));
	}

	public static void ModGc(final Player p) {
		p.sendMessage("§9§lTAGS ATUAIS §fVoc\u00ea est\u00e1 §b§lUTILIZANDO §fa tag: §5§lMODGC");
		p.setDisplayName("§5§lMODGC §5" + p.getName() + ScoreBoard.getRankNick(p));
		NametagEdit.getApi().setPrefix(p, "§5§lMODGC §5");
		NametagEdit.getApi().setSuffix(p, ScoreBoard.getRankNick(p));
	}

	public static void Mod(final Player p) {
		p.sendMessage("§9§lTAGS ATUAIS §fVoc\u00ea est\u00e1 §b§lUTILIZANDO §fa tag: §5§lMOD");
		p.setDisplayName("§5§lMOD §5" + ScoreBoard.getRankNick(p));
		NametagEdit.getApi().setPrefix(p, "§5§lMOD §5");
		NametagEdit.getApi().setSuffix(p, ScoreBoard.getRankNick(p));
	}

	public static void Trial(final Player p) {
		p.sendMessage("§9§lTAGS ATUAIS §fVoc\u00ea est\u00e1 §b§lUTILIZANDO §fa tag: §5§lTRIAL");
		p.setDisplayName("§5§lTRIAL §5" + p.getName() + ScoreBoard.getRankNick(p));
		NametagEdit.getApi().setPrefix(p, "§5§lTRIAL §5");
		NametagEdit.getApi().setSuffix(p, ScoreBoard.getRankNick(p));
	}

	public static void Ajudante(final Player p) {
		p.sendMessage("§9§lTAGS ATUAIS §fVoc\u00ea est\u00e1 §b§lUTILIZANDO §fa tag: §9§lAJUDANTE");
		p.setDisplayName("§9§lAJUDANTE §9" + p.getName() + ScoreBoard.getRankNick(p));
		NametagEdit.getApi().setPrefix(p, "§9§lAJUDANTE §9");
		NametagEdit.getApi().setSuffix(p, ScoreBoard.getRankNick(p));
	}

	public static void Builder(final Player p) {
		p.sendMessage("§9§lTAGS ATUAIS §fVoc\u00ea est\u00e1 §b§lUTILIZANDO §fa tag: §2§lBUILDER");
		p.setDisplayName("§2§lBUILDER §2" + p.getName() + ScoreBoard.getRankNick(p));
		NametagEdit.getApi().setPrefix(p, "§2§lBUILDER §2");
		NametagEdit.getApi().setSuffix(p, ScoreBoard.getRankNick(p));
	}

	public static void YoutuberPlus(final Player p) {
		p.sendMessage("§9§lTAGS ATUAIS §fVoc\u00ea est\u00e1 §b§lUTILIZANDO §fa tag: §3§lYOUTUBER+");
		p.setDisplayName("§3§lYOUTUBER+ §3" + p.getName() + ScoreBoard.getRankNick(p));
		NametagEdit.getApi().setPrefix(p, "§3§lYOUTUBER+ §3");
		NametagEdit.getApi().setSuffix(p, ScoreBoard.getRankNick(p));
	}

	public static void Youtuber(final Player p) {
		p.sendMessage("§9§lTAGS ATUAIS §fVoc\u00ea est\u00e1 §b§lUTILIZANDO §fa tag: §b§lYOUTUBER");
		p.setDisplayName("§b§lYOUTUBER §b" + p.getName() + ScoreBoard.getRankNick(p));
		NametagEdit.getApi().setPrefix(p, "§b§lYOUTUBER §b");
		NametagEdit.getApi().setSuffix(p, ScoreBoard.getRankNick(p));
	}

	public static void Ultimate(final Player p) {
		p.sendMessage("§9§lTAGS ATUAIS §fVoc\u00ea est\u00e1 §b§lUTILIZANDO §fa tag: §d§lULTIMATE");
		p.setDisplayName("§d§lULTIMATE §d" + p.getName() + ScoreBoard.getRankNick(p));
		NametagEdit.getApi().setPrefix(p, "§d§lULTIMATE §d");
		NametagEdit.getApi().setSuffix(p, ScoreBoard.getRankNick(p));
	}

	public static void Beta(final Player p) {
		p.sendMessage("§9§lTAGS ATUAIS §fVoc\u00ea est\u00e1 §b§lUTILIZANDO §fa tag: §1§lBETA");
		p.setDisplayName("§1§lBETA §1" + p.getName() + ScoreBoard.getRankNick(p));
		NametagEdit.getApi().setPrefix(p, "§1§lBETA §1");
		NametagEdit.getApi().setSuffix(p, ScoreBoard.getRankNick(p));
	}

	public static void Premium(final Player p) {
		p.sendMessage("§9§lTAGS ATUAIS §fVoc\u00ea est\u00e1 §b§lUTILIZANDO §fa tag: §6§lPREMIUM");
		p.setDisplayName("§6§lPREMIUM §6" + p.getName() + ScoreBoard.getRankNick(p));
		NametagEdit.getApi().setPrefix(p, "§6§lPREMIUM §6");
		NametagEdit.getApi().setSuffix(p, ScoreBoard.getRankNick(p));
	}

	public static void Light(final Player p) {
		p.sendMessage("§9§lTAGS ATUAIS §fVoc\u00ea est\u00e1 §b§lUTILIZANDO §fa tag: §a§lLIGHT");
		p.setDisplayName("§a§lLIGHT §a" + p.getName() + ScoreBoard.getRankNick(p));
		NametagEdit.getApi().setPrefix(p, "§a§lLIGHT §a");
		NametagEdit.getApi().setSuffix(p, ScoreBoard.getRankNick(p));
	}

	public static void Normal(final Player p) {
		p.sendMessage("§9§lTAGS ATUAIS §fVoc\u00ea est\u00e1 §b§lUTILIZANDO §fa tag: §7§lMEMBRO");
		p.setDisplayName("§7" + p.getName() + ScoreBoard.getRankNick(p));
		NametagEdit.getApi().setPrefix(p, "§7");
		NametagEdit.getApi().setSuffix(p, ScoreBoard.getRankNick(p));
	}

	public static void Ss(final Player p) {
		p.setDisplayName("§c§lSCREENSHARE §c" + p.getName() + ScoreBoard.getRankNick(p));
		NametagEdit.getApi().setPrefix(p, "§c§lSCREENSHARE §c");
		NametagEdit.getApi().setSuffix(p, ScoreBoard.getRankNick(p));
	}

	public static ItemStack criarItem(final Player p, final Material material, final String nome, final String[] lore,
			final int quantidade, final short cor) {
		final ItemStack item = new ItemStack(material, quantidade, cor);
		final ItemMeta kitem = item.getItemMeta();
		kitem.setDisplayName(nome);
		kitem.setLore(Arrays.asList(lore));
		item.setItemMeta(kitem);
		return item;
	}
}
