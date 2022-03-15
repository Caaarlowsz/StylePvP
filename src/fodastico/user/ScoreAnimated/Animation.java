package fodastico.user.ScoreAnimated;

import com.github.caaarlowsz.stylemc.kitpvp.StylePvP;

public class Animation {
	private int animation1;
	private int animation2;
	private int animation3;
	private int animation4;
	public static String texto;
	public static String texto1v1;
	public static String textovanish;
	public static String textoss;

	static {
		Animation.texto = "";
		Animation.texto1v1 = "";
		Animation.textovanish = "";
		Animation.textoss = "";
	}

	public Animation() {
		this.animation1 = 1;
		this.animation2 = 1;
		this.animation3 = 1;
		this.animation4 = 1;
	}

	public void start() {
		if (this.animation1 == 1) {
			Animation.texto = StylePvP.getInstance().getConfig().getString("ANIMACAO-SCORE-PVP-1").replace("&", "�");
		}
		if (this.animation1 == 2) {
			Animation.texto = StylePvP.getInstance().getConfig().getString("ANIMACAO-SCORE-PVP-2").replace("&", "�");
		}
		if (this.animation1 == 3) {
			Animation.texto = StylePvP.getInstance().getConfig().getString("ANIMACAO-SCORE-PVP-3").replace("&", "�");
		}
		if (this.animation1 == 4) {
			Animation.texto = StylePvP.getInstance().getConfig().getString("ANIMACAO-SCORE-PVP-4").replace("&", "�");
		}
		if (this.animation1 == 5) {
			Animation.texto = StylePvP.getInstance().getConfig().getString("ANIMACAO-SCORE-PVP-5").replace("&", "�");
		}
		if (this.animation1 == 6) {
			Animation.texto = StylePvP.getInstance().getConfig().getString("ANIMACAO-SCORE-PVP-6").replace("&", "�");
		}
		if (this.animation1 == 7) {
			Animation.texto = StylePvP.getInstance().getConfig().getString("ANIMACAO-SCORE-PVP-7").replace("&", "�");
		}
		if (this.animation1 == 8) {
			Animation.texto = StylePvP.getInstance().getConfig().getString("ANIMACAO-SCORE-PVP-8").replace("&", "�");
		}
		if (this.animation1 == 9) {
			Animation.texto = StylePvP.getInstance().getConfig().getString("ANIMACAO-SCORE-PVP-9").replace("&", "�");
		}
		if (this.animation1 == 10) {
			Animation.texto = StylePvP.getInstance().getConfig().getString("ANIMACAO-SCORE-PVP-10").replace("&", "�");
		}
		if (this.animation1 == 11) {
			Animation.texto = StylePvP.getInstance().getConfig().getString("ANIMACAO-SCORE-PVP-11").replace("&", "�");
		}
		if (this.animation1 == 12) {
			Animation.texto = StylePvP.getInstance().getConfig().getString("ANIMACAO-SCORE-PVP-12").replace("&", "�");
		}
		if (this.animation1 == 13) {
			Animation.texto = StylePvP.getInstance().getConfig().getString("ANIMACAO-SCORE-PVP-13").replace("&", "�");
		}
		if (this.animation1 == 14) {
			Animation.texto = StylePvP.getInstance().getConfig().getString("ANIMACAO-SCORE-PVP-14").replace("&", "�");
		}
		if (this.animation1 == 15) {
			Animation.texto = StylePvP.getInstance().getConfig().getString("ANIMACAO-SCORE-PVP-15").replace("&", "�");
		}
		if (this.animation1 == 16) {
			Animation.texto = StylePvP.getInstance().getConfig().getString("ANIMACAO-SCORE-PVP-16").replace("&", "�");
		}
		if (this.animation1 == 17) {
			Animation.texto = StylePvP.getInstance().getConfig().getString("ANIMACAO-SCORE-PVP-17").replace("&", "�");
		}
		if (this.animation1 == 18) {
			Animation.texto = StylePvP.getInstance().getConfig().getString("ANIMACAO-SCORE-PVP-18").replace("&", "�");
		}
		if (this.animation1 == 19) {
			Animation.texto = StylePvP.getInstance().getConfig().getString("ANIMACAO-SCORE-PVP-19").replace("&", "�");
		}
		if (this.animation1 == 20) {
			Animation.texto = StylePvP.getInstance().getConfig().getString("ANIMACAO-SCORE-PVP-20").replace("&", "�");
			this.animation1 = 0;
		}
		++this.animation1;
	}

