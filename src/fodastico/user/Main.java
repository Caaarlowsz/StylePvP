package fodastico.user;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import fodastico.user.Apis.APIs;
import fodastico.user.Apis.DeathAPI;
import fodastico.user.Apis.KillsAPI;
import fodastico.user.Apis.KitAPI;
import fodastico.user.Apis.MoneyAPI;
import fodastico.user.Apis.TopKsAPI;
import fodastico.user.Apis.XpAPI;
import fodastico.user.DoubleXp.BDoubleXpsAPI;
import fodastico.user.Events.EventosGerais;
import fodastico.user.FullVIP.VipallAPI;
import fodastico.user.Managers.CommandManager;
import fodastico.user.Managers.ListenerManager;
import fodastico.user.Managers.ReflectionManager;
import fodastico.user.Managers.TabAPI;
import fodastico.user.ScoreAnimated.Animation;
import fodastico.user.ScoreBoard.ScoreBoard;
import fodastico.user.Warp.WarpsConfigurations;

public class Main extends JavaPlugin implements Listener {
	public static Plugin plugin;
	public static Main instancea;
	private String craftBukkitVersion;
	public static Main instance;
	public ReflectionManager rm;
	static ArrayList<String> A;
	public static Animation an;
	public static ScoreBoard sc;
	public static ScoreBoard up;
	public static EventosGerais lt;

	static {
		Main.A = new ArrayList<String>();
		Main.an = new Animation();
		Main.sc = new ScoreBoard();
		Main.up = new ScoreBoard();
		Main.lt = new EventosGerais();
	}

	public String getCraftBukkitVersion() {
		return this.craftBukkitVersion;
	}

	public static Plugin getPlugin() {
		return Main.plugin;
	}

	public static Main getInstance() {
		return Main.instancea;
	}

	public void onEnable() {
		this.saveDefaultConfig();
		Main.plugin = (Plugin) this;
		Main.instancea = this;
		WarpsConfigurations.getConfig().createYMLFil((Plugin) this);
		this.rm = new ReflectionManager();
		WarpsConfigurations.getConfig().createYMLFil((Plugin) this);
		ListenerManager.onEventsLoad();
		new CommandManager(this);
		MoneyAPI.createFile1();
		XpAPI.createFile1();
		KillsAPI.createFile1();
		DeathAPI.createFile1();
		TopKsAPI.createFile1();
		BDoubleXpsAPI.createFile1();
		Bukkit.getConsoleSender().sendMessage("§a§l---------------------------------");
		Bukkit.getConsoleSender().sendMessage("§fSistema de §6§lVIP ALL §7(§cOFF§7)");
		Bukkit.getConsoleSender().sendMessage("§fWarp §e§lEVENTO §7(§cDESLIGADO§7)");
		Bukkit.getConsoleSender().sendMessage("§a§l---------------------------------");
		Bukkit.getConsoleSender().sendMessage("§a§lO plugin foi ativado com sucesso!");
		Bukkit.getConsoleSender()
				.sendMessage("§a§lLembre-se que \u00e9 uma vers\u00e3o de TESTES (n\u00e3o terminado)");
		Bukkit.getConsoleSender().sendMessage("§a§l---------------------------------");
		VipallAPI.vipall = false;
		this.run();
		this.updateMotd();
		this.onLoadTab();
		Main.up.run();
		Bukkit.getScheduler().scheduleSyncRepeatingTask(getPlugin(), (Runnable) new Runnable() {
			@Override
			public void run() {
				APIs.AutomaticMessage();
			}
		}, 1L, 2400L);
	}

	public void onDisable() {
		Bukkit.getScheduler().cancelAllTasks();
		Player[] onlinePlayers;
		for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
			final Player all = onlinePlayers[i];
			all.kickPlayer(
					"§c§lSERVIDOR FECHANDO/REINICIANDO \n§fO servidor que voc\u00ea estava conectando foi fechado/reiniciado \n§fGarantimos que \u00e9 para sua melhor §e§lJOGABILIDADE");
		}
	}

	public void onLoadTab() {
		new BukkitRunnable() {
			public void run() {
				Player[] onlinePlayers;
				for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
					final Player p = onlinePlayers[i];
					TabAPI.sendTabTitle(p,
							"    " + Main.getInstance().getConfig().getString("MNOME-SERVER-TAB").replace("&", "§")
									+ "\n" + "       "
									+ Main.getInstance().getConfig().getString("MSITE-SERVER-TAB").replace("&", "§")
									+ "\n",
							"\n§eSeu Kit: &f" + KitAPI.getkit(p) + " §8| §eLiga: " + ScoreBoard.getRankName(p) + "\n"
									+ "\n" + "§eRegras: §f/regras" + "\n"
									+ Main.getInstance().getConfig().getString("MIP-SERVER-TAB").replace("&", "§"));
				}
			}
		}.runTaskTimer(Main.plugin, 0L, 3L);
	}

	public void run() {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(getPlugin(), (Runnable) new Runnable() {
			@Override
			public void run() {
				Main.an.start();
				Main.an.start3();
				Main.an.start4();
				Main.an.start2();
			}
		}, 0L, 12L);
	}

	public void updateMotd() {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(getPlugin(), (Runnable) new Runnable() {
			@Override
			public void run() {
				EventosGerais.MotdUpdate();
			}
		}, 0L, 400L);
	}
}
