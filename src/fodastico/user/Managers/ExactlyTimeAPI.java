package fodastico.user.Managers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class ExactlyTimeAPI {
	public static SimpleDateFormat sdf;
	public static Calendar ca;

	static {
		ExactlyTimeAPI.sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		ExactlyTimeAPI.ca = new GregorianCalendar(TimeZone.getTimeZone("America/Sao_Paulo"));
	}

	public static String getExactlyTime() {
		final TimeZone tz = TimeZone.getTimeZone("America/Sao_Paulo");
		final Calendar calendar = Calendar.getInstance(tz);
		final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
		return sdf.format(calendar.getTime());
	}
}