	public void start2() {
		if (this.animation2 == 1) {
			Animation.textoss = StylePvP.getInstance().getConfig().getString("ANIMACAO-SCORE-SS-1").replace("&", "�");
		}
		if (this.animation2 == 2) {
			Animation.textoss = StylePvP.getInstance().getConfig().getString("ANIMACAO-SCORE-SS-2").replace("&", "�");
		}
		if (this.animation2 == 3) {
			Animation.textoss = StylePvP.getInstance().getConfig().getString("ANIMACAO-SCORE-SS-3").replace("&", "�");
		}
		if (this.animation2 == 4) {
			Animation.textoss = StylePvP.getInstance().getConfig().getString("ANIMACAO-SCORE-SS-4").replace("&", "�");
		}
		if (this.animation2 == 5) {
			Animation.textoss = StylePvP.getInstance().getConfig().getString("ANIMACAO-SCORE-SS-5").replace("&", "�");
		}
		if (this.animation2 == 6) {
			Animation.textoss = StylePvP.getInstance().getConfig().getString("ANIMACAO-SCORE-SS-6").replace("&", "�");
		}
		if (this.animation2 == 7) {
			Animation.textoss = StylePvP.getInstance().getConfig().getString("ANIMACAO-SCORE-SS-7").replace("&", "�");
		}
		if (this.animation2 == 8) {
			Animation.textoss = StylePvP.getInstance().getConfig().getString("ANIMACAO-SCORE-SS-8").replace("&", "�");
			this.animation2 = 0;
		}
		++this.animation2;
	}

	public void start3() {
		if (this.animation3 == 1) {
			Animation.texto1v1 = StylePvP.getInstance().getConfig().getString("ANIMACAO-SCORE-1v1-1").replace("&", "�");
		}
		if (this.animation3 == 2) {
			Animation.texto1v1 = StylePvP.getInstance().getConfig().getString("ANIMACAO-SCORE-1v1-2").replace("&", "�");
		}
		if (this.animation3 == 3) {
			Animation.texto1v1 = StylePvP.getInstance().getConfig().getString("ANIMACAO-SCORE-1v1-3").replace("&", "�");
		}
		if (this.animation3 == 4) {
			Animation.texto1v1 = StylePvP.getInstance().getConfig().getString("ANIMACAO-SCORE-1v1-4").replace("&", "�");
		}
		if (this.animation3 == 5) {
			Animation.texto1v1 = StylePvP.getInstance().getConfig().getString("ANIMACAO-SCORE-1v1-5").replace("&", "�");
		}
		if (this.animation3 == 6) {
			Animation.texto1v1 = StylePvP.getInstance().getConfig().getString("ANIMACAO-SCORE-1v1-6").replace("&", "�");
		}
		if (this.animation3 == 7) {
			Animation.texto1v1 = StylePvP.getInstance().getConfig().getString("ANIMACAO-SCORE-1v1-7").replace("&", "�");
		}
		if (this.animation3 == 8) {
			Animation.texto1v1 = StylePvP.getInstance().getConfig().getString("ANIMACAO-SCORE-1v1-8").replace("&", "�");
		}
		if (this.animation3 == 9) {
			Animation.texto1v1 = StylePvP.getInstance().getConfig().getString("ANIMACAO-SCORE-1v1-9").replace("&", "�");
		}
		if (this.animation3 == 10) {
			Animation.texto1v1 = StylePvP.getInstance().getConfig().getString("ANIMACAO-SCORE-1v1-10").replace("&", "�");
		}
		if (this.animation3 == 11) {
			Animation.texto1v1 = StylePvP.getInstance().getConfig().getString("ANIMACAO-SCORE-1v1-11").replace("&", "�");
		}
		if (this.animation3 == 12) {
			Animation.texto1v1 = StylePvP.getInstance().getConfig().getString("ANIMACAO-SCORE-1v1-12").replace("&", "�");
		}
		if (this.animation3 == 13) {
			Animation.texto1v1 = StylePvP.getInstance().getConfig().getString("ANIMACAO-SCORE-1v1-13").replace("&", "�");
		}
		if (this.animation3 == 14) {
			Animation.texto1v1 = StylePvP.getInstance().getConfig().getString("ANIMACAO-SCORE-1v1-14").replace("&", "�");
		}
		if (this.animation3 == 15) {
			Animation.texto1v1 = StylePvP.getInstance().getConfig().getString("ANIMACAO-SCORE-1v1-15").replace("&", "�");
		}
		if (this.animation3 == 16) {
			Animation.texto1v1 = StylePvP.getInstance().getConfig().getString("ANIMACAO-SCORE-1v1-16").replace("&", "�");
		}
		if (this.animation3 == 17) {
			Animation.texto1v1 = StylePvP.getInstance().getConfig().getString("ANIMACAO-SCORE-1v1-17").replace("&", "�");
		}
		if (this.animation3 == 18) {
			Animation.texto1v1 = StylePvP.getInstance().getConfig().getString("ANIMACAO-SCORE-1v1-18").replace("&", "�");
		}
		if (this.animation3 == 19) {
			Animation.texto1v1 = StylePvP.getInstance().getConfig().getString("ANIMACAO-SCORE-1v1-19").replace("&", "�");
		}
		if (this.animation3 == 20) {
			Animation.texto1v1 = StylePvP.getInstance().getConfig().getString("ANIMACAO-SCORE-1v1-20").replace("&", "�");
			this.animation3 = 0;
		}
		++this.animation3;
	}

