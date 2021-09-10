package fodastico.user.Events;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;

import fodastico.user.Main;
import fodastico.user.Apis.ImortalAPI;
import fodastico.user.Apis.KitAPI;
import fodastico.user.Apis.MoneyAPI;
import fodastico.user.Apis.TopKsAPI;
import fodastico.user.DoubleXp.XpbyXpAPI;
import fodastico.user.OneVsOne.Get1v1Itens;
import fodastico.user.Warp.WarpsManager;

public class EventsOneVsOne implements Listener {
	public static HashMap<Player, String> oponentename;
	public static HashMap<Player, String> oponentename2;
	public static List<Player> Waiting;
	public static ArrayList<String> isInOnevsOne;
	public static List<Player> DuelAccept;
	public static List<Player> isPlaying;
	public static List<Player> inBattle;
	public static HashMap<String, String> LogOutOnevsOne;

	static {
		EventsOneVsOne.oponentename = new HashMap<Player, String>();
		EventsOneVsOne.oponentename2 = new HashMap<Player, String>();
		EventsOneVsOne.Waiting = new ArrayList<Player>();
		EventsOneVsOne.isInOnevsOne = new ArrayList<String>();
		EventsOneVsOne.DuelAccept = new ArrayList<Player>();
		EventsOneVsOne.isPlaying = new ArrayList<Player>();
		EventsOneVsOne.inBattle = new ArrayList<Player>();
		EventsOneVsOne.LogOutOnevsOne = new HashMap<String, String>();
	}

