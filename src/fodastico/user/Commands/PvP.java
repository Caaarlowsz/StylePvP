package fodastico.user.Commands;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class PvP implements CommandExecutor
{
    public static boolean worldpvp;
    
    static {
        PvP.worldpvp = false;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("pvp")) {
            if (!p.hasPermission("kitpvp.pvp")) {
                p.sendMessage("§e§lPERMISSAO §fVoc\u00ea n\u00e3o possui §4§lPERMISSAO §fpara executar este §3§lCOMANDO.");
                return true;
            }
            if (args.length == 0) {
                p.sendMessage("§6§lPVP §fUtilize /pvp <on> <off>");
                return true;
            }
            if (args.length == 1 && args[0].equalsIgnoreCase("on")) {
                if (PvP.worldpvp) {
                    p.sendMessage("§6§lPVP §fO §e§lPVP §fdo servidor j\u00e1 est\u00e1 §a§lATIVADO§f!");
                    return true;
                }
                PvP.worldpvp = true;
                p.getWorld().setPVP(true);
                p.sendMessage("§6§lPVP §fVoc\u00ea §a§lATIVOU §fo §e§lPVP §fdo servidor§f!");
                Bukkit.broadcastMessage("§6§lPVP §fO §e§lPVP §fdo servidor foi §a§lATIVADO §fpor: §b" + p.getName() + "§f.");
                return true;
            }
            else if (args[0].equalsIgnoreCase("off")) {
                if (!PvP.worldpvp) {
                    p.sendMessage("§6§lPVP §fO §e§lPVP §fdo servidor j\u00e1 est\u00e1 §c§lDESATIVADO§f!");
                    return true;
                }
                PvP.worldpvp = false;
                p.getWorld().setPVP(false);
                p.sendMessage("§6§lPVP §fVoc\u00ea §c§lDESATIVOU §fo §e§lPVP §fdo servidor§f!");
                Bukkit.broadcastMessage("§6§lPVP §fO §e§lPVP §fdo servidor foi §c§lDESATIVADO §fpor: §b" + p.getName() + "§f.");
                return true;
            }
        }
        return false;
    }
}
