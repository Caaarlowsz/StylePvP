package fodastico.user.Events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import fodastico.user.Main;
import fodastico.user.Admin.AdminAPI;
import fodastico.user.Apis.APIs;
import fodastico.user.Apis.BuildScoreAPI;
import fodastico.user.Apis.DeathAPI;
import fodastico.user.Apis.EventoAPI;
import fodastico.user.Apis.ImortalAPI;
import fodastico.user.Apis.KillsAPI;
import fodastico.user.Apis.KitAPI;
import fodastico.user.Apis.MoneyAPI;
import fodastico.user.Apis.StaffOnlineAPI;
import fodastico.user.Apis.TopKsAPI;
import fodastico.user.Apis.XpAPI;
import fodastico.user.Commands.Admin;
import fodastico.user.Commands.Score;
import fodastico.user.DoubleXp.BDoubleXpsAPI;
import fodastico.user.DoubleXp.XpbyXpAPI;
import fodastico.user.Managers.CooldownAPI;
import fodastico.user.PerderKillStreak.LostKillStreak;
import fodastico.user.ScoreBoard.ScoreBoard;
import fodastico.user.Warp.WarpsMenu;

public class EventosGerais implements Listener {
	public static String topksformat;
	public static String scoreanimatedspawn;
	public static String nometop;
	public static Integer kstop;
	public static ScoreBoard up;
	public static ArrayList<Block> bloco;
	public static HashMap<Player, Block> blocks;
	public static String motdrandom;

	static {
		EventosGerais.up = new ScoreBoard();
		EventosGerais.bloco = new ArrayList<Block>();
		EventosGerais.blocks = new HashMap<Player, Block>();
	}

	@EventHandler
	public void renascer1(final PlayerDeathEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		new BukkitRunnable() {
			public void run() {
				e.getEntity().spigot().respawn();
			}
		}.runTask(Main.getPlugin());
	}

	public void TirarFlechas(final ProjectileHitEvent e) {
		final Entity entity = (Entity) e.getEntity();
		if (entity.getType() == EntityType.ARROW) {
			entity.remove();
		}
	}

