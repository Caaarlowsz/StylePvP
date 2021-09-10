package fodastico.user.Commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import fodastico.user.Main;

public class Score implements CommandExecutor, Listener {
	public static ArrayList<String> ativada;
	public static ArrayList<Player> delayzin;

	static {
		Score.ativada = new ArrayList<String>();
		Score.delayzin = new ArrayList<Player>();
	}

	public static Scoreboard getScoreBoard() {
		final ScoreboardManager manager = Bukkit.getScoreboardManager();
		final Scoreboard board = manager.getNewScoreboard();
		return board;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (!(sender instanceof Player)) {
			return true;
		}
		final Player p = (Player) sender;
		if (args.length == 0) {
			p.sendMessage("§6§lSCOREBOARD §fUtilize: /score <on> <off>");
			return true;
		}
		if (args.length != 1) {
			return false;
		}
		if (args[0].equalsIgnoreCase("off")) {
			if (!Score.ativada.contains(p.getName())) {
				p.sendMessage("§6§lSCOREBOARD §fSua §e§lSCOREBOARD §fj\u00e1 est\u00e1 §c§lDESATIVADA§f!");
				Score.delayzin.add(p);
				return true;
			}
			p.sendMessage("§6§lSCOREBOARD §fVoc\u00ea §c§lDESATIVOU §fsua §e§lSCOREBOARD§f!");
			Score.ativada.remove(p.getName());
			getScoreBoard().clearSlot(DisplaySlot.SIDEBAR);
			p.setScoreboard(getScoreBoard());
			return true;
		} else {
			if (!args[0].equalsIgnoreCase("on")) {
				return true;
			}
			if (Score.ativada.contains(p.getName())) {
				p.sendMessage("§6§lSCOREBOARD §fSua §e§lSCOREBOARD §fj\u00e1 est\u00e1 §a§lATIVADA§f!");
				return true;
			}
			p.sendMessage("§6§lSCOREBOARD §fVoc\u00ea §a§lATIVOU §fsua §e§lSCOREBOARD§f!");
			Score.delayzin.add(p);
			Score.ativada.add(p.getName());
			Main.sc.registerScoreBoard(p);
			return true;
		}
	}
}
