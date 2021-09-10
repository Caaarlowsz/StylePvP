package fodastico.user.Events;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Bat;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.help.HelpTopic;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import fodastico.user.Main;
import fodastico.user.Admin.AdminAPI;
import fodastico.user.Apis.APIs;
import fodastico.user.Apis.KitAPI;
import fodastico.user.Commands.Build;
import fodastico.user.Commands.Chat;
import fodastico.user.Commands.Doublexp;
import fodastico.user.Commands.Sc;
import fodastico.user.Commands.Ss;
import fodastico.user.Managers.TimeAPI;
import fodastico.user.Managers.TituloAPI;

public class SubEventos implements Listener {
	public static ArrayList<Player> antflood;
	public static HashMap<String, String> botarblocoglad;
	public static HashMap<Player, ItemStack[]> inventario;
	public static ArrayList<Player> combate;

	static {
		SubEventos.antflood = new ArrayList<Player>();
		SubEventos.botarblocoglad = new HashMap<String, String>();
		SubEventos.inventario = new HashMap<Player, ItemStack[]>();
		SubEventos.combate = new ArrayList<Player>();
	}

	@EventHandler
	public void onChatFormat(final AsyncPlayerChatEvent e) {
		final Player jogador = e.getPlayer();
		if (jogador.hasPermission("kitpvp.colorchat")) {
			e.setFormat(String.valueOf(jogador.getDisplayName()) + "§7: §f"
					+ e.getMessage().replace("&", "§").replace("%", "%%"));
		} else {
			e.setFormat(String.valueOf(jogador.getDisplayName()) + "§7: " + e.getMessage().replace("%", "%%"));
		}
		if (!jogador.hasPermission("kitpvp.divulca\u00e7ao") && (e.getMessage().contains(".com.br")
				|| e.getMessage().contains(".com") || e.getMessage().contains("mc.")
				|| e.getMessage().contains("jogar.") || e.getMessage().contains(".tk")
				|| e.getMessage().contains(".pro") || e.getMessage().contains(".net")
				|| e.getMessage().contains(".play") || e.getMessage().contains("play.")
				|| e.getMessage().contains("pvp.") || e.getMessage().contains("hg.") || e.getMessage().contains(".nu")
				|| e.getMessage().contains(".mcnetwork") || e.getMessage().contains(".me")
				|| e.getMessage().contains(".playbr.net") || e.getMessage().contains(".playbr")
				|| e.getMessage().contains(".desirehost") || e.getMessage().contains(".virtus")
				|| e.getMessage().contains(".host") || e.getMessage().contains(".br")
				|| e.getMessage().contains(".server"))) {
			e.setCancelled(true);
			jogador.sendMessage(
					"§b§lDIVULGA\u00c7AO §fVoc\u00ea n\u00e3o possui §4§lPERMISSAO §fpara §9§lDIVULGAR §fIP´s!");
		}
	}

