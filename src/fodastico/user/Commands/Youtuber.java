package fodastico.user.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fodastico.user.Main;

public class Youtuber implements CommandExecutor {
	public boolean onCommand(final CommandSender Sender, final Command Cmd, final String Label, final String[] Args) {
		if (!(Sender instanceof Player)) {
			Sender.sendMessage("§cVoc\u00ea n\u00e3o \u00e9 um jogador.");
			return false;
		}
		final Player p = (Player) Sender;
		if (Cmd.getName().equalsIgnoreCase("youtuber")) {
			p.sendMessage(" ");
			p.sendMessage(Main.getInstance().getConfig().getString("MSG-YT-1").replace("&", "§"));
			p.sendMessage(Main.getInstance().getConfig().getString("MSG-YT-2").replace("&", "§"));
			p.sendMessage(Main.getInstance().getConfig().getString("MSG-YT-3").replace("&", "§"));
			p.sendMessage(Main.getInstance().getConfig().getString("MSG-YT-4").replace("&", "§"));
			p.sendMessage(Main.getInstance().getConfig().getString("MSG-YT-5").replace("&", "§"));
			p.sendMessage(Main.getInstance().getConfig().getString("MSG-YT-6").replace("&", "§"));
			p.sendMessage(Main.getInstance().getConfig().getString("MSG-YT-7").replace("&", "§"));
			p.sendMessage(Main.getInstance().getConfig().getString("MSG-YT-8").replace("&", "§"));
			p.sendMessage(Main.getInstance().getConfig().getString("MSG-YT-9").replace("&", "§"));
			p.sendMessage(Main.getInstance().getConfig().getString("MSG-YT-10").replace("&", "§"));
			p.sendMessage(Main.getInstance().getConfig().getString("MSG-YT-11").replace("&", "§"));
			p.sendMessage(Main.getInstance().getConfig().getString("MSG-YT-12").replace("&", "§"));
			p.sendMessage(Main.getInstance().getConfig().getString("MSG-YT-13").replace("&", "§"));
			p.sendMessage(Main.getInstance().getConfig().getString("MSG-YT-14").replace("&", "§"));
			p.sendMessage(Main.getInstance().getConfig().getString("MSG-YT-15").replace("&", "§"));
			p.sendMessage(Main.getInstance().getConfig().getString("MSG-YT-16").replace("&", "§"));
			p.sendMessage(Main.getInstance().getConfig().getString("MSG-YT-17").replace("&", "§"));
			p.sendMessage(Main.getInstance().getConfig().getString("MSG-YT-18").replace("&", "§"));
			p.sendMessage(Main.getInstance().getConfig().getString("MSG-YT-19").replace("&", "§"));
			p.sendMessage(" ");
		}
		return false;
	}
}
