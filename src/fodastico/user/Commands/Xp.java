package fodastico.user.Commands;

import fodastico.user.Apis.XpAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class Xp implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cVoc\u00ea n\u00e3o \u00e9 um jogador.");
            return false;
        }
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("xp")) {
            if (!p.hasPermission("kitpvp.xp")) {
                p.sendMessage("§e§lPERMISSAO §7Voc\u00ea n\u00e3o possui §4§lPERMISSAO §7para executar este §3§lCOMANDO.");
                return true;
            }
            if (args.length == 0) {
                p.sendMessage("§a§lXP §fUtilize: /xp <add/remove> (player) [quantidade]");
                return true;
            }
            if (args.length < 3) {
                p.sendMessage("§a§lXP §fUtilize: /xp <add/remove> (player) [quantidade]");
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
                    XpAPI.addXp(t, tanto);
                    p.sendMessage("§a§lXP §fVoc\u00ea adiconou §a§l" + tanto + " XP´s §fna §e§lCONTA §fdo jogador §7[§e" + t.getName() + "§7]§f!");
                    t.sendMessage("§a§lXP §fVoc\u00ea acabou de receber §a§l" + tanto + " XP´s §ana sua §e§lCONTA§f!");
                    t.sendMessage("§a§lXP §eStaffer §7(§f" + p.getName() + "§7)§f.");
                }
                catch (Exception e) {
                    p.sendMessage("§a§lXP §fUtilize apenas §9§lNUMEROS§f!");
                }
            }
            else {
                if (!args[0].equalsIgnoreCase("remove")) {
                    p.sendMessage("§a§lXP §fUtilize: /xp <add/remove> (player) [quantidade]");
                    return true;
                }
                try {
                    XpAPI.removeXp(t, tanto);
                    p.sendMessage("§a§lXP §fVoc\u00ea removeu §a§l" + tanto + " XP´s §fda §e§lCONTA §fdo jogador §7[§e" + t.getName() + "§7]§f!");
                    t.sendMessage("§a§lXP §fForam removidas §a§l" + tanto + " XP´s §fda sua §e§lCONTA§f!");
                    t.sendMessage("§a§lXP §eStaffer §7(§f" + p.getName() + "§7)§f.");
                }
                catch (Exception e) {
                    p.sendMessage("§a§lXP §fUtilize apenas §9§lNUMEROS§f!");
                }
            }
        }
        return false;
    }
}
