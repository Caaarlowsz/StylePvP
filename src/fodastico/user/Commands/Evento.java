package fodastico.user.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.caaarlowsz.stylemc.kitpvp.StylePvP;
import fodastico.user.Apis.EventoAPI;

public class Evento implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (!(sender instanceof Player)) {
			return true;
		}
		final Player p = (Player) sender;
		if (!cmd.getName().equalsIgnoreCase("evento")) {
			return false;
		}
		if (!p.hasPermission("kitpvp.evento")) {
			p.sendMessage("�e�lPERMISSAO �fVoc\u00ea n\u00e3o possui �4�lPERMISSAO �fpara executar este �3�lCOMANDO.");
			return true;
		}
		if (args.length == 0) {
			p.sendMessage("�6�lEVENTO �fUtilize: /evento <iniciar> <desligar>");
			return true;
		}
		if (args.length == 1) {
			if (args[0].equalsIgnoreCase("iniciar")) {
				if (EventoAPI.onEvent) {
					p.sendMessage("�6�lEVENTO �fJa possui um �e�lEVENTO �fem andamento!");
					return true;
				}
				p.sendMessage("�6�lEVENTO �fVoc\u00ea �a�lLIGOU �fum �e�lEVENTO�f!");
				Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage(
						"�6�lEVENTO �fUm �e�lEVENTO �fest\u00e1 iniciando agora! �fUtilize: /warp evento para participar!");
				Bukkit.broadcastMessage(" ");
				EventoAPI.onEvent = true;
				Bukkit.getScheduler().scheduleSyncDelayedTask(StylePvP.getPlugin(), (Runnable) new Runnable() {
					@Override
					public void run() {
						if (EventoAPI.onEvent) {
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(
									"�6�lEVENTO �fUm �e�lEVENTO �fest\u00e1 iniciando agora! �fUtilize: /warp evento para participar! �c�l30 SEGUNDOS RESTANTES!");
							Bukkit.broadcastMessage(" ");
						}
					}
				}, 100L);
				Bukkit.getScheduler().scheduleSyncDelayedTask(StylePvP.getPlugin(), (Runnable) new Runnable() {
					@Override
					public void run() {
						if (EventoAPI.onEvent) {
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(
									"�6�lEVENTO �fUm �e�lEVENTO �fest\u00e1 iniciando agora! �fUtilize: /warp evento para participar! �c�l25 SEGUNDOS RESTANTES!");
							Bukkit.broadcastMessage(" ");
						}
					}
				}, 200L);
				Bukkit.getScheduler().scheduleSyncDelayedTask(StylePvP.getPlugin(), (Runnable) new Runnable() {
					@Override
					public void run() {
						if (EventoAPI.onEvent) {
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(
									"�6�lEVENTO �fUm �e�lEVENTO �fest\u00e1 iniciando agora! �fUtilize: /warp evento para participar! �c�l20 SEGUNDOS RESTANTES!");
							Bukkit.broadcastMessage(" ");
						}
					}
				}, 300L);
				Bukkit.getScheduler().scheduleSyncDelayedTask(StylePvP.getPlugin(), (Runnable) new Runnable() {
					@Override
					public void run() {
						if (EventoAPI.onEvent) {
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(
									"�6�lEVENTO �fUm �e�lEVENTO �fest\u00e1 iniciando agora! �fUtilize: /warp evento para participar! �c�l15 SEGUNDOS RESTANTES!");
							Bukkit.broadcastMessage(" ");
						}
					}
				}, 400L);
				Bukkit.getScheduler().scheduleSyncDelayedTask(StylePvP.getPlugin(), (Runnable) new Runnable() {
					@Override
					public void run() {
						if (EventoAPI.onEvent) {
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(
									"�6�lEVENTO �fUm �e�lEVENTO �fest\u00e1 iniciando agora! �fUtilize: /warp evento para participar! �c�l10 SEGUNDOS RESTANTES!");
							Bukkit.broadcastMessage(" ");
						}
					}
				}, 500L);
				Bukkit.getScheduler().scheduleSyncDelayedTask(StylePvP.getPlugin(), (Runnable) new Runnable() {
					@Override
					public void run() {
						if (EventoAPI.onEvent) {
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(
									"�6�lEVENTO �fUm �e�lEVENTO �fest\u00e1 iniciando agora! �fUtilize: /warp evento para participar! �c�l5 SEGUNDOS RESTANTES!");
							Bukkit.broadcastMessage(" ");
						}
					}
				}, 600L);
				Bukkit.getScheduler().scheduleSyncDelayedTask(StylePvP.getPlugin(), (Runnable) new Runnable() {
					@Override
					public void run() {
						if (EventoAPI.onEvent) {
							EventoAPI.closeEvent = true;
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(
									"�6�lEVENTO �fA �a�lENTRADA �fpara o �e�lEVENTO �ffoi �c�lFECHADA�f!");
							Bukkit.broadcastMessage(" ");
						}
					}
				}, 700L);
			} else if (args[0].equalsIgnoreCase("desligar")) {
				if (!EventoAPI.onEvent) {
					p.sendMessage("�6�lEVENTO �fNenhum �e�lEVENTO �fest\u00e1 em andamento!");
					return true;
				}
				EventoAPI.onEvent = false;
				EventoAPI.closeEvent = false;
				Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage("�6�lEVENTO �fO �e�lEVENTO �ffoi �a�lFINALIZADO�f!");
				Bukkit.broadcastMessage(" ");
				EventoAPI.quitEvent();
				return true;
			}
		}
		return true;
	}
}
