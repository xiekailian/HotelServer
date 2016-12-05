package data.dataHelper.jdbc;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
/**
 * 改变calendar为timestamp
 * @author xiamutian
 *
 */
public class ChangerHelper {
	public  static  Timestamp changeToTimestamp(Calendar cal){
		if(cal!=null){
			java.util.Date date = cal.getTime();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time = sdf.format(date);
			java.sql.Timestamp result = java.sql.Timestamp.valueOf(time);
			return result;}
		else{
			return null;
		}
	}
	public static java.sql.Date changeToSqlDate(Calendar cal){
		if(cal!=null){
			java.util.Date date = cal.getTime();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String birth = sdf.format(date);
			java.sql.Date result = java.sql.Date.valueOf(birth);
			return result;
		}
		else{
			return null;
		}
	}
	public static Calendar changeToCalendar(Timestamp time){
		if(time!=null){
			Calendar result = Calendar.getInstance();
			result.setTime(time);
			return result;}
		else{
		return null;
		}
	}
	public static Calendar changeToCalendar(java.sql.Date date){
		if(date!=null){
			Calendar result = Calendar.getInstance();
			result.setTime(date);
			return result;}
		else{
		return null;
		}
	}
	
	
}