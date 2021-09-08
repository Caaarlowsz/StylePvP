package fodastico.user.Managers;

import java.util.Calendar;
import org.bukkit.event.Listener;

public class TimeLeftAPI implements Listener
{
    public static long update;
    
    public static String getRemainingTime(final long seconds) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(seconds);
        int mMonth = calendar.get(2);
        final int Hour = calendar.get(11);
        final int Minute = calendar.get(12);
        if (++mMonth > 12) {
            mMonth = 1;
        }
        return " \u00e1s " + ((String.valueOf(Hour).length() == 1) ? "0" : "") + Hour + ":" + ((String.valueOf(Minute).length() == 1) ? "0" : "") + Minute;
    }
}
