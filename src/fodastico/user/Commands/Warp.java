package fodastico.user.Commands;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fodastico.user.Main;
import fodastico.user.Apis.EventoAPI;
import fodastico.user.Apis.ImortalAPI;
import fodastico.user.Apis.KitAPI;
import fodastico.user.Warp.WarpsManager;
import fodastico.user.Warp.WarpsMenu;

public class Warp implements CommandExecutor {
	public static HashMap<String, String> inEvent;

	static {
		Warp.inEvent = new HashMap<String, String>();
	}

	public boolean onCommand(final CommandSender Sender, final Command Cmd, final String Label, final String[] Args) {
		final Player p = (Player) Sender;
		if (Cmd.getName().equalsIgnoreCase("warp")) {
			if (Args.length == 0) {
				WarpsMenu.inventoryWarps(p);
				return true;
			}
			if (Args[0].equalsIgnoreCase("fps")) {
				p.closeInventory();
				p.sendMessage(
						"§3§lWARPS §fVoc\u00ea ser\u00e1 teleportado para a §9§lWARP §9§lFPS §fem §9§l5 SEGUNDOS...");
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
					@Override
					public void run() {
						p.setGameMode(GameMode.SURVIVAL);
						p.closeInventory();
						p.getInventory().clear();
						p.getInventory().setArmorContents((ItemStack[]) null);
						KitAPI.setFpsItens(p);
						WarpsManager.Ir(p, "Fps");
						KitAPI.setKit(p, "Fps");
						p.sendMessage("§3§lWARPS §fVoc\u00ea foi teleportado para a §9§lWARP FPS");
					}
				}, 100L);
			}
			if (Args[0].equalsIgnoreCase("pot")) {
				p.closeInventory();
				p.sendMessage(
						"§3§lWARPS §fVoc\u00ea ser\u00e1 teleportado para a §9§lWARP §9§lPOT §fem §9§l5 SEGUNDOS...");
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
					@Override
					public void run() {
						p.setGameMode(GameMode.SURVIVAL);
						p.closeInventory();
						p.getInventory().clear();
						p.getInventory().setArmorContents((ItemStack[]) null);
						KitAPI.setPotItens(p);
						WarpsManager.Ir(p, "Pot");
						KitAPI.setKit(p, "Pot");
						p.sendMessage("§3§lWARPS §fVoc\u00ea foi teleportado para a §9§lWARP POT");
					}
				}, 100L);
			} else if (Args[0].equalsIgnoreCase("textura")) {
				p.closeInventory();
				p.sendMessage(
						"§3§lWARPS §fVoc\u00ea ser\u00e1 teleportado para a §9§lWARP §9§lTEXTURA §fem §9§l5 SEGUNDOS...");
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
					@Override
					public void run() {
						p.setGameMode(GameMode.SURVIVAL);
						p.closeInventory();
						p.getInventory().clear();
						p.getInventory().setArmorContents((ItemStack[]) null);
						WarpsManager.Ir(p, "Textura");
						ImortalAPI.setInvensibility(p);
						KitAPI.RemoveKit(p);
						p.sendMessage("§3§lWARPS §fVoc\u00ea foi teleportado para a §9§lWARP TEXTURA");
					}
				}, 100L);
			} else if (Args[0].equalsIgnoreCase("evento")) {
				if (EventoAPI.onEvent && !EventoAPI.closeEvent) {
					p.closeInventory();
					p.getInventory().clear();
					p.getInventory().setArmorContents((ItemStack[]) null);
					WarpsManager.Ir(p, "Evento");
					KitAPI.setKit(p, "Evento");
					Warp.inEvent.put(p.getName(), "/spawn");
					p.sendMessage("§3§lWARPS §fVoc\u00ea foi teleportado para a §9§lWARP EVENTO");
					p.getInventory().clear();
					p.updateInventory();
					Main.sc.registerScoreBoard(p);
				} else {
					p.closeInventory();
					p.sendMessage(
							"§e§lEVENTO §fNenhum §6§lEVENTO §fest\u00e1 iniciando agora ou j\u00e1 possui um §6§lEVENTO §fem §a§lANDAMENTO§f!");
				}
			} else if (Args[0].equalsIgnoreCase("1v1")) {
				p.sendMessage(
						"§3§lWARPS §fVoc\u00ea ser\u00e1 teleportado para a §9§lWARP §9§l1v1 §fem §9§l5 SEGUNDOS...");
				p.closeInventory();
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
					@Override
					public void run() {
						p.setGameMode(GameMode.SURVIVAL);
						p.closeInventory();
						p.getInventory().clear();
						p.getInventory().setArmorContents((ItemStack[]) null);
						KitAPI.RemoveKit(p);
						ImortalAPI.setInvensibility(p);
						WarpsManager.Ir(p, "1v1");
						KitAPI.setKit(p, "1v1");
						Main.sc.registerScoreBoard(p);
						p.sendMessage("§3§lWARPS §fVoc\u00ea foi teleportado para a §9§lWARP 1v1");
						final ItemStack blaze = new ItemStack(Material.BLAZE_ROD);
						final ItemMeta blaze2 = blaze.getItemMeta();
						blaze2.setDisplayName("§3§lDESAFIO");
						blaze.setItemMeta(blaze2);
						final ItemStack sack = new ItemStack(Material.INK_SACK, 1, (short) 8);
						final ItemMeta sack2 = sack.getItemMeta();
						sack2.setDisplayName("§a§lFAST1V1");
						sack.setItemMeta(sack2);
						p.getInventory().setItem(3, blaze);
						p.getInventory().setItem(5, sack);
					}
				}, 100L);
			} else if (Args[0].equalsIgnoreCase("challenge")) {
				p.sendMessage(
						"§3§lWARPS §fVoc\u00ea ser\u00e1 teleportado para a §9§lWARP §9§lCHALLENGE §fem §9§l5 SEGUNDOS...");
				p.closeInventory();
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
					@Override
					public void run() {
						p.setGameMode(GameMode.SURVIVAL);
						p.closeInventory();
						p.getInventory().clear();
						p.getInventory().setArmorContents((ItemStack[]) null);
						KitAPI.setChallengeItens(p);
						WarpsManager.Ir(p, "Challenge");
						KitAPI.setKit(p, "Challenge");
						p.sendMessage("§3§lWARPS §fVoc\u00ea foi teleportado para a §9§lWARP CHALLENGE");
					}
				}, 100L);
			}
		}
		return false;
	}
}
