package fodastico.user.Events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.github.caaarlowsz.stylemc.kitpvp.StylePvP;

public class Placas implements Listener {
	@EventHandler
	public void Recraft(final SignChangeEvent e) {
		final Player p = e.getPlayer();
		if (p.hasPermission("kitpvp.placa") && e.getLine(0).equalsIgnoreCase("recraft")) {
			e.setLine(0, StylePvP.getInstance().getConfig().getString("MSG-PLACA-RECRAFT-1").replace("&", "�"));
			e.setLine(2, StylePvP.getInstance().getConfig().getString("MSG-PLACA-RECRAFT-2").replace("&", "�"));
			e.setLine(3, StylePvP.getInstance().getConfig().getString("MSG-PLACA-RECRAFT-3").replace("&", "�"));
			p.sendMessage("�6�lPLACA �fA �e�lPLACA �fde �6�lRECRAFT �ffoi �a�lCRIADA �fcom sucesso!");
		}
	}

	@EventHandler
	public void InvRecraft(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK
				&& ((e.getClickedBlock() != null && e.getClickedBlock().getType() == Material.WALL_SIGN)
						|| e.getClickedBlock().getType() == Material.SIGN_POST)) {
			final Sign s = (Sign) e.getClickedBlock().getState();
			final String[] lines = s.getLines();
			if (lines.length > 0
					&& lines[0]
							.equals(StylePvP.getInstance().getConfig().getString("MSG-PLACA-RECRAFT-1").replace("&", "�"))
					&& lines.length > 2
					&& lines[2]
							.equals(StylePvP.getInstance().getConfig().getString("MSG-PLACA-RECRAFT-2").replace("&", "�"))
					&& lines.length > 3 && lines[3].equals(
							StylePvP.getInstance().getConfig().getString("MSG-PLACA-RECRAFT-3").replace("&", "�"))) {
				final Inventory inv = Bukkit.createInventory((InventoryHolder) p, 27, "�6�lRecraft");
				final ItemStack cogu1 = new ItemStack(Material.RED_MUSHROOM, 64);
				final ItemMeta cogu1meta = cogu1.getItemMeta();
				cogu1meta.setDisplayName("�eCogumelo Vermelho");
				cogu1.setItemMeta(cogu1meta);
				final ItemStack cogu2 = new ItemStack(Material.BROWN_MUSHROOM, 64);
				final ItemMeta cogu2meta = cogu2.getItemMeta();
				cogu2meta.setDisplayName("�eCogumelo Marrom");
				cogu2.setItemMeta(cogu2meta);
				final ItemStack potes = new ItemStack(Material.BOWL, 64);
				final ItemMeta potesmeta = potes.getItemMeta();
				potesmeta.setDisplayName("�eTijela");
				potes.setItemMeta(potesmeta);
				for (int i = 0; i != 9; ++i) {
					inv.setItem(i, cogu1);
				}
				for (int i = 9; i != 18; ++i) {
					inv.setItem(i, cogu2);
				}
				for (int i = 18; i != 27; ++i) {
					inv.setItem(i, potes);
				}
				p.openInventory(inv);
			}
		}
	}

	@EventHandler
	public void Sopas(final SignChangeEvent e) {
		final Player p = e.getPlayer();
		if (p.hasPermission("kitpvp.placa") && e.getLine(0).equalsIgnoreCase("sopa")) {
			e.setLine(0, StylePvP.getInstance().getConfig().getString("MSG-PLACA-SOPA-1").replace("&", "�"));
			e.setLine(2, StylePvP.getInstance().getConfig().getString("MSG-PLACA-SOPA-2").replace("&", "�"));
			e.setLine(3, StylePvP.getInstance().getConfig().getString("MSG-PLACA-SOPA-3").replace("&", "�"));
			p.sendMessage("�6�lPLACA �fA �e�lPLACA �fde �6�lSOPAS �ffoi �a�lCRIADA �fcom sucesso!");
		}
	}

	@EventHandler
	public void InvSopas(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK
				&& ((e.getClickedBlock() != null && e.getClickedBlock().getType() == Material.WALL_SIGN)
						|| e.getClickedBlock().getType() == Material.SIGN_POST)) {
			final Sign s = (Sign) e.getClickedBlock().getState();
			final String[] lines = s.getLines();
			if (lines.length > 0
					&& lines[0].equals(StylePvP.getInstance().getConfig().getString("MSG-PLACA-SOPA-1").replace("&", "�"))
					&& lines.length > 2
					&& lines[2].equals(StylePvP.getInstance().getConfig().getString("MSG-PLACA-SOPA-2").replace("&", "�"))
					&& lines.length > 3 && lines[3]
							.equals(StylePvP.getInstance().getConfig().getString("MSG-PLACA-SOPA-3").replace("&", "�"))) {
				final Inventory inv = Bukkit.createInventory((InventoryHolder) p, 54, "�6�lSopas");
				final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
				final ItemMeta sopameta = sopa.getItemMeta();
				sopameta.setDisplayName("�eSopa");
				sopa.setItemMeta(sopameta);
				for (int i = 0; i != 54; ++i) {
					inv.setItem(i, sopa);
				}
				p.openInventory(inv);
			}
		}
	}
}
