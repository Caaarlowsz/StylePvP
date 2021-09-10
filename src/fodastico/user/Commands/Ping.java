package fodastico.user.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import net.minecraft.server.v1_7_R4.EntityPlayer;

public class Ping implements CommandExecutor, Listener {
	public boolean onCommand(final CommandSender sender, final Command command, final String label,
			final String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§cVoc\u00ea n\u00e3o \u00e9 um jogador.");
			return false;
		}
		if (!label.equalsIgnoreCase("ping")) {
			return false;
		}
		if (args.length == 0) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("§cVoc\u00ea n\u00e3o \u00e9 um jogador.");
				return true;
			}
			final CraftPlayer cp = (CraftPlayer) sender;
			final EntityPlayer ep = cp.getHandle();
			sender.sendMessage("§a§lPING §aSeu §a§lPING \u00e9 de " + ep.ping + " ms");
			return true;
		} else {
			if (args.length != 1) {
				sender.sendMessage("§a§lPING §fUtilize: /ping <player>");
				return true;
			}
			final Player target = Bukkit.getPlayer(args[0]);
			final String nameoff = args[0];
			if (target == null) {
				sender.sendMessage("§f§lOFFLINE §fO jogador §7(§e" + nameoff + "§7) §fest\u00e1 offline.");
				return true;
			}
			final CraftPlayer cp2 = (CraftPlayer) target;
			final EntityPlayer ep2 = cp2.getHandle();
			sender.sendMessage("§a§lPING §aO ping do(a) jogador(a) §7(§f" + target.getName() + "§7) §a\u00e9 de "
					+ ep2.ping + " ms.");
			return true;
		}
	}
}
