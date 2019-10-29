package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class Utils {
	public static java.util.Date strToDate(String str) throws ParseException {
		if (str != null && !str.equals("") ) {			
				SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");		
				java.util.Date data;
					data = formatoData.parse(str);
					
					Calendar cal = Calendar.getInstance();
					cal.setTime(data);
					Calendar now = Calendar.getInstance();
					cal.setTimeZone(TimeZone.getTimeZone("America/Sao_Paulo"));
					now.setTimeZone(TimeZone.getTimeZone("America/Sao_Paulo"));
					cal.set(Calendar.HOUR_OF_DAY, now.get(Calendar.HOUR_OF_DAY));
					cal.set(Calendar.MINUTE, now.get(Calendar.MINUTE));
					cal.set(Calendar.SECOND, now.get(Calendar.SECOND));
					
					return cal.getTime();
				
		}
		return null;
	}
}