	@EventHandler
	public void onWarpsInventoryClick(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equalsIgnoreCase("§aWarps") && e.getCurrentItem() != null
				&& e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);
			if (e.getCurrentItem().getType() == Material.BLAZE_ROD) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/warp 1v1");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 2.0f, 2.0f);
				return;
			}
			if (e.getCurrentItem().getType() == Material.COOKIE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/warp textura");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 2.0f, 2.0f);
				return;
			}
			if (e.getCurrentItem().getType() == Material.GLASS) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/warp fps");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 2.0f, 2.0f);
				return;
			}
			if (e.getCurrentItem().getType() == Material.POTION) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/warp pot");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 2.0f, 2.0f);
				return;
			}
			if (e.getCurrentItem().getType() == Material.LAVA) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/warp challenge");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 2.0f, 2.0f);
			}
		}
	}

	@EventHandler
	public void onNameLenth(final AsyncPlayerPreLoginEvent event) {
		final String p = event.getName();
		if (p.length() > 15) {
			event.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER,
					"§4§lERRO\n§fNeste §6§lSERVIDOR§f seu nick n\u00e3o pode ter mais que §9§l15 CARATERES§f!\n§fAt\u00e9 resolvermos os §c§lBUGS§f relacionado \u00e1 isso, aguarde para §a§lENTRAR§f!");
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onfakeJoin(final PlayerLoginEvent e) {
		final Player jogador = e.getPlayer();
		Player[] onlinePlayers;
		for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
			final Player jogadores = onlinePlayers[i];
			if (jogador.getName().contains(jogadores.getName())) {
				e.disallow(PlayerLoginEvent.Result.KICK_OTHER,
						"§4§lONLINE \n \n §fJ\u00e1 §e§lPOSSUI §fum jogador §c§lONLINE §fcom este nick!");
			}
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onCommandPreProcess(final PlayerCommandPreprocessEvent e) {
		final String[] msg = e.getMessage().split(" ");
		final List<String> plugins = new ArrayList<String>();
		plugins.add("pl");
		plugins.add("plugin");
		plugins.add("ver" + msg);
		plugins.add("help" + msg);
		plugins.add("ver");
		plugins.add("help");
		plugins.add("?");
		plugins.add("me");
		plugins.add("bukkit:help");
		plugins.add("plugins");
		plugins.add("minecraft:me");
		for (final String Loop : plugins) {
			if (msg[0].equalsIgnoreCase("/" + Loop)) {
				e.getPlayer().sendMessage(Main.getInstance().getConfig().getString("MSG-PLUGINS").replace("&", "§"));
				e.setCancelled(true);
			}
		}
	}

	public static void topks(final Player sender) {
		final HashMap<String, Integer> players = new HashMap<String, Integer>();
		for (int length = (Bukkit.getOnlinePlayers()).length, j = 0; j < length; ++j) {
			for (final String playerName : TopKsAPI.TopKs.getKeys(false)) {
				players.put(playerName, TopKsAPI.TopKs.getInt(playerName));
			}
		}
		String nextTop = "Ningu\u00e9m";
		Integer nextTopKs = 0;
		for (int i = 1; i < 2; ++i) {
			for (int length2 = (Bukkit.getOnlinePlayers()).length, k = 0; k < length2; ++k) {
				for (final String playerName2 : players.keySet()) {
					if (players.get(playerName2) > nextTopKs) {
						nextTop = playerName2;
						nextTopKs = players.get(playerName2);
					}
				}
			}
			EventosGerais.nometop = nextTop;
			EventosGerais.kstop = nextTopKs;
			players.remove(nextTop);
			nextTop = "Ningu\u00e9m";
			nextTopKs = 0;
		}
	}

	public static void updateAdmin(final Player p) {
		Player[] onlinePlayers;
		for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
			final Player todos = onlinePlayers[i];
			if (p.hasPermission("kitpvp.admin") && AdminAPI.inAdmin.contains(todos)) {
				todos.showPlayer(p);
				p.showPlayer(todos);
			} else if (AdminAPI.inAdmin.contains(todos)) {
				p.hidePlayer(todos);
				todos.showPlayer(p);
			}
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void dano(final EntityDamageEvent e) {
		if (e.getEntity() instanceof Player && e.getCause() != EntityDamageEvent.DamageCause.LAVA) {
			final Player p = (Player) e.getEntity();
			if (ImortalAPI.isInvensible(p)) {
				e.setCancelled(true);
			}
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void entityDamage(final EntityDamageByEntityEvent e) {
		final Player d = (Player) e.getEntity();
		if (e.getCause() == EntityDamageEvent.DamageCause.FALL && ImortalAPI.isInvensible(d)) {
			e.setCancelled(true);
		}
		if (e.getDamager() instanceof Player) {
			final Player p = (Player) e.getDamager();
			if (ImortalAPI.isInvensible(p)) {
				e.setCancelled(true);
			}
		}
	}

	@EventHandler
	public void Entrar1(final PlayerJoinEvent e) {
		e.setJoinMessage((String) null);
		final Player p = e.getPlayer();
		Score.ativada.add(p.getName());
		BuildScoreAPI.forceBuild(p);
		p.getInventory().clear();
		p.getInventory().setArmorContents((ItemStack[]) null);
		KitAPI.sendSpawn(p);
		Main.sc.registerScoreBoard(p);
		BDoubleXpsAPI.createDoubleXpsAcc(p);
		TopKsAPI.TopKs.set(p.getName(), (Object) 0);
		AdminAPI.isPlaying.add(p);
		AdminAPI.inAdmin.remove(p);
		Admin.updateAdmin(p);
		StaffOnlineAPI.putStaffOnline(p);
		EventoAPI.removeEvent(p);
		APIs.Normal(p);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
			@Override
			public void run() {
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(" ");
				p.sendMessage(Main.getInstance().getConfig().getString("MSG-ENTRAR-1").replace("&", "§"));
				p.sendMessage(Main.getInstance().getConfig().getString("MSG-ENTRAR-2").replace("&", "§"));
				p.sendMessage(Main.getInstance().getConfig().getString("MSG-ENTRAR-3").replace("&", "§"));
				p.sendMessage(Main.getInstance().getConfig().getString("MSG-ENTRAR-4").replace("&", "§"));
				p.sendMessage(Main.getInstance().getConfig().getString("MSG-ENTRAR-5").replace("&", "§"));
				p.sendMessage(Main.getInstance().getConfig().getString("MSG-ENTRAR-6").replace("&", "§"));
				p.sendMessage(Main.getInstance().getConfig().getString("MSG-ENTRAR-7").replace("&", "§"));
				p.sendMessage(Main.getInstance().getConfig().getString("MSG-ENTRAR-8").replace("&", "§"));
				p.sendMessage(Main.getInstance().getConfig().getString("MSG-ENTRAR-9").replace("&", "§"));
				p.sendMessage(" ");
				TopKsAPI.TopKs.set(p.getName(), (Object) 0);
				Admin.updateAdmin(p);
				Main.sc.registerScoreBoard(p);
				Admin.updateAdmin(p);
				EventoAPI.removeEvent(p);
			}
		}, 40L);
	}

	public static void EncontrarTag(final Player p) {
		if (p.hasPermission("*")) {
			APIs.Dono(p);
		} else if (p.hasPermission("rank.dev")) {
			APIs.Dev(p);
		} else if (p.hasPermission("rank.gerente")) {
			APIs.Gerente(p);
		} else if (p.hasPermission("rank.admin")) {
			APIs.Admin(p);
		} else if (p.hasPermission("rank.mod+")) {
			APIs.ModPlus(p);
		} else if (p.hasPermission("rank.modgc")) {
			APIs.ModGc(p);
		} else if (p.hasPermission("rank.mod")) {
			APIs.Mod(p);
		} else if (p.hasPermission("rank.trial")) {
			APIs.Trial(p);
		} else if (p.hasPermission("rank.ajudante")) {
			APIs.Ajudante(p);
		} else if (p.hasPermission("rank.builder")) {
			APIs.Builder(p);
		} else if (p.hasPermission("rank.youtuber+")) {
			APIs.YoutuberPlus(p);
		} else if (p.hasPermission("rank.youtuber")) {
			APIs.Youtuber(p);
		} else if (p.hasPermission("rank.ultimate")) {
			APIs.Ultimate(p);
		} else if (p.hasPermission("rank.beta")) {
			APIs.Beta(p);
		} else if (p.hasPermission("rank.premium")) {
			APIs.Premium(p);
		} else if (p.hasPermission("rank.light")) {
			APIs.Light(p);
		} else {
			APIs.Normal(p);
		}
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void ItensSpawnClick(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (KitAPI.getkit(p) != "Spawn") {
			return;
		}
		if (p.getItemInHand().getType() == Material.CHEST) {
			KitEvents.onOpenInvKits(p);
		}
		if (p.getItemInHand().getType() == Material.ENCHANTED_BOOK) {
			p.chat("/warp evento");
		}
		if (p.getItemInHand().getType() == Material.COMPASS) {
			WarpsMenu.inventoryWarps(p);
		}
		if (p.getItemInHand().getType() == Material.EMERALD) {
			Menus.inventarioShop(p);
		}
		if (p.getItemInHand().getType() == Material.BOOK) {
			Menus.inventorystatus(p);
		}
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void RepararArmadura(final PlayerDeathEvent e) {
		final Player d = e.getEntity();
		final Player k = e.getEntity().getKiller();
		if (e.getEntity().getKiller() instanceof Player) {
			if (KitAPI.getkit(d) == "1v1" || KitAPI.getkit(k) == "1v1") {
				return;
			}
			try {
				k.getInventory().getHelmet().setDurability((short) 0);
				k.getInventory().getChestplate().setDurability((short) 0);
				k.getInventory().getLeggings().setDurability((short) 0);
				k.getInventory().getBoots().setDurability((short) 0);
			} catch (Exception ex) {
			}
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void getBreakBlock(final BlockBreakEvent evento) {
		final Player p = evento.getPlayer();
		if (Gladiator.fighting.containsKey(p.getName())) {
			EventosGerais.blocks.remove(p, evento.getBlock());
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void getBreakBlock(final BlockPlaceEvent e) {
		final Player p = e.getPlayer();
		if (Gladiator.fighting.containsKey(p.getName())) {
			EventosGerais.blocks.put(p, e.getBlock());
		}
	}

	public static void clearBlocksGladiator(final Player p) {
		EventosGerais.blocks.get(p).setType(Material.AIR);
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void MorrerMatarPrincipal(final PlayerDeathEvent e) {
		final Player d = e.getEntity();
		final Player k = e.getEntity().getKiller();
		e.setDeathMessage((String) null);
		if (e.getEntity().getKiller() instanceof Player) {
			Imortal.removercooldown.remove(d);
			CooldownAPI.removeCooldown(d);
			LostKillStreak.lostKillStreak(d, k);
			XpbyXpAPI.xpbyxp(d, k);
			k.sendMessage("§c§lKILL §fVoc\u00ea matou: §a" + d.getName());
			k.sendMessage("§6§lMOEDAS §fVoc\u00ea §a§lRECEBEU §6§l60 MOEDAS");
			k.playSound(k.getLocation(), Sound.FIREWORK_LAUNCH, 1.0f, 1.0f);
			d.sendMessage("§4§lMORTE §fVoc\u00ea foi §c§lMORTO §fpor §c" + k.getName());
			d.sendMessage("§6§lMOEDAS §fVoc\u00ea §c§lPERDEU §6§l4 MOEDAS");
			TopKsAPI.addTopKs(k, 1);
			KillsAPI.addKills(k, 1);
			DeathAPI.addDeath(d, 1);
			MoneyAPI.addMoney(k, 60);
			KillStreak(k);
			MoneyAPI.removeMoney(d, 4);
			TopKsAPI.TopKs.set(d.getName(), (Object) 0);
			EventoAPI.removeEvent(d);
			Main.sc.registerScoreBoard(k);
			Main.sc.registerScoreBoard(d);
		} else {
			TopKsAPI.TopKs.set(d.getName(), (Object) 0);
			Main.sc.registerScoreBoard(d);
			EventoAPI.removeEvent(d);
			d.sendMessage("§4§lMORTE §fVoc\u00ea §c§lMORREU§f!");
		}
	}

	public static void KillStreak(final Player player) {
		final Player killer = player;
		if (TopKsAPI.getStreak(killer) == 10) {
			Bukkit.getServer().broadcastMessage(
					"§4§lKILLSTREAK §c§l" + killer.getName() + " §fconseguiu um §6§lKILLSTREAK DE 10");
		} else if (TopKsAPI.getStreak(killer) == 15) {
			Bukkit.getServer().broadcastMessage(
					"§4§lKILLSTREAK §c§l" + killer.getName() + " §fconseguiu um §6§lKILLSTREAK DE 15");
		} else if (TopKsAPI.getStreak(killer) == 20) {
			Bukkit.getServer().broadcastMessage(
					"§4§lKILLSTREAK §c§l" + killer.getName() + " §fconseguiu um §6§lKILLSTREAK DE 20");
		} else if (TopKsAPI.getStreak(killer) == 25) {
			Bukkit.getServer().broadcastMessage(
					"§4§lKILLSTREAK §c§l" + killer.getName() + " §fconseguiu um §6§lKILLSTREAK DE 25");
		} else if (TopKsAPI.getStreak(killer) == 30) {
			Bukkit.getServer().broadcastMessage(
					"§4§lKILLSTREAK §c§l" + killer.getName() + " §fconseguiu um §6§lKILLSTREAK DE 30");
		} else if (TopKsAPI.getStreak(killer) == 35) {
			Bukkit.getServer().broadcastMessage(
					"§4§lKILLSTREAK §c§l" + killer.getName() + " §fconseguiu um §6§lKILLSTREAK DE 35");
		} else if (TopKsAPI.getStreak(killer) == 40) {
			Bukkit.getServer().broadcastMessage(
					"§4§lKILLSTREAK §c§l" + killer.getName() + " §fconseguiu um §6§lKILLSTREAK DE 40");
		} else if (TopKsAPI.getStreak(killer) == 45) {
			Bukkit.getServer().broadcastMessage(
					"§4§lKILLSTREAK §c§l" + killer.getName() + " §fconseguiu um §6§lKILLSTREAK DE 45");
		} else if (TopKsAPI.getStreak(killer) == 50) {
			Bukkit.getServer().broadcastMessage(
					"§4§lKILLSTREAK §c§l" + killer.getName() + " §fconseguiu um §6§lKILLSTREAK DE 50");
		} else if (TopKsAPI.getStreak(killer) == 55) {
			Bukkit.getServer().broadcastMessage(
					"§4§lKILLSTREAK §c§l" + killer.getName() + " §fconseguiu um §6§lKILLSTREAK DE 55");
		} else if (TopKsAPI.getStreak(killer) == 60) {
			Bukkit.getServer().broadcastMessage(
					"§4§lKILLSTREAK §c§l" + killer.getName() + " §fconseguiu um §6§lKILLSTREAK DE 60");
		} else if (TopKsAPI.getStreak(killer) == 65) {
			Bukkit.getServer().broadcastMessage(
					"§4§lKILLSTREAK §c§l" + killer.getName() + " §fconseguiu um §6§lKILLSTREAK DE 65");
		} else if (TopKsAPI.getStreak(killer) == 70) {
			Bukkit.getServer().broadcastMessage(
					"§4§lKILLSTREAK §c§l" + killer.getName() + " §fconseguiu um §6§lKILLSTREAK DE 70");
		} else if (TopKsAPI.getStreak(killer) == 75) {
			Bukkit.getServer().broadcastMessage(
					"§4§lKILLSTREAK §c§l" + killer.getName() + " §fconseguiu um §6§lKILLSTREAK DE 75");
		} else if (TopKsAPI.getStreak(killer) == 80) {
			Bukkit.getServer().broadcastMessage(
					"§4§lKILLSTREAK §c§l" + killer.getName() + " §fconseguiu um §6§lKILLSTREAK DE 80");
		} else if (TopKsAPI.getStreak(killer) == 85) {
			Bukkit.getServer().broadcastMessage(
					"§4§lKILLSTREAK §c§l" + killer.getName() + " §fconseguiu um §6§lKILLSTREAK DE 85");
		} else if (TopKsAPI.getStreak(killer) == 90) {
			Bukkit.getServer().broadcastMessage(
					"§4§lKILLSTREAK §c§l" + killer.getName() + " §fconseguiu um §6§lKILLSTREAK DE 90");
		} else if (TopKsAPI.getStreak(killer) == 95) {
			Bukkit.getServer().broadcastMessage(
					"§4§lKILLSTREAK §c§l" + killer.getName() + " §fconseguiu um §6§lKILLSTREAK DE 95");
		} else if (TopKsAPI.getStreak(killer) == 100) {
			Bukkit.getServer().broadcastMessage(
					"§4§lKILLSTREAK §c§l" + killer.getName() + " §fconseguiu um §6§lKILLSTREAK DE 100");
		} else if (TopKsAPI.getStreak(killer) == 105) {
			Bukkit.getServer().broadcastMessage(
					"§4§lKILLSTREAK §c§l" + killer.getName() + " §fconseguiu um §6§lKILLSTREAK DE 105");
		} else if (TopKsAPI.getStreak(killer) == 110) {
			Bukkit.getServer().broadcastMessage(
					"§4§lKILLSTREAK §c§l" + killer.getName() + " §fconseguiu um §6§lKILLSTREAK DE 110");
		} else if (TopKsAPI.getStreak(killer) == 115) {
			Bukkit.getServer().broadcastMessage(
					"§4§lKILLSTREAK §c§l" + killer.getName() + " §fconseguiu um §6§lKILLSTREAK DE 115");
		} else if (TopKsAPI.getStreak(killer) == 120) {
			Bukkit.getServer().broadcastMessage(
					"§4§lKILLSTREAK §c§l" + killer.getName() + " §fconseguiu um §6§lKILLSTREAK DE 120");
		} else if (TopKsAPI.getStreak(killer) == 125) {
			Bukkit.getServer().broadcastMessage(
					"§4§lKILLSTREAK §c§l" + killer.getName() + " §fconseguiu um §6§lKILLSTREAK DE 125");
		} else if (TopKsAPI.getStreak(killer) == 130) {
			Bukkit.getServer().broadcastMessage(
					"§4§lKILLSTREAK §c§l" + killer.getName() + " §fconseguiu um §6§lKILLSTREAK DE 130");
		} else if (TopKsAPI.getStreak(killer) == 135) {
			Bukkit.getServer().broadcastMessage(
					"§4§lKILLSTREAK §c§l" + killer.getName() + " §fconseguiu um §6§lKILLSTREAK DE 135");
		} else if (TopKsAPI.getStreak(killer) == 140) {
			Bukkit.getServer().broadcastMessage(
					"§4§lKILLSTREAK §c§l" + killer.getName() + " §fconseguiu um §6§lKILLSTREAK DE 140");
		} else if (TopKsAPI.getStreak(killer) == 145) {
			Bukkit.getServer().broadcastMessage(
					"§4§lKILLSTREAK §c§l" + killer.getName() + " §fconseguiu um §6§lKILLSTREAK DE 145");
		} else if (TopKsAPI.getStreak(killer) == 150) {
			Bukkit.getServer().broadcastMessage(
					"§4§lKILLSTREAK §c§l" + killer.getName() + " §fconseguiu um §6§lKILLSTREAK DE 150");
		} else if (TopKsAPI.getStreak(killer) == 155) {
			Bukkit.getServer().broadcastMessage(
					"§4§lKILLSTREAK §c§l" + killer.getName() + " §fconseguiu um §6§lKILLSTREAK DE 155");
		} else if (TopKsAPI.getStreak(killer) == 160) {
			Bukkit.getServer().broadcastMessage(
					"§4§lKILLSTREAK §c§l" + killer.getName() + " §fconseguiu um §6§lKILLSTREAK DE 160");
		} else if (TopKsAPI.getStreak(killer) == 170) {
			Bukkit.getServer().broadcastMessage(
					"§4§lKILLSTREAK §c§l" + killer.getName() + " §fconseguiu um §6§lKILLSTREAK DE 170");
		} else if (TopKsAPI.getStreak(killer) == 175) {
			Bukkit.getServer().broadcastMessage(
					"§4§lKILLSTREAK §c§l" + killer.getName() + " §fconseguiu um §6§lKILLSTREAK DE 175");
		} else if (TopKsAPI.getStreak(killer) == 180) {
			Bukkit.getServer().broadcastMessage(
					"§4§lKILLSTREAK §c§l" + killer.getName() + " §fconseguiu um §6§lKILLSTREAK DE 180");
		} else if (TopKsAPI.getStreak(killer) == 185) {
			Bukkit.getServer().broadcastMessage(
					"§4§lKILLSTREAK §c§l" + killer.getName() + " §fconseguiu um §6§lKILLSTREAK DE 185");
		} else if (TopKsAPI.getStreak(killer) == 190) {
			Bukkit.getServer().broadcastMessage(
					"§4§lKILLSTREAK §c§l" + killer.getName() + " §fconseguiu um §6§lKILLSTREAK DE 190");
		} else if (TopKsAPI.getStreak(killer) == 195) {
			Bukkit.getServer().broadcastMessage(
					"§4§lKILLSTREAK §c§l" + killer.getName() + " §fconseguiu um §6§lKILLSTREAK DE 195");
		} else if (TopKsAPI.getStreak(killer) == 200) {
			Bukkit.getServer().broadcastMessage(
					"§4§lKILLSTREAK §c§l" + killer.getName() + " §fconseguiu um §6§lKILLSTREAK DE 200");
		} else if (TopKsAPI.getStreak(killer) == 205) {
			Bukkit.getServer().broadcastMessage(
					"§4§lKILLSTREAK §c§l" + killer.getName() + " §fconseguiu um §6§lKILLSTREAK DE 205");
		} else if (TopKsAPI.getStreak(killer) == 210) {
			Bukkit.getServer().broadcastMessage(
					"§4§lKILLSTREAK §c§l" + killer.getName() + " §fconseguiu um §6§lKILLSTREAK DE 210");
		} else if (TopKsAPI.getStreak(killer) == 215) {
			Bukkit.getServer().broadcastMessage(
					"§4§lKILLSTREAK §c§l" + killer.getName() + " §fconseguiu um §6§lKILLSTREAK DE 215");
		} else if (TopKsAPI.getStreak(killer) == 220) {
			Bukkit.getServer().broadcastMessage(
					"§4§lKILLSTREAK §c§l" + killer.getName() + " §fconseguiu um §6§lKILLSTREAK DE 220");
		} else if (TopKsAPI.getStreak(killer) == 225) {
			Bukkit.getServer().broadcastMessage(
					"§4§lKILLSTREAK §c§l" + killer.getName() + " §fconseguiu um §6§lKILLSTREAK DE 225");
		} else if (TopKsAPI.getStreak(killer) == 230) {
			Bukkit.getServer().broadcastMessage(
					"§4§lKILLSTREAK §c§l" + killer.getName() + " §fconseguiu um §6§lKILLSTREAK DE 230");
		} else if (TopKsAPI.getStreak(killer) == 235) {
			Bukkit.getServer().broadcastMessage(
					"§4§lKILLSTREAK §c§l" + killer.getName() + " §fconseguiu um §6§lKILLSTREAK DE 235");
		} else if (TopKsAPI.getStreak(killer) == 240) {
			Bukkit.getServer().broadcastMessage(
					"§4§lKILLSTREAK §c§l" + killer.getName() + " §fconseguiu um §6§lKILLSTREAK DE 240");
		} else if (TopKsAPI.getStreak(killer) == 245) {
			Bukkit.getServer().broadcastMessage(
					"§4§lKILLSTREAK §c§l" + killer.getName() + " §fconseguiu um §6§lKILLSTREAK DE 245");
		} else if (TopKsAPI.getStreak(killer) == 250) {
			Bukkit.getServer().broadcastMessage(
					"§4§lKILLSTREAK §c§l" + killer.getName() + " §fconseguiu um §6§lKILLSTREAK DE 250");
		} else if (TopKsAPI.getStreak(killer) == 255) {
			Bukkit.getServer().broadcastMessage(
					"§4§lKILLSTREAK §c§l" + killer.getName() + " §fconseguiu um §6§lKILLSTREAK DE 255");
		} else if (TopKsAPI.getStreak(killer) == 260) {
			Bukkit.getServer().broadcastMessage(
					"§4§lKILLSTREAK §c§l" + killer.getName() + " §fconseguiu um §6§lKILLSTREAK DE 260");
		} else if (TopKsAPI.getStreak(killer) == 265) {
			Bukkit.getServer().broadcastMessage(
					"§4§lKILLSTREAK §c§l" + killer.getName() + " §fconseguiu um §6§lKILLSTREAK DE 265");
		} else if (TopKsAPI.getStreak(killer) == 270) {
			Bukkit.getServer().broadcastMessage(
					"§4§lKILLSTREAK §c§l" + killer.getName() + " §fconseguiu um §6§lKILLSTREAK DE 270");
		} else if (TopKsAPI.getStreak(killer) == 275) {
			Bukkit.getServer().broadcastMessage(
					"§4§lKILLSTREAK §c§l" + killer.getName() + " §fconseguiu um §6§lKILLSTREAK DE 275");
		} else if (TopKsAPI.getStreak(killer) == 280) {
			Bukkit.getServer().broadcastMessage(
					"§4§lKILLSTREAK §c§l" + killer.getName() + " §fconseguiu um §6§lKILLSTREAK DE 280");
		} else if (TopKsAPI.getStreak(killer) == 285) {
			Bukkit.getServer().broadcastMessage(
					"§4§lKILLSTREAK §c§l" + killer.getName() + " §fconseguiu um §6§lKILLSTREAK DE 285");
		} else if (TopKsAPI.getStreak(killer) == 290) {
			Bukkit.getServer().broadcastMessage(
					"§4§lKILLSTREAK §c§l" + killer.getName() + " §fconseguiu um §6§lKILLSTREAK DE 290");
		} else if (TopKsAPI.getStreak(killer) == 295) {
			Bukkit.getServer().broadcastMessage(
					"§4§lKILLSTREAK §c§l" + killer.getName() + " §fconseguiu um §6§lKILLSTREAK DE 295");
		} else if (TopKsAPI.getStreak(killer) == 300) {
			Bukkit.getServer().broadcastMessage(
					"§4§lKILLSTREAK §c§l" + killer.getName() + " §fconseguiu um §6§lKILLSTREAK DE 300");
		}
	}

	public static String Grupo(final Player p) {
		if (p.hasPermission("*")) {
			return "§4§lDONO";
		}
		if (p.hasPermission("rank.gerente")) {
			return "§c§lGERENTE";
		}
		if (p.hasPermission("rank.admin")) {
			return "§c§lADMIN";
		}
		if (p.hasPermission("rank.mod+")) {
			return "§5§lMOD+";
		}
		if (p.hasPermission("rank.mod")) {
			return "§5§lMOD";
		}
		if (p.hasPermission("rank.trial")) {
			return "§5§lTRIAL";
		}
		if (p.hasPermission("rank.ajudante")) {
			return "§9§lAJUDANTE";
		}
		if (p.hasPermission("rank.builder")) {
			return "§2§lBUILDER";
		}
		if (p.hasPermission("rank.ultimate")) {
			return "§d§lULTIMATE";
		}
		if (p.hasPermission("rank.premium")) {
			return "§6§lPREMIUM";
		}
		if (p.hasPermission("rank.light")) {
			return "§a§lLIGHT";
		}
		if (p.hasPermission("rank.youtuber+")) {
			return "§3§lYOUTUBER+";
		}
		if (p.hasPermission("rank.youtuber")) {
			return "§b§lYOUTUBER";
		}
		return "§7§lNORMAL";
	}

	public static String SerVip(final Player p) {
		if (p.hasPermission("rank.ultimate")) {
			return "§aVoc\u00ea \u00e9 §6§lVIP! §eDetalhes do §6§lVIP: §7(§d§lULTIMATE§7)";
		}
		if (p.hasPermission("rank.premium")) {
			return "§aVoc\u00ea \u00e9 §6§lVIP! §eDetalhes do §6§lVIP: §7(§6§lPREMIUM§7)";
		}
		if (p.hasPermission("rank.light")) {
			return "§aVoc\u00ea \u00e9 §6§lVIP! §eDetalhes do §6§lVIP: §7(§a§lLIGHT§7)";
		}
		return "§cVoc\u00ea n\u00e3o \u00e9 §6§lVIP!";
	}

	public static String LigaAtual(final Player p) {
		final int r = XpAPI.getXp(p);
		if (r <= 99) {
			return "§f§l- UNRANKED";
		}
		if (r >= 100 && r <= 499) {
			return "§a§l\u2630 PRIMARY";
		}
		if (r >= 500 && r <= 999) {
			return "§e§l\u2634 ADVANCED";
		}
		if (r >= 1000 && r <= 1499) {
			return "§1§l\u2637 EXPERT";
		}
		if (r >= 1500 && r <= 1999) {
			return "§7§l\u2736 SILVER";
		}
		if (r >= 2000 && r <= 2999) {
			return "§6§l\u2739 GOLD";
		}
		if (r >= 3000 && r <= 4000) {
			return "§b§l\u2726 DIAMOND";
		}
		if (r >= 5000 && r <= 5999) {
			return "§5§l\u2739 ELITE";
		}
		if (r >= 6000 && r <= 6999) {
			return "§c§l\u272b MASTER";
		}
		if (r >= 7000) {
			return "§4§l\u272a LEGENDARY";
		}
		return "§4§l\u272a LEGENDARY";
	}

	public static int XpNecessario(final Player p) {
		final int r = XpAPI.getXp(p);
		if (r <= 99) {
			final int b = 100;
			return b - r;
		}
		if (r >= 100 && r <= 499) {
			final int b = 500;
			return b - r;
		}
		if (r >= 500 && r <= 999) {
			final int b = 1000;
			return b - r;
		}
		if (r >= 1000 && r <= 1499) {
			final int b = 1500;
			return b - r;
		}
		if (r >= 1500 && r <= 1999) {
			final int b = 2000;
			return b - r;
		}
		if (r >= 2000 && r <= 2999) {
			final int b = 3000;
			return b - r;
		}
		if (r >= 3000 && r <= 4999) {
			final int b = 5000;
			return b - r;
		}
		if (r >= 5000 && r <= 5999) {
			final int b = 6000;
			return b - r;
		}
		if (r >= 6000 && r <= 6999) {
			final int b = 7000;
			return b - r;
		}
		if (r >= 7000 && r <= 10000) {
			return 0;
		}
		return 0;
	}

	public static int XpNecessarioVipLight(final Player p) {
		final int r = XpAPI.getXp(p);
		if (r <= 4999) {
			final int b = 5000;
			return b - r;
		}
		return 0;
	}

	public static int MoneyNecessarioVipLight(final Player p) {
		final int r = MoneyAPI.getMoney(p);
		if (r <= 99999) {
			final int b = 100000;
			return b - r;
		}
		return 0;
	}

	public static int XpNecessarioVipPremium(final Player p) {
		final int r = XpAPI.getXp(p);
		if (r <= 9999) {
			final int b = 10000;
			return b - r;
		}
		return 0;
	}

	public static int MoneyNecessarioVipPremium(final Player p) {
		final int r = MoneyAPI.getMoney(p);
		if (r <= 199999) {
			final int b = 200000;
			return b - r;
		}
		return 0;
	}

	public static int XpNecessarioVipUltimate(final Player p) {
		final int r = XpAPI.getXp(p);
		if (r <= 14999) {
			final int b = 15000;
			return b - r;
		}
		return 0;
	}

	public static int MoneyNecessarioVipUltimate(final Player p) {
		final int r = MoneyAPI.getMoney(p);
		if (r <= 299999) {
			final int b = 300000;
			return b - r;
		}
		return 0;
	}

	public static int MoneyNecessarioLojaPerm(final Player p) {
		final int r = MoneyAPI.getMoney(p);
		if (r <= 24999) {
			final int b = 25000;
			return b - r;
		}
		return 0;
	}

	public static int MoneyNecessarioLojaPermkd(final Player p) {
		final int r = MoneyAPI.getMoney(p);
		if (r <= 29999) {
			final int b = 30000;
			return b - r;
		}
		return 0;
	}

	public static int MoneyNecessarioGladiator(final Player p) {
		final int r = MoneyAPI.getMoney(p);
		if (r <= 3499) {
			final int b = 3500;
			return b - r;
		}
		return 0;
	}

	public static int MoneyNecessarioViking(final Player p) {
		final int r = MoneyAPI.getMoney(p);
		if (r <= 3499) {
			final int b = 3500;
			return b - r;
		}
		return 0;
	}

	public static int MoneyNecessarioMagma(final Player p) {
		final int r = MoneyAPI.getMoney(p);
		if (r <= 2499) {
			final int b = 2500;
			return b - r;
		}
		return 0;
	}

	public static int MoneyNecessarioPhantom(final Player p) {
		final int r = MoneyAPI.getMoney(p);
		if (r <= 2499) {
			final int b = 2500;
			return b - r;
		}
		return 0;
	}

	public static int MoneyNecessarioStomper(final Player p) {
		final int r = MoneyAPI.getMoney(p);
		if (r <= 4999) {
			final int b = 5000;
			return b - r;
		}
		return 0;
	}

	public static int MoneyNecessarioAntiStomper(final Player p) {
		final int r = MoneyAPI.getMoney(p);
		if (r <= 2999) {
			final int b = 3000;
			return b - r;
		}
		return 0;
	}

	@EventHandler
	public void renascer2(final PlayerRespawnEvent e) {
		final Player p = e.getPlayer();
		KitAPI.sendSpawn(e.getPlayer());
		BuildScoreAPI.forceBuild(p);
	}

	@EventHandler
	public void SairPrincipal(final PlayerQuitEvent event) {
		final Player p = event.getPlayer();
		event.setQuitMessage((String) null);
		KitAPI.RemoveKit(p);
		EventoAPI.removeEvent(p);
		StaffOnlineAPI.removeStaffOnline(p);
		Main.sc.registerScoreBoard(p);
		Score.ativada.remove(p.getName());
		TopKsAPI.TopKs.set(p.getName(), (Object) 0);
		CooldownAPI.removeCooldown(p);
	}

	@EventHandler
	public void Fome(final FoodLevelChangeEvent event) {
		event.setCancelled(true);
	}

	@EventHandler
	public void onEvent(final PlayerJoinEvent e) {
		final Player p = e.getPlayer();
		p.chat("/spawn");
	}

	@EventHandler
	public void Weather(final WeatherChangeEvent e) {
		e.setCancelled(true);
	}

	@EventHandler
	public void onSoup(final PlayerInteractEvent e) {
		final Damageable hp;
		final Player p = (Player) (hp = (Damageable) e.getPlayer());
		if (hp.getHealth() != 20.0) {
			final int sopa = 7;
			if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
					&& p.getItemInHand().getTypeId() == 282) {
				p.setHealth((hp.getHealth() + sopa > hp.getMaxHealth()) ? hp.getMaxHealth() : (hp.getHealth() + sopa));
				p.getItemInHand().setType(Material.BOWL);
				if (KitAPI.getkit(p) == "Quickdropper") {
					p.getInventory().removeItem(new ItemStack[] { p.getInventory().getItemInHand() });
				}
			}
		}
	}

	@EventHandler
	public void onDrop(final ItemSpawnEvent e) {
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable) new Runnable() {
			@Override
			public void run() {
				e.getEntity().remove();
			}
		}, 160L);
	}

	@EventHandler
	public void onSpawner(final CreatureSpawnEvent e) {
		if (e.getSpawnReason() != CreatureSpawnEvent.SpawnReason.CUSTOM) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onExplosion(final EntityExplodeEvent e) {
		e.setCancelled(true);
	}

	@EventHandler
	public void Whitelist(final PlayerLoginEvent e) {
		if (e.getResult() == PlayerLoginEvent.Result.KICK_WHITELIST) {
			e.disallow(PlayerLoginEvent.Result.KICK_OTHER,
					"§4§lMANUTEN\u00c7\u00c3O §fEstamos em §c§l§oMANUTEN\u00c7\u00c3O, §fpor isso voc\u00ea foi kickado!\n§fGarantimos que estamos §e§lTRABALHANDO §fpara um melhor §f§lSERVIDOR §fe enfim,\n§fpara sua melhor §a§lJOGABILIDADE");
		}
	}

	public static void MotdUpdate() {
		final Random random = new Random();
		switch (random.nextInt(6)) {
		case 1: {
			EventosGerais.motdrandom = String
					.valueOf(Main.getInstance().getConfig().getString("AUTOMOTD-1-LINE1").replace("&", "§")) + "\n"
					+ Main.getInstance().getConfig().getString("AUTOMOTD-1-LINE2").replace("&", "§");
			break;
		}
		case 2: {
			EventosGerais.motdrandom = String
					.valueOf(Main.getInstance().getConfig().getString("AUTOMOTD-2-LINE1").replace("&", "§")) + "\n"
					+ Main.getInstance().getConfig().getString("AUTOMOTD-2-LINE2").replace("&", "§");
			break;
		}
		case 3: {
			EventosGerais.motdrandom = String
					.valueOf(Main.getInstance().getConfig().getString("AUTOMOTD-3-LINE1").replace("&", "§")) + "\n"
					+ Main.getInstance().getConfig().getString("AUTOMOTD-3-LINE2").replace("&", "§");
			break;
		}
		}
	}

	@EventHandler
	public void MotdServidor(final ServerListPingEvent e) {
		e.setMotd(EventosGerais.motdrandom);
		if (Bukkit.hasWhitelist()) {
			e.setMotd(
					"       §a§m    §a§m    §a§m    §f §l§m[§6 §lBATTLE§f§lBITS§f §l§m]§a§m    §a§m    §a§m     \n§f§lESTAMOS EM §4§lMANUTEN\u00c7\u00c3O §f§lPARA SUA MELHOR §e§lJOGABILIDADE");
		}
	}
}
