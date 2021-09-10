package fodastico.user.Events;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fodastico.user.Apis.APIs;
import fodastico.user.Apis.KitAPI;
import fodastico.user.FullVIP.VipallAPI;
import fodastico.user.Managers.TituloAPI;
import fodastico.user.Warp.WarpsMenu;
import net.md_5.bungee.api.ChatColor;

public class KitEvents implements Listener {
	public static void onOpenInvKits(final Player p) {
		final Inventory inv = Bukkit.createInventory((InventoryHolder) p, 54, "§3§lSELETOR DE KITS");
		final ItemStack tvidro = new ItemStack(Material.STAINED_GLASS_PANE);
		final ItemMeta tvidroetaa = tvidro.getItemMeta();
		tvidroetaa.setDisplayName("§§3§lKITS");
		tvidro.setItemMeta(tvidroetaa);
		final ItemStack ss = WarpsMenu.createMenuItem(Material.CHEST, "§b§lTODOS SEUS KITS", new String[1]);
		inv.setItem(0, tvidro);
		inv.setItem(1, tvidro);
		inv.setItem(2, tvidro);
		inv.setItem(3, tvidro);
		inv.setItem(4, ss);
		inv.setItem(5, tvidro);
		inv.setItem(6, tvidro);
		inv.setItem(7, tvidro);
		inv.setItem(8, tvidro);
		if (p.hasPermission("kit.pvp") || VipallAPI.vipall) {
			inv.addItem(new ItemStack[] { newMenuItem(Material.DIAMOND_SWORD, "§b§lPvP",
					new String[] { "§fO velho kitpvp", "§fcom espada afiada 1" }) });
		}
		if (p.hasPermission("kit.kangaroo") || VipallAPI.vipall) {
			inv.addItem(new ItemStack[] { newMenuItem(Material.FIREWORK, "§b§lKangaroo",
					new String[] { "§fPule, corra ou suba por a\u00ed", "§fcom o seu foguete" }) });
		}
		if (p.hasPermission("kit.quickdropper") || VipallAPI.vipall) {
			inv.addItem(new ItemStack[] { newMenuItem(Material.BOWL, "§b§lQuickdropper",
					new String[] { "§fAo tomar uma sopa", "§fo pote dropar\u00e1 autom\u00e1ticamente" }) });
		}
		if (p.hasPermission("kit.snail") || VipallAPI.vipall) {
			inv.addItem(new ItemStack[] { newMenuItem(Material.SOUL_SAND, "§b§lSnail", new String[] {
					"§fAo hitar um jogador, ter\u00e1 40% de", "§fchance dele receber lentid\u00e3o" }) });
		}
		if (p.hasPermission("kit.fisherman") || VipallAPI.vipall) {
			inv.addItem(new ItemStack[] { newMenuItem(Material.FISHING_ROD, "§b§lFisherman",
					new String[] { "§fAo fisgar um jogador com sua vara", "§fpuxe-o at\u00e9 voc\u00ea" }) });
		}
		if (p.hasPermission("kit.stomper") || VipallAPI.vipall) {
			inv.addItem(new ItemStack[] { newMenuItem(Material.LEATHER_BOOTS, "§b§lStomper",
					new String[] { "§fPule de uma altura em cima de seus inimigos",
							"§fpara esmag\u00e1los e mat\u00e1-los automaticamente" }) });
		}
		if (p.hasPermission("kit.switcher") || VipallAPI.vipall) {
			inv.addItem(new ItemStack[] { newMenuItem(Material.SNOW_BALL, "§b§lSwitcher",
					new String[] { "§fAo lan\u00e7ar bolinhas de neve em um jogador",
							"§fele trocar\u00e1 de lugar com voc\u00ea" }) });
		}
		if (p.hasPermission("kit.anchor") || VipallAPI.vipall) {
			inv.addItem(new ItemStack[] { newMenuItem(Material.ANVIL, "§b§lAnchor",
					new String[] { "§fN\u00e3o d\u00ea e nem leve", "§fknockback ao hitar um jogador" }) });
		}
		if (p.hasPermission("kit.gladiator") || VipallAPI.vipall) {
			inv.addItem(new ItemStack[] { newMenuItem(Material.IRON_FENCE, "§b§lGladiator",
					new String[] { "§fAo utilizar sua grade de ferro em um jogador",
							"§fvoces ser\u00e3o teleportados \u00e1 uma arena fechada para x1" }) });
		}
		if (p.hasPermission("kit.critical") || VipallAPI.vipall) {
			inv.addItem(new ItemStack[] { newMenuItem(Material.COAL_BLOCK, "§b§lCritical",
					new String[] { "§fAo hitar um jogador tenha 40% de", "§fchance de um dano cr\u00edtico" }) });
		}
		if (p.hasPermission("kit.viper") || VipallAPI.vipall) {
			inv.addItem(new ItemStack[] { newMenuItem(Material.SPIDER_EYE, "§b§lViper",
					new String[] { "§fAo hitar um jogador tenha 40% de", "§fchance dele receber efeito de veneno" }) });
		}
		if (p.hasPermission("kit.antistomper") || VipallAPI.vipall) {
			inv.addItem(new ItemStack[] { newMenuItem(Material.DIAMOND_BOOTS, "§b§lAntiStomper",
					new String[] { "§fN\u00e3o morra stompado" }) });
		}
		if (p.hasPermission("kit.poseidon") || VipallAPI.vipall) {
			inv.addItem(new ItemStack[] { newMenuItem(Material.WATER_BUCKET, "§b§lPoseidon",
					new String[] { "§fQuando voc\u00ea estiver a \u00e1gua", "§ffique mais forte e mais perigoso" }) });
		}
		if (p.hasPermission("kit.sniper") || VipallAPI.vipall) {
			inv.addItem(new ItemStack[] { newMenuItem(Material.BONE, "§b§lSniper",
					new String[] { "§fTenha um arco e flecha", "§fpara atirar e dar dano nos inimigos" }) });
		}
		if (p.hasPermission("kit.phantom") || VipallAPI.vipall) {
			inv.addItem(new ItemStack[] { newMenuItem(Material.FEATHER, "§b§lPhantom",
					new String[] { "§fAo usar sua pena, voc\u00ea ganhar\u00e1", "§fhabilidade de voar" }) });
		}
		if (p.hasPermission("kit.specialist") || VipallAPI.vipall) {
			inv.addItem(new ItemStack[] { newMenuItem(Material.BOOK, "§b§lSpecialist",
					new String[] { "§fA cada kill, ganhe xp", "§fpara encantar sua espada" }) });
		}
		if (p.hasPermission("kit.hotpotato") || VipallAPI.vipall) {
			inv.addItem(new ItemStack[] { newMenuItem(Material.TNT, "§b§lHotPotato", new String[] {
					"§fColoque TNT na cabe\u00e7a dos jogadores", "§fe explodir\u00e1 em 3 segundos" }) });
		}
		if (p.hasPermission("kit.imortal") || VipallAPI.vipall) {
			inv.addItem(new ItemStack[] { newMenuItem(Material.BEDROCK, "§b§lImortal",
					new String[] { "§fFique completamente imortal", "§fpor 30 segundos!" }) });
		}
		if (p.hasPermission("kit.viking") || VipallAPI.vipall) {
			inv.addItem(new ItemStack[] { newMenuItem(Material.DIAMOND_AXE, "§b§lViking", new String[] {
					"§fCom seu machado de diamente", "§fde um dano de uma espada de diamante afiada 3" }) });
		}
		p.openInventory(inv);
	}

