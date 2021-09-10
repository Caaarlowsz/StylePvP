package fodastico.user.Events;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import fodastico.user.Main;
import fodastico.user.OneVsOne.Get1v1Itens;

public class Fast1v1 implements Listener {
	public static List<Player> inSecondsWaiting;
	public static boolean FirstMatch;
	public static List<Player> Started;
	public static String getName;

	static {
		Fast1v1.inSecondsWaiting = new ArrayList<Player>();
		Fast1v1.FirstMatch = false;
		Fast1v1.Started = new ArrayList<Player>();
		Fast1v1.getName = "";
	}

	public void setFastItens(final Player p) {
		if (Fast1v1.Started.contains(p)) {
			p.getInventory().setItem(5, new ItemStack(Get1v1Itens.Lookingtry1));
			p.getInventory().setItem(5, new ItemStack(Get1v1Itens.LookinTry2));
			p.getInventory().setItem(5, new ItemStack(Get1v1Itens.Lookingtry3));
			p.updateInventory();
		}
	}

	@EventHandler
	public void onInteract2(final PlayerInteractEvent event) {
		final Player p = event.getPlayer();
		if (!p.getItemInHand().equals((Object) Get1v1Itens.Lookingtry1)
				&& !p.getItemInHand().equals((Object) Get1v1Itens.LookinTry2)
				&& !p.getItemInHand().equals((Object) Get1v1Itens.Lookingtry3)) {
			return;
		}
		if (event.getAction() == Action.RIGHT_CLICK_BLOCK
				|| (event.getAction() == Action.RIGHT_CLICK_AIR && Fast1v1.inSecondsWaiting.contains(p))) {
			p.sendMessage("§a§lFAST1V1 §fVoc\u00ea j\u00e1 est\u00e1 na fila para §b§l1v1 §fr\u00e1pido.");
		}
	}

	@EventHandler
	public void onInteract(final PlayerInteractEvent event) {
		final Player p = event.getPlayer();
		if (p.getItemInHand().equals((Object) Get1v1Itens.SackFast)
				&& (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR)) {
			if (Fast1v1.FirstMatch) {
				p.performCommand("speed1v1 " + Fast1v1.getName);
				Fast1v1.FirstMatch = false;
				Fast1v1.getName = "";
				return;
			}
			if (!Fast1v1.FirstMatch) {
				Fast1v1.getName = p.getName();
				Fast1v1.FirstMatch = true;
				p.getInventory().removeItem(new ItemStack[] { Get1v1Itens.SackFast });
				p.sendMessage("§a§lFAST1V1 §fVoc\u00ea §a§lENTROU §fna fila para §b§l1v1 §fr\u00e1pido.");
				Fast1v1.Started.add(p);
				this.setFastItens(p);
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable) new Runnable() {
					@Override
					public void run() {
						Fast1v1.inSecondsWaiting.add(p);
					}
				}, 1L);
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable) new Runnable() {
					@Override
					public void run() {
						if (Fast1v1.inSecondsWaiting.contains(p)) {
							Fast1v1.inSecondsWaiting.remove(p);
							Fast1v1.FirstMatch = true;
							Fast1v1.getName = "";
							Fast1v1.Started.remove(p);
							p.getInventory().removeItem(new ItemStack[] { Get1v1Itens.Lookingtry1 });
							p.getInventory().removeItem(new ItemStack[] { Get1v1Itens.LookinTry2 });
							p.getInventory().removeItem(new ItemStack[] { Get1v1Itens.Lookingtry3 });
							if (!EventsOneVsOne.inBattle.contains(p)) {
								p.updateInventory();
								p.sendMessage("§a§lFAST1V1 §fNenhuma partida r\u00e1pida foi localizada.");
								p.getInventory().setItem(5, Get1v1Itens.SackFast);
							}
						}
					}
				}, 100L);
			}
		}
	}
}
