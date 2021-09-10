package fodastico.user.DoubleXp;

import org.bukkit.entity.Player;

import fodastico.user.Apis.XpAPI;

public class XpbyXpAPI {
	public static void xpbyxp(final Player d, final Player k) {
		if (XpAPI.getXp(d) <= 0 && XpAPI.getXp(d) <= 29) {
			DoublexpAPI.addXps(k, 1);
			return;
		}
		if (XpAPI.getXp(d) >= 30 && XpAPI.getXp(d) <= 119) {
			DoublexpAPI.addXps(k, 1);
			return;
		}
		if (XpAPI.getXp(d) >= 120 && XpAPI.getXp(d) <= 279) {
			DoublexpAPI.addXps(k, 2);
			return;
		}
		if (XpAPI.getXp(d) >= 280 && XpAPI.getXp(d) <= 499) {
			DoublexpAPI.addXps(k, 2);
			return;
		}
		if (XpAPI.getXp(d) >= 500 && XpAPI.getXp(d) <= 999) {
			DoublexpAPI.addXps(k, 3);
			return;
		}
		if (XpAPI.getXp(d) >= 1000 && XpAPI.getXp(d) <= 1499) {
			DoublexpAPI.addXps(k, 5);
			return;
		}
		if (XpAPI.getXp(d) >= 1500 && XpAPI.getXp(d) <= 1999) {
			DoublexpAPI.addXps(k, 7);
			return;
		}
		if (XpAPI.getXp(d) >= 2000 && XpAPI.getXp(d) <= 2499) {
			DoublexpAPI.addXps(k, 12);
			return;
		}
		if (XpAPI.getXp(d) >= 2500 && XpAPI.getXp(d) <= 2999) {
			DoublexpAPI.addXps(k, 15);
			return;
		}
		if (XpAPI.getXp(d) >= 3000 && XpAPI.getXp(d) <= 3999) {
			DoublexpAPI.addXps(k, 18);
			return;
		}
		if (XpAPI.getXp(d) >= 4000 && XpAPI.getXp(d) <= 4599) {
			DoublexpAPI.addXps(k, 28);
			return;
		}
		if (XpAPI.getXp(d) >= 5000 && XpAPI.getXp(d) <= 5999) {
			DoublexpAPI.addXps(k, 35);
			return;
		}
		if (XpAPI.getXp(d) >= 6000 && XpAPI.getXp(d) <= 6599) {
			DoublexpAPI.addXps(k, 51);
			return;
		}
		if (XpAPI.getXp(d) >= 6999 && XpAPI.getXp(d) <= 7999) {
			DoublexpAPI.addXps(k, 72);
			return;
		}
		if (XpAPI.getXp(d) >= 8000) {
			DoublexpAPI.addXps(k, 92);
		}
	}
}
