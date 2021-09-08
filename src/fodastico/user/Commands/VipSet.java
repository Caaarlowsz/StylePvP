package fodastico.user.Commands;

import org.bukkit.entity.Player;
import fodastico.user.Apis.APIs;
import fodastico.user.Managers.TituloAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class VipSet implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("vipset")) {
            if (!sender.hasPermission("kitpvp.vipset")) {
                sender.sendMessage("§e§lPERMISSAO §7Voc\u00ea n\u00e3o possui §4§lPERMISSAO §7para executar este §3§lCOMANDO.");
                return true;
            }
            if (args.length == 0) {
                sender.sendMessage("§6§lVIPSET §fUtilize: §a/vipset §e(jogador) §6(vip)");
                return true;
            }
            if (args.length == 1) {
                sender.sendMessage("§6§lVIPSET §fUtilize: §a/vipset §e(jogador) §6(vip)");
                return true;
            }
            if (args.length != 2) {
                sender.sendMessage("§6§lVIPSET §6§lVIP §fn\u00e3o existente.");
                return true;
            }
            final String vip = args[1];
            final Player player = Bukkit.getPlayer(args[0]);
            if (player == null) {
                sender.sendMessage("§6§lVIPSET §fEste jogador n\u00e3o est\u00e1 §4§lONLINE§f!");
                return true;
            }
            if (vip.equalsIgnoreCase("light")) {
                sender.sendMessage("§6§lVIPSET §fVoc\u00ea setou o §6§lVIP §a§lLIGHT §fna conta do jogador jogador §e" + player.getName() + "§e(" + player.getUniqueId() + "§e)");
                Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "pex user " + player.getName() + " group set light");
                TituloAPI.MandarTitulo(player, "§6§lVIP");
                TituloAPI.MandarSubTitulo(player, "§fVoc\u00ea recebeu o §6§lVIP §a§lLIGHT");
                player.sendMessage("§6§lVIP: §fSeu novo rank §6§lVIP §f\u00e9: §a§lLIGHT");
                APIs.Ultimate(player);
                return true;
            }
            if (vip.equalsIgnoreCase("premium")) {
                sender.sendMessage("§6§lVIPSET §fVoc\u00ea setou o §6§lVIP §6§lPREMIUM §fna conta do jogador jogador §e" + player.getName() + "§e(" + player.getUniqueId() + "§e)");
                Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "pex user " + player.getName() + " group set premium");
                TituloAPI.MandarTitulo(player, "§6§lVIP");
                TituloAPI.MandarSubTitulo(player, "§fVoc\u00ea recebeu o §6§lVIP §6§lPREMIUM");
                player.sendMessage("§6§lVIP: §fSeu novo rank §6§lVIP §f\u00e9: §6§lPREMIUM");
                APIs.Ultimate(player);
                return true;
            }
            if (vip.equalsIgnoreCase("beta")) {
                sender.sendMessage("§6§lVIPSET §fVoc\u00ea setou o §6§lVIP §1§lBETA §fna conta do jogador jogador §e" + player.getName() + "§e(" + player.getUniqueId() + "§e)");
                Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "pex user " + player.getName() + " group set beta");
                TituloAPI.MandarTitulo(player, "§6§lVIP");
                TituloAPI.MandarSubTitulo(player, "§fVoc\u00ea recebeu o §6§lVIP §1§lBETA");
                player.sendMessage("§6§lVIP: §fSeu novo rank §6§lVIP §f\u00e9: §1§lBETA");
                APIs.Ultimate(player);
                return true;
            }
            if (vip.equalsIgnoreCase("ultimate")) {
                sender.sendMessage("§6§lVIPSET §fVoc\u00ea setou o §6§lVIP §d§lULTIMATE §fna conta do jogador jogador §e" + player.getName() + "§e(" + player.getUniqueId() + "§e)");
                Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "pex user " + player.getName() + " group set ultimate");
                TituloAPI.MandarTitulo(player, "§6§lVIP");
                TituloAPI.MandarSubTitulo(player, "§fVoc\u00ea recebeu o §6§lVIP §d§lULTIMATE");
                player.sendMessage("§6§lVIP: §fSeu novo rank §6§lVIP §f\u00e9: §d§lULTIMATE");
                APIs.Ultimate(player);
                return true;
            }
        }
        return false;
    }
}
