package fodastico.user.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import java.util.ArrayList;
import org.bukkit.command.CommandExecutor;

public class Tell implements CommandExecutor
{
    static ArrayList<Player> tellunactived;
    
    static {
        Tell.tellunactived = new ArrayList<Player>();
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cVoc\u00ea n\u00e3o \u00e9 um jogador.");
            return false;
        }
        final Player p = (Player)sender;
        if (label.equalsIgnoreCase("tell") || label.equalsIgnoreCase("msg")) {
            if (args.length == 0) {
                p.sendMessage("§6§lTELL §fUtilize: /tell <jogador> <mensagem>");
                p.sendMessage("§6§lTELL §fPara desativar/ativar seu tell utilize: /tell <on> <off>");
                return true;
            }
            final Player messenger = Bukkit.getPlayer(args[0]);
            if (messenger == p) {
                p.sendMessage("§6§lTELL §fVoc\u00ea n\u00e3o pode §a§lENVIAR §fmensagens para voc\u00ea mesmo.");
                return true;
            }
            if (args[0].toLowerCase().equalsIgnoreCase("on")) {
                Tell.tellunactived.remove(p);
                p.sendMessage(String.valueOf("§6§lTELL §fVoc\u00ea §a§lATIVOU §fseu §e§lTELL §fe n\u00e3o receber\u00e1 nenhuma mensagem."));
            }
            else if (args[0].toLowerCase().equalsIgnoreCase("off")) {
                Tell.tellunactived.add(p);
                p.sendMessage(String.valueOf("§6§lTELL §aVoc\u00ea §cdesativou §fseu §e§lTELL §fe poder\u00e1 receber mensagens."));
            }
            if (args.length > 1) {
                if (messenger == null) {
                    p.sendMessage("§6§lTELL §fEste jogador n\u00e3o est\u00e1 online.");
                    return true;
                }
                if (Tell.tellunactived.contains(messenger)) {
                    p.sendMessage(String.valueOf("§6§lTELL §fO §e§lTELL §fdeste jogador est\u00e1 §c§lDESATIVADO§f!"));
                    return true;
                }
                final StringBuilder sb = new StringBuilder();
                for (int i = 1; i < args.length; ++i) {
                    sb.append(args[i]).append(" ");
                }
                final String message = sb.toString().trim();
                p.sendMessage("§6§lTELL §7(§fVoc\u00ea §8» " + messenger.getDisplayName() + "§7)§f»§e " + message);
                messenger.sendMessage("§6§lTELL §7(§fDe §f8» " + p.getDisplayName() + "§7)§f»§e " + message);
            }
        }
        return false;
    }
}