	@EventHandler
	public void entityDamagePedra(final EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Player && ((Player) e.getDamager()) instanceof Player) {
			final Player p = (Player) e.getDamager();
			if (e.getEntity() instanceof Player && p.getItemInHand().getType() == Material.STONE_SWORD) {
				e.setDamage(e.getDamage() * 0.5);
				return;
			}
			if (p.getItemInHand().getType() == Material.WOOD_SWORD) {
				e.setDamage(e.getDamage() * 0.4);
				return;
			}
			if (p.getItemInHand().getType() == Material.DIAMOND_SWORD) {
				e.setDamage(e.getDamage() * 0.6);
			}
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onFlood(final AsyncPlayerChatEvent e) {
		final Player p = e.getPlayer();
		if (SubEventos.antflood.contains(e.getPlayer())) {
			e.getPlayer().sendMessage("§b§lFLOOD §fAguarde para §a§lENVIAR §foutra mensagem.");
			e.setCancelled(true);
			return;
		}
		if (!p.hasPermission("kitpvp.flood")) {
			SubEventos.antflood.add(e.getPlayer());
		}
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
			@Override
			public void run() {
				if (SubEventos.antflood.contains(p)) {
					SubEventos.antflood.remove(p);
				}
			}
		}, 60L);
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerCommandPreprocess(final PlayerCommandPreprocessEvent event) {
		if (!event.isCancelled()) {
			final Player player = event.getPlayer();
			final String cmd = event.getMessage().split(" ")[0];
			final HelpTopic topic = Bukkit.getServer().getHelpMap().getHelpTopic(cmd);
			if (topic == null) {
				TituloAPI.MandarTitulo(player, "§3§lCOMANDO §f§lINEXISTENTE");
				player.sendMessage("§b§lCOMANDO §fEste §3§lCOMANDO§f n\u00e3o foi encontrado.");
				player.playSound(player.getLocation(), Sound.ITEM_BREAK, 1.0f, 1.0f);
				event.setCancelled(true);
			}
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void ssblockcmd(final PlayerCommandPreprocessEvent event) {
		final Player p = event.getPlayer();
		if (Ss.inss.contains(p)) {
			p.sendMessage("§4§lSCREENSHARE §fVoc\u00ea n\u00e3o pode executar §3§lCOMANDOS §fem §c§lSCREENSHARE");
			event.setCancelled(true);
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void ssmessengerquit(final PlayerQuitEvent event) {
		final Player p = event.getPlayer();
		if (Ss.inss.contains(p)) {
			Bukkit.broadcastMessage(
					"§4§lSCREENSHARE §fO jogador §1§l" + p.getName() + " §e§lDESLOGOU §fem §c§lSCREENSHARE");
			Ss.inss.remove(p);
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPickup(final PlayerPickupItemEvent e) {
		final Player p = e.getPlayer();
		if (KitAPI.getkit(p) != "1v1" && e.getItem().getItemStack().getType() != Material.MUSHROOM_SOUP
				&& e.getItem().getItemStack().getType() != Material.RED_MUSHROOM
				&& e.getItem().getItemStack().getType() != Material.BROWN_MUSHROOM
				&& e.getItem().getItemStack().getType() != Material.BOWL) {
			e.setCancelled(true);
		} else if (KitAPI.getkit(p) == "1v1") {
			e.setCancelled(true);
		}
	}

	public static void onSsList(final Player p) {
		Player[] onlinePlayers;
		for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
			final Player jogadores = onlinePlayers[i];
			if (Ss.sscheckname.containsKey(jogadores)) {
				p.sendMessage("§c§l(!)SCREENSHARE EM ANDAMENTO §7- §fJogador(a): §e§l" + Ss.sscheckname.get(jogadores));
				p.sendMessage(" ");
			}
		}
	}

	@EventHandler
	public void onBreakCancell(final BlockBreakEvent e) {
		final Player p = e.getPlayer();
		if (Build.Build.get(p.getName()) == Build.BuilderMode.FALSE && e.getBlock().getType() != Material.BROWN_MUSHROOM
				&& e.getBlock().getType() != Material.RED_MUSHROOM) {
			e.setCancelled(true);
		} else if (Build.Build.get(p.getName()) == Build.BuilderMode.TRUE && e.getBlock().getType() != Material.GLASS) {
			e.setCancelled(false);
		}
	}

	@EventHandler
	public void onBlockPlace(final BlockPlaceEvent e) {
		final Player p = e.getPlayer();
		if (Build.Build.get(p.getName()) == Build.BuilderMode.FALSE) {
			e.setCancelled(true);
		} else if (Build.Build.get(p.getName()) == Build.BuilderMode.TRUE) {
			e.setCancelled(false);
		}
	}

	@EventHandler
	public void onChatMute(final AsyncPlayerChatEvent e) {
		final Player p = e.getPlayer();
		if (Chat.pausado && !p.hasPermission("kitpvp.falarchat")) {
			e.setCancelled(true);
			p.sendMessage("§4§lCHAT §fO §c§lCHAT §fdo servidor est\u00e1 §cDESATIVADO§f.");
		}
	}

	@EventHandler
	private void onAdminInteract(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (KitAPI.getkit(p) == "Admin" && p.getItemInHand().getType() == Material.getMaterial(351)) {
			p.chat("/admin");
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					p.chat("/admin");
				}
			}, 10L);
		}
	}

	public static int getAmount(final Player p, final Material m) {
		int amount = 0;
		ItemStack[] contents;
		for (int length = (contents = p.getInventory().getContents()).length, i = 0; i < length; ++i) {
			final ItemStack item = contents[i];
			if (item != null && item.getType() == m && item.getAmount() > 0) {
				amount += item.getAmount();
			}
		}
		return amount;
	}

	@EventHandler
	public void onAutoSoupTest(final PlayerInteractEntityEvent e) {
		final Player p = e.getPlayer();
		if (p instanceof Player && e.getRightClicked() instanceof Player) {
			if (p.getItemInHand().getType() == null && AdminAPI.inAdmin.contains(p)) {
				final Player t = (Player) e.getRightClicked();
				p.openInventory((Inventory) t.getInventory());
			}
			if (p.getItemInHand().getType() == Material.NETHER_FENCE && AdminAPI.inAdmin.contains(p)) {
				final Player t = (Player) e.getRightClicked();
				t.getWorld().spawnEntity(t.getLocation(), EntityType.BAT);
				t.getWorld().spawnEntity(t.getLocation(), EntityType.BAT);
				t.getWorld().spawnEntity(t.getLocation(), EntityType.BAT);
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
					@Override
					public void run() {
						final String world = t.getWorld().getName();
						for (final Entity entity : Bukkit.getServer().getWorld(world).getEntities()) {
							if (entity instanceof Bat) {
								entity.remove();
							}
						}
					}
				}, 40L);
			}
			if (p.getItemInHand().getType() == Material.MUSHROOM_SOUP && AdminAPI.inAdmin.contains(p)) {
				final Player t = (Player) e.getRightClicked();
				if (AdminAPI.autoSoupChecking.contains(t)) {
					p.sendMessage(
							"§c§lADMIN §fOutro §d§lSTAFFER §fj\u00e1 est\u00e1 §e§lCHECANDO §fauto-soup neste jogador.");
					return;
				}
				SubEventos.inventario.put(t, t.getInventory().getContents());
				t.getInventory().clear();
				t.setHealth(0.5);
				AdminAPI.autoSoupChecking.add(t);
				p.openInventory((Inventory) t.getInventory());
				t.getInventory().setItem(18,
						APIs.criarItem(p, Material.MUSHROOM_SOUP, "§cSopa", new String[] { "" }, 1, (short) 0));
				t.getInventory().setItem(19,
						APIs.criarItem(p, Material.MUSHROOM_SOUP, "§cSopa", new String[] { "" }, 1, (short) 0));
				t.getInventory().setItem(20,
						APIs.criarItem(p, Material.MUSHROOM_SOUP, "§cSopa", new String[] { "" }, 1, (short) 0));
				t.getInventory().setItem(21,
						APIs.criarItem(p, Material.MUSHROOM_SOUP, "§cSopa", new String[] { "" }, 1, (short) 0));
				t.getInventory().setItem(22,
						APIs.criarItem(p, Material.MUSHROOM_SOUP, "§cSopa", new String[] { "" }, 1, (short) 0));
				t.getInventory().setItem(23,
						APIs.criarItem(p, Material.MUSHROOM_SOUP, "§cSopa", new String[] { "" }, 1, (short) 0));
				t.getInventory().setItem(24,
						APIs.criarItem(p, Material.MUSHROOM_SOUP, "§cSopa", new String[] { "" }, 1, (short) 0));
				t.getInventory().setItem(25,
						APIs.criarItem(p, Material.MUSHROOM_SOUP, "§cSopa", new String[] { "" }, 1, (short) 0));
				t.getInventory().setItem(26,
						APIs.criarItem(p, Material.MUSHROOM_SOUP, "§cSopa", new String[] { "" }, 1, (short) 0));
				p.sendMessage(" ");
				p.sendMessage("§3§lADMIN §fTestando auto-soup em §7" + t.getName());
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
					@Override
					public void run() {
						if (SubEventos.getAmount(t, Material.BOWL) == 1) {
							p.sendMessage(" ");
							p.sendMessage(
									"§c§lADMIN §fO jogador §c§lPROVAVELMENTE §fest\u00e1 de auto-soup! (1 sopa tomada)");
						} else if (SubEventos.getAmount(t, Material.BOWL) == 2) {
							p.sendMessage(" ");
							p.sendMessage(
									"§c§lADMIN §fO jogador §c§lCERTAMENTE §fest\u00e1 de auto-soup! (2 sopas tomadas)");
						} else if (SubEventos.getAmount(t, Material.BOWL) == 3) {
							p.sendMessage(" ");
							p.sendMessage(
									"§c§lADMIN §fO jogador §4§lDEFINITIVAMENTE §fest\u00e1 de auto-soup! (3 sopas tomadas)");
						} else if (SubEventos.getAmount(t, Material.BOWL) == 4) {
							p.sendMessage(" ");
							p.sendMessage(
									"§c§lADMIN §fO jogador §4§lDEFINITIVAMENTE §fest\u00e1 de auto-soup! (4 sopas tomadas)");
						} else if (SubEventos.getAmount(t, Material.BOWL) >= 5) {
							p.sendMessage(" ");
							p.sendMessage(
									"§c§lADMIN §fO jogador §4§lDEFINITIVAMENTE §fest\u00e1 de auto-soup! (5 sopas tomadas)");
						} else if (SubEventos.getAmount(t, Material.BOWL) == 0) {
							p.sendMessage(" ");
							p.sendMessage(
									"§c§lADMIN §fO jogador §a§lN\u00c3O §fest\u00e1 de auto-soup! (0 sopas tomadas)");
						}
						AdminAPI.autoSoupChecking.remove(t);
						t.getInventory().clear();
						t.closeInventory();
						t.getInventory().setContents((ItemStack[]) SubEventos.inventario.get(t));
						t.setHealth(20.0);
					}
				}, 20L);
			}
		}
		if (p.getItemInHand().getType() == Material.BEDROCK && AdminAPI.inAdmin.contains(p)) {
			final Player t = (Player) e.getRightClicked();
			t.getLocation().add(0.0, 13.0, 0.0).getBlock().setType(Material.BEDROCK);
			t.getLocation().add(0.0, 11.0, 1.0).getBlock().setType(Material.BEDROCK);
			t.getLocation().add(1.0, 11.0, 0.0).getBlock().setType(Material.BEDROCK);
			t.getLocation().add(0.0, 11.0, -1.0).getBlock().setType(Material.BEDROCK);
			t.getLocation().add(-1.0, 11.0, 0.0).getBlock().setType(Material.BEDROCK);
			t.getLocation().add(0.0, 10.0, 0.0).getBlock().setType(Material.BEDROCK);
			t.teleport(t.getLocation().add(0.0, 11.0, -0.05));
			p.teleport(t.getLocation().add(3.0, 0.0, 0.05));
		}
		if (p.getItemInHand().getType() == Material.IRON_FENCE && AdminAPI.inAdmin.contains(p)) {
			final Player t = (Player) e.getRightClicked();
			p.chat("/ss " + t.getName());
		}
		if (p.getItemInHand().getType() == Material.PAPER && AdminAPI.inAdmin.contains(p)) {
			final Player t = (Player) e.getRightClicked();
			p.chat("/ipcheck " + t.getName());
			p.chat("/conta " + t.getName());
		}
		if (p.getItemInHand().getType() == Material.AIR && AdminAPI.inAdmin.contains(p)) {
			final Player t = (Player) e.getRightClicked();
			p.openInventory((Inventory) t.getInventory());
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onStaffChatEvent(final AsyncPlayerChatEvent e) {
		final Player p = e.getPlayer();
		if (Sc.inStaffChat.contains(p.getName())) {
			Bukkit.broadcast("§d[§d§lSTAFF§d] " + p.getDisplayName() + " §8» §e"
					+ e.getMessage().replace("&", "§").replace("%", "%%"), "kitpvp.sc");
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onCompassClick(final PlayerInteractEvent e) {
		boolean parar = false;
		if (e.getPlayer().getItemInHand().getType() == Material.COMPASS && KitAPI.getkit(e.getPlayer()) != "Spawn") {
			for (final Entity entidades : e.getPlayer().getNearbyEntities(100.0, 150.0, 100.0)) {
				if (entidades instanceof Player
						&& e.getPlayer().getLocation().distance(entidades.getLocation()) >= 9.0) {
					if (entidades.getLocation().getY() > 170.0) {
						return;
					}
					parar = true;
					e.getPlayer().setCompassTarget(entidades.getLocation());
					e.getPlayer().sendMessage(
							"§b§lBUSSOLA §fB\u00fassola apontando para §3§l" + ((Player) entidades).getName());
					return;
				}
			}
			if (!parar) {
				e.getPlayer().sendMessage("§b§lBUSSOLA §fNenhum jogador foi encontrado.");
				e.getPlayer().setCompassTarget(new Location(e.getPlayer().getWorld(), 0.0, 100.0, 0.0));
			}
		}
	}

	@EventHandler
	public void onDrop(final PlayerDropItemEvent e) {
		if (e.getItemDrop().getItemStack().getType() != Material.MUSHROOM_SOUP
				&& e.getItemDrop().getItemStack().getType() != Material.BOWL
				&& e.getItemDrop().getItemStack().getType() != Material.ENDER_PEARL
				&& e.getItemDrop().getItemStack().getType() != Material.RED_MUSHROOM
				&& e.getItemDrop().getItemStack().getType() != Material.BROWN_MUSHROOM
				&& e.getItemDrop().getItemStack().getType() != Material.IRON_HELMET
				&& e.getItemDrop().getItemStack().getType() != Material.IRON_CHESTPLATE
				&& e.getItemDrop().getItemStack().getType() != Material.IRON_LEGGINGS
				&& e.getItemDrop().getItemStack().getType() != Material.IRON_BOOTS
				&& e.getItemDrop().getItemStack().getType() != Material.GLASS_BOTTLE) {
			e.setCancelled(true);
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onCooldownCombat(final EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Player) {
			final Player d = (Player) e.getEntity();
			SubEventos.combate.add(d);
			Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) Main.getInstance(), (Runnable) new Runnable() {
				@Override
				public void run() {
					SubEventos.combate.remove(d);
				}
			}, 140L);
		}
	}

	@EventHandler
	public void onEntityDamageByEntity(final EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Player) {
			final Player d = (Player) e.getDamager();
			if (d.getItemInHand().getType() == Material.DIAMOND_SWORD
					|| d.getItemInHand().getType() == Material.STONE_SWORD
					|| d.getItemInHand().getType() == Material.WOOD_SWORD
					|| d.getItemInHand().getType() == Material.STONE_SWORD
					|| d.getItemInHand().getType() == Material.IRON_SWORD
					|| d.getItemInHand().getType() == Material.GOLD_SWORD
					|| d.getItemInHand().getType() == Material.FISHING_ROD
					|| d.getItemInHand().getType() == Material.DIAMOND_AXE
					|| d.getItemInHand().getType() == Material.GOLD_AXE
					|| d.getItemInHand().getType() == Material.STONE_AXE
					|| d.getItemInHand().getType() == Material.WOOD_AXE
					|| d.getItemInHand().getType() == Material.IRON_AXE) {
				d.getItemInHand().setDurability((short) 0);
				d.updateInventory();
			}
		}
	}

	public static void removeCooldownXp(final Player p) {
		if (Doublexp.delaydoublexp.contains(p.getName())) {
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					TimeAPI.removeTempo(p.getName());
					Doublexp.delaydoublexp.remove(p.getName());
					SubEventos.sendMsg(p);
				}
			}, 108000L);
		}
	}

	public static void sendMsg(final Player p) {
		if (p.isOnline()) {
			p.sendMessage(
					"§9§lDOUBLEXP §fVoc\u00ea saiu de §c§lCOOLDOWN§f! Se quiser, j\u00e1 pode §a§lUSAR§f outro §b§lDOUBLEXP §fnovamente caso ainda possua!");
		}
	}
}
