package fodastico.user.Commands;

import org.bukkit.entity.Entity;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class Puxar implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cVoc\u00ea n\u00e3o \u00e9 um jogador.");
            return false;
        }
        final Player p = (Player)sender;
        if (!cmd.getName().equalsIgnoreCase("puxar")) {
            return false;
        }
        if (!p.hasPermission("kitpvp.puxar")) {
            p.sendMessage("§e§lPERMISSAO §fVoc\u00ea n\u00e3o possui §4§lPERMISSAO §fpara executar este §3§lCOMANDO.");
            return true;
        }
        if (args.length == 0) {
            p.sendMessage("§6§lPUXAR §fUtilize: /puxar <jogador>");
            return true;
        }
        final Player k = Bukkit.getPlayer(args[0]);
        final String nameoff = args[0];
        if (k == null) {
            p.sendMessage("§f§lOFFLINE §fO jogador §7(§e" + nameoff + "§7) §fest\u00e1 offline.");
            return true;
        }
        k.teleport((Entity)p);
        p.sendMessage("§6§lPUXAR §cVoc\u00ea puxou o(a) jogador(a) §7(§f" + k.getName() + "§7) §cat\u00e9 voc\u00ea.");
        return true;
    }
}
