package fodastico.user.Commands;

import org.bukkit.entity.Entity;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class Tp implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Negativo.");
            return true;
        }
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("tp")) {
            if (!p.hasPermission("kitpvp.tp")) {
                p.sendMessage("§e§lPERMISSAO §fVoc\u00ea n\u00e3o possui §c§lPERMISSAO§f para executar este §b§lCOMANDO§f!");
                return true;
            }
            if (args.length == 0) {
                p.sendMessage("§6§lTELEPORT §fUtilize: /tp <jogador>");
            }
            if (args.length == 1) {
                final Player p2 = Bukkit.getPlayer(args[0]);
                if (p2 == null) {
                    p.sendMessage("§4§lERRO§f Este jogador n\u00e3o est\u00e1 §4§lONLINE§f!");
                }
                p.teleport((Entity)p2);
                p.sendMessage("§6§lTELEPORT §fVoc\u00ea foi §6§lTELEPORTADO§f at\u00e9 o(a) §e" + p2.getName());
                return true;
            }
            if (args.length > 1) {
                p.sendMessage("§6§lTELEPORT §fUtilize apenas: /tp <jogador>, o §6§lTELEPORT §fpara coordenadas n\u00e3o est\u00e1 §c§lDISPONIVEL§f ainda.");
                return true;
            }
        }
        return false;
    }
}
