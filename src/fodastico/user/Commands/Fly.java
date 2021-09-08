package fodastico.user.Commands;

import fodastico.user.Apis.KitAPI;
import fodastico.user.FullVIP.VipallAPI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import java.util.ArrayList;
import org.bukkit.command.CommandExecutor;

public class Fly implements CommandExecutor
{
    public static ArrayList<Player> Fly;
    
    static {
        fodastico.user.Commands.Fly.Fly = new ArrayList<Player>();
    }
    
    public boolean onCommand(final CommandSender Sender, final Command Cmd, final String Label, final String[] Args) {
        if (!(Sender instanceof Player)) {
            Sender.sendMessage("§cVoc\u00ea n\u00e3o \u00e9 um jogador.");
            return false;
        }
        final Player p = (Player)Sender;
        if (Cmd.getName().equalsIgnoreCase("fly")) {
            if (!p.hasPermission("kitpvp.fly") || VipallAPI.vipall) {
                p.sendMessage("§e§lPERMISSAO §fVoc\u00ea n\u00e3o possui §4§lPERMISSAO §fpara executar este §3§lCOMANDO.");
                return true;
            }
            if (Args.length == 0 && KitAPI.getkit(p) == "Spawn") {
                if (!fodastico.user.Commands.Fly.Fly.contains(p)) {
                    p.sendMessage("§9§lFLY §fVoc\u00ea §a§lHABILITOU §fseu modo §b§lFLY");
                    p.setAllowFlight(true);
                    p.setFlying(true);
                    fodastico.user.Commands.Fly.Fly.add(p);
                    return true;
                }
                p.sendMessage("§9§lFLY §fVoc\u00ea §c§lDESABILITOU §fseu modo §b§lFLY");
                p.setAllowFlight(false);
                p.setFlying(false);
                fodastico.user.Commands.Fly.Fly.remove(p);
                return false;
            }
            else if (KitAPI.getkit(p) != "Spawn") {
                p.setAllowFlight(false);
                p.setFlying(false);
                fodastico.user.Commands.Fly.Fly.remove(p);
                p.sendMessage("§9§lFLY §fSeu modo §b§lFLY §fs\u00f3 pode ser §a§lHABILITADO §fno §6§lSPAWN");
                return true;
            }
        }
        return false;
    }
}
