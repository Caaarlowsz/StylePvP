package fodastico.user.Commands;

import fodastico.user.Events.EventosGerais;
import fodastico.user.Apis.TopKsAPI;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class SetarKs implements CommandExecutor
{
    public boolean onCommand(final CommandSender Sender, final Command Cmd, final String Label, final String[] Args) {
        if (!(Sender instanceof Player)) {
            Sender.sendMessage("§cVoc\u00ea n\u00e3o \u00e9 um jogador.");
            return false;
        }
        final Player p = (Player)Sender;
        if (Cmd.getName().equalsIgnoreCase("setarks")) {
            if (!p.hasPermission("kitpvp.setarks")) {
                p.sendMessage("§e§lPERMISSAO §fVoc\u00ea n\u00e3o possui §4§lPERMISSAO §fpara executar este §b§lCOMANDO§f!");
                return true;
            }
            TopKsAPI.addTopKs(p, 1);
            EventosGerais.KillStreak(p);
        }
        return false;
    }
}
