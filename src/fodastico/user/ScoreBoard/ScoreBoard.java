package fodastico.user.ScoreBoard;

import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.OfflinePlayer;
import org.bukkit.scoreboard.DisplaySlot;
import fodastico.user.Apis.APIs;
import fodastico.user.Commands.Ss;
import org.bukkit.scoreboard.Team;
import fodastico.user.Apis.KillsAPI;
import fodastico.user.Apis.DeathAPI;
import fodastico.user.Apis.TopKsAPI;
import fodastico.user.Apis.KitAPI;
import fodastico.user.Commands.Score;
import net.md_5.bungee.api.ChatColor;
import fodastico.user.Events.EventsOneVsOne;
import fodastico.user.Apis.XpAPI;
import org.bukkit.entity.Player;
import fodastico.user.Events.EventosGerais;
import fodastico.user.Events.Imortal;
import fodastico.user.Main;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

public class ScoreBoard implements Listener
{
    private static String ninguem;
    
    static {
        ScoreBoard.ninguem = "§3Ningu\u00e9m";
    }
    
    public void run() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), (Runnable)new Runnable() {
            @Override
            public void run() {
                Player[] onlinePlayers;
                for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
                    final Player todos = onlinePlayers[i];
                    ScoreBoard.UpdatePVP(todos);
                    ScoreBoard.Update1v1(todos);
                    ScoreBoard.UpdateVanish(todos);
                    ScoreBoard.UpdateSsStaff(todos);
                    ScoreBoard.UpdateEvent(todos);
                    ScoreBoard.UpdateSsPlayer(todos);
                    Imortal.Regenerar(todos);
                    EventosGerais.topks(todos);
                }
            }
        }, 0L, 1L);
    }
    
    public static String getRankName(final Player p) {
        final int r = XpAPI.getXp(p);
        if (r <= 99) {
            return "§f- UNRANKED";
        }
        if (r >= 100 && r <= 499) {
            return "§a\u2630 PRIMARY";
        }
        if (r >= 500 && r <= 999) {
            return "§e\u2634 ADVANCED";
        }
        if (r >= 1000 && r <= 1499) {
            return "§1\u2637 EXPERT";
        }
        if (r >= 1500 && r <= 1999) {
            return "§7\u2736 SILVER";
        }
        if (r >= 2000 && r <= 2999) {
            return "§6\u2739 GOLD";
        }
        if (r >= 3000 && r <= 4000) {
            return "§b\u2726 DIAMOND";
        }
        if (r >= 5000 && r <= 5999) {
            return "§5\u2739 ELITE";
        }
        if (r >= 6000 && r <= 6999) {
            return "§c\u272b MASTER";
        }
        if (r >= 7000 && r <= 10000) {
            return "§4\u272a LEGENDARY";
        }
        return "§4\u272a LEGENDARY";
    }
    
    public static String Oponente(final Player p) {
        if (EventsOneVsOne.oponentename.containsKey(p)) {
            return ChatColor.DARK_AQUA + EventsOneVsOne.oponentename.get(p);
        }
        if (EventsOneVsOne.oponentename2.containsKey(p)) {
            return ChatColor.DARK_AQUA + EventsOneVsOne.oponentename2.get(p);
        }
        return ScoreBoard.ninguem;
    }
    
    public static String topksgetscore(final Player p) {
        if (EventosGerais.kstop == null) {
            return ChatColor.DARK_AQUA + " - 0";
        }
        return ChatColor.DARK_AQUA + " - " + EventosGerais.kstop;
    }
    
    public static String topksnamegetscore(final Player p) {
        if (EventosGerais.nometop == null) {
            return ChatColor.DARK_AQUA + "Ningu\u00e9m";
        }
        return ChatColor.DARK_AQUA + EventosGerais.nometop;
    }
    
    public static String getRankNick(final Player p) {
        final int r = XpAPI.getXp(p);
        if (r <= 99) {
            return " §7(§f-§7)";
        }
        if (r >= 100 && r <= 499) {
            return " §7(§a\u2630§7)";
        }
        if (r >= 500 && r <= 999) {
            return " §7(§e\u2634§7)";
        }
        if (r >= 1000 && r <= 1499) {
            return " §7(§1\u2637§7)";
        }
        if (r >= 1500 && r <= 1999) {
            return " §7(§7\u2736§7)";
        }
        if (r >= 2000 && r <= 2999) {
            return " §7(§6\u2739§7)";
        }
        if (r >= 3000 && r <= 4000) {
            return " §7(§b\u2726§7)";
        }
        if (r >= 5000 && r <= 5999) {
            return " §7(§5\u2739§7)";
        }
        if (r >= 6000 && r <= 6999) {
            return " §7(§c\u272b§7)";
        }
        if (r >= 7000 && r <= 10000) {
            return " §7(§4\u272a§7)";
        }
        return " §7(§4\u272a§7)";
    }
    
    public static void UpdatePVP(final Player p) {
        if (Score.ativada.contains(p.getName()) && KitAPI.getkit(p) != "1v1" && KitAPI.getkit(p) != "Admin" && KitAPI.getkit(p) != "Evento" && KitAPI.getkit(p) != "ScreenShare") {
            final Thread th = new Thread(new Runnable() {
                @Override
                public void run() {
                    if (Score.ativada.contains(p.getName())) {
                        p.getScoreboard().getObjective("sbanimado").setDisplayName(Main.an.getText());
                        final Team site = p.getScoreboard().getTeam("line1");
                        site.setPrefix(Main.getInstance().getConfig().getString("MSITE-SCORE-PREFIX").replace("&", "§"));
                        site.setSuffix(Main.getInstance().getConfig().getString("MSITE-SCORE-SUFFIX").replace("&", "§"));
                        final Team kit = p.getScoreboard().getTeam("line3");
                        kit.setPrefix("§fKit: ");
                        kit.setSuffix("§e" + KitAPI.getkit(p));
                        final Team xp = p.getScoreboard().getTeam("line5");
                        xp.setPrefix("§fXP: ");
                        xp.setSuffix("§7" + XpAPI.getXp(p));
                        final Team liga = p.getScoreboard().getTeam("line6");
                        liga.setPrefix("§fLiga: ");
                        liga.setSuffix("§7" + ScoreBoard.getRankName(p));
                        final Team streak = p.getScoreboard().getTeam("line8");
                        streak.setPrefix("§fStreak: ");
                        streak.setSuffix("§7" + TopKsAPI.getStreak(p));
                        final Team deaths = p.getScoreboard().getTeam("line9");
                        deaths.setPrefix("§fDeaths: ");
                        deaths.setSuffix("§7" + DeathAPI.getDeath(p));
                        final Team kills = p.getScoreboard().getTeam("line10");
                        kills.setPrefix("§fKills: ");
                        kills.setSuffix("§7" + KillsAPI.getKills(p));
                    }
                }
            });
            th.start();
        }
    }
    
    public static void Update1v1(final Player p) {
        if (Score.ativada.contains(p.getName()) && KitAPI.getkit(p) == "1v1") {
            final Thread th = new Thread(new Runnable() {
                @Override
                public void run() {
                    if (Score.ativada.contains(p.getName())) {
                        p.getScoreboard().getObjective("sbanimado").setDisplayName(Main.an.getText1v1());
                        final Team site = p.getScoreboard().getTeam("line1");
                        site.setPrefix(Main.getInstance().getConfig().getString("MSITE-SCORE-PREFIX").replace("&", "§"));
                        site.setSuffix(Main.getInstance().getConfig().getString("MSITE-SCORE-SUFFIX").replace("&", "§"));
                        final Team xp = p.getScoreboard().getTeam("line3");
                        xp.setPrefix("§fXP: ");
                        xp.setSuffix("§7" + XpAPI.getXp(p));
                        final Team liga = p.getScoreboard().getTeam("line4");
                        liga.setPrefix("§fLiga: ");
                        liga.setSuffix(new StringBuilder().append(ScoreBoard.getRankName(p)).toString());
                        final Team streak = p.getScoreboard().getTeam("line6");
                        streak.setPrefix("§fStreak: ");
                        streak.setSuffix("§7" + TopKsAPI.getStreak(p));
                        final Team deaths = p.getScoreboard().getTeam("line7");
                        deaths.setPrefix("§fDeaths: ");
                        deaths.setSuffix("§7" + DeathAPI.getDeath(p));
                        final Team kills = p.getScoreboard().getTeam("line8");
                        kills.setPrefix("§fKills: ");
                        kills.setSuffix("§7" + KillsAPI.getKills(p));
                    }
                }
            });
            th.start();
        }
    }
    
    public static void UpdateSsPlayer(final Player p) {
        if (Score.ativada.contains(p.getName()) && KitAPI.getkit(p) == "ScreenShare" && Ss.inss.contains(p)) {
            final Thread th = new Thread(new Runnable() {
                @Override
                public void run() {
                    if (Score.ativada.contains(p.getName())) {
                        p.getScoreboard().getObjective("sbanimado").setDisplayName(Main.an.getTextSs());
                        final Team site = p.getScoreboard().getTeam("line1");
                        site.setPrefix(Main.getInstance().getConfig().getString("MSITE-SCORE-PREFIX").replace("&", "§"));
                        site.setSuffix(Main.getInstance().getConfig().getString("MSITE-SCORE-SUFFIX").replace("&", "§"));
                        final Team linha3 = p.getScoreboard().getTeam("line3");
                        linha3.setPrefix("§cser\u00e1 libera");
                        linha3.setSuffix("§cdo!");
                        final Team linha4 = p.getScoreboard().getTeam("line4");
                        linha4.setPrefix("§cCaso voc\u00ea es");
                        linha4.setSuffix("§cteja limpo,");
                        final Team linha5 = p.getScoreboard().getTeam("line6");
                        linha5.setPrefix("§cSiga os pass");
                        linha5.setSuffix("§cos do staff!");
                        final Team linha6 = p.getScoreboard().getTeam("line7");
                        linha6.setPrefix("§csuspeito de ");
                        linha6.setSuffix("§cuso de hack!");
                        final Team linha7 = p.getScoreboard().getTeam("line8");
                        linha7.setPrefix("§cVoc\u00ea ser\u00e1 tel");
                        linha7.setSuffix("§cado por ser");
                        final Team linha8 = p.getScoreboard().getTeam("line9");
                        linha8.setPrefix("§cN\u00e3o deslogue");
                        linha8.setSuffix("§c!");
                    }
                }
            });
            th.start();
        }
    }
    
    public static void UpdateSsStaff(final Player p) {
        if (Score.ativada.contains(p.getName()) && KitAPI.getkit(p) == "ScreenShare" && !Ss.inss.contains(p)) {
            final Thread th = new Thread(new Runnable() {
                @Override
                public void run() {
                    if (Score.ativada.contains(p.getName())) {
                        p.getScoreboard().getObjective("sbanimado").setDisplayName(Main.an.getTextSs());
                        final Team site = p.getScoreboard().getTeam("line1");
                        site.setPrefix(Main.getInstance().getConfig().getString("MSITE-SCORE-PREFIX").replace("&", "§"));
                        site.setSuffix(Main.getInstance().getConfig().getString("MSITE-SCORE-SUFFIX").replace("&", "§"));
                        final Team linha3 = p.getScoreboard().getTeam("line3");
                        linha3.setPrefix("§7spawn e volt");
                        linha3.setSuffix("§7e a moderar!");
                        final Team linha4 = p.getScoreboard().getTeam("line4");
                        linha4.setPrefix("§7Ap\u00f3s ser lib");
                        linha4.setSuffix("§7erado, v\u00e1 no");
                        final Team linha5 = p.getScoreboard().getTeam("line6");
                        linha5.setPrefix("§7concluir a s");
                        linha5.setSuffix("§7creenshare!");
                        final Team linha6 = p.getScoreboard().getTeam("line7");
                        linha6.setPrefix("§7e de modo al");
                        linha6.setSuffix("§7gum saia sem");
                        final Team linha7 = p.getScoreboard().getTeam("line8");
                        linha7.setPrefix("§7Realize os p");
                        linha7.setSuffix("§7rocedimentos");
                        final Team linha8 = p.getScoreboard().getTeam("line9");
                        linha8.setPrefix("§7Voc\u00ea puxou u");
                        linha8.setSuffix("§7m player!");
                    }
                }
            });
            th.start();
        }
    }
    
    public static void UpdateVanish(final Player p) {
        if (Score.ativada.contains(p.getName()) && KitAPI.getkit(p) == "Admin") {
            final int online = Bukkit.getOnlinePlayers().length;
            final Thread th = new Thread(new Runnable() {
                @Override
                public void run() {
                    if (Score.ativada.contains(p.getName())) {
                        p.getScoreboard().getObjective("sbanimado").setDisplayName(Main.an.getTextVanish());
                        final Team site = p.getScoreboard().getTeam("line1");
                        site.setPrefix(Main.getInstance().getConfig().getString("MSITE-SCORE-PREFIX").replace("&", "§"));
                        site.setSuffix(Main.getInstance().getConfig().getString("MSITE-SCORE-SUFFIX").replace("&", "§"));
                        final Team on = p.getScoreboard().getTeam("line3");
                        on.setPrefix("§7Online: ");
                        on.setSuffix("§a" + online);
                        final Team vanish = p.getScoreboard().getTeam("line5");
                        vanish.setPrefix("§3MODO ");
                        vanish.setSuffix("§3VANISH");
                        final Team group = p.getScoreboard().getTeam("line7");
                        group.setPrefix("§7Grupo: ");
                        group.setSuffix(APIs.Grupo(p));
                    }
                }
            });
            th.start();
        }
    }
    
    public static void UpdateEvent(final Player p) {
        if (Score.ativada.contains(p.getName()) && KitAPI.getkit(p) == "Evento") {
            final Thread th = new Thread(new Runnable() {
                @Override
                public void run() {
                    if (Score.ativada.contains(p.getName())) {
                        p.getScoreboard().getObjective("sbanimado").setDisplayName("§e§lEVENTO");
                        final Team site = p.getScoreboard().getTeam("line1");
                        site.setPrefix(Main.getInstance().getConfig().getString("MSITE-SCORE-PREFIX").replace("&", "§"));
                        site.setSuffix(Main.getInstance().getConfig().getString("MSITE-SCORE-SUFFIX").replace("&", "§"));
                        final Team xp = p.getScoreboard().getTeam("line3");
                        xp.setPrefix("§fXP: ");
                        xp.setSuffix("§7" + XpAPI.getXp(p));
                        final Team liga = p.getScoreboard().getTeam("line4");
                        liga.setPrefix("§fLiga: ");
                        liga.setSuffix(ScoreBoard.getRankName(p));
                    }
                }
            });
            th.start();
        }
    }
    
    public void registerScoreBoard(final Player p) {
        if (Score.ativada.contains(p.getName())) {
            final Scoreboard sb = Bukkit.getScoreboardManager().getNewScoreboard();
            final Objective obj = sb.registerNewObjective("sbanimado", "dummy");
            obj.setDisplaySlot(DisplaySlot.SIDEBAR);
            obj.setDisplayName("§6LOADING");
            final Team t1 = sb.registerNewTeam("line1");
            final Team t2 = sb.registerNewTeam("line3");
            final Team t3 = sb.registerNewTeam("line4");
            final Team t4 = sb.registerNewTeam("line5");
            final Team t5 = sb.registerNewTeam("line6");
            final Team t6 = sb.registerNewTeam("line7");
            final Team t7 = sb.registerNewTeam("line8");
            final Team t8 = sb.registerNewTeam("line9");
            final Team t9 = sb.registerNewTeam("line10");
            final Team t10 = sb.registerNewTeam("line11");
            final Team t11 = sb.registerNewTeam("line12");
            final Team t12 = sb.registerNewTeam("line13");
            if (KitAPI.getkit(p) == "1v1") {
                final FastOfflinePlayer f1 = new FastOfflinePlayer("§1");
                obj.getScore((OfflinePlayer)f1).setScore(1);
                t1.addPlayer((OfflinePlayer)f1);
                final FastOfflinePlayer f2 = new FastOfflinePlayer("§2");
                obj.getScore((OfflinePlayer)f2).setScore(2);
                final FastOfflinePlayer f3 = new FastOfflinePlayer("§3");
                obj.getScore((OfflinePlayer)f3).setScore(3);
                t2.addPlayer((OfflinePlayer)f3);
                final FastOfflinePlayer f4 = new FastOfflinePlayer("§4");
                obj.getScore((OfflinePlayer)f4).setScore(4);
                t3.addPlayer((OfflinePlayer)f4);
                final FastOfflinePlayer f5 = new FastOfflinePlayer("§5");
                obj.getScore((OfflinePlayer)f5).setScore(5);
                final FastOfflinePlayer f6 = new FastOfflinePlayer("§6");
                obj.getScore((OfflinePlayer)f6).setScore(6);
                t5.addPlayer((OfflinePlayer)f6);
                final FastOfflinePlayer f7 = new FastOfflinePlayer("§7");
                obj.getScore((OfflinePlayer)f7).setScore(7);
                t6.addPlayer((OfflinePlayer)f7);
                final FastOfflinePlayer f8 = new FastOfflinePlayer("§8");
                obj.getScore((OfflinePlayer)f8).setScore(8);
                t7.addPlayer((OfflinePlayer)f8);
                final FastOfflinePlayer f9 = new FastOfflinePlayer("§9");
                obj.getScore((OfflinePlayer)f9).setScore(9);
            }
            else if (KitAPI.getkit(p) == "Admin") {
                final FastOfflinePlayer f1 = new FastOfflinePlayer("§c");
                obj.getScore((OfflinePlayer)f1).setScore(1);
                t1.addPlayer((OfflinePlayer)f1);
                final FastOfflinePlayer f2 = new FastOfflinePlayer("§7");
                obj.getScore((OfflinePlayer)f2).setScore(2);
                final FastOfflinePlayer f3 = new FastOfflinePlayer("§b");
                obj.getScore((OfflinePlayer)f3).setScore(3);
                t2.addPlayer((OfflinePlayer)f3);
                final FastOfflinePlayer f4 = new FastOfflinePlayer("§1");
                obj.getScore((OfflinePlayer)f4).setScore(4);
                final FastOfflinePlayer f5 = new FastOfflinePlayer("§4");
                obj.getScore((OfflinePlayer)f5).setScore(5);
                t4.addPlayer((OfflinePlayer)f5);
                t4.addPlayer((OfflinePlayer)f5);
                final FastOfflinePlayer f6 = new FastOfflinePlayer("§2");
                obj.getScore((OfflinePlayer)f6).setScore(6);
                final FastOfflinePlayer f7 = new FastOfflinePlayer("§3");
                obj.getScore((OfflinePlayer)f7).setScore(7);
                t6.addPlayer((OfflinePlayer)f7);
                final FastOfflinePlayer f8 = new FastOfflinePlayer("§0");
                obj.getScore((OfflinePlayer)f8).setScore(8);
            }
            else if (KitAPI.getkit(p) == "Evento") {
                final FastOfflinePlayer f1 = new FastOfflinePlayer("§c");
                obj.getScore((OfflinePlayer)f1).setScore(1);
                t1.addPlayer((OfflinePlayer)f1);
                final FastOfflinePlayer f2 = new FastOfflinePlayer("§7");
                obj.getScore((OfflinePlayer)f2).setScore(2);
                final FastOfflinePlayer f3 = new FastOfflinePlayer("§b");
                obj.getScore((OfflinePlayer)f3).setScore(3);
                t2.addPlayer((OfflinePlayer)f3);
                final FastOfflinePlayer f4 = new FastOfflinePlayer("§1");
                obj.getScore((OfflinePlayer)f4).setScore(4);
                t3.addPlayer((OfflinePlayer)f4);
                final FastOfflinePlayer f5 = new FastOfflinePlayer("§4");
                obj.getScore((OfflinePlayer)f5).setScore(5);
            }
            else if (KitAPI.getkit(p) == "ScreenShare") {
                final FastOfflinePlayer f1 = new FastOfflinePlayer("§1");
                obj.getScore((OfflinePlayer)f1).setScore(1);
                t1.addPlayer((OfflinePlayer)f1);
                final FastOfflinePlayer f2 = new FastOfflinePlayer("§2");
                obj.getScore((OfflinePlayer)f2).setScore(2);
                final FastOfflinePlayer f3 = new FastOfflinePlayer("§3");
                obj.getScore((OfflinePlayer)f3).setScore(3);
                t2.addPlayer((OfflinePlayer)f3);
                final FastOfflinePlayer f4 = new FastOfflinePlayer("§4");
                obj.getScore((OfflinePlayer)f4).setScore(4);
                t3.addPlayer((OfflinePlayer)f4);
                final FastOfflinePlayer f5 = new FastOfflinePlayer("§5");
                obj.getScore((OfflinePlayer)f5).setScore(5);
                final FastOfflinePlayer f6 = new FastOfflinePlayer("§6");
                obj.getScore((OfflinePlayer)f6).setScore(6);
                t5.addPlayer((OfflinePlayer)f6);
                final FastOfflinePlayer f7 = new FastOfflinePlayer("§7");
                obj.getScore((OfflinePlayer)f7).setScore(7);
                t6.addPlayer((OfflinePlayer)f7);
                final FastOfflinePlayer f8 = new FastOfflinePlayer("§8");
                obj.getScore((OfflinePlayer)f8).setScore(8);
                t7.addPlayer((OfflinePlayer)f8);
                final FastOfflinePlayer f9 = new FastOfflinePlayer("§9");
                obj.getScore((OfflinePlayer)f9).setScore(9);
                t8.addPlayer((OfflinePlayer)f9);
                final FastOfflinePlayer f10 = new FastOfflinePlayer("§0");
                obj.getScore((OfflinePlayer)f10).setScore(10);
            }
            else {
                final FastOfflinePlayer f1 = new FastOfflinePlayer("§0");
                obj.getScore((OfflinePlayer)f1).setScore(1);
                t1.addPlayer((OfflinePlayer)f1);
                final FastOfflinePlayer f2 = new FastOfflinePlayer("§1");
                obj.getScore((OfflinePlayer)f2).setScore(2);
                final FastOfflinePlayer f3 = new FastOfflinePlayer("§2");
                obj.getScore((OfflinePlayer)f3).setScore(3);
                t2.addPlayer((OfflinePlayer)f3);
                final FastOfflinePlayer f4 = new FastOfflinePlayer("§3");
                obj.getScore((OfflinePlayer)f4).setScore(4);
                final FastOfflinePlayer f5 = new FastOfflinePlayer("§4");
                obj.getScore((OfflinePlayer)f5).setScore(5);
                t4.addPlayer((OfflinePlayer)f5);
                final FastOfflinePlayer f6 = new FastOfflinePlayer("§5");
                obj.getScore((OfflinePlayer)f6).setScore(6);
                t5.addPlayer((OfflinePlayer)f6);
                final FastOfflinePlayer f7 = new FastOfflinePlayer("§6");
                obj.getScore((OfflinePlayer)f7).setScore(7);
                final FastOfflinePlayer f8 = new FastOfflinePlayer("§7");
                obj.getScore((OfflinePlayer)f8).setScore(8);
                t7.addPlayer((OfflinePlayer)f8);
                final FastOfflinePlayer f9 = new FastOfflinePlayer("§8");
                obj.getScore((OfflinePlayer)f9).setScore(9);
                t8.addPlayer((OfflinePlayer)f9);
                final FastOfflinePlayer f10 = new FastOfflinePlayer("§9");
                obj.getScore((OfflinePlayer)f10).setScore(10);
                t9.addPlayer((OfflinePlayer)f10);
                final FastOfflinePlayer f11 = new FastOfflinePlayer("§a");
                obj.getScore((OfflinePlayer)f11).setScore(11);
                t10.addPlayer((OfflinePlayer)f11);
            }
            p.setScoreboard(sb);
        }
    }
}
