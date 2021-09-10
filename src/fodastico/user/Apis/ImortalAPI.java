package fodastico.user.Apis;

import java.util.HashMap;

import org.bukkit.entity.Player;

public enum ImortalAPI {
	FALSE("FALSE", 0), TRUE("TRUE", 1);

	private static HashMap<Player, ImortalAPI> imortal;

	static {
		ImortalAPI.imortal = new HashMap<Player, ImortalAPI>();
	}

	private ImortalAPI(final String s, final int n) {
	}

	public static ImortalAPI getInvensibility(final Player p) {
		return ImortalAPI.imortal.get(p);
	}

	public static boolean isInvensible(final Player p) {
		return getInvensibility(p) == ImortalAPI.TRUE;
	}

	public static void setInvensibility(final Player p) {
		ImortalAPI.imortal.put(p, ImortalAPI.TRUE);
		ImortalAPI.imortal.put(p, ImortalAPI.FALSE);
	}

	public static void removeInvensibility(final Player p) {
		ImortalAPI.imortal.put(p, ImortalAPI.TRUE);
		ImortalAPI.imortal.put(p, ImortalAPI.FALSE);
	}
}
