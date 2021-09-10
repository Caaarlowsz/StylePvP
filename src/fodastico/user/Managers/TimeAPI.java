package fodastico.user.Managers;

import java.util.HashMap;

import org.bukkit.Bukkit;

import fodastico.user.Main;

public class TimeAPI {
	public static long total;
	public static long totalzao;
	public static HashMap<String, String> temptime;

	static {
		TimeAPI.total = 0L;
		TimeAPI.totalzao = 0L;
		TimeAPI.temptime = new HashMap<String, String>();
	}

	public static void addTempo(final String string, final int horas, final int minutos, final int segundos) {
		long hour = 0L;
		long minute = 0L;
		long second = 0L;
		hour = horas * 3600;
		minute = minutos * 60;
		second = segundos;
		TimeAPI.total += hour + minute + second;
		TimeAPI.totalzao = hour + minute + second;
		final long newTime = TimeAPI.total * 1000L + System.currentTimeMillis();
		TimeAPI.temptime.put(string, TimeLeftAPI.getRemainingTime(newTime));
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
			@Override
			public void run() {
				TimeAPI.removeTempo(string);
			}
		}, TimeAPI.totalzao * 20L);
	}

	public static void removeTempo(final String string) {
		TimeAPI.temptime.remove(string);
	}

	public static String tempoFaltando(final String p) {
		return TimeAPI.temptime.get(p);
	}
}
