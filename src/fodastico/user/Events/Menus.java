package fodastico.user.Events;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.URL;
import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.nametagedit.plugin.NametagEdit;

import fodastico.user.Apis.APIs;
import fodastico.user.Apis.DeathAPI;
import fodastico.user.Apis.KillsAPI;
import fodastico.user.Apis.MoneyAPI;
import fodastico.user.Apis.XpAPI;
import fodastico.user.FullVIP.VipallAPI;
import fodastico.user.ScoreBoard.ScoreBoard;

public class Menus implements Listener {
	public static String location;

	public static ItemStack newMenuItem(final Material material, final String nome, final String[] habilidade) {
		final ItemStack item = new ItemStack(material);
		final ItemMeta kitem = item.getItemMeta();
		kitem.setDisplayName(nome);
		kitem.setLore(Arrays.asList(habilidade));
		item.setItemMeta(kitem);
		return item;
	}

	public static String getCountry(final InetSocketAddress ip) throws Exception {
		final URL url = new URL("http://ip-api.com/json/" + ip.getHostName());
		final BufferedReader stream = new BufferedReader(new InputStreamReader(url.openStream()));
		final StringBuilder entirePage = new StringBuilder();
		String inputLine;
		while ((inputLine = stream.readLine()) != null) {
			entirePage.append(inputLine);
		}
		stream.close();
		Menus.location = entirePage.toString().split("\"country\":\"")[1].split("\",")[0];
		if (!entirePage.toString().contains("\"country\":\"")) {
			return null;
		}
		return entirePage.toString().split("\"country\":\"")[1].split("\",")[0];
	}

	public static void inventorystatus(final Player p) {
		final Player p2 = p;
		final int Matou = KillsAPI.getKills(p2);
		final int Morreu = DeathAPI.getDeath(p2);
		final Inventory menu = Bukkit.createInventory((InventoryHolder) p, 54, p2.getName());
		menu.setItem(0, APIs.criarItem(p, Material.STAINED_GLASS_PANE, "§bStatus", new String[1], 1, (short) 11));
		menu.setItem(1, APIs.criarItem(p, Material.STAINED_GLASS_PANE, "§bStatus", new String[1], 1, (short) 11));
		menu.setItem(2, APIs.criarItem(p, Material.STAINED_GLASS_PANE, "§bStatus", new String[1], 1, (short) 11));
		menu.setItem(3, APIs.criarItem(p, Material.STAINED_GLASS_PANE, "§bStatus", new String[1], 1, (short) 11));
		menu.setItem(5, APIs.criarItem(p, Material.STAINED_GLASS_PANE, "§bStatus", new String[1], 1, (short) 11));
		menu.setItem(6, APIs.criarItem(p, Material.STAINED_GLASS_PANE, "§bStatus", new String[1], 1, (short) 11));
		menu.setItem(7, APIs.criarItem(p, Material.STAINED_GLASS_PANE, "§bStatus", new String[1], 1, (short) 11));
		menu.setItem(8, APIs.criarItem(p, Material.STAINED_GLASS_PANE, "§bStatus", new String[1], 1, (short) 11));
		menu.setItem(17, APIs.criarItem(p, Material.STAINED_GLASS_PANE, "§bStatus", new String[1], 1, (short) 11));
		menu.setItem(18, APIs.criarItem(p, Material.STAINED_GLASS_PANE, "§bStatus", new String[1], 1, (short) 11));
		menu.setItem(19, APIs.criarItem(p, Material.STAINED_GLASS_PANE, "§bStatus", new String[1], 1, (short) 11));
		menu.setItem(20, APIs.criarItem(p, Material.STAINED_GLASS_PANE, "§bStatus", new String[1], 1, (short) 11));
		menu.setItem(21, APIs.criarItem(p, Material.STAINED_GLASS_PANE, "§bStatus", new String[1], 1, (short) 11));
		menu.setItem(22, APIs.criarItem(p, Material.STAINED_GLASS_PANE, "§bStatus", new String[1], 1, (short) 11));
		menu.setItem(23, APIs.criarItem(p, Material.STAINED_GLASS_PANE, "§bStatus", new String[1], 1, (short) 11));
		menu.setItem(24, APIs.criarItem(p, Material.STAINED_GLASS_PANE, "§bStatus", new String[1], 1, (short) 11));
		menu.setItem(25, APIs.criarItem(p, Material.STAINED_GLASS_PANE, "§bStatus", new String[1], 1, (short) 11));
		menu.setItem(26, APIs.criarItem(p, Material.STAINED_GLASS_PANE, "§bStatus", new String[1], 1, (short) 11));
		menu.setItem(27, APIs.criarItem(p, Material.STAINED_GLASS_PANE, "§bStatus", new String[1], 1, (short) 11));
		menu.setItem(28, APIs.criarItem(p, Material.STAINED_GLASS_PANE, "§bStatus", new String[1], 1, (short) 11));
		menu.setItem(29, APIs.criarItem(p, Material.STAINED_GLASS_PANE, "§bStatus", new String[1], 1, (short) 11));
		menu.setItem(30, APIs.criarItem(p, Material.STAINED_GLASS_PANE, "§bStatus", new String[1], 1, (short) 11));
		menu.setItem(32, APIs.criarItem(p, Material.STAINED_GLASS_PANE, "§bStatus", new String[1], 1, (short) 11));
		menu.setItem(33, APIs.criarItem(p, Material.STAINED_GLASS_PANE, "§bStatus", new String[1], 1, (short) 11));
		menu.setItem(34, APIs.criarItem(p, Material.STAINED_GLASS_PANE, "§bStatus", new String[1], 1, (short) 11));
		menu.setItem(35, APIs.criarItem(p, Material.STAINED_GLASS_PANE, "§bStatus", new String[1], 1, (short) 11));
		menu.setItem(36, APIs.criarItem(p, Material.STAINED_GLASS_PANE, "§bStatus", new String[1], 1, (short) 11));
		menu.setItem(37, APIs.criarItem(p, Material.STAINED_GLASS_PANE, "§bStatus", new String[1], 1, (short) 11));
		menu.setItem(38, APIs.criarItem(p, Material.STAINED_GLASS_PANE, "§bStatus", new String[1], 1, (short) 11));
		menu.setItem(40, APIs.criarItem(p, Material.STAINED_GLASS_PANE, "§bStatus", new String[1], 1, (short) 11));
		menu.setItem(42, APIs.criarItem(p, Material.STAINED_GLASS_PANE, "§bStatus", new String[1], 1, (short) 11));
		menu.setItem(43, APIs.criarItem(p, Material.STAINED_GLASS_PANE, "§bStatus", new String[1], 1, (short) 11));
		menu.setItem(44, APIs.criarItem(p, Material.STAINED_GLASS_PANE, "§bStatus", new String[1], 1, (short) 11));
		menu.setItem(45, APIs.criarItem(p, Material.STAINED_GLASS_PANE, "§bStatus", new String[1], 1, (short) 11));
		menu.setItem(46, APIs.criarItem(p, Material.STAINED_GLASS_PANE, "§bStatus", new String[1], 1, (short) 11));
		menu.setItem(47, APIs.criarItem(p, Material.STAINED_GLASS_PANE, "§bStatus", new String[1], 1, (short) 11));
		menu.setItem(48, APIs.criarItem(p, Material.STAINED_GLASS_PANE, "§bStatus", new String[1], 1, (short) 11));
		menu.setItem(49, APIs.criarItem(p, Material.STAINED_GLASS_PANE, "§bStatus", new String[1], 1, (short) 11));
		menu.setItem(50, APIs.criarItem(p, Material.STAINED_GLASS_PANE, "§bStatus", new String[1], 1, (short) 11));
		menu.setItem(51, APIs.criarItem(p, Material.STAINED_GLASS_PANE, "§bStatus", new String[1], 1, (short) 11));
		menu.setItem(52, APIs.criarItem(p, Material.STAINED_GLASS_PANE, "§bStatus", new String[1], 1, (short) 11));
		menu.setItem(53, APIs.criarItem(p, Material.STAINED_GLASS_PANE, "§bStatus", new String[1], 1, (short) 11));
		menu.setItem(9, APIs.criarItem(p, Material.STAINED_GLASS_PANE, "§bStatus", new String[1], 1, (short) 11));
		menu.setItem(4, newMenuItem(Material.PAPER, "§b§lCONTA", new String[0]));
		menu.setItem(10,
				newMenuItem(Material.ANVIL, "§b§lGRUPO: §7[§8" + EventosGerais.Grupo(p2) + "§7]", new String[0]));
		menu.setItem(11,
				newMenuItem(Material.DIAMOND_CHESTPLATE, "§6§lVIP: " + EventosGerais.SerVip(p2), new String[0]));
		menu.setItem(12, newMenuItem(Material.EXP_BOTTLE, "§a§lXP: " + XpAPI.getXp(p), new String[0]));
		menu.setItem(13, newMenuItem(Material.GOLD_INGOT, "§6§lMOEDAS: " + MoneyAPI.getMoney(p), new String[0]));
		menu.setItem(14,
				newMenuItem(Material.REDSTONE_BLOCK, "§b§lLIGA: " + EventosGerais.LigaAtual(p), new String[0]));
		menu.setItem(15, newMenuItem(Material.REDSTONE,
				"§2§lXP PARA PR\u00d3XIMA LIGA: §4§l" + EventosGerais.XpNecessario(p), new String[0]));
		menu.setItem(16,
				newMenuItem(Material.PAINTING, "§b§lNICK FORMAT ATUAL: " + p2.getDisplayName(), new String[0]));
		menu.setItem(31, newMenuItem(Material.PAPER, "§b§lKDR", new String[0]));
		menu.setItem(39, newMenuItem(Material.DIAMOND_SWORD, "§a§oKILLS: §3§l" + Matou, new String[0]));
		menu.setItem(41, newMenuItem(Material.WOOD_SWORD, "§c§oDEATHS: §3§l" + Morreu, new String[0]));
		p.openInventory(menu);
	}

