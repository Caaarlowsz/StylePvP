package fodastico.user.OneVsOne;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fodastico.user.Apis.KitAPI;
import fodastico.user.Events.EventsOneVsOne;
import fodastico.user.Events.Fast1v1;
import fodastico.user.Warp.WarpsManager;

public class SpeedCMD implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (Fast1v1.FirstMatch && cmd.getName().equalsIgnoreCase("speed1v1")) {
			if (args.length == 0) {
				return true;
			}
			if (args.length == 1) {
				final Player Player2 = Bukkit.getPlayerExact(args[0]);
				if (Player2 instanceof Player) {
					EventsOneVsOne.isPlaying.add(p);
					EventsOneVsOne.isPlaying.add(Player2);
					EventsOneVsOne.LogOutOnevsOne.put(p.getName(), Player2.getName());
					EventsOneVsOne.LogOutOnevsOne.put(Player2.getName(), p.getName());
					Fast1v1.Started.remove(Player2);
					Fast1v1.inSecondsWaiting.remove(Player2);
					WarpsManager.Ir(Player2, "1v1loc2");
					WarpsManager.Ir(p, "1v1loc1");
					EventsOneVsOne.isInOnevsOne.add(p.getName());
					EventsOneVsOne.isInOnevsOne.add(Player2.getName());
					EventsOneVsOne.Waiting.remove(Player2);
					EventsOneVsOne.DuelAccept.remove(Player2);
					EventsOneVsOne.Waiting.remove(p);
					EventsOneVsOne.DuelAccept.remove(p);
					p.getInventory().clear();
					Player2.getInventory().clear();
					EventsOneVsOne.inBattle.add(p);
					EventsOneVsOne.inBattle.add(Player2);
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
					KitAPI.setKit(Player2, "1v1");
					KitAPI.setKit(p, "1v1");
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
						Player[] onlinePlayers;
						for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, j = 0; j < length; ++j) {
							final Player plr = onlinePlayers[j];
							Player2.hidePlayer(plr);
							p.hidePlayer(plr);
							p.showPlayer(Player2);
							Player2.showPlayer(p);
						}
					}
				}
			}
		}
		return false;
	}
}