	@EventHandler
	public void PlayerInteractEntityEvent4(final PlayerInteractEntityEvent event) {
		final Player p = event.getPlayer();
		if (!(event.getRightClicked() instanceof Player)) {
			return;
		}
		if (Fast1v1.inSecondsWaiting.contains(p)) {
			if (p.getItemInHand().equals((Object) Get1v1Itens.Blaze)) {
				p.sendMessage(
						"§b§l1v1 §fVoc\u00ea n\u00e3o pode §c§lDESAFIAR §fum jogador, enquanto estiver na fila para §b§l1v1 §fr\u00e1pido.");
			}
		} else if (p.getItemInHand().equals((Object) Get1v1Itens.Blaze)) {
			if (EventsOneVsOne.Waiting.contains(p)) {
				p.sendMessage("§b§l1v1 §fAguarde para §c§lDESAFIAR §7outro jogador.");
				return;
			}
			final Player Player2 = (Player) event.getRightClicked();
			EventsOneVsOne.DuelAccept.add(Player2);
			EventsOneVsOne.Waiting.add(p);
			p.sendMessage("§b§l1v1 §fVoc\u00ea §c§lDESAFIOU §fo jogador §a§l" + Player2.getName() + " §fpara §b§l1v1");
			Player2.sendMessage(
					"§b§l1v1 §fVoc\u00ea foi §c§lDESAFIADO §fpelo jogador §a§l" + p.getName() + " §fpara §b§l1v1");
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					if (EventsOneVsOne.Waiting.contains(p)) {
						EventsOneVsOne.Waiting.remove(p);
						EventsOneVsOne.DuelAccept.remove(Player2);
					}
				}
			}, 120L);
		}
	}

	@EventHandler
	public void PlayerInteractEntityEvent3(final PlayerInteractEntityEvent event) {
		final Player p = event.getPlayer();
		if (!(event.getRightClicked() instanceof Player)) {
			return;
		}
		if (EventsOneVsOne.DuelAccept.contains(p) && p.getItemInHand().equals((Object) Get1v1Itens.Blaze)) {
			final Player Player2 = (Player) event.getRightClicked();
			if (EventsOneVsOne.Waiting.contains(Player2)) {
				EventsOneVsOne.isPlaying.add(p);
				EventsOneVsOne.isPlaying.add(Player2);
				EventsOneVsOne.LogOutOnevsOne.put(p.getName(), Player2.getName());
				EventsOneVsOne.LogOutOnevsOne.put(Player2.getName(), p.getName());
				KitAPI.setKit(Player2, "1v1");
				KitAPI.setKit(p, "1v1");
				WarpsManager.Ir(Player2, "1v1loc2");
				WarpsManager.Ir(p, "1v1loc1");
				EventsOneVsOne.Waiting.remove(Player2);
				EventsOneVsOne.DuelAccept.remove(Player2);
				EventsOneVsOne.Waiting.remove(p);
				EventsOneVsOne.DuelAccept.remove(p);
				EventsOneVsOne.inBattle.add(p);
				EventsOneVsOne.inBattle.add(Player2);
				EventsOneVsOne.oponentename.put(p, Player2.getName());
				EventsOneVsOne.oponentename2.put(Player2, p.getName());
				p.getInventory().clear();
				Player2.getInventory().clear();
				final ItemStack Espada = new ItemStack(Material.DIAMOND_SWORD);
				Espada.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
				final ItemMeta Espada2 = Espada.getItemMeta();
				Espada2.setDisplayName("§eEspada");
				Espada.setItemMeta(Espada2);
				p.getInventory().addItem(new ItemStack[] { Espada });
				Player2.getInventory().addItem(new ItemStack[] { Espada });
				Player2.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
				Player2.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
				Player2.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
				Player2.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
				p.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
				p.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
				p.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
				p.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
				p.sendMessage("§b§l1v1 §fO jogador §a§l" + Player2.getName() + " §2§lACEITOU §fo seu §c§lDESAFIO");
				Player2.sendMessage("§b§l1v1 §fVoc\u00ea §2§lACEITOU §fo §c§lDESAFIO §fdo joador §a§l" + p.getName());
				ImortalAPI.removeInvensibility(p);
				ImortalAPI.removeInvensibility(Player2);
				for (int i = 1; i < 9; ++i) {
					final ItemStack Fisherman = new ItemStack(Material.MUSHROOM_SOUP);
					p.getInventory().addItem(new ItemStack[] { Fisherman });
					Player2.getInventory().addItem(new ItemStack[] { Fisherman });
					Player2.updateInventory();
					p.updateInventory();
					if (Fast1v1.Started.contains(p)) {
						Fast1v1.Started.remove(p);
						Fast1v1.FirstMatch = false;
					}
					if (Fast1v1.Started.contains(Player2)) {
						Fast1v1.Started.remove(Player2);
						Fast1v1.FirstMatch = false;
					}
					Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
						@Override
						public void run() {
							Player[] onlinePlayers;
							for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length,
									i = 0; i < length; ++i) {
								final Player plr = onlinePlayers[i];
								Player2.hidePlayer(plr);
								p.hidePlayer(plr);
								plr.hidePlayer(Player2);
								plr.hidePlayer(p);
								p.showPlayer(Player2);
								Player2.showPlayer(p);
								p.showPlayer(Player2);
								Player2.showPlayer(p);
							}
						}
					}, 2L);
					Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable) new Runnable() {
						@Override
						public void run() {
							p.setMaxHealth(20);
							p.setHealth(20);
							Player2.setMaxHealth(20);
							Player2.setHealth(20);
						}
					}, 20L);
				}
			}
		}
	}

	public static String coraexato(final Player p) {
		final Damageable vida = (Damageable) p;
		final int cora = (int) vida.getHealth();
		if (cora == 20.0) {
			return "10,0";
		}
		if (cora == 19.9) {
			return "9,9";
		}
		if (cora == 19.8) {
			return "9,9";
		}
		if (cora == 19.7) {
			return "9,8";
		}
		if (cora == 19.6) {
			return "9,8";
		}
		if (cora == 19.5) {
			return "9,7";
		}
		if (cora == 19.4) {
			return "9,7";
		}
		if (cora == 19.3) {
			return "9,6";
		}
		if (cora == 19.2) {
			return "9,6";
		}
		if (cora == 19.1) {
			return "9,5";
		}
		if (cora == 19.0) {
			return "9,5";
		}
		if (cora == 18.9) {
			return "9,4";
		}
		if (cora == 18.8) {
			return "9,4";
		}
		if (cora == 18.7) {
			return "9,3";
		}
		if (cora == 18.6) {
			return "9,3";
		}
		if (cora == 18.5) {
			return "9,2 ";
		}
		if (cora == 18.4) {
			return "9,2";
		}
		if (cora == 18.3) {
			return "9,1";
		}
		if (cora == 18.2) {
			return "9,1";
		}
		if (cora == 18.1) {
			return "9,0";
		}
		if (cora == 18.0) {
			return "9,0";
		}
		if (cora == 17.9) {
			return "8,9";
		}
		if (cora == 17.8) {
			return "8,9";
		}
		if (cora == 17.7) {
			return "8,8";
		}
		if (cora == 17.6) {
			return "8,8";
		}
		if (cora == 17.5) {
			return "8,7";
		}
		if (cora == 17.4) {
			return "8,7";
		}
		if (cora == 17.3) {
			return "8,6";
		}
		if (cora == 17.2) {
			return "8,6";
		}
		if (cora == 17.1) {
			return "8,5";
		}
		if (cora == 17.0) {
			return "8,5";
		}
		if (cora == 16.9) {
			return "8,4";
		}
		if (cora == 16.8) {
			return "8,4";
		}
		if (cora == 16.7) {
			return "8,3";
		}
		if (cora == 16.6) {
			return "8,3";
		}
		if (cora == 16.5) {
			return "8,2";
		}
		if (cora == 16.4) {
			return "8,2";
		}
		if (cora == 16.3) {
			return "8,1";
		}
		if (cora == 16.2) {
			return "8,1";
		}
		if (cora == 16.1) {
			return "8,0";
		}
		if (cora == 16.0) {
			return "8,0";
		}
		if (cora == 15.9) {
			return "7,9";
		}
		if (cora == 15.8) {
			return "7,9";
		}
		if (cora == 15.7) {
			return "7,8";
		}
		if (cora == 15.6) {
			return "7,8";
		}
		if (cora == 15.5) {
			return "7,7";
		}
		if (cora == 15.4) {
			return "7,7";
		}
		if (cora == 15.3) {
			return "7,6";
		}
		if (cora == 15.2) {
			return "7,6";
		}
		if (cora == 15.1) {
			return "7,5";
		}
		if (cora == 15.0) {
			return "7,5";
		}
		if (cora == 14.9) {
			return "7,4";
		}
		if (cora == 14.8) {
			return "7,4";
		}
		if (cora == 14.7) {
			return "7,3";
		}
		if (cora == 14.6) {
			return "7,3";
		}
		if (cora == 14.5) {
			return "7,2";
		}
		if (cora == 14.4) {
			return "7,2";
		}
		if (cora == 14.3) {
			return "7,1";
		}
		if (cora == 14.2) {
			return "7,1";
		}
		if (cora == 14.1) {
			return "7,0";
		}
		if (cora == 14.0) {
			return "7,0";
		}
		if (cora == 13.9) {
			return "6,9";
		}
		if (cora == 13.8) {
			return "6,9";
		}
		if (cora == 13.7) {
			return "6,8";
		}
		if (cora == 13.6) {
			return "6,8";
		}
		if (cora == 13.5) {
			return "6,7";
		}
		if (cora == 13.4) {
			return "6,7";
		}
		if (cora == 13.3) {
			return "6,6";
		}
		if (cora == 13.2) {
			return "6,6";
		}
		if (cora == 13.1) {
			return "6,5";
		}
		if (cora == 13.0) {
			return "6,5";
		}
		if (cora == 12.9) {
			return "6,4";
		}
		if (cora == 12.8) {
			return "6,4";
		}
		if (cora == 12.7) {
			return "6,3";
		}
		if (cora == 12.6) {
			return "6,3";
		}
		if (cora == 12.5) {
			return "6,2";
		}
		if (cora == 12.4) {
			return "6,2";
		}
		if (cora == 12.3) {
			return "6,1";
		}
		if (cora == 12.2) {
			return "6,1";
		}
		if (cora == 12.1) {
			return "6,0";
		}
		if (cora == 12.0) {
			return "6,0";
		}
		if (cora == 11.9) {
			return "5,9";
		}
		if (cora == 11.8) {
			return "5,9";
		}
		if (cora == 11.7) {
			return "5,8";
		}
		if (cora == 11.6) {
			return "5,8";
		}
		if (cora == 11.5) {
			return "5,7";
		}
		if (cora == 11.4) {
			return "5,7";
		}
		if (cora == 11.3) {
			return "5,6";
		}
		if (cora == 11.2) {
			return "5,6";
		}
		if (cora == 11.1) {
			return "5,5";
		}
		if (cora == 11.0) {
			return "5,5";
		}
		if (cora == 10.9) {
			return "5,4";
		}
		if (cora == 10.8) {
			return "5,4";
		}
		if (cora == 10.7) {
			return "5,3";
		}
		if (cora == 10.6) {
			return "5,3";
		}
		if (cora == 10.5) {
			return "5,2";
		}
		if (cora == 10.4) {
			return "5,2";
		}
		if (cora == 10.3) {
			return "5,1";
		}
		if (cora == 10.2) {
			return "5,1";
		}
		if (cora == 10.1) {
			return "5,0";
		}
		if (cora == 10.0) {
			return "5,0";
		}
		if (cora == 9.9) {
			return "4,9";
		}
		if (cora == 9.8) {
			return "4,9";
		}
		if (cora == 9.7) {
			return "4,8";
		}
		if (cora == 9.6) {
			return "4,8";
		}
		if (cora == 9.5) {
			return "4,7";
		}
		if (cora == 9.4) {
			return "4,7";
		}
		if (cora == 9.3) {
			return "4,6";
		}
		if (cora == 9.2) {
			return "4,6";
		}
		if (cora == 9.1) {
			return "4,5";
		}
		if (cora == 9.0) {
			return "4,5";
		}
		if (cora == 8.9) {
			return "4,4";
		}
		if (cora == 8.8) {
			return "4,4";
		}
		if (cora == 8.7) {
			return "4,3";
		}
		if (cora == 8.6) {
			return "4,3";
		}
		if (cora == 8.5) {
			return "4,2";
		}
		if (cora == 8.4) {
			return "4,2";
		}
		if (cora == 8.3) {
			return "4,1";
		}
		if (cora == 8.2) {
			return "4,1";
		}
		if (cora == 8.1) {
			return "4,0";
		}
		if (cora == 8.0) {
			return "4,0";
		}
		if (cora == 7.9) {
			return "3,9";
		}
		if (cora == 7.8) {
			return "3,9";
		}
		if (cora == 7.7) {
			return "3,8";
		}
		if (cora == 7.6) {
			return "3,8";
		}
		if (cora == 7.5) {
			return "3,7";
		}
		if (cora == 7.4) {
			return "3,7";
		}
		if (cora == 7.3) {
			return "3,6";
		}
		if (cora == 7.2) {
			return "3,6";
		}
		if (cora == 7.1) {
			return "3,5";
		}
		if (cora == 7.0) {
			return "3,5";
		}
		if (cora == 6.9) {
			return "3,4";
		}
		if (cora == 6.8) {
			return "3,4";
		}
		if (cora == 6.7) {
			return "3,3";
		}
		if (cora == 6.6) {
			return "3,3";
		}
		if (cora == 6.5) {
			return "3,2";
		}
		if (cora == 6.4) {
			return "3,2";
		}
		if (cora == 6.3) {
			return "3,1";
		}
		if (cora == 6.2) {
			return "3,1";
		}
		if (cora == 6.1) {
			return "3,0";
		}
		if (cora == 6.0) {
			return "3,0";
		}
		if (cora == 5.9) {
			return "2,9";
		}
		if (cora == 5.8) {
			return "2,9";
		}
		if (cora == 5.7) {
			return "2,8";
		}
		if (cora == 5.6) {
			return "2,8";
		}
		if (cora == 5.5) {
			return "2,7";
		}
		if (cora == 5.4) {
			return "2,7";
		}
		if (cora == 5.3) {
			return "2,6";
		}
		if (cora == 5.2) {
			return "2,6";
		}
		if (cora == 5.1) {
			return "2,5";
		}
		if (cora == 5.0) {
			return "2,5";
		}
		if (cora == 4.9) {
			return "2,4";
		}
		if (cora == 4.8) {
			return "2,4";
		}
		if (cora == 4.7) {
			return "2,3";
		}
		if (cora == 4.6) {
			return "2,3";
		}
		if (cora == 4.5) {
			return "2,2";
		}
		if (cora == 4.4) {
			return "2,2";
		}
		if (cora == 4.3) {
			return "2,1";
		}
		if (cora == 4.2) {
			return "2,1";
		}
		if (cora == 4.1) {
			return "2,0";
		}
		if (cora == 4.0) {
			return "2,0";
		}
		if (cora == 3.9) {
			return "1,9";
		}
		if (cora == 3.8) {
			return "1,9";
		}
		if (cora == 3.7) {
			return "1,8";
		}
		if (cora == 3.6) {
			return "1,8";
		}
		if (cora == 3.5) {
			return "1,7";
		}
		if (cora == 3.4) {
			return "1,7";
		}
		if (cora == 3.3) {
			return "1,6";
		}
		if (cora == 3.2) {
			return "1,6";
		}
		if (cora == 3.1) {
			return "1,5";
		}
		if (cora == 3.0) {
			return "1,5";
		}
		if (cora == 2.9) {
			return "1,4";
		}
		if (cora == 2.8) {
			return "1,4";
		}
		if (cora == 2.7) {
			return "1,3";
		}
		if (cora == 2.6) {
			return "1,3";
		}
		if (cora == 2.5) {
			return "1,2";
		}
		if (cora == 2.4) {
			return "1,2";
		}
		if (cora == 2.3) {
			return "1,1";
		}
		if (cora == 2.2) {
			return "1,1";
		}
		if (cora == 2.1) {
			return "1,0";
		}
		if (cora == 2.0) {
			return "1,0";
		}
		if (cora == 1.9) {
			return "0,9";
		}
		if (cora == 1.8) {
			return "0,9";
		}
		if (cora == 1.7) {
			return "0,8";
		}
		if (cora == 1.6) {
			return "0,8";
		}
		if (cora == 1.5) {
			return "0,7";
		}
		if (cora == 1.4) {
			return "0,7";
		}
		if (cora == 1.3) {
			return "0,6";
		}
		if (cora == 1.2) {
			return "0,6";
		}
		if (cora == 1.1) {
			return "0,5";
		}
		if (cora == 1.0) {
			return "0,5";
		}
		if (cora == 0.9) {
			return "0,4";
		}
		if (cora == 0.8) {
			return "0,4";
		}
		if (cora == 0.7) {
			return "0,3";
		}
		if (cora == 0.6) {
			return "0,3";
		}
		if (cora == 0.5) {
			return "0,2";
		}
		if (cora == 0.4) {
			return "0,2";
		}
		if (cora == 0.3) {
			return "0,1";
		}
		if (cora == 0.2) {
			return "0,1";
		}
		if (cora == 0.1) {
			return "0,0";
		}
		if (cora == 0.0) {
			return "0,0";
		}
		return coraexato(p);
	}

	@EventHandler
	public void Morrer2(final PlayerDeathEvent e) {
		final Player v = e.getEntity();
		e.setDeathMessage((String) null);
		if (e.getEntity().getKiller() instanceof Player) {
			final Player m = e.getEntity().getKiller();
			if (m != v) {
				if (!EventsOneVsOne.isPlaying.contains(m) && !EventsOneVsOne.isPlaying.contains(v)) {
					EventsOneVsOne.isPlaying.remove(v);
					EventsOneVsOne.isPlaying.remove(m);
					v.setLevel(0);
					return;
				}
				final int amountm = this.itemsInInventory((Inventory) m.getInventory(),
						new Material[] { Material.MUSHROOM_SOUP });
				ImortalAPI.setInvensibility(m);
				ImortalAPI.setInvensibility(v);
				m.sendMessage("     ");
				m.sendMessage("§a§lVITORIA §fVoc\u00ea §2§lVENCEU §fa batalha contra o §a" + v.getName() + " §fcom "
						+ amountm + " §fsopas e " + coraexato(m) + " §fcora\u00e7\u00f5es.");
				EventsOneVsOne.inBattle.remove(m);
				EventsOneVsOne.inBattle.remove(v);
				KitAPI.setKit(v, "1v1");
				KitAPI.setKit(m, "1v1");
				v.sendMessage("     ");
				v.sendMessage("§c§lDERROTA §fVoc\u00ea §c§lPERDEU §fa batalha contra §c" + m.getName()
						+ " §fque ficou com " + amountm + " §fsopas e " + coraexato(m) + " §fcora\u00e7\u00f5es.");
				EventsOneVsOne.oponentename.remove(v);
				EventsOneVsOne.oponentename2.remove(v);
				EventsOneVsOne.oponentename.remove(m);
				EventsOneVsOne.oponentename2.remove(m);
				Player[] onlinePlayers;
				for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
					final Player plr = onlinePlayers[i];
					v.showPlayer(plr);
					m.showPlayer(plr);
				}
				WarpsManager.Ir(m, "1v1");
				m.setGameMode(GameMode.SURVIVAL);
				m.getInventory().setArmorContents((ItemStack[]) null);
				m.getInventory().clear();
				for (final PotionEffect effect : m.getActivePotionEffects()) {
					m.removePotionEffect(effect.getType());
				}
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
					@Override
					public void run() {
						WarpsManager.Ir(v, "1v1");
						v.setGameMode(GameMode.SURVIVAL);
						v.getInventory().setArmorContents((ItemStack[]) null);
						v.getInventory().clear();
						for (final PotionEffect effect : v.getActivePotionEffects()) {
							v.removePotionEffect(effect.getType());
						}
					}
				}, 1L);
				KitAPI.setKit(m, "1v1");
				KitAPI.setKit(v, "1v1");
				EventsOneVsOne.isPlaying.remove(v);
				EventsOneVsOne.isPlaying.remove(m);
				EventsOneVsOne.LogOutOnevsOne.remove(m.getName());
				EventsOneVsOne.LogOutOnevsOne.remove(v.getName());
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
					@Override
					public void run() {
						v.getInventory().setItem(3, Get1v1Itens.Blaze);
						v.getInventory().setItem(5, Get1v1Itens.SackFast);
						m.getInventory().setItem(3, Get1v1Itens.Blaze);
						m.getInventory().setItem(5, Get1v1Itens.SackFast);
						m.updateInventory();
						v.updateInventory();
						WarpsManager.Ir(v, "1v1");
						KitAPI.setKit(m, "1v1");
						KitAPI.setKit(v, "1v1");
					}
				}, 2L);
				m.setHealth(20);
				v.setHealth(20);
			}
		}
	}

	@EventHandler
	public void Morrer3(final PlayerDeathEvent e) {
		final Player v = e.getEntity();
		if (e.getEntity().getKiller() instanceof Player) {
			final Player m = e.getEntity().getKiller();
			if (m != v) {
				if (!EventsOneVsOne.isPlaying.contains(v) && !EventsOneVsOne.isPlaying.contains(m)) {
					EventsOneVsOne.isPlaying.remove(v);
					EventsOneVsOne.isPlaying.remove(m);
					v.setLevel(0);
					return;
				}
				final int amountm = this.itemsInInventory((Inventory) m.getInventory(),
						new Material[] { Material.MUSHROOM_SOUP });
				ImortalAPI.setInvensibility(m);
				ImortalAPI.setInvensibility(v);
				m.sendMessage("     ");
				m.sendMessage("§a§lVITORIA §fVoc\u00ea §2§lVENCEU §fa batalha contra o §a" + v.getName() + " §fcom "
						+ amountm + " §fsopas e " + coraexato(m) + " §fcora\u00e7\u00f5es.");
				EventsOneVsOne.inBattle.remove(m);
				EventsOneVsOne.inBattle.remove(v);
				KitAPI.setKit(v, "1v1");
				KitAPI.setKit(m, "1v1");
				v.sendMessage("     ");
				v.sendMessage("§c§lDERROTA §fVoc\u00ea §c§lPERDEU §fa batalha contra §c" + m.getName()
						+ " §fque ficou com " + amountm + " §fsopas e " + coraexato(m) + " §fcora\u00e7\u00f5es.");
				EventsOneVsOne.oponentename.remove(v);
				EventsOneVsOne.oponentename2.remove(v);
				EventsOneVsOne.oponentename.remove(m);
				EventsOneVsOne.oponentename2.remove(m);
				Player[] onlinePlayers;
				for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
					final Player plr = onlinePlayers[i];
					v.showPlayer(plr);
					m.showPlayer(plr);
				}
				WarpsManager.Ir(m, "1v1");
				m.setGameMode(GameMode.SURVIVAL);
				m.getInventory().setArmorContents((ItemStack[]) null);
				m.getInventory().clear();
				v.setLevel(0);
				for (final PotionEffect effect : m.getActivePotionEffects()) {
					m.removePotionEffect(effect.getType());
				}
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
					@Override
					public void run() {
						WarpsManager.Ir(v, "1v1");
						v.setGameMode(GameMode.SURVIVAL);
						v.getInventory().setArmorContents((ItemStack[]) null);
						v.getInventory().clear();
						for (final PotionEffect effect : v.getActivePotionEffects()) {
							v.removePotionEffect(effect.getType());
						}
					}
				}, 1L);
				EventsOneVsOne.isPlaying.remove(v);
				EventsOneVsOne.isPlaying.remove(m);
				EventsOneVsOne.LogOutOnevsOne.remove(m.getName());
				EventsOneVsOne.LogOutOnevsOne.remove(v.getName());
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
					@Override
					public void run() {
						v.getInventory().setItem(3, Get1v1Itens.Blaze);
						v.getInventory().setItem(5, Get1v1Itens.SackFast);
						m.getInventory().setItem(3, Get1v1Itens.Blaze);
						m.getInventory().setItem(5, Get1v1Itens.SackFast);
						m.updateInventory();
						v.updateInventory();
						WarpsManager.Ir(v, "1v1");
						KitAPI.setKit(m, "1v1");
						KitAPI.setKit(v, "1v1");
					}
				}, 2L);
				m.setHealth(20);
				v.setHealth(20);
			}
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerLeft(final PlayerQuitEvent e) {
		final Player p = e.getPlayer();
		if (EventsOneVsOne.LogOutOnevsOne.containsKey(p.getName())) {
			final Player t = Bukkit.getServer().getPlayer((String) EventsOneVsOne.LogOutOnevsOne.get(p.getName()));
			WarpsManager.Ir(t, "1v1");
			EventsOneVsOne.LogOutOnevsOne.remove(t.getName());
			EventsOneVsOne.LogOutOnevsOne.remove(p.getName());
			EventsOneVsOne.isPlaying.remove(p);
			EventsOneVsOne.isPlaying.remove(t);
			EventsOneVsOne.inBattle.remove(p);
			EventsOneVsOne.inBattle.remove(t);
			t.setMaxHealth(20.0);
			t.setHealth(20.0);
			KitAPI.setKit(t, "1v1");
			t.setGameMode(GameMode.SURVIVAL);
			t.getInventory().setArmorContents((ItemStack[]) null);
			t.getInventory().clear();
			for (final PotionEffect effect : t.getActivePotionEffects()) {
				t.removePotionEffect(effect.getType());
			}
			ImortalAPI.setInvensibility(t);
			t.sendMessage(
					"§a§lVIT\u00d3RIA §f" + p.getName() + " §c§lDESLOGOU §fportando voc\u00ea §a§lVENCEU §fa batalha.");
			t.sendMessage("§6§lMOEDAS §fVoc\u00ea §a§lRECEBEU §6§l50 MOEDAS");
			XpbyXpAPI.xpbyxp(p, t);
			MoneyAPI.addMoney(t, 50);
			TopKsAPI.TopKs.set(p.getName(), (Object) 0);
			EventsOneVsOne.oponentename.remove(p);
			EventsOneVsOne.oponentename2.remove(p);
			EventsOneVsOne.oponentename.remove(t);
			EventsOneVsOne.oponentename2.remove(t);
			t.getInventory().setItem(3, Get1v1Itens.Blaze);
			t.getInventory().setItem(5, Get1v1Itens.SackFast);
			t.updateInventory();
			Player[] onlinePlayers;
			for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
				final Player plr = onlinePlayers[i];
				t.showPlayer(plr);
				p.showPlayer(plr);
			}
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerLeft2(final PlayerQuitEvent e) {
		final Player p = e.getPlayer();
		if (EventsOneVsOne.LogOutOnevsOne.containsKey(p.getName())) {
			final Player t = Bukkit.getServer().getPlayer((String) EventsOneVsOne.LogOutOnevsOne.get(p.getName()));
			WarpsManager.Ir(t, "1v1");
			EventsOneVsOne.LogOutOnevsOne.remove(t.getName());
			EventsOneVsOne.LogOutOnevsOne.remove(p.getName());
			EventsOneVsOne.isPlaying.remove(p);
			EventsOneVsOne.isPlaying.remove(t);
			EventsOneVsOne.inBattle.remove(p);
			EventsOneVsOne.inBattle.remove(t);
			t.setMaxHealth(20.0);
			t.setHealth(20.0);
			KitAPI.setKit(t, "1v1");
			t.setGameMode(GameMode.SURVIVAL);
			t.getInventory().setArmorContents((ItemStack[]) null);
			t.getInventory().clear();
			for (final PotionEffect effect : t.getActivePotionEffects()) {
				t.removePotionEffect(effect.getType());
			}
			ImortalAPI.setInvensibility(t);
			t.sendMessage("§a§lVIT\u00d3RIA §f" + p.getName()
					+ " §c§l§oDESLOGOU §fportando voc\u00ea §2§lVENCEU §fa batalha.");
			t.sendMessage("§6§lMOEDAS §fVoc\u00ea §a§lRECEBEU §6§l50 MOEDAS");
			XpbyXpAPI.xpbyxp(p, t);
			MoneyAPI.addMoney(t, 50);
			TopKsAPI.TopKs.set(p.getName(), (Object) 0);
			EventsOneVsOne.oponentename.remove(p);
			EventsOneVsOne.oponentename2.remove(p);
			EventsOneVsOne.oponentename.remove(t);
			EventsOneVsOne.oponentename2.remove(t);
			t.getInventory().setItem(3, Get1v1Itens.Blaze);
			t.getInventory().setItem(5, Get1v1Itens.SackFast);
			t.updateInventory();
			Player[] onlinePlayers;
			for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
				final Player plr = onlinePlayers[i];
				t.showPlayer(plr);
				p.showPlayer(plr);
			}
		}
	}

	@EventHandler
	public void cmda(final PlayerCommandPreprocessEvent event) {
		final Player p = event.getPlayer();
		if (EventsOneVsOne.isPlaying.contains(p)) {
			event.getPlayer().sendMessage(
					"§b§l1v1 §fVoc\u00ea n\u00e3o pode executar §3§lCOMANDOS §fenquanto estiver §c§lLUTANDO");
			event.setCancelled(true);
		}
	}

	public int itemsInInventory(final Inventory inventory, final Material[] search) {
		final List<Material> wanted = Arrays.asList(search);
		int found = 0;
		ItemStack[] arrayOfItemStack;
		for (int j = (arrayOfItemStack = inventory.getContents()).length, i = 0; i < j; ++i) {
			final ItemStack item = arrayOfItemStack[i];
			if (item != null && wanted.contains(item.getType())) {
				found += item.getAmount();
			}
		}
		return found;
	}

	@EventHandler
	public void PlayerInteractEntityEvent2(final PlayerJoinEvent e) {
		final Player p = e.getPlayer();
		Player[] onlinePlayers;
		for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
			final Player pl = onlinePlayers[i];
			if (EventsOneVsOne.isPlaying.contains(pl)) {
				pl.hidePlayer(p);
			}
		}
	}
}
