package fodastico.user.Commands;

import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import java.util.HashMap;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;

public class Build implements Listener, CommandExecutor
{
    public static HashMap<String, BuilderMode> Build;
    
    static {
        fodastico.user.Commands.Build.Build = new HashMap<String, BuilderMode>();
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cVoc\u00ea n\u00e3o \u00e9 um jogador.");
            return true;
        }
        final Player p = (Player)sender;
        if (!p.hasPermission("kitpvp.build")) {
            sender.sendMessage("§e§lPERMISSAO §fVoc\u00ea n\u00e3o possui §4§lPERMISSAO §fpara executar este §3§lCOMANDO.");
            return true;
        }
        if (args.length == 0) {
            p.sendMessage("§6§lBUILD §fUtilize: /build <on> <off>");
        }
        else if (args[0].equalsIgnoreCase("on")) {
            if (fodastico.user.Commands.Build.Build.get(p.getName()) == BuilderMode.TRUE) {
                p.sendMessage("§6§lBUILD §fSeu modo §e§lBUILD §fj\u00e1 est\u00e1 §a§lATIVADO!");
                return true;
            }
            p.sendMessage("§e§lBUILD §fVoc\u00ea §a§lATIVOU §fseu modo §e§lBUILD!");
            fodastico.user.Commands.Build.Build.put(p.getName(), BuilderMode.TRUE);
            return true;
        }
        else if (args[0].equalsIgnoreCase("off")) {
            if (fodastico.user.Commands.Build.Build.get(p.getName()) == BuilderMode.FALSE) {
                p.sendMessage("§e§lBUILD §fSeu modo §e§lBUILD §fj\u00e1 est\u00e1 §c§lDESATIVADO!");
                return true;
            }
            p.sendMessage("§e§lBUILD §fVoc\u00ea §c§lDESATIVOU §fseu modo §e§lBUILD!");
            fodastico.user.Commands.Build.Build.put(p.getName(), BuilderMode.FALSE);
            return true;
        }
        return false;
    }
    
    public enum BuilderMode
    {
        TRUE("TRUE", 0), 
        FALSE("FALSE", 1);
        
        private BuilderMode(final String s, final int n) {
        }
    }
}