	public void start4() {
		if (this.animation4 == 1) {
			Animation.textovanish = StylePvP.getInstance().getConfig().getString("ANIMACAO-SCORE-ADMIN-1").replace("&",
					"�");
		}
		if (this.animation4 == 2) {
			Animation.textovanish = StylePvP.getInstance().getConfig().getString("ANIMACAO-SCORE-ADMIN-2").replace("&",
					"�");
		}
		if (this.animation4 == 3) {
			Animation.textovanish = StylePvP.getInstance().getConfig().getString("ANIMACAO-SCORE-ADMIN-3").replace("&",
					"�");
		}
		if (this.animation4 == 4) {
			Animation.textovanish = StylePvP.getInstance().getConfig().getString("ANIMACAO-SCORE-ADMIN-4").replace("&",
					"�");
		}
		if (this.animation4 == 5) {
			Animation.textovanish = StylePvP.getInstance().getConfig().getString("ANIMACAO-SCORE-ADMIN-5").replace("&",
					"�");
		}
		if (this.animation4 == 6) {
			Animation.textovanish = StylePvP.getInstance().getConfig().getString("ANIMACAO-SCORE-ADMIN-6").replace("&",
					"�");
		}
		if (this.animation4 == 7) {
			Animation.textovanish = StylePvP.getInstance().getConfig().getString("ANIMACAO-SCORE-ADMIN-7").replace("&",
					"�");
		}
		if (this.animation4 == 8) {
			Animation.textovanish = StylePvP.getInstance().getConfig().getString("ANIMACAO-SCORE-ADMIN-8").replace("&",
					"�");
		}
		if (this.animation4 == 9) {
			Animation.textovanish = StylePvP.getInstance().getConfig().getString("ANIMACAO-SCORE-ADMIN-9").replace("&",
					"�");
			this.animation4 = 0;
		}
		++this.animation4;
	}

	public String getText() {
		return Animation.texto;
	}

	public String getTextSs() {
		return Animation.textoss;
	}

	public String getText1v1() {
		return Animation.texto1v1;
	}

	public String getTextVanish() {
		return Animation.textovanish;
	}
}
