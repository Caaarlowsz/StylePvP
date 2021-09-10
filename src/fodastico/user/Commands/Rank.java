package fodastico.user.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fodastico.user.Apis.XpAPI;
import fodastico.user.Events.EventosGerais;

public class Rank implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§cVoc\u00ea n\u00e3o \u00e9 um jogador.");
			return false;
		}
		final Player jogador = (Player) sender;
		if (label.equalsIgnoreCase("rank")) {
			jogador.sendMessage(
					"§6§lLIGA §fA nossa rede possui um sistema de liga \u00fanico que garante aos players uma competi\u00e7\u00e3o e mais destaque no servidor.");
			jogador.sendMessage(
					"§fAo matar alg\u00faem, ganhar uma partida ou fazer a\u00e7\u00f5es espec\u00edficas de cada Modo de Jogo voc\u00ea recebe uma quantidade de XP calculada por nossa rede para upar de n\u00edvel.");
			jogador.sendMessage("§4\u272a LEGENDARY");
			jogador.sendMessage("§c\u272b MASTER");
			jogador.sendMessage("§5\u2739 ELITE");
			jogador.sendMessage("§b\u2726 DIAMOND");
			jogador.sendMessage("§6\u2739 GOLD");
			jogador.sendMessage("§7\u2736 SILVER");
			jogador.sendMessage("§1\u2637 EXPERT");
			jogador.sendMessage("§e\u2634 ADVANCED");
			jogador.sendMessage("§a\u2630 PRIMARY");
			jogador.sendMessage("§f\u2500 UNRANKED");
			jogador.sendMessage("§fSua liga atual \u00e9 " + EventosGerais.LigaAtual(jogador));
			jogador.sendMessage("§fSeu XP atual \u00e9 §4§l" + XpAPI.getXp(jogador));
			jogador.sendMessage(
					"§fXP necess\u00e1rio para a pr\u00f3xima liga: §4§l" + EventosGerais.XpNecessario(jogador));
			jogador.sendMessage("");
		}
		return false;
	}
}
