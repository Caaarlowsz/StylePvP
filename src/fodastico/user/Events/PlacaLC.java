package fodastico.user.Events;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import fodastico.user.Apis.KitAPI;
import fodastico.user.Apis.MoneyAPI;
import fodastico.user.Warp.WarpsManager;

public class PlacaLC implements Listener {
	@EventHandler
	public void Escrever(final SignChangeEvent e) {
		final Player player = e.getPlayer();
		if (!player.hasPermission("kitpvp.placalc")) {
			return;
		}
		if (e.getLine(0).equalsIgnoreCase("facil")) {
			e.setLine(0, " ");
			e.setLine(1, "  §a§lFACIL");
			e.setLine(2, " §7COMPLETE");
			e.setLine(3, " ");
		}
		if (e.getLine(0).equalsIgnoreCase("medio")) {
			e.setLine(0, " ");
			e.setLine(1, "  §e§lMEDIO");
			e.setLine(2, " §7COMPLETE");
			e.setLine(3, " ");
		}
		if (e.getLine(0).equalsIgnoreCase("dificil")) {
			e.setLine(0, " ");
			e.setLine(1, "  §c§lDIFICIL");
			e.setLine(2, " §7COMPLETE");
			e.setLine(3, " ");
		}
		if (e.getLine(0).equalsIgnoreCase("extreme")) {
			e.setLine(0, " ");
			e.setLine(1, "  §4§lEXTREME");
			e.setLine(2, " §7COMPLETE");
			e.setLine(3, " ");
		}
	}

	@EventHandler
	public void inv(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getClickedBlock() != null
				&& (e.getClickedBlock().getType() == Material.WALL_SIGN
						|| e.getClickedBlock().getType() == Material.SIGN_POST)) {
			final Sign s = (Sign) e.getClickedBlock().getState();
			final String[] lines = s.getLines();
			if (lines.length > 0 && lines[0].equals(" ") && lines.length > 1 && lines[1].equals("  §a§lFACIL")
					&& lines.length > 2 && lines[2].equals(" §7COMPLETE") && lines.length > 3 && lines[3].equals(" ")) {
				p.sendMessage(
						"§3§lCHALLENGE §fVoc\u00ea completou a lava challenge §a§lFACIL §fe ganhou §6§l50 MOEDAS§f.");
				MoneyAPI.addMoney(p, 50);
				p.setGameMode(GameMode.SURVIVAL);
				p.closeInventory();
				p.getInventory().clear();
				KitAPI.setNoArmorDefaultItens(p);
				p.getInventory().setArmorContents((ItemStack[]) null);
				WarpsManager.Ir(p, "Challenge");
			}
			if (lines.length > 0 && lines[0].equals(" ") && lines.length > 1 && lines[1].equals("  §e§lMEDIO")
					&& lines.length > 2 && lines[2].equals(" §7COMPLETE") && lines.length > 3 && lines[3].equals(" ")) {
				p.sendMessage(
						"§3§lCHALLENGE §fVoc\u00ea completou a lava challenge §e§lMEDIO §fe ganhou §6§l100 MOEDAS§f.");
				MoneyAPI.addMoney(p, 100);
				p.setGameMode(GameMode.SURVIVAL);
				p.closeInventory();
				p.getInventory().clear();
				KitAPI.setNoArmorDefaultItens(p);
				p.getInventory().setArmorContents((ItemStack[]) null);
				WarpsManager.Ir(p, "Challenge");
			}
			if (lines.length > 0 && lines[0].equals(" ") && lines.length > 1 && lines[1].equals("  §c§lDIFICIL")
					&& lines.length > 2 && lines[2].equals(" §7COMPLETE") && lines.length > 3 && lines[3].equals(" ")) {
				p.sendMessage(
						"§3§lCHALLENGE §fVoc\u00ea completou a lava challenge §c§lDIFICIL §fe ganhou §6§l150 MOEDAS§f.");
				MoneyAPI.addMoney(p, 150);
				p.setGameMode(GameMode.SURVIVAL);
				p.closeInventory();
				p.getInventory().clear();
				KitAPI.setNoArmorDefaultItens(p);
				p.getInventory().setArmorContents((ItemStack[]) null);
				WarpsManager.Ir(p, "Challenge");
			}
			if (lines.length > 0 && lines[0].equals(" ") && lines.length > 1 && lines[1].equals("  §4§lEXTREME")
					&& lines.length > 2 && lines[2].equals(" §7COMPLETE") && lines.length > 3 && lines[3].equals(" ")) {
				Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage("§3§lCHALLENGE §fO jogador §e§l" + p.getName()
						+ " §fcompletou o n\u00edvel §4§lEXTREME §fdo §4§fCHALLENGE§f.");
				Bukkit.broadcastMessage(" ");
				p.sendMessage(
						"§3§lCHALLENGE §fVoc\u00ea completou a lava challenge §4§lEXTREME §fe ganhou §6§l250 MOEDAS§f.");
				MoneyAPI.addMoney(p, 250);
				p.setGameMode(GameMode.SURVIVAL);
				p.closeInventory();
				p.getInventory().clear();
				KitAPI.setNoArmorDefaultItens(p);
				p.getInventory().setArmorContents((ItemStack[]) null);
				WarpsManager.Ir(p, "Challenge");
			}
		}
	}
}