	public static void MenuWarpFPS(final Player p) {
		final Inventory inv = Bukkit.createInventory((InventoryHolder) p, 54, "§fInfo §9§lWARP FPS");
		inv.setItem(22,
				newMenuItem(Material.DIAMOND_BLOCK, "§6§lWARP FPS", new String[] { "§b§lUTILIDADE §fEsta §9§lWARP §fse",
						"§fconsiste em dar mais §3§lFPS §fpara", "§fos jogadores tirarem §e§lPVP" }));
		p.openInventory(inv);
	}

	@EventHandler
	public void ClickarMWarpFps(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("§fInfo §9§lWARP FPS") && e.getCurrentItem() != null
				&& e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);
			if (e.getCurrentItem().getType() == Material.DIAMOND_BLOCK) {
				e.setCancelled(true);
				p.closeInventory();
			}
		}
	}

	public static void MenuWarpCHALLENGE(final Player p) {
		final Inventory inv = Bukkit.createInventory((InventoryHolder) p, 54, "§fInfo §9§lWARP CHALLENGE");
		inv.setItem(22,
				newMenuItem(Material.DIAMOND_BLOCK, "§6§lWARP CHALLENGE",
						new String[] { "§b§lUTILIDADE §fEsta §9§lWARP §ffoi feita",
								"§fpara jogadores que querem treinar suas habilidades",
								"§fem tomar sopa ou farmar §6§lMOEDAS", "§fe §a§lXP's §fmais r\u00e1pido." }));
		p.openInventory(inv);
	}

	@EventHandler
	public void ClickarMWarpChallenge(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("§fInfo §9§lWARP CHALLENGE") && e.getCurrentItem() != null
				&& e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);
			if (e.getCurrentItem().getType() == Material.DIAMOND_BLOCK) {
				e.setCancelled(true);
				p.closeInventory();
			}
		}
	}

	public static void MenuWarpTEXTURA(final Player p) {
		final Inventory inv = Bukkit.createInventory((InventoryHolder) p, 54, "§fInfo §9§lWARP TEXTURA");
		inv.setItem(22,
				newMenuItem(Material.DIAMOND_BLOCK, "§6§lWARP TEXTURA",
						new String[] { "§b§lUTILIDADE §fUma §9§lWARP §fsimples,",
								"§ffeita por nossos §2§lBUILDERS §fpara voc\u00ea conhecer",
								"§fmelhor e testar suas texturas." }));
		p.openInventory(inv);
	}

	@EventHandler
	public void ClickarMWarpTextura(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("§fInfo §9§lWARP TEXTURA") && e.getCurrentItem() != null
				&& e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);
			if (e.getCurrentItem().getType() == Material.DIAMOND_BLOCK) {
				e.setCancelled(true);
				p.closeInventory();
			}
		}
	}

	public static void MenuWarp1v1(final Player p) {
		final Inventory inv = Bukkit.createInventory((InventoryHolder) p, 54, "§fInfo §9§lWARP 1v1");
		inv.setItem(22,
				newMenuItem(Material.DIAMOND_BLOCK, "§6§lWARP 1v1",
						new String[] { "§b§lUTILIDADE §fEsta §9§lWARP §ffoi feita especialmente para",
								"§fos jogadores que gostam de ir pvp justo,", "§fupar de ligas, treinar etc." }));
		p.openInventory(inv);
	}

	@EventHandler
	public void ClickarMWarp1v1(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("§fInfo §9§lWARP 1v1") && e.getCurrentItem() != null
				&& e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);
			if (e.getCurrentItem().getType() == Material.DIAMOND_BLOCK) {
				e.setCancelled(true);
				p.closeInventory();
			}
		}
	}

	static ItemStack newMenuItem(final Material material, final String nome, final String[] habilidade) {
		final ItemStack item = new ItemStack(material);
		final ItemMeta kitem = item.getItemMeta();
		kitem.setDisplayName(nome);
		kitem.setLore(Arrays.asList(habilidade));
		item.setItemMeta(kitem);
		return item;
	}

	@EventHandler
	public void onKitClick(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equalsIgnoreCase("§3§lSELETOR DE KITS") && e.getCurrentItem() != null
				&& e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);
			if (e.getCurrentItem().getType() == Material.DIAMOND_SWORD) {
				e.setCancelled(true);
				KitAPI.setKit(p, "PvP");
				KitAPI.setDefaultItens(p);
				p.getInventory().setItem(8,
						APIs.criarItem(p, Material.COMPASS, ChatColor.GREEN + "Bussola", new String[1], 1, (short) 0));
				final ItemStack espadapvp = new ItemStack(Material.DIAMOND_SWORD);
				final ItemMeta espadapvpmeta = espadapvp.getItemMeta();
				espadapvpmeta.setDisplayName("§eEspada");
				espadapvp.setItemMeta(espadapvpmeta);
				espadapvp.addEnchantment(Enchantment.DAMAGE_ALL, 1);
				p.getInventory().setItem(0, espadapvp);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 2.0f, 2.0f);
				p.closeInventory();
				TituloAPI.MandarTitulo(p, "§e§lPVP");
				p.sendMessage("§3§lKIT §fVoc\u00ea selecionou o §b§lKIT §e§lPVP");
				return;
			}
			if (e.getCurrentItem().getType() == Material.SPIDER_EYE) {
				e.setCancelled(true);
				KitAPI.setDefaultItens(p);
				KitAPI.setKit(p, "Viper");
				p.getInventory().setItem(8,
						APIs.criarItem(p, Material.COMPASS, ChatColor.GREEN + "Bussola", new String[1], 1, (short) 0));
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 2.0f, 2.0f);
				p.closeInventory();
				TituloAPI.MandarTitulo(p, "§e§lVIPER");
				p.sendMessage("§3§lKIT §fVoc\u00ea selecionou o §b§lKIT §e§lVIPER");
				return;
			}
			if (e.getCurrentItem().getType() == Material.ANVIL) {
				e.setCancelled(true);
				KitAPI.setDefaultItens(p);
				KitAPI.setKit(p, "Anchor");
				p.getInventory().setItem(8,
						APIs.criarItem(p, Material.COMPASS, ChatColor.GREEN + "Bussola", new String[1], 1, (short) 0));
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 2.0f, 2.0f);
				p.closeInventory();
				TituloAPI.MandarTitulo(p, "§e§lANCHOR");
				p.sendMessage("§3§lKIT §fVoc\u00ea selecionou o §b§lKIT §e§lANCHOR");
				return;
			}
			if (e.getCurrentItem().getType() == Material.WATER_BUCKET) {
				e.setCancelled(true);
				KitAPI.setDefaultItens(p);
				KitAPI.setKit(p, "Poseidon");
				p.getInventory().setItem(8,
						APIs.criarItem(p, Material.COMPASS, ChatColor.GREEN + "Bussola", new String[1], 1, (short) 0));
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 2.0f, 2.0f);
				p.closeInventory();
				TituloAPI.MandarTitulo(p, "§e§lPOSEIDON");
				p.sendMessage("§3§lKIT §fVoc\u00ea selecionou o §b§lKIT §e§lPOSEIDON");
				return;
			}
			if (e.getCurrentItem().getType() == Material.BEACON) {
				e.setCancelled(true);
				KitAPI.setDefaultItens(p);
				KitAPI.setKit(p, "Turtle");
				p.getInventory().setItem(8,
						APIs.criarItem(p, Material.COMPASS, ChatColor.GREEN + "Bussola", new String[1], 1, (short) 0));
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 2.0f, 2.0f);
				p.closeInventory();
				TituloAPI.MandarTitulo(p, "§e§lBEACON");
				p.sendMessage("§3§lKIT §fVoc\u00ea selecionou o §b§lKIT §e§lBEACON");
				return;
			}
			if (e.getCurrentItem().getType() == Material.FEATHER) {
				e.setCancelled(true);
				KitAPI.setDefaultItens(p);
				KitAPI.setKit(p, "Phantom");
				p.getInventory().setItem(1,
						APIs.criarItem(p, Material.FEATHER, ChatColor.GREEN + "Phantom", new String[1], 1, (short) 0));
				p.getInventory().setItem(8,
						APIs.criarItem(p, Material.COMPASS, ChatColor.GREEN + "Bussola", new String[1], 1, (short) 0));
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 2.0f, 2.0f);
				p.closeInventory();
				TituloAPI.MandarTitulo(p, "§e§lPHANTOM");
				p.sendMessage("§3§lKIT §fVoc\u00ea selecionou o §b§lKIT §e§lPHANTOM");
				return;
			}
			if (e.getCurrentItem().getType() == Material.DIAMOND_BOOTS) {
				e.setCancelled(true);
				KitAPI.setDefaultItens(p);
				KitAPI.setKit(p, "AntiStomper");
				p.getInventory().setItem(8,
						APIs.criarItem(p, Material.COMPASS, ChatColor.GREEN + "Bussola", new String[1], 1, (short) 0));
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 2.0f, 2.0f);
				p.closeInventory();
				TituloAPI.MandarTitulo(p, "§e§lANTISTOMPER");
				p.sendMessage("§3§lKIT §fVoc\u00ea selecionou o §b§lKIT §e§lANTISTOMPER");
				return;
			}
			if (e.getCurrentItem().getType() == Material.BOWL) {
				e.setCancelled(true);
				KitAPI.setDefaultItens(p);
				KitAPI.setKit(p, "Quickdropper");
				p.getInventory().setItem(8,
						APIs.criarItem(p, Material.COMPASS, ChatColor.GREEN + "Bussola", new String[1], 1, (short) 0));
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 2.0f, 2.0f);
				p.closeInventory();
				TituloAPI.MandarTitulo(p, "§e§lQUICKDROPPER");
				p.sendMessage("§3§lKIT §fVoc\u00ea selecionou o §b§lKIT §e§lQUICKSROPPER");
				return;
			}
			if (e.getCurrentItem().getType() == Material.IRON_FENCE) {
				e.setCancelled(true);
				KitAPI.setDefaultItens(p);
				KitAPI.setKit(p, "Gladiator");
				p.getInventory().setItem(1, APIs.criarItem(p, Material.IRON_FENCE, ChatColor.GREEN + "Gladiator",
						new String[1], 1, (short) 0));
				p.getInventory().setItem(8,
						APIs.criarItem(p, Material.COMPASS, ChatColor.GREEN + "Bussola", new String[1], 1, (short) 0));
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 2.0f, 2.0f);
				p.closeInventory();
				TituloAPI.MandarTitulo(p, "§e§lGLADIATOR");
				p.sendMessage("§3§lKIT §fVoc\u00ea selecionou o §b§lKIT §e§lGLADIATOR");
				p.sendMessage("§4§lGLADIATOR §fEste §b§lKIT §festpa em §c§lTESTES§f!");
				return;
			}
			if (e.getCurrentItem().getType() == Material.TNT) {
				e.setCancelled(true);
				KitAPI.setDefaultItens(p);
				KitAPI.setKit(p, "HotPotato");
				p.getInventory().setItem(1,
						APIs.criarItem(p, Material.TNT, ChatColor.GREEN + "HotPotato", new String[1], 1, (short) 0));
				p.getInventory().setItem(8,
						APIs.criarItem(p, Material.COMPASS, ChatColor.GREEN + "Bussola", new String[1], 1, (short) 0));
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 2.0f, 2.0f);
				p.closeInventory();
				TituloAPI.MandarTitulo(p, "§e§lHITPOTATO");
				p.sendMessage("§3§lKIT §fVoc\u00ea selecionou o §b§lKIT §e§lHOTPOTATO");
				return;
			}
			if (e.getCurrentItem().getType() == Material.BEDROCK) {
				e.setCancelled(true);
				KitAPI.setDefaultItens(p);
				KitAPI.setKit(p, "Imortal");
				p.getInventory().setItem(1, APIs.criarItem(p, Material.BEDROCK, ChatColor.GREEN + "Imortalidade",
						new String[1], 1, (short) 0));
				p.getInventory().setItem(8,
						APIs.criarItem(p, Material.COMPASS, ChatColor.GREEN + "Bussola", new String[1], 1, (short) 0));
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 2.0f, 2.0f);
				p.closeInventory();
				TituloAPI.MandarTitulo(p, "§e§lIMORTAL");
				p.sendMessage("§3§lKIT §fVoc\u00ea selecionou o §b§lKIT §e§lIMORTAL");
				return;
			}
			if (e.getCurrentItem().getType() == Material.COAL_BLOCK) {
				e.setCancelled(true);
				KitAPI.setDefaultItens(p);
				KitAPI.setKit(p, "Critical");
				p.getInventory().setItem(8,
						APIs.criarItem(p, Material.COMPASS, ChatColor.GREEN + "Bussola", new String[1], 1, (short) 0));
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 2.0f, 2.0f);
				p.closeInventory();
				TituloAPI.MandarTitulo(p, "§e§lCRITICAL");
				p.sendMessage("§3§lKIT §fVoc\u00ea selecionou o §b§lKIT §e§lCRITICAL");
				return;
			}
			if (e.getCurrentItem().getType() == Material.DIAMOND_AXE) {
				e.setCancelled(true);
				KitAPI.setDefaultItens(p);
				KitAPI.setKit(p, "Viking");
				p.getInventory().setItem(0, APIs.criarItem(p, Material.DIAMOND_AXE, ChatColor.GREEN + "Viking",
						new String[1], 1, (short) 0));
				p.getInventory().setItem(8,
						APIs.criarItem(p, Material.COMPASS, ChatColor.GREEN + "Bussola", new String[1], 1, (short) 0));
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 2.0f, 2.0f);
				p.closeInventory();
				TituloAPI.MandarTitulo(p, "§e§lVIKING");
				p.sendMessage("§3§lKIT §fVoc\u00ea selecionou o §b§lKIT §e§lVIKING");
				return;
			}
			if (e.getCurrentItem().getType() == Material.IRON_INGOT) {
				e.setCancelled(true);
				KitAPI.setDefaultItens(p);
				KitAPI.setKit(p, "IronMan");
				p.getInventory().setItem(1, APIs.criarItem(p, Material.WORKBENCH, ChatColor.GREEN + "IronMan",
						new String[1], 1, (short) 0));
				p.getInventory().setItem(8,
						APIs.criarItem(p, Material.COMPASS, ChatColor.GREEN + "Bussola", new String[1], 1, (short) 0));
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 2.0f, 2.0f);
				p.closeInventory();
				TituloAPI.MandarTitulo(p, "§e§lIRONMAN");
				p.sendMessage("§3§lKIT §fVoc\u00ea selecionou o §b§lKIT §e§lIRONMAN");
				return;
			}
			if (e.getCurrentItem().getType() == Material.WOOD_AXE) {
				e.setCancelled(true);
				KitAPI.setDefaultItens(p);
				KitAPI.setKit(p, "Thor");
				p.getInventory().setItem(1,
						APIs.criarItem(p, Material.WOOD_AXE, ChatColor.GREEN + "Thor", new String[1], 1, (short) 0));
				p.getInventory().setItem(8,
						APIs.criarItem(p, Material.COMPASS, ChatColor.GREEN + "Bussola", new String[1], 1, (short) 0));
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 2.0f, 2.0f);
				p.closeInventory();
				TituloAPI.MandarTitulo(p, "§e§lTHOR");
				p.sendMessage("§3§lKIT §fVoc\u00ea selecionou o §b§lKIT §e§lTHOR");
				return;
			}
			if (e.getCurrentItem().getType() == Material.FIREWORK) {
				e.setCancelled(true);
				KitAPI.setDefaultItens(p);
				KitAPI.setKit(p, "Kangaroo");
				p.getInventory().setItem(1, APIs.criarItem(p, Material.FIREWORK, ChatColor.GREEN + "Kangaroo",
						new String[1], 1, (short) 0));
				p.getInventory().setItem(8,
						APIs.criarItem(p, Material.COMPASS, ChatColor.GREEN + "Bussola", new String[1], 1, (short) 0));
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 2.0f, 2.0f);
				p.closeInventory();
				TituloAPI.MandarTitulo(p, "§e§lKANGAROO");
				p.sendMessage("§3§lKIT §fVoc\u00ea selecionou o §b§lKIT §e§lKANGAROO");
				return;
			}
			if (e.getCurrentItem().getType() == Material.SOUL_SAND) {
				e.setCancelled(true);
				KitAPI.setDefaultItens(p);
				KitAPI.setKit(p, "Snail");
				p.getInventory().setItem(8,
						APIs.criarItem(p, Material.COMPASS, ChatColor.GREEN + "Bussola", new String[1], 1, (short) 0));
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 2.0f, 2.0f);
				p.closeInventory();
				TituloAPI.MandarTitulo(p, "§e§lSNAIL");
				p.sendMessage("§3§lKIT §fVoc\u00ea selecionou o §b§lKIT §e§lSNAIL");
				return;
			}
			if (e.getCurrentItem().getType() == Material.BOOK) {
				e.setCancelled(true);
				KitAPI.setDefaultItens(p);
				KitAPI.setKit(p, "Specialist");
				p.getInventory().setItem(1,
						APIs.criarItem(p, Material.BOOK, ChatColor.GREEN + "Specialist", new String[1], 1, (short) 0));
				p.getInventory().setItem(8,
						APIs.criarItem(p, Material.COMPASS, ChatColor.GREEN + "Bussola", new String[1], 1, (short) 0));
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 2.0f, 2.0f);
				p.closeInventory();
				TituloAPI.MandarTitulo(p, "§e§lSPECIALIST");
				p.sendMessage("§3§lKIT §fVoc\u00ea selecionou o §b§lKIT §e§lSPECIALIST");
				return;
			}
			if (e.getCurrentItem().getType() == Material.LEATHER_BOOTS) {
				e.setCancelled(true);
				KitAPI.setDefaultItens(p);
				KitAPI.setKit(p, "Stomper");
				p.getInventory().setItem(8,
						APIs.criarItem(p, Material.COMPASS, ChatColor.GREEN + "Bussola", new String[1], 1, (short) 0));
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 2.0f, 2.0f);
				p.closeInventory();
				TituloAPI.MandarTitulo(p, "§e§lSTOMPER");
				p.sendMessage("§3§lKIT §fVoc\u00ea selecionou o §b§lKIT §e§lSTOMPER");
				return;
			}
			if (e.getCurrentItem().getType() == Material.FISHING_ROD) {
				e.setCancelled(true);
				KitAPI.setDefaultItens(p);
				KitAPI.setKit(p, "Fisherman");
				p.getInventory().setItem(1, APIs.criarItem(p, Material.FISHING_ROD, ChatColor.GREEN + "Fisherman",
						new String[1], 1, (short) 0));
				p.getInventory().setItem(8,
						APIs.criarItem(p, Material.COMPASS, ChatColor.GREEN + "Bussola", new String[1], 1, (short) 0));
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 2.0f, 2.0f);
				p.closeInventory();
				TituloAPI.MandarTitulo(p, "§e§lFISHERMAN");
				p.sendMessage("§3§lKIT §fVoc\u00ea selecionou o §b§lKIT §e§lFISHERMAN");
				return;
			}
			if (e.getCurrentItem().getType() == Material.SNOW_BALL) {
				e.setCancelled(true);
				KitAPI.setDefaultItens(p);
				KitAPI.setKit(p, "Switcher");
				p.getInventory().setItem(1, APIs.criarItem(p, Material.SNOW_BALL, ChatColor.GREEN + "Switcher",
						new String[1], 64, (short) 0));
				p.getInventory().setItem(8,
						APIs.criarItem(p, Material.COMPASS, ChatColor.GREEN + "Bussola", new String[1], 1, (short) 0));
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 2.0f, 2.0f);
				p.closeInventory();
				TituloAPI.MandarTitulo(p, "§e§lSWITCHER");
				p.sendMessage("§3§lKIT §fVoc\u00ea selecionou o §b§lKIT §e§lSWITCHER");
				p.sendMessage(
						"§3§lSWITCHER §fDeixe um espa\u00e7o no seu §e§lINVENTARIO §fpara receber mais §b§lBOLAS DE NEVE§f!");
				return;
			}
			if (e.getCurrentItem().getType() == Material.ARROW) {
				e.setCancelled(true);
				KitAPI.setDefaultItens(p);
				KitAPI.setKit(p, "Teleporter");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 2.0f, 2.0f);
				p.getInventory().setItem(1,
						APIs.criarItem(p, Material.BOW, ChatColor.GREEN + "Arco", new String[1], 1, (short) 0));
				p.getInventory().setItem(8,
						APIs.criarItem(p, Material.COMPASS, ChatColor.GREEN + "Bussola", new String[1], 1, (short) 0));
				p.getInventory().setItem(20,
						APIs.criarItem(p, Material.ARROW, ChatColor.GREEN + "Flechas", new String[1], 30, (short) 0));
				p.closeInventory();
				TituloAPI.MandarTitulo(p, "§e§lTELEPORTER");
				p.sendMessage("§3§lKIT §fVoc\u00ea selecionou o §b§lKIT §e§lTELEPORTER");
			}
		}
	}
}
