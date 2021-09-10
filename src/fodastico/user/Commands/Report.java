package fodastico.user.Commands;

import java.util.ArrayList;
import java.util.Arrays;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fodastico.user.Main;
import fodastico.user.Managers.ChatInterativo;

public class Report implements CommandExecutor {
	public ArrayList<String> hasReported;

	public Report() {
		this.hasReported = new ArrayList<String>();
	}

	public boolean onCommand(final CommandSender sender, final Command Cmd, final String Label, final String[] Args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§cVoc\u00ea n\u00e3o \u00e9 um jogador.");
			return false;
		}
		final Player p = (Player) sender;
		if (Cmd.getName().equalsIgnoreCase("report")) {
			if (Args.length >= 2) {
				final Player acusado = p.getServer().getPlayer(Args[0]);
				final String nameoff = Args[0];
				if (acusado != null) {
					if (this.hasReported.contains(p.getName())) {
						p.sendMessage("§9§lREPORT §fAguarde para enviar outro report.");
						return true;
					}
					if (acusado == p) {
						p.sendMessage("§9§lREPORT §fVoc\u00ea n\u00e3o pode se reportar.");
						return true;
					}
					final String reportMsg = StringUtils.join((Object[]) Arrays.copyOfRange(Args, 1, Args.length), " ");
					this.hasReported.add(p.getName());
					p.sendMessage("§9§lREPORT §aVoc\u00ea reportou o(a) jogador(a) §7(§f" + acusado.getName()
							+ "§7) §apor §7§(§e" + reportMsg + "§7)§a.");
					Player[] onlinePlayers;
					for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
						final Player players = onlinePlayers[i];
						if (players.hasPermission("kitpvp.report")) {
							players.getPlayer().playSound(p.getPlayer().getLocation(), Sound.ANVIL_USE, 5.0f, 5.0f);
							players.sendMessage("§4§l NOVO REPORT ");
							players.sendMessage(" ");
							players.sendMessage("§fV\u00edtima §8» §e" + p.getName());
							players.sendMessage("§fAcusado §8» §e" + acusado.getName());
							players.sendMessage("§fMotivo §8» §e" + reportMsg);
							players.sendMessage("§fServidor §f8» §eKit-PvP");
							ChatInterativo.Comando(p.getName(), "§6§l[TELEPORT]", "/tp " + acusado.getName(),
									"§7(§cClique para teleportar ao acusado§7)");
							players.sendMessage("");
							Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(),
									(Runnable) new Runnable() {
										@Override
										public void run() {
											Report.this.hasReported.remove(p.getName());
										}
									}, 600L);
						}
					}
				} else {
					p.sendMessage("§f§lOFFLINE §fO jogador §7(§e" + nameoff + "§7) est\u00e1 offline.");
				}
			} else {
				p.sendMessage("§9§lREPORT §fUtilize: /report <jogador> <motivo>");
			}
		}
		return false;
	}
}
