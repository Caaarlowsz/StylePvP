package fodastico.user.Commands;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.caaarlowsz.stylemc.kitpvp.StylePvP;
import fodastico.user.Apis.APIs;
import fodastico.user.Apis.KitAPI;
import fodastico.user.Events.SubEventos;
import fodastico.user.Warp.WarpsManager;

public class Ss implements CommandExecutor {
	public static ArrayList<Player> inss;
	public static HashMap<Player, String> sscheckname;

	static {
		Ss.inss = new ArrayList<Player>();
		Ss.sscheckname = new HashMap<Player, String>();
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("ss")) {
			if (!p.hasPermission("kitpvp.ss")) {
				p.sendMessage(
						"�e�lPERMISSAO �fVoc\u00ea n\u00e3o possui �4�lPERMISSAO �fpara executar este �3�lCOMANDO.");
				return true;
			}
			if (args.length == 0) {
				p.sendMessage(
						"�4�lSCREENSHARE �fUtilize: /ss <jogador> - �3�lCOLOCA �fou �a�lLIBERA �fum jogador da �c�lSCREENSHARE");
				p.sendMessage(
						"�4�lSCREENSHARE �fUtilize: /ss <check> - Veja a �2�lLISTA �fde jogadores em �c�lSCREENSHARE");
				return true;
			}
			final String nameoff = args[0];
			if (args[0].toLowerCase().equals("check")) {
				p.sendMessage("");
				p.sendMessage("�4�lSCREENSHARE �fLista de �c�lSCREENSHARES �fem �e�lANDAMENTO!");
				p.sendMessage("");
				SubEventos.onSsList(p);
				return true;
			}
			final Player ip = p.getServer().getPlayer(args[0]);
			if (ip == null) {
				p.sendMessage("�f�lOFFLINE �fO jogador �7(�e" + nameoff + "�7) est\u00e1 offline.");
				return true;
			}
			if (ip == p) {
				p.sendMessage("�4�lSCREENSHARE �fVoc\u00ea n\u00e3o pode se colocar em �c�lSCREENSHARE");
				return true;
			}
			if (!Ss.inss.contains(ip)) {
				WarpsManager.Ir(ip, "Ss");
				WarpsManager.Ir(p, "Ss");
				KitAPI.setKit(ip, "ScreenShare");
				KitAPI.setKit(p, "ScreenShare");
				Ss.inss.add(ip);
				Ss.sscheckname.put(ip, ip.getName());
				StylePvP.sc.registerScoreBoard(ip);
				StylePvP.sc.registerScoreBoard(p);
				p.sendMessage("�4�lSCREENSHARE �fVoc\u00ea �e�lCOLOCOU �fo jogador �1�l" + ip.getName()
						+ " �fem �c�lSCREENSHARE");
				ip.sendMessage("�4�lSCREENSHARE �fVoc\u00ea foi �e�lCOLOCADO �fem �c�lSCREENSHARE");
				Bukkit.broadcastMessage(
						"�4�lSCREENSHARE �fO jogador �1�l" + ip.getName() + " �ffoi �e�lCOLOCADO �fem �c�lSCREENSHARE");
				APIs.Ss(ip);
				WarpsManager.Ir(ip, "Ss");
				WarpsManager.Ir(p, "Ss");
				p.showPlayer(ip);
				ip.showPlayer(p);
				p.showPlayer(ip);
				ip.showPlayer(p);
				return true;
			}
			KitAPI.sendSpawn(p);
			KitAPI.sendSpawn(ip);
			Ss.inss.remove(ip);
			Ss.sscheckname.remove(ip);
			StylePvP.sc.registerScoreBoard(ip);
			StylePvP.sc.registerScoreBoard(p);
			StylePvP.sc.registerScoreBoard(ip);
			StylePvP.sc.registerScoreBoard(p);
			p.sendMessage("�4�lSCREENSHARE �fVoc\u00ea �a�lLIBEROU �fo jogador �1�l" + ip.getName()
					+ " �fda �c�lSCREENSHARE");
			ip.sendMessage("�4�lSCREENSHARE �fVoc\u00ea foi �a�lLIBERADO �fda �c�lSCREENSHARE");
			Bukkit.broadcastMessage(
					"�4�lSCREENSHARE �fO jogador �1�l" + ip.getName() + " �ffoi �a�lLIBERADO �fda �c�lSCREENSHARE");
			APIs.Normal(ip);
			p.showPlayer(ip);
			ip.showPlayer(p);
			p.showPlayer(ip);
			Ss.inss.remove(ip);
			Ss.sscheckname.remove(ip);
			Ss.inss.remove(ip);
			Ss.sscheckname.remove(ip);
			Ss.inss.remove(ip);
			Ss.sscheckname.remove(ip);
		}
		return false;
	}
}
