package fodastico.user.Commands;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class Gm implements CommandExecutor
{
    public boolean onCommand(final CommandSender Sender, final Command Cmd, final String Label, final String[] Args) {
        if (!(Sender instanceof Player)) {
            Sender.sendMessage("§cVoc\u00ea n\u00e3o \u00e9 um jogador.");
            return false;
        }
        final Player p = (Player)Sender;
        if (Cmd.getName().equalsIgnoreCase("gm")) {
            if (!p.hasPermission("kitpvp.gm")) {
                p.sendMessage("§e§lPERMISSAO §fVoc\u00ea n\u00e3o possui §4§lPERMISSAO §fpara executar este §3§lCOMANDO.");
                return true;
            }
            if (Args.length == 0) {
                p.sendMessage("§6§lGAMEMODE §fUtilize: /gm <1> <0> [jogador]");
                return true;
            }
            if (Args[0].equalsIgnoreCase("1")) {
                if (p.getGameMode().equals((Object)GameMode.CREATIVE)) {
                    p.sendMessage("§6§lGAMEMODE §fSeu §e§lGAMEMODE §fj\u00e1 est\u00e1 no §a§lCRIATIVO§f!");
                    return true;
                }
                p.setGameMode(GameMode.CREATIVE);
                p.sendMessage("§6§lGAMEMODE §fSeu §e§lGAMEMODE §ffoi alterado para §a§lCRIATIVO§f!");
                return true;
            }
            else if (Args[0].equalsIgnoreCase("0")) {
                if (p.getGameMode().equals((Object)GameMode.SURVIVAL)) {
                    p.sendMessage("§6§lGAMEMODE §fSeu §e§lGAMEMODE §fj\u00e1 est\u00e1 no §e§lSOBREVIVENCIA§f!");
                    return true;
                }
                p.setGameMode(GameMode.SURVIVAL);
                p.sendMessage("§6§lGAMEMODE §fSeu §e§lGAMEMODE §ffoi alterado para §e§lSOBREVIVENCIA§f!");
                return true;
            }
        }
        return false;
    }
}