	@EventHandler
	public void clickarstatus(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		final int Matou = KillsAPI.getKills(p);
		final int Morreu = DeathAPI.getDeath(p);
		if (e.getInventory().getTitle().equals(p.getName()) && e.getCurrentItem() != null
				&& e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bStatus")) {
				e.setCancelled(true);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lCLAN: §7[§8NENHUM§7]")) {
				e.setCancelled(true);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName()
					.equalsIgnoreCase("§b§lGRUPO: §7[§8" + EventosGerais.Grupo(p) + "§7]")) {
				e.setCancelled(true);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lCONTA")) {
				e.setCancelled(true);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName()
					.equalsIgnoreCase("§6§lVIP: " + EventosGerais.SerVip(p))) {
				e.setCancelled(true);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lXP: " + XpAPI.getXp(p))) {
				e.setCancelled(true);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName()
					.equalsIgnoreCase("§6§lMOEDAS: " + MoneyAPI.getMoney(p))) {
				e.setCancelled(true);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName()
					.equalsIgnoreCase("§b§lLIGA: " + EventosGerais.LigaAtual(p))) {
				e.setCancelled(true);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName()
					.equalsIgnoreCase("§2§lXP PARA PR\u00d3XIMA LIGA: §4§l" + EventosGerais.XpNecessario(p))) {
				e.setCancelled(true);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName()
					.equalsIgnoreCase("§b§lNICK FORMAT ATUAL: " + p.getDisplayName())) {
				e.setCancelled(true);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lKDR")) {
				e.setCancelled(true);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§oKILLS: §3§l" + Matou)) {
				e.setCancelled(true);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c§oDEATHS: §3§l" + Morreu)) {
				e.setCancelled(true);
			}
		}
	}

	public static void inventarioLojasKits(final Player p) {
		final Inventory menu = Bukkit.createInventory((InventoryHolder) p, 54, "§b§lLoja de Kits");
		menu.setItem(0, new ItemStack(Material.STAINED_GLASS_PANE));
		menu.setItem(1, new ItemStack(Material.STAINED_GLASS_PANE));
		menu.setItem(2, new ItemStack(Material.STAINED_GLASS_PANE));
		menu.setItem(3, new ItemStack(Material.STAINED_GLASS_PANE));
		menu.setItem(4, new ItemStack(Material.STAINED_GLASS_PANE));
		menu.setItem(5, new ItemStack(Material.STAINED_GLASS_PANE));
		menu.setItem(6, new ItemStack(Material.STAINED_GLASS_PANE));
		menu.setItem(7, new ItemStack(Material.STAINED_GLASS_PANE));
		menu.setItem(8, new ItemStack(Material.STAINED_GLASS_PANE));
		menu.setItem(9, new ItemStack(Material.STAINED_GLASS_PANE));
		menu.setItem(10, new ItemStack(Material.STAINED_GLASS_PANE));
		menu.setItem(11, new ItemStack(Material.STAINED_GLASS_PANE));
		menu.setItem(12, new ItemStack(Material.STAINED_GLASS_PANE));
		menu.setItem(13, new ItemStack(Material.STAINED_GLASS_PANE));
		menu.setItem(14, new ItemStack(Material.STAINED_GLASS_PANE));
		menu.setItem(15, new ItemStack(Material.STAINED_GLASS_PANE));
		menu.setItem(16, new ItemStack(Material.STAINED_GLASS_PANE));
		menu.setItem(17, new ItemStack(Material.STAINED_GLASS_PANE));
		menu.setItem(18, new ItemStack(Material.STAINED_GLASS_PANE));
		menu.setItem(19, newMenuItem(Material.IRON_FENCE, "§aKit Gladiator §7- §6§l3.500 MOEDAS", new String[0]));
		menu.setItem(20, newMenuItem(Material.FEATHER, "§aKit Phantom §7- §6§l2.500 MOEDAS", new String[0]));
		menu.setItem(21, newMenuItem(Material.LEATHER_BOOTS, "§aKit Stomper §7- §6§l5.000 MOEDAS", new String[0]));
		menu.setItem(22, newMenuItem(Material.DIAMOND_BOOTS, "§aKit AntStomper §7- §6§l3.000 MOEDAS", new String[0]));
		menu.setItem(23, newMenuItem(Material.DIAMOND_AXE, "§aKit Viking §7- §6§l3.500 MOEDAS", new String[0]));
		menu.setItem(24, newMenuItem(Material.LAVA_BUCKET, "§aKit Magma §7- §6§l2.500 MOEDAS", new String[0]));
		menu.setItem(25, new ItemStack(Material.STAINED_GLASS_PANE));
		menu.setItem(26, new ItemStack(Material.STAINED_GLASS_PANE));
		menu.setItem(27, new ItemStack(Material.STAINED_GLASS_PANE));
		menu.setItem(28, new ItemStack(Material.STAINED_GLASS_PANE));
		menu.setItem(29, new ItemStack(Material.STAINED_GLASS_PANE));
		menu.setItem(30, new ItemStack(Material.STAINED_GLASS_PANE));
		menu.setItem(31, new ItemStack(Material.STAINED_GLASS_PANE));
		menu.setItem(32, new ItemStack(Material.STAINED_GLASS_PANE));
		menu.setItem(33, new ItemStack(Material.STAINED_GLASS_PANE));
		menu.setItem(34, new ItemStack(Material.STAINED_GLASS_PANE));
		menu.setItem(35, new ItemStack(Material.STAINED_GLASS_PANE));
		menu.setItem(36, new ItemStack(Material.STAINED_GLASS_PANE));
		menu.setItem(37, new ItemStack(Material.STAINED_GLASS_PANE));
		menu.setItem(38, new ItemStack(Material.STAINED_GLASS_PANE));
		menu.setItem(39, new ItemStack(Material.STAINED_GLASS_PANE));
		menu.setItem(40, new ItemStack(Material.STAINED_GLASS_PANE));
		menu.setItem(41, new ItemStack(Material.STAINED_GLASS_PANE));
		menu.setItem(42, new ItemStack(Material.STAINED_GLASS_PANE));
		menu.setItem(43, new ItemStack(Material.STAINED_GLASS_PANE));
		menu.setItem(44, new ItemStack(Material.STAINED_GLASS_PANE));
		menu.setItem(45, new ItemStack(Material.STAINED_GLASS_PANE));
		menu.setItem(46, new ItemStack(Material.STAINED_GLASS_PANE));
		menu.setItem(47, new ItemStack(Material.STAINED_GLASS_PANE));
		menu.setItem(48, new ItemStack(Material.STAINED_GLASS_PANE));
		menu.setItem(49, new ItemStack(Material.STAINED_GLASS_PANE));
		menu.setItem(50, new ItemStack(Material.STAINED_GLASS_PANE));
		menu.setItem(51, new ItemStack(Material.STAINED_GLASS_PANE));
		menu.setItem(52, new ItemStack(Material.STAINED_GLASS_PANE));
		menu.setItem(53, new ItemStack(Material.STAINED_GLASS_PANE));
		p.openInventory(menu);
	}

	public static void inventarioShop(final Player p) {
		final Inventory menu = Bukkit.createInventory((InventoryHolder) p, 54, "§b§lShop");
		menu.setItem(19, newMenuItem(Material.FIREWORK, "§bLoja de §7(§aKits§7)", new String[0]));
		menu.setItem(22, newMenuItem(Material.MAP, "§bLoja de §7(§cPermiss\u00f5es§7)", new String[0]));
		menu.setItem(25, newMenuItem(Material.GOLD_BLOCK, "§bLoja de §7(§6Vips§7)", new String[0]));
		p.openInventory(menu);
	}

	public static void inventarioLojaPerm(final Player p) {
		final Inventory menu = Bukkit.createInventory((InventoryHolder) p, 54, "§b§lLoja de §7(§cPERMISS\u00d5ES§7)");
		menu.setItem(21, newMenuItem(Material.NAME_TAG,
				"§aAcesso §fao §7(§e/fly§7) '§fSOMENTE NO SPAWN' §f- §6§l[25000] Moedas!", new String[0]));
		menu.setItem(23, newMenuItem(Material.NAME_TAG, "§5Resetar §4KD §f- §6§l[30000] Moedas!", new String[0]));
		p.openInventory(menu);
	}

	@EventHandler
	public void clickarlojaperm(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("§b§lLoja de §7(§cPERMISS\u00d5ES§7)") && e.getCurrentItem() != null
				&& e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);
			if (e.getCurrentItem().getItemMeta().getDisplayName()
					.equalsIgnoreCase("§aAcesso §fao §7(§e/fly§7) '§fSOMENTE NO SPAWN' §f- §6§l[25000] Moedas!")) {
				final int moedas = MoneyAPI.getMoney(p);
				if (moedas < 25000) {
					p.closeInventory();
					p.sendMessage(
							"§3§lMOEDAS §cVoc\u00ea precisa de mais §6§l" + EventosGerais.MoneyNecessarioLojaPerm(p)
									+ " §6§lMOEDAS §cpara comprar esta §4§lPERMISS\u00c3O§c.");
				} else {
					MoneyAPI.removeMoney(p, 25000);
					p.closeInventory();
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"pex user " + p.getName() + " add kitpvp.fly");
					p.sendMessage("§3§lFLY §aVoc\u00ea agora possui permiss\u00e3o para voar no spawn!");
				}
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName()
					.equalsIgnoreCase("§5Resetar §4KD §f- §6§l[30000] Moedas!")) {
				final int moedas = MoneyAPI.getMoney(p);
				if (moedas < 30000) {
					p.closeInventory();
					p.sendMessage(
							"§3§lMOEDAS §cVoc\u00ea precisa de mais §6§l" + EventosGerais.MoneyNecessarioLojaPermkd(p)
									+ " §6§lMOEDAS §cpara comprar esta §4§lPERMISS\u00c3O§c.");
				} else {
					MoneyAPI.removeMoney(p, 30000);
					p.closeInventory();
					KillsAPI.Kills.set(p.getName(), (Object) 0);
					KillsAPI.saveKills();
					DeathAPI.Death.set(p.getName(), (Object) 0);
					DeathAPI.saveDeath();
					p.sendMessage(
							"§3§lKD §aSeu kills/deaths foram resetados com sucesso! Caso n\u00e3o atualize na scoreboard, apenas relogue.");
				}
			}
		}
	}

	@EventHandler
	public void clickarlojakits(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("§b§lLoja de Kits") && e.getCurrentItem() != null
				&& e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);
			if (e.getCurrentItem().getItemMeta().getDisplayName()
					.equalsIgnoreCase("§aKit Gladiator §7- §6§l3.500 MOEDAS")) {
				final int moedas = MoneyAPI.getMoney(p);
				if (moedas < 3500) {
					p.closeInventory();
					p.sendMessage("§3§lMOEDAS §cVoc\u00ea precisa de mais §6§l"
							+ EventosGerais.MoneyNecessarioGladiator(p) + " §6§lMOEDAS §cpara comprar este §b§lKIT§c.");
				} else {
					MoneyAPI.removeMoney(p, 3500);
					p.closeInventory();
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"pex user " + p.getName() + " add kit.gladiator");
					p.sendMessage("§3§lKIT §aVoc\u00ea comprou o kit gladiator com sucesso!");
				}
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName()
					.equalsIgnoreCase("§aKit Phantom §7- §6§l2.500 MOEDAS")) {
				final int moedas = MoneyAPI.getMoney(p);
				if (moedas < 2500) {
					p.closeInventory();
					p.sendMessage("§3§lMOEDAS §cVoc\u00ea precisa de mais §6§l"
							+ EventosGerais.MoneyNecessarioPhantom(p) + " §6§lMOEDAS §cpara comprar este §b§lKIT§c.");
				} else {
					MoneyAPI.removeMoney(p, 2500);
					p.closeInventory();
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"pex user " + p.getName() + " add kit.phantom");
					p.sendMessage("§3§lKIT §aVoc\u00ea comprou o kit phantom com sucesso!");
				}
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName()
					.equalsIgnoreCase("§aKit Stomper §7- §6§l5.000 MOEDAS")) {
				final int moedas = MoneyAPI.getMoney(p);
				if (moedas < 5000) {
					p.closeInventory();
					p.sendMessage("§3§lMOEDAS §cVoc\u00ea precisa de mais §6§l"
							+ EventosGerais.MoneyNecessarioStomper(p) + " §6§lMOEDAS §cpara comprar este §b§lKIT§c.");
				} else {
					MoneyAPI.removeMoney(p, 5000);
					p.closeInventory();
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"pex user " + p.getName() + " add kit.stomper");
					p.sendMessage("§3§lKIT §aVoc\u00ea comprou o kit stomper com sucesso!");
				}
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName()
					.equalsIgnoreCase("§aKit AntStomper §7- §6§l3.000 MOEDAS")) {
				final int moedas = MoneyAPI.getMoney(p);
				if (moedas < 3000) {
					p.closeInventory();
					p.sendMessage(
							"§3§lMOEDAS §cVoc\u00ea precisa de mais §6§l" + EventosGerais.MoneyNecessarioAntiStomper(p)
									+ " §6§lMOEDAS §cpara comprar este §b§lKIT§c.");
				} else {
					MoneyAPI.removeMoney(p, 3000);
					p.closeInventory();
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"pex user " + p.getName() + " add kit.antistomper");
					p.sendMessage("§3§lKIT §aVoc\u00ea comprou o kit antistomper com sucesso!");
				}
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName()
					.equalsIgnoreCase("§aKit Viking §7- §6§l3.500 MOEDAS")) {
				final int moedas = MoneyAPI.getMoney(p);
				if (moedas < 3500) {
					p.closeInventory();
					p.sendMessage("§3§lMOEDAS §cVoc\u00ea precisa de mais §6§l" + EventosGerais.MoneyNecessarioViking(p)
							+ " §6§lMOEDAS §cpara comprar este §b§lKIT§c.");
				} else {
					MoneyAPI.removeMoney(p, 3500);
					p.closeInventory();
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"pex user " + p.getName() + " add kit.viking");
					p.sendMessage("§3§lKIT §aVoc\u00ea comprou o kit viking com sucesso!");
				}
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName()
					.equalsIgnoreCase("§aKit Magma §7- §6§l2.500 MOEDAS")) {
				final int moedas = MoneyAPI.getMoney(p);
				if (moedas < 2500) {
					p.closeInventory();
					p.sendMessage("§3§lMOEDAS §cVoc\u00ea precisa de mais §6§l" + EventosGerais.MoneyNecessarioMagma(p)
							+ " §6§lMOEDAS §cpara comprar este §b§lKIT§c.");
				} else {
					MoneyAPI.removeMoney(p, 2500);
					p.closeInventory();
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"pex user " + p.getName() + " add kit.magma");
					p.sendMessage("§3§lKIT §aVoc\u00ea comprou o kit magma com sucesso!");
				}
			}
		}
	}

	public static void inventarioLojaVips(final Player p) {
		final Inventory menu = Bukkit.createInventory((InventoryHolder) p, 54, "§b§lLoja de §7(§6Vips§7)");
		menu.setItem(11, newMenuItem(Material.GOLD_BLOCK, "§6§lVIP(s)", new String[0]));
		menu.setItem(12, newMenuItem(Material.GOLD_BLOCK, "§6§lVIP(s)", new String[0]));
		menu.setItem(13, newMenuItem(Material.GOLD_BLOCK, "§6§lVIP(s)", new String[0]));
		menu.setItem(20, newMenuItem(Material.GOLD_BLOCK, "§6§lVIP(s)", new String[0]));
		menu.setItem(21, newMenuItem(Material.NAME_TAG, "§bLoja §7(§6INTERNA§7)", new String[0]));
		menu.setItem(22, newMenuItem(Material.GOLD_BLOCK, "§6§lVIP(s)", new String[0]));
		menu.setItem(29, newMenuItem(Material.GOLD_BLOCK, "§6§lVIP(s)", new String[0]));
		menu.setItem(30, newMenuItem(Material.GOLD_BLOCK, "§6§lVIP(s)", new String[0]));
		menu.setItem(31, newMenuItem(Material.GOLD_BLOCK, "§6§lVIP(s)", new String[0]));
		menu.setItem(32, newMenuItem(Material.GOLD_BLOCK, "§6§lVIP(s)", new String[0]));
		menu.setItem(14, newMenuItem(Material.GOLD_BLOCK, "§6§lVIP(s)", new String[0]));
		menu.setItem(15, newMenuItem(Material.GOLD_BLOCK, "§6§lVIP(s)", new String[0]));
		menu.setItem(24, newMenuItem(Material.GOLD_BLOCK, "§6§lVIP(s)", new String[0]));
		menu.setItem(33, newMenuItem(Material.GOLD_BLOCK, "§6§lVIP(s)", new String[0]));
		menu.setItem(23, newMenuItem(Material.NAME_TAG, "§bLoja do §7(§6§lSERVIDOR§7)", new String[0]));
		p.openInventory(menu);
	}

	@EventHandler
	public void clickarshop(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("§b§lShop") && e.getCurrentItem() != null
				&& e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bLoja de §7(§aKits§7)")) {
				e.setCancelled(true);
				inventarioLojasKits(p);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName()
					.equalsIgnoreCase("§bLoja de §7(§cPermiss\u00f5es§7)")) {
				e.setCancelled(true);
				inventarioLojaPerm(p);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bLoja de §7(§6Vips§7)")) {
				e.setCancelled(true);
				inventarioLojaVips(p);
			}
		}
	}

	@EventHandler
	public void clickarlojavip(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("§b§lLoja de §7(§6Vips§7)") && e.getCurrentItem() != null
				&& e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bLoja §7(§6INTERNA§7)")) {
				e.setCancelled(true);
				inventarioLojaVipserver(p);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6§lVIP(s)")) {
				e.setCancelled(true);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bLoja do §7(§6§lSERVIDOR§7)")) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/loja");
			}
		}
	}

	public static void inventarioLojaVipserver(final Player p) {
		final Inventory menu = Bukkit.createInventory((InventoryHolder) p, 54, "§bLoja §6§lVIP §7(§6INTERNA§7)");
		menu.setItem(19, newMenuItem(Material.DIAMOND_BLOCK,
				"§6§lVIP §7(§a§lLIGHT§7) §6§l[100000] Moedas §b& §a§l5000+ XPs", new String[0]));
		menu.setItem(22, newMenuItem(Material.DIAMOND_BLOCK,
				"§6§lVIP §7(§6§lPREMIUM§7) §6§l[200000] Moedas §b& §a§l10000+ XPs", new String[0]));
		menu.setItem(25, newMenuItem(Material.DIAMOND_BLOCK,
				"§6§lVIP §7(§d§lULTIMATE§7) §6§l[300000] Moedas §b& §a§l15000+ XPs", new String[0]));
		p.openInventory(menu);
	}

	@EventHandler
	public void clickarlojadevipinterna(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("§bLoja §6§lVIP §7(§6INTERNA§7)") && e.getCurrentItem() != null
				&& e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);
			if (e.getCurrentItem().getItemMeta().getDisplayName()
					.equalsIgnoreCase("§6§lVIP §7(§a§lLIGHT§7) §6§l[100000] Moedas §b& §a§l5000+ XPs")) {
				final int moedas = MoneyAPI.getMoney(p);
				final int xps = XpAPI.getXp(p);
				if (moedas < 100000 && xps < 5000) {
					p.closeInventory();
					p.sendMessage("§3§l        REQUISITOS INSUFICIENTES! ");
					p.sendMessage("§3§lMOEDAS §cVoc\u00ea precisa de mais §6§l"
							+ EventosGerais.MoneyNecessarioVipLight(p) + " §6§lMOEDAS §cpara comprar este §6§lVIP§c.");
					p.sendMessage("§3§lXP §cVoc\u00ea precisa de mais §a§l" + EventosGerais.XpNecessarioVipLight(p)
							+ " §a§lXPs §cpara comprar este §6§lVIP§c.");
					p.sendMessage(
							"§3§lREQUISITOS §cQuando possuir os 2 requisitos, voc\u00ea conseguir\u00e1 comprar!");
				} else {
					MoneyAPI.removeMoney(p, 100000);
					p.closeInventory();
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"grupo " + p.getName() + " light");
					Bukkit.broadcastMessage("§3§lVIP §aO jogador §7(§f" + p.getName()
							+ "§7) §aacabou de comprar um §6§lVIP §7(§a§lLIGHT§7) §ana loja de §6§lVIP §7(§eINTERNA§7)§a.");
				}
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName()
					.equalsIgnoreCase("§6§lVIP §7(§6§lPREMIUM§7) §6§l[200000] Moedas §b& §a§l10000+ XPs")) {
				final int moedas = MoneyAPI.getMoney(p);
				final int xps = XpAPI.getXp(p);
				if (moedas < 200000 && xps < 10000) {
					p.closeInventory();
					p.sendMessage("§3§l        REQUISITOS INSUFICIENTES! ");
					p.sendMessage(
							"§3§lMOEDAS §cVoc\u00ea precisa de mais §6§l" + EventosGerais.MoneyNecessarioVipPremium(p)
									+ " §6§lMOEDAS §cpara comprar este §6§lVIP§c.");
					p.sendMessage("§3§lXP §cVoc\u00ea precisa de mais §a§l" + EventosGerais.XpNecessarioVipPremium(p)
							+ " §a§lXPs §cpara comprar este §6§lVIP§c.");
					p.sendMessage(
							"§3§lREQUISITOS §cQuando possuir os 2 requisitos, voc\u00ea conseguir\u00e1 comprar!");
				} else {
					MoneyAPI.removeMoney(p, 200000);
					p.closeInventory();
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"grupo " + p.getName() + " premium");
					Bukkit.broadcastMessage("§3§lVIP §aO jogador §7(§f" + p.getName()
							+ "§7) §aacabou de comprar um §6§lVIP §7(§6§lPREMIUM§7) §ana loja de §6§lVIP §7(§eINTERNA§7)§a.");
				}
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName()
					.equalsIgnoreCase("§6§lVIP §7(§d§lULTIMATE§7) §6§l[300000] Moedas §b& §a§l15000+ XPs")) {
				final int moedas = MoneyAPI.getMoney(p);
				final int xps = XpAPI.getXp(p);
				if (moedas < 300000 && xps < 15000) {
					p.closeInventory();
					p.sendMessage("§3§l        REQUISITOS INSUFICIENTES! ");
					p.sendMessage(
							"§3§lMOEDAS §cVoc\u00ea precisa de mais §6§l" + EventosGerais.MoneyNecessarioVipUltimate(p)
									+ " §6§lMOEDAS §cpara comprar este §6§lVIP§c.");
					p.sendMessage("§3§lXP §cVoc\u00ea precisa de mais §a§l" + EventosGerais.XpNecessarioVipUltimate(p)
							+ " §a§lXPs §cpara comprar este §6§lVIP§c.");
					p.sendMessage(
							"§3§lREQUISITOS §cQuando possuir os 2 requisitos, voc\u00ea conseguir\u00e1 comprar!");
				} else {
					MoneyAPI.removeMoney(p, 300000);
					p.closeInventory();
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"grupo " + p.getName() + " ultimate");
					Bukkit.broadcastMessage("§3§lVIP §aO jogador §7(§f" + p.getName()
							+ "§7) §aacabou de comprar um §6§lVIP §7(§d§lULTIMATE§7) §ana loja de §6§lVIP §7(§eINTERNA§7)§a.");
				}
			}
		}
	}

	public static void inventarioMenuVip(final Player p) {
		final Inventory menu = Bukkit.createInventory((InventoryHolder) p, 54, "§6§lTAGS §b§lESPECIAIS");
		menu.setItem(10, newMenuItem(Material.PAPER, "§b§lTAG §b§oGAMER", new String[0]));
		menu.setItem(11, newMenuItem(Material.PAPER, "§b§lTAG §8§oOLD", new String[0]));
		menu.setItem(12, newMenuItem(Material.PAPER, "§b§lTAG §3§oMITO", new String[0]));
		menu.setItem(13, newMenuItem(Material.PAPER, "§b§lTAG §9§oGAMING", new String[0]));
		menu.setItem(14, newMenuItem(Material.PAPER, "§b§lTAG §b§oHUMILDE", new String[0]));
		menu.setItem(15, newMenuItem(Material.PAPER, "§b§lTAG §2§oEXPERIENTE", new String[0]));
		menu.setItem(16, newMenuItem(Material.PAPER, "§b§lTAG §5§oDEUS", new String[0]));
		menu.setItem(19, newMenuItem(Material.PAPER, "§b§lTAG §5§oG0D", new String[0]));
		menu.setItem(20, newMenuItem(Material.PAPER, "§b§lTAG §5§oVIDALOKA", new String[0]));
		menu.setItem(21, newMenuItem(Material.PAPER, "§b§lTAG §5§oV1D4LOK4", new String[0]));
		menu.setItem(22, newMenuItem(Material.PAPER, "§b§lTAG §d§oGIRL", new String[0]));
		menu.setItem(23, newMenuItem(Material.PAPER, "§b§lTAG §3§oRANDOM", new String[0]));
		menu.setItem(24, newMenuItem(Material.PAPER, "§b§lTAG §4§oCOMPETENTE", new String[0]));
		menu.setItem(25, newMenuItem(Material.PAPER, "§b§lTAG §f§oCOMPREENDIDO", new String[0]));
		menu.setItem(29, newMenuItem(Material.PAPER, "§b§lTAG §a§oLEGIT", new String[0]));
		menu.setItem(30, newMenuItem(Material.PAPER, "§b§lTAG §2§oLEGITZ", new String[0]));
		menu.setItem(31, newMenuItem(Material.PAPER, "§b§lTAG §c§oNEGAO", new String[0]));
		menu.setItem(32, newMenuItem(Material.PAPER, "§b§lTAG §c§oNEGUIN", new String[0]));
		menu.setItem(33, newMenuItem(Material.PAPER, "§b§lTAG §b§oHONESTO", new String[0]));
		menu.setItem(40, newMenuItem(Material.PAPER, "§c§lREMOVER TAGS", new String[0]));
		p.openInventory(menu);
	}

	@EventHandler
	public void clickarinventariomenuvip(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("§6§lTAGS §b§lESPECIAIS") && e.getCurrentItem() != null
				&& e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c§lREMOVER TAGS")) {
				p.closeInventory();
				p.sendMessage("§C§lTAG REMOVER §fSe voc\u00ea possui alguma §b§lTAG §fela foi removida.");
				p.setDisplayName("§7 " + p.getName() + ScoreBoard.getRankNick(p));
				NametagEdit.getApi().setPrefix(p, "§7 ");
				NametagEdit.getApi().setSuffix(p, ScoreBoard.getRankNick(p));
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lTAG §b§oGAMER")) {
				if (p.hasPermission("kitpvp.especial") || VipallAPI.vipall) {
					p.closeInventory();
					p.sendMessage("§6§lTAGS §b§lESPECIAIS §fVoc\u00ea colocou a §b§lTAG: §b§oGAMER");
					p.setDisplayName("§b§oGAMER " + p.getName() + ScoreBoard.getRankNick(p));
					NametagEdit.getApi().setPrefix(p, "§b§oGAMER ");
					NametagEdit.getApi().setSuffix(p, ScoreBoard.getRankNick(p));
				} else {
					p.closeInventory();
					p.sendMessage(
							"§6§lTAGS §b§lESPECIAIS §fAjude o servidor adiquirindo §6§lVIP §fpara ter §e§lACESSO §f\u00e1s §b§lTAGS");
				}
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lTAG §8§oOLD")) {
				if (p.hasPermission("kitpvp.especial") || VipallAPI.vipall) {
					p.closeInventory();
					p.sendMessage("§6§lTAGS §b§lESPECIAIS §fVoc\u00ea colocou a §b§lTAG: §8§oOLD");
					p.setDisplayName("§8§oOLD " + p.getName() + ScoreBoard.getRankNick(p));
					NametagEdit.getApi().setPrefix(p, "§8§oOLD ");
					NametagEdit.getApi().setSuffix(p, ScoreBoard.getRankNick(p));
				} else {
					p.closeInventory();
					p.sendMessage(
							"§6§lTAGS §b§lESPECIAIS §fAjude o servidor adiquirindo §6§lVIP §fpara ter §e§lACESSO §f\u00e1s §b§lTAGS");
				}
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lTAG §3§oMITO")) {
				if (p.hasPermission("kitpvp.especial") || VipallAPI.vipall) {
					p.closeInventory();
					p.sendMessage("§6§lTAGS §b§lESPECIAIS §fVoc\u00ea colocou a §b§lTAG: §3§oMITO");
					p.setDisplayName("§3§oMITO " + p.getName() + ScoreBoard.getRankNick(p));
					NametagEdit.getApi().setPrefix(p, "§3§oMITO ");
					NametagEdit.getApi().setSuffix(p, ScoreBoard.getRankNick(p));
				} else {
					p.closeInventory();
					p.sendMessage(
							"§6§lTAGS §b§lESPECIAIS §fAjude o servidor adiquirindo §6§lVIP §fpara ter §e§lACESSO §f\u00e1s §b§lTAGS");
				}
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lTAG §9§oGAMING")) {
				if (p.hasPermission("kitpvp.especial") || VipallAPI.vipall) {
					p.closeInventory();
					p.sendMessage("§6§lTAGS §b§lESPECIAIS §fVoc\u00ea colocou a §b§lTAG: §9§oGAMING");
					p.setDisplayName("§9§oGAMING " + p.getName() + ScoreBoard.getRankNick(p));
					NametagEdit.getApi().setPrefix(p, "§9§oGAMING ");
					NametagEdit.getApi().setSuffix(p, ScoreBoard.getRankNick(p));
				} else {
					p.closeInventory();
					p.sendMessage(
							"§6§lTAGS §b§lESPECIAIS §fAjude o servidor adiquirindo §6§lVIP §fpara ter §e§lACESSO §f\u00e1s §b§lTAGS");
				}
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lTAG §b§oHUMILDE")) {
				if (p.hasPermission("kitpvp.especial") || VipallAPI.vipall) {
					p.closeInventory();
					p.sendMessage("§6§lTAGS §b§lESPECIAIS §fVoc\u00ea colocou a §b§lTAG: §b§oHUMILDE");
					p.setDisplayName("§b§oHUMILDE " + p.getName() + ScoreBoard.getRankNick(p));
					NametagEdit.getApi().setPrefix(p, "§b§oHUMILDE ");
					NametagEdit.getApi().setSuffix(p, ScoreBoard.getRankNick(p));
				} else {
					p.closeInventory();
					p.sendMessage(
							"§6§lTAGS §b§lESPECIAIS §fAjude o servidor adiquirindo §6§lVIP §fpara ter §e§lACESSO §f\u00e1s §b§lTAGS");
				}
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lTAG §2§oEXPERIENTE")) {
				if (p.hasPermission("kitpvp.especial") || VipallAPI.vipall) {
					p.closeInventory();
					p.sendMessage("§6§lTAGS §b§lESPECIAIS §fVoc\u00ea colocou a §b§lTAG: §2§oEXPERIENTE");
					p.setDisplayName("§2§oEXPERIENTE " + p.getName() + ScoreBoard.getRankNick(p));
					NametagEdit.getApi().setPrefix(p, "§2§oEXPERIENTE ");
					NametagEdit.getApi().setSuffix(p, ScoreBoard.getRankNick(p));
				} else {
					p.closeInventory();
					p.sendMessage(
							"§6§lTAGS §b§lESPECIAIS §fAjude o servidor adiquirindo §6§lVIP §fpara ter §e§lACESSO §f\u00e1s §b§lTAGS");
				}
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lTAG §5§oDEUS")) {
				if (p.hasPermission("kitpvp.especial") || VipallAPI.vipall) {
					p.closeInventory();
					p.sendMessage("§6§lTAGS §b§lESPECIAIS §fVoc\u00ea colocou a §b§lTAG: §5§oDEUS");
					p.setDisplayName("§5§oDEUS " + p.getName() + ScoreBoard.getRankNick(p));
					NametagEdit.getApi().setPrefix(p, "§5§oDEUS ");
					NametagEdit.getApi().setSuffix(p, ScoreBoard.getRankNick(p));
				} else {
					p.closeInventory();
					p.sendMessage(
							"§6§lTAGS §b§lESPECIAIS §fAjude o servidor adiquirindo §6§lVIP §fpara ter §e§lACESSO §f\u00e1s §b§lTAGS");
				}
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lTAG §5§oG0D")) {
				if (p.hasPermission("kitpvp.especial") || VipallAPI.vipall) {
					p.closeInventory();
					p.sendMessage("§6§lTAGS §b§lESPECIAIS §fVoc\u00ea colocou a §b§lTAG: §5§oG0D");
					p.setDisplayName("§5§oG0D " + p.getName() + ScoreBoard.getRankNick(p));
					NametagEdit.getApi().setPrefix(p, "§5§oG0D ");
					NametagEdit.getApi().setSuffix(p, ScoreBoard.getRankNick(p));
				} else {
					p.closeInventory();
					p.sendMessage(
							"§6§lTAGS §b§lESPECIAIS §fAjude o servidor adiquirindo §6§lVIP §fpara ter §e§lACESSO §f\u00e1s §b§lTAGS");
				}
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lTAG §5§oVIDALOKA")) {
				if (p.hasPermission("kitpvp.especial") || VipallAPI.vipall) {
					p.closeInventory();
					p.sendMessage("§6§lTAGS §b§lESPECIAIS §fVoc\u00ea colocou a §b§lTAG: §5§oVIDALOKA");
					p.setDisplayName("§5§oVIDALOKA " + p.getName() + ScoreBoard.getRankNick(p));
					NametagEdit.getApi().setPrefix(p, "§5§oVIDALOKA ");
					NametagEdit.getApi().setSuffix(p, ScoreBoard.getRankNick(p));
				} else {
					p.closeInventory();
					p.sendMessage(
							"§6§lTAGS §b§lESPECIAIS §fAjude o servidor adiquirindo §6§lVIP §fpara ter §e§lACESSO §f\u00e1s §b§lTAGS");
				}
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lTAG §d§oGIRL")) {
				if (p.hasPermission("kitpvp.especial") || VipallAPI.vipall) {
					p.closeInventory();
					p.sendMessage("§6§lTAGS §b§lESPECIAIS §fVoc\u00ea colocou a §b§lTAG: §d§oGIRL");
					p.setDisplayName("§d§oGIRL " + p.getName() + ScoreBoard.getRankNick(p));
					NametagEdit.getApi().setPrefix(p, "§d§oGIRL ");
					NametagEdit.getApi().setSuffix(p, ScoreBoard.getRankNick(p));
				} else {
					p.closeInventory();
					p.sendMessage(
							"§6§lTAGS §b§lESPECIAIS §fAjude o servidor adiquirindo §6§lVIP §fpara ter §e§lACESSO §f\u00e1s §b§lTAGS");
				}
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lTAG §3§oRANDOM")) {
				if (p.hasPermission("kitpvp.especial") || VipallAPI.vipall) {
					p.closeInventory();
					p.sendMessage("§6§lTAGS §b§lESPECIAIS §fVoc\u00ea colocou a §b§lTAG: §3§oRANDOM");
					p.setDisplayName("§3§oRANDOM " + p.getName() + ScoreBoard.getRankNick(p));
					NametagEdit.getApi().setPrefix(p, "§3§oRANDOM ");
					NametagEdit.getApi().setSuffix(p, ScoreBoard.getRankNick(p));
				} else {
					p.closeInventory();
					p.sendMessage(
							"§6§lTAGS §b§lESPECIAIS §fAjude o servidor adiquirindo §6§lVIP §fpara ter §e§lACESSO §f\u00e1s §b§lTAGS");
				}
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lTAG §4§oCOMPETENTE")) {
				if (p.hasPermission("kitpvp.especial") || VipallAPI.vipall) {
					p.closeInventory();
					p.sendMessage("§6§lTAGS §b§lESPECIAIS §fVoc\u00ea colocou a §b§lTAG: §4§oCOMPETENTE");
					p.setDisplayName("§4§oCOMPETENTE " + p.getName() + ScoreBoard.getRankNick(p));
					NametagEdit.getApi().setPrefix(p, "§4§oCOMPETENTE ");
					NametagEdit.getApi().setSuffix(p, ScoreBoard.getRankNick(p));
				} else {
					p.closeInventory();
					p.sendMessage(
							"§6§lTAGS §b§lESPECIAIS §fAjude o servidor adiquirindo §6§lVIP §fpara ter §e§lACESSO §f\u00e1s §b§lTAGS");
				}
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lTAG §f§oCOMPREENDIDO")) {
				if (p.hasPermission("kitpvp.especial") || VipallAPI.vipall) {
					p.closeInventory();
					p.sendMessage("§6§lTAGS §b§lESPECIAIS §fVoc\u00ea colocou a §b§lTAG: §f§oCOMPREENDIDO");
					p.setDisplayName("§f§oCOMPREENDIDO " + p.getName() + ScoreBoard.getRankNick(p));
					NametagEdit.getApi().setPrefix(p, "§f§oCOMPREENDIDO ");
					NametagEdit.getApi().setSuffix(p, ScoreBoard.getRankNick(p));
				} else {
					p.closeInventory();
					p.sendMessage(
							"§6§lTAGS §b§lESPECIAIS §fAjude o servidor adiquirindo §6§lVIP §fpara ter §e§lACESSO §f\u00e1s §b§lTAGS");
				}
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lTAG §a§oLEGIT")) {
				if (p.hasPermission("kitpvp.especial") || VipallAPI.vipall) {
					p.closeInventory();
					p.sendMessage("§6§lTAGS §b§lESPECIAIS §fVoc\u00ea colocou a §b§lTAG: §a§oLEGIT");
					p.setDisplayName("§a§oLEGIT " + p.getName() + ScoreBoard.getRankNick(p));
					NametagEdit.getApi().setPrefix(p, "§a§oLEGIT ");
					NametagEdit.getApi().setSuffix(p, ScoreBoard.getRankNick(p));
				} else {
					p.closeInventory();
					p.sendMessage(
							"§6§lTAGS §b§lESPECIAIS §fAjude o servidor adiquirindo §6§lVIP §fpara ter §e§lACESSO §f\u00e1s §b§lTAGS");
				}
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lTAG §2§oLEGITZ")) {
				if (p.hasPermission("kitpvp.especial") || VipallAPI.vipall) {
					p.closeInventory();
					p.sendMessage("§6§lTAGS §b§lESPECIAIS §fVoc\u00ea colocou a §b§lTAG: §2§oLEGITZ");
					p.setDisplayName("§2§oLEGITZ " + p.getName() + ScoreBoard.getRankNick(p));
					NametagEdit.getApi().setPrefix(p, "§2§oLEGITZ ");
					NametagEdit.getApi().setSuffix(p, ScoreBoard.getRankNick(p));
				} else {
					p.closeInventory();
					p.sendMessage(
							"§6§lTAGS §b§lESPECIAIS §fAjude o servidor adiquirindo §6§lVIP §fpara ter §e§lACESSO §f\u00e1s §b§lTAGS");
				}
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lTAG §c§oNEGAO")) {
				if (p.hasPermission("kitpvp.especial") || VipallAPI.vipall) {
					p.closeInventory();
					p.sendMessage("§6§lTAGS §b§lESPECIAIS §fVoc\u00ea colocou a §b§lTAG: §c§oNEGAO");
					p.setDisplayName("§c§oNEGAO " + p.getName() + ScoreBoard.getRankNick(p));
					NametagEdit.getApi().setPrefix(p, "§c§oNEGAO ");
					NametagEdit.getApi().setSuffix(p, ScoreBoard.getRankNick(p));
				} else {
					p.closeInventory();
					p.sendMessage(
							"§6§lTAGS §b§lESPECIAIS §fAjude o servidor adiquirindo §6§lVIP §fpara ter §e§lACESSO §f\u00e1s §b§lTAGS");
				}
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lTAG §c§oNEGUIN")) {
				if (p.hasPermission("kitpvp.especial") || VipallAPI.vipall) {
					p.closeInventory();
					p.sendMessage("§6§lTAGS §b§lESPECIAIS §fVoc\u00ea colocou a §b§lTAG: §c§oNEGUIN");
					p.setDisplayName("§c§oNEGUIN " + p.getName() + ScoreBoard.getRankNick(p));
					NametagEdit.getApi().setPrefix(p, "§c§oNEGUIN ");
					NametagEdit.getApi().setSuffix(p, ScoreBoard.getRankNick(p));
				} else {
					p.closeInventory();
					p.sendMessage(
							"§6§lTAGS §b§lESPECIAIS §fAjude o servidor adiquirindo §6§lVIP §fpara ter §e§lACESSO §f\u00e1s §b§lTAGS");
				}
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lTAG §b§oHONESTO")) {
				if (p.hasPermission("kitpvp.especial") || VipallAPI.vipall) {
					p.closeInventory();
					p.sendMessage("§6§lTAGS §b§lESPECIAIS §fVoc\u00ea colocou a §b§lTAG: §b§oHONESTO");
					p.setDisplayName("§b§oHONESTO " + p.getName() + ScoreBoard.getRankNick(p));
					NametagEdit.getApi().setPrefix(p, "§b§oHONESTO ");
					NametagEdit.getApi().setSuffix(p, ScoreBoard.getRankNick(p));
				} else {
					p.closeInventory();
					p.sendMessage(
							"§6§lTAGS §b§lESPECIAIS §fAjude o servidor adiquirindo §6§lVIP §fpara ter §e§lACESSO §f\u00e1s §b§lTAGS");
				}
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lTAG §5§oV1D4LOK4")) {
				if (p.hasPermission("kitpvp.especial") || VipallAPI.vipall) {
					p.closeInventory();
					p.sendMessage("§6§lTAGS §b§lESPECIAIS §fVoc\u00ea colocou a §b§lTAG: §5§oV1D4LOK4");
					p.setDisplayName("§5§oV1D4LOK4 " + p.getName() + ScoreBoard.getRankNick(p));
					NametagEdit.getApi().setPrefix(p, "§5§oV1D4LOK4 ");
					NametagEdit.getApi().setSuffix(p, ScoreBoard.getRankNick(p));
				} else {
					p.closeInventory();
					p.sendMessage(
							"§6§lTAGS §b§lESPECIAIS §fAjude o servidor adiquirindo §6§lVIP §fpara ter §e§lACESSO §f\u00e1s §b§lTAGS");
				}
			}
		}
	}
}
