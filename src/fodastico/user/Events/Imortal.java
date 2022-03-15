package fodastico.user.Events;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;

import com.github.caaarlowsz.stylemc.kitpvp.StylePvP;
import fodastico.user.Apis.KitAPI;
import fodastico.user.Managers.CooldownAPI;

public class Imortal implements Listener {
	public static ArrayList<Player> regen;
	public static ArrayList<Player> removercooldown;
	public static HashMap<String, String> cooldown;

	static {
		Imortal.regen = new ArrayList<Player>();
		Imortal.removercooldown = new ArrayList<Player>();
		Imortal.cooldown = new HashMap<String, String>();
	}

	public static void Regenerar(final Player p) {
		final Damageable jogador = (Damageable) p;
		if (Imortal.regen.contains(p) && jogador.getHealth() < 20.0) {
			jogador.setHealth(20.0);
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void AtivarImortal(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (KitAPI.getkit(p).equalsIgnoreCase("Imortal")
				&& (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& p.getItemInHand().getType() == Material.BEDROCK) {
			if (Imortal.regen.contains(p)) {
				p.sendMessage("�3�lIMORTAL �fSua �9�lIMORTALIDADE �fj\u00e1 est\u00e1 ativada.");
				return;
			}
			if (KitAPI.getkit(p).equalsIgnoreCase("Imortal")
					&& (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
					&& p.getItemInHand().getType() == Material.BEDROCK) {
				if (CooldownAPI.pCooldown.containsKey(p.getName())) {
					p.sendMessage("�3�lIMORTAL �fVoc\u00ea est\u00e1 em �c�lCOOLDOWN �fde �c�l"
							+ CooldownAPI.getCooldown(p) + "s");
					return;
				}
				Imortal.regen.add(p);
				p.sendMessage("�3�lIMORTAL �fVoc\u00ea ativou sua �9�lIMORTALIDADE");
				Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) StylePvP.getInstance(), (Runnable) new Runnable() {
					@Override
					public void run() {
						Imortal.regen.remove(p);
						p.sendMessage("�3�lIMORTAL �fSua �9�lIMORTALIDADE �facabou.");
						CooldownAPI.addCooldown(p, 60);
					}
				}, 600L);
			}
		}
	}
}
