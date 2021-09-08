package fodastico.user.Commands;

import fodastico.user.Apis.StaffOnlineAPI;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class Equipe implements CommandExecutor
{
    public boolean onCommand(final CommandSender Sender, final Command Cmd, final String Label, final String[] Args) {
        if (!(Sender instanceof Player)) {
            Sender.sendMessage("§cVoc\u00ea n\u00e3o \u00e9 um jogador.");
            return false;
        }
        final Player p = (Player)Sender;
        if (Args.length != 0 || (!Cmd.getName().equalsIgnoreCase("equipe") && !Cmd.getName().equalsIgnoreCase("staffonline"))) {
            return false;
        }
        if (!p.hasPermission("kitpvp.equipe")) {
            p.sendMessage("§b§lSTAFFS ONLINE §fVoc\u00ea n\u00e3o possui §c§lPERMISSAO §fpara ver os §9§lSTAFFERS ONLINE§f!");
            return true;
        }
        p.sendMessage("§b§lSTAFFS ONLINE §fCaso tenha algum §d§lSTAFFER §fonline, voc\u00ea ver\u00e1 abaixo:");
        p.sendMessage(" ");
        StaffOnlineAPI.getStaffsOnline(p);
        return true;
    }
}
