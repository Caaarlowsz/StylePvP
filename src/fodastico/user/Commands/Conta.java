package fodastico.user.Commands;

import org.bukkit.Bukkit;
import fodastico.user.ScoreBoard.ScoreBoard;
import fodastico.user.Apis.APIs;
import fodastico.user.Apis.KitAPI;
import fodastico.user.Apis.MoneyAPI;
import fodastico.user.Apis.XpAPI;
import fodastico.user.Apis.DeathAPI;
import fodastico.user.Apis.KillsAPI;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class Conta implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String c, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cVoc\u00ea n\u00e3o \u00e9 um jogador.");
            return false;
        }
        final Player p = (Player)sender;
        if (args.length == 0) {
            p.sendMessage(" ");
            p.sendMessage("§e§lCONTA §fNICKNAME + UUID: §e" + p.getName() + "(" + p.getUniqueId() + ")");
            p.sendMessage("§e§lCONTA §fIP: §7(§e" + p.getAddress().getHostString() + "§7)");
            p.sendMessage("§e§lCONTA §fKILLS: §7(§e" + KillsAPI.getKills(p) + "§7)");
            p.sendMessage("§e§lCONTA §fDEATHS: §b§7(§e" + DeathAPI.getDeath(p) + "§7)");
            p.sendMessage("§e§lCONTA §fKILLSTREAK: §7(§e" + p.getLevel() + "§7)");
            p.sendMessage("§e§lCONTA §fXP: §7(§e" + XpAPI.getXp(p) + "§7)");
            p.sendMessage("§e§lCONTA §fMOEDAS: §7(§e" + MoneyAPI.getMoney(p) + "§7)");
            p.sendMessage("§e§lCONTA §fKIT ATUAL: §7(§e" + KitAPI.getkit(p) + "§7)");
            p.sendMessage("§e§lCONTA §fGRUPO: " + APIs.Grupo(p));
            p.sendMessage("§e§lCONTA §fLIGA: " + ScoreBoard.getRankName(p));
            p.sendMessage("");
            p.sendMessage("§e§lCONTA §7Utilize: /conta <nick> para saber informa\u00e7\u00f5es de outro(s) jogador(es).");
        }
        else if (p.getServer().getPlayer(args[0]) != null) {
            final Player alvo = Bukkit.getServer().getPlayer(args[0]);
            p.sendMessage(" ");
            p.sendMessage("§e§lCONTA §fNICK: §7(§e" + alvo.getName() + "§7)");
            p.sendMessage("§e§lCONTA §fKILLS: §7(§e" + KillsAPI.getKills(alvo) + "§7)");
            p.sendMessage("§e§lCONTA §fDEATHS: §b§7(§e" + DeathAPI.getDeath(alvo) + "§7)");
            p.sendMessage("§e§lCONTA §fKILLSTREAK: §7(§e" + alvo.getLevel() + "§7)");
            p.sendMessage("§e§lCONTA §fXP: §7(§e" + XpAPI.getXp(alvo) + "§7)");
            p.sendMessage("§e§lCONTA §fMOEDAS: §7(§e" + MoneyAPI.getMoney(alvo) + "§7)");
            p.sendMessage("§e§lCONTA §fGRUPO: " + APIs.Grupo(p));
            p.sendMessage("§e§lCONTA §fLIGA: " + ScoreBoard.getRankName(alvo));
            p.sendMessage("");
        }
        else {
            final String jogadoralvo = args[0];
            p.sendMessage("§f§lOFFLINE §fO jogador §7(§e" + jogadoralvo + "§7) §fest\u00e1 offline");
        }
        return false;
    }
}
