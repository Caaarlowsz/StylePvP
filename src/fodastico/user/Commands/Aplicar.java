package fodastico.user.Commands;

import fodastico.user.Main;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class Aplicar implements CommandExecutor
{
    public boolean onCommand(final CommandSender Sender, final Command Cmd, final String Label, final String[] Args) {
        if (!(Sender instanceof Player)) {
            Sender.sendMessage("§cVoc\u00ea n\u00e3o \u00e9 um jogador.");
            return false;
        }
        final Player p = (Player)Sender;
        if (Args.length == 0 && (Cmd.getName().equalsIgnoreCase("aplicar") || Cmd.getName().equalsIgnoreCase("staff"))) {
            p.sendMessage(" ");
            p.sendMessage(Main.getInstance().getConfig().getString("MSG-APLICAR-1").replace("&", "§"));
            p.sendMessage(Main.getInstance().getConfig().getString("MSG-APLICAR-2").replace("&", "§"));
            p.sendMessage(Main.getInstance().getConfig().getString("MSG-APLICAR-3").replace("&", "§"));
            p.sendMessage(Main.getInstance().getConfig().getString("MSG-APLICAR-4").replace("&", "§"));
            p.sendMessage(Main.getInstance().getConfig().getString("MSG-APLICAR-5").replace("&", "§"));
            p.sendMessage(Main.getInstance().getConfig().getString("MSG-APLICAR-6").replace("&", "§"));
            p.sendMessage(Main.getInstance().getConfig().getString("MSG-APLICAR-7").replace("&", "§"));
            p.sendMessage(" ");
            return true;
        }
        return false;
    }
}
