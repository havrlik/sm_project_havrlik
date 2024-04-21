package main.java.project.havrlik.soft.smlib.other;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import main.java.project.havrlik.soft.smlib.SmLib;
import main.java.project.havrlik.soft.smlib.message.MessageList;
import main.java.project.havrlik.soft.smlib.message.MessageType;

/**
 * Date and time-related data: ISO 8601, https://en.wikipedia.org/wiki/ISO_8601
 *
 */


public class TimePerform {
	
	protected SmLib smLib;
	
    public final SimpleDateFormat sdf_date_withDots = new SimpleDateFormat("dd.MM.yyyy");
    public final SimpleDateFormat sdf_date_withoutSeparators_descending = new SimpleDateFormat("yyyyMMdd");
    public final SimpleDateFormat sdf_date_withDash_descending = new SimpleDateFormat("yyyy-MM-dd");
    public final SimpleDateFormat sdf_date_year = new SimpleDateFormat("yyyy");
    public final SimpleDateFormat sdf_date_month = new SimpleDateFormat("MM");
    public final SimpleDateFormat sdf_date_day = new SimpleDateFormat("dd");
    public final SimpleDateFormat sdf_date_monthYear_withDot = new SimpleDateFormat("MM.yyyy");
    public final SimpleDateFormat sdf_date_yearMonth_withDash_descending = new SimpleDateFormat("yyyy-MM");
    public final SimpleDateFormat sdf_date_yearMonth_withoutSeparators_descending = new SimpleDateFormat("yyyyMM");
    public final SimpleDateFormat sdf_date_monthYear_withSlash = new SimpleDateFormat("MM/yyyy");
    
    public final SimpleDateFormat sdf_time_withSeparators = new SimpleDateFormat("HH:mm:ss");
    public final SimpleDateFormat sdf_time_withSeparators_withMills = new SimpleDateFormat("HH:mm:ss.SSS");
    public final SimpleDateFormat sdf_time_withoutSeparator = new SimpleDateFormat("HHmmss");
    public final SimpleDateFormat sdf_time_withoutSeparator_withMills = new SimpleDateFormat("HHmmssSSS");
    public final SimpleDateFormat sdf_time_hours = new SimpleDateFormat("HH");
    public final SimpleDateFormat sdf_time_minutes = new SimpleDateFormat("mm");
    public final SimpleDateFormat sdf_time_seconds = new SimpleDateFormat("ss");
    public final SimpleDateFormat sdf_time_milliseconds = new SimpleDateFormat("SSS");
    public final SimpleDateFormat sdf_time_hoursMinutes_withSeparators = new SimpleDateFormat("HH:mm");
    public final SimpleDateFormat sdf_time_hoursMinutes_withoutSeparators = new SimpleDateFormat("HHmm");

    public final SimpleDateFormat sdf_dateTime_withSeparators_twoSpaces = new SimpleDateFormat("dd.MM.yyyy  HH:mm:ss");
    public final SimpleDateFormat sdf_dateTime_withSeparators_twoSpaces_withMills = new SimpleDateFormat("dd.MM.yyyy  HH:mm:ss.SSS");
    public final SimpleDateFormat sdf_dateTime_withSeparators_twoSpaces_descending = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
    public final SimpleDateFormat sdf_dateTime_withSeparators_twoSpaces_withMills_descending = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss.SSS");
    public final SimpleDateFormat sdf_dateTime_withoutSeparators_twoSpaces_descending = new SimpleDateFormat("yyyyMMdd  HHmmss");
    public final SimpleDateFormat sdf_dateTime_withoutSeparators_dash_descending = new SimpleDateFormat("yyyyMMdd-HHmmss");
    public final SimpleDateFormat sdf_dateTime_withoutSeparators_apostrophe_descending = new SimpleDateFormat("yyyyMMdd''HHmmss");
    public final SimpleDateFormat sdf_dateTime_withoutSeparators_twoSpaces_withMills_descending = new SimpleDateFormat("yyyyMMdd  HHmmssSSS");
    public final SimpleDateFormat sdf_dateTime_withoutSeparators_dash_withMills_descending = new SimpleDateFormat("yyyyMMdd-HHmmssSSS");
	
	public static final String CHARS_twoSpaces = "  ";
	
	
	public TimePerform(SmLib smLib) {
		this.smLib = smLib;
		
		call_constructorContinues();
	}
	
	
	protected void call_constructorContinues() {
		// Recommended to disable this method by overriding by empty method in your sub class 
		// and call method bellow at the end of your constructor.
		constructorContinues();
	}
	
	
	protected void constructorContinues() {
		constructor3();
		constructor4_sub();
		constructor5();
		constructor6_sub();
	}
	
	
	protected void constructor3() {  }
	protected void constructor4_sub() {  }
	protected void constructor5() {  }
	protected void constructor6_sub() {  }
	
	
	public void setup1() {  }
	public void setup2_sub() {  }
	public void setup3() {  }
	public void setup4_sub() {  }
	
	
	// Returns String.
	public String get_str_sdf_actualDate_withDots() { return sdf_date_withDots.format(Calendar.getInstance().getTime()); }
	public String get_str_sdf_actualDate_withoutSeparators_descending() { return sdf_date_withoutSeparators_descending.format(Calendar.getInstance().getTime()); }
	public String get_str_sdf_actualDate_withDash_descending() { return sdf_date_withDash_descending.format(Calendar.getInstance().getTime()); }
	public String get_str_sdf_actualDate_year() { return sdf_date_year.format(Calendar.getInstance().getTime()); }
	public String get_str_sdf_actualDate_month() { return sdf_date_month.format(Calendar.getInstance().getTime()); }
	public String get_str_sdf_actualDate_day() { return sdf_date_day.format(Calendar.getInstance().getTime()); }
	public String get_str_sdf_actualDate_monthYear_withDot() { return sdf_date_monthYear_withDot.format(Calendar.getInstance().getTime()); }
	public String get_str_sdf_actualDate_yearMonth_withDash_descending() { return sdf_date_yearMonth_withDash_descending.format(Calendar.getInstance().getTime()); }
	public String get_str_sdf_actualDate_yearMonth_withoutSeparators_descending() { return sdf_date_yearMonth_withoutSeparators_descending.format(Calendar.getInstance().getTime()); }
	public String get_str_sdf_actualDate_monthYear_withSlash() { return sdf_date_monthYear_withSlash.format(Calendar.getInstance().getTime()); }
	
	public String get_str_sdf_actualTime_withSeparators() { return sdf_time_withSeparators.format(Calendar.getInstance().getTime()); }
	public String get_str_sdf_actualTime_withSeparators_withMills() { return sdf_time_withSeparators_withMills.format(Calendar.getInstance().getTime()); }
	public String get_str_sdf_actualTime_withoutSeparator() { return sdf_time_withoutSeparator.format(Calendar.getInstance().getTime()); }
	public String get_str_sdf_actualTime_withoutSeparator_withMills() { return sdf_time_withoutSeparator_withMills.format(Calendar.getInstance().getTime()); }
	public String get_str_sdf_actualTime_hours() { return sdf_time_hours.format(Calendar.getInstance().getTime()); }
	public String get_str_sdf_actualTime_minutes() { return sdf_time_minutes.format(Calendar.getInstance().getTime()); }
	public String get_str_sdf_actualTime_seconds() { return sdf_time_seconds.format(Calendar.getInstance().getTime()); }
	public String get_str_sdf_actualTime_milliseconds() { return sdf_time_milliseconds.format(Calendar.getInstance().getTime()); }
	public String get_str_sdf_actualTime_hoursMinutes_withSeparators() { return sdf_time_hoursMinutes_withSeparators.format(Calendar.getInstance().getTime()); }
	public String get_str_sdf_actualTime_hoursMinutes_withoutSeparators() { return sdf_time_hoursMinutes_withoutSeparators.format(Calendar.getInstance().getTime()); }
	
	public String get_str_sdf_actualDateTime_withSeparators_twoSpaces() { return sdf_dateTime_withSeparators_twoSpaces.format(Calendar.getInstance().getTime()); }
	public String get_str_sdf_actualDateTime_withSeparators_twoSpaces_withMills() { return sdf_dateTime_withSeparators_twoSpaces_withMills.format(Calendar.getInstance().getTime()); }
	public String get_str_sdf_actualDateTime_withSeparators_twoSpaces_descending() { return sdf_dateTime_withSeparators_twoSpaces_descending.format(Calendar.getInstance().getTime()); }
	public String get_str_sdf_actualDateTime_withSeparators_twoSpaces_withMills_descending() { return sdf_dateTime_withSeparators_twoSpaces_withMills_descending.format(Calendar.getInstance().getTime()); }
	public String get_str_sdf_actualDateTime_withoutSeparators_twoSpaces_descending() { return sdf_dateTime_withoutSeparators_twoSpaces_descending.format(Calendar.getInstance().getTime()); }
	public String get_str_sdf_actualDateTime_withoutSeparators_dash_descending() { return sdf_dateTime_withoutSeparators_dash_descending.format(Calendar.getInstance().getTime()); }
	public String get_str_sdf_actualDateTime_withoutSeparators_apostrophe_descending() { return sdf_dateTime_withoutSeparators_apostrophe_descending.format(Calendar.getInstance().getTime()); }
	public String get_str_sdf_actualDateTime_withoutSeparators_twoSpaces_withMills_descending() { return sdf_dateTime_withoutSeparators_twoSpaces_withMills_descending.format(Calendar.getInstance().getTime()); }
	public String get_str_sdf_actualDateTime_withoutSeparators_dash_withMills_descending() { return sdf_dateTime_withoutSeparators_dash_withMills_descending.format(Calendar.getInstance().getTime()); }
	
	
	// Returns int.
	public int get_int_sdf_actualDate_withoutSeparators_descending() { return Integer.parseInt(sdf_date_withoutSeparators_descending.format(Calendar.getInstance().getTime())); }
	public int get_int_sdf_actualDate_year() { return Integer.parseInt(sdf_date_year.format(Calendar.getInstance().getTime())); }
	public int get_int_sdf_actualDate_month() { return Integer.parseInt(sdf_date_month.format(Calendar.getInstance().getTime())); }
	public int get_int_sdf_actualDate_day() { return Integer.parseInt(sdf_date_day.format(Calendar.getInstance().getTime())); }
	public int get_int_sdf_actualDate_yearMonth_withoutSeparators_descending() { return Integer.parseInt(sdf_date_yearMonth_withoutSeparators_descending.format(Calendar.getInstance().getTime())); }

	public int get_int_sdf_actualTime_withoutSeparator() { return Integer.parseInt(sdf_time_withoutSeparator.format(Calendar.getInstance().getTime())); }
	public int get_int_sdf_actualTime_withoutSeparator_withMills() { return Integer.parseInt(sdf_time_withoutSeparator_withMills.format(Calendar.getInstance().getTime())); }
	public int get_int_sdf_actualTime_hours() { return Integer.parseInt(sdf_time_hours.format(Calendar.getInstance().getTime())); }
	public int get_int_sdf_actualTime_minutes() { return Integer.parseInt(sdf_time_minutes.format(Calendar.getInstance().getTime())); }
	public int get_int_sdf_actualTime_seconds() { return Integer.parseInt(sdf_time_seconds.format(Calendar.getInstance().getTime())); }
	public int get_int_sdf_actualTime_milliseconds() { return Integer.parseInt(sdf_time_milliseconds.format(Calendar.getInstance().getTime())); }
	public int get_int_sdf_actualTime_hoursMinutes_withoutSeparators() { return Integer.parseInt(sdf_time_hoursMinutes_withoutSeparators.format(Calendar.getInstance().getTime())); }
	
	
	// Date and time
	
	
	// Date and time data type format editing.
	
	/**
	 * int date_int = e.g. 20050123;
	 */
	public static String return_date_string(int date_int) {
		if (date_int < 1 || date_int > 99_999_999) {
			return null;
		}
		
		String date_string1 = Integer.toString(date_int);
		String date_string2 = "";
		
		for (byte b1 = (byte) (date_string1.length()); b1 < 8; b1++) {
			date_string2 += "0";
		}
		date_string2 += date_string1;
		
		return date_string2;
	}
	
	
	/**
	 * int date_int = e.g. '20050123' -> '23.01.2005'.
	 */
	public static String return_date_format_cs(int date_int) {
		String date_string1 = return_date_string(date_int);
		
		String date_string2 = "" + 
				date_string1.charAt(6) + date_string1.charAt(7) + "." + 
				date_string1.charAt(4) + date_string1.charAt(5) + "." + 
				date_string1.charAt(0) + date_string1.charAt(1) + date_string1.charAt(2) + date_string1.charAt(3);
		
		return date_string2;
	}
	
	
	/**
	 * int time_int = e.g. 3000;
	 */
	public static String return_time_string(int time_int) {
		if (time_int < 0 || time_int >= 235960) {
			return null;
		}
		String time_string1 = Integer.toString(time_int);
		String time_string2 = "";
		
		for (byte b1 = (byte) (time_string1.length()); b1 < 6; b1++) {
			time_string2 += "0";
		}
		time_string2 += time_string1;
		
		return time_string2;
	}
	
	
	public static String return_time_string(double time_double) {
		/*
		 * double time_double = e.g. 3000.123;
		 * 
		 * 0.000_05
		 * 9.999_1
		 * 9.999_95
		 * 
		 */
		// TODO 105959.9999996 to 110000.000 (not 105960.000)
		// TODO HHmmssSSS or HHmmss.SSS?
		time_double += 0.000_05;  // If number had computed, ensere to not be e.g. 102959.9999996 but 103000.000.
		if (time_double < 0 || time_double > 235959.999_9) {
			return null;
		}
		String time_string1 = Double.toString(time_double);
		String time_string2 = "";
		byte dotAtposition = 0;
		
		// Determine where is dot.
		for (; dotAtposition < (byte) time_string1.length(); dotAtposition++) {
			if (time_string1.charAt(dotAtposition) == 46) {  // 46 = dot '.'.
				break;
			}
		}
		// Add zeros.
		for (byte b2 = dotAtposition; b2 < 6; b2++) {
			time_string2 += "0";
		}
		// Add correct digits of time_string1.
		// Decimal places is always more than then 3, because is added correction number.
		for (byte b3 = 0; b3 <= dotAtposition + 3; b3++) {
			time_string2 += time_string1.charAt(b3);
		}
		
		return time_string2;
	}
	
	
	public static String return_dateTime_string(int date_int, int time_int) {
		String date_string = return_date_string(date_int);
		String time_string = return_time_string(time_int);
		if (date_string == null || time_string == null) {
			return null;
		}
		
		String dateTime_string = "";
		dateTime_string = date_string;
		dateTime_string += CHARS_twoSpaces + time_string;
		
		return dateTime_string;
	}
	
	
	public static String return_dateTime_string(int date_int, double time_double) {
		String date_string = return_date_string(date_int);
		String time_string = return_time_string(time_double);
		if (date_string == null || time_string == null) {
			return null;
		}
		
		String dateTime_string = "";
		dateTime_string = date_string;
		dateTime_string += CHARS_twoSpaces + time_string;
		
		return dateTime_string;
	}
	
	
	public static String return_dateTime_string(String date_string, String time_string) {
		if (date_string == null || date_string.length() != 8 || time_string == null || (time_string.length() != 6 && time_string.length() != 10)) {
			return null;
		}
		
		String dateTime_string = "";
		dateTime_string = date_string;
		dateTime_string += CHARS_twoSpaces + time_string;
		
		if (!is_validDateOrDateTime(dateTime_string)) {
			return null;
		}
		return dateTime_string;
	}
	
	
	public static String return_dateFromDateTime(String dateTime) {
		if (dateTime == null) {
			return null;
		}
		
		String date = "";
		
		for (int i1 = 0; i1 < 8; i1++) {
			date += dateTime.charAt(i1);
		}
		
		return date;
	}
	
	
	public static String return_timeFromDateTime(String dateTime) {
		if (dateTime == null) {
			return null;
		}
		
		String time = "";
		boolean hasSpaces = false;
		
		for (int i1 = 0; i1 < dateTime.length(); i1++) {
			if (dateTime.charAt(i1) == ' ') {
				hasSpaces = true;
			}
			else if (hasSpaces) {
				time += dateTime.charAt(i1);
			}
		}
		
		return time;
	}
	
	
	/**
	 * Actually only formats:
	 * yyyyMMdd, yyyyMMdd  HHmmss.
	 * 
	 * todo: need to add more checks.
	 */
	public static boolean is_validDateOrDateTime(String dateTime) {
		if (dateTime == null || (dateTime.length() != 8 && dateTime.length() != 16 && dateTime.length() != 20)) {
			return false;
		}
		String date = "";
		String time = "";
		
		if (dateTime.length() == 8) {
			date = dateTime;
			time = null;
		}
		else if (dateTime.length() == 16 || dateTime.length() == 20) {
			boolean hasSpace = false;
			for (int i1 = 0; i1 < dateTime.length(); i1++) {
				if (dateTime.charAt(i1) == ' ') {
					hasSpace = true;
				}
				else if (!hasSpace) {
					date += dateTime.charAt(i1);
				}
				else {
					time += dateTime.charAt(i1);
				}
			}
		}
		else {
			return false;
		}
		
		// Check length and is numbers.
		if (date == null || date.length() != 8 || !ValuePerform.is_stringNumber_int(date)) {
			return false;
		}
		if (time != null && (time.length() != 6 && time.length() != 10 || !ValuePerform.is_stringNumber_double(time))) {
			return false;
		}
		
		return true;
	}
	
	
	// Date and time changing.
	
	/**
	 * String date : yyyyMMdd ; HHmmss ; ...
	 * movingTimeType : D - day ; M - month ; m - minute ; ...
	 * int movingTimeLength
	 * Actually only date - no time.
	 * Actually only days.
	 */
	public String return_datePlusTimeLength(String dateTime, TimeType movingTimeType, int movingTimeLength) {
//		if (movingTimeType.equals("m")) {
//			System.out.println(this.getClass().getSimpleName() + "      " + dateTime + "  " + movingTimeType + "  " + movingTimeLength);  // Debug
//		}
		String newDate = "";
		
		try {
			// Rather exception?
//			if ((dateTime.length() != 6 && dateTime.length() != 8 && dateTime.length() != 16) || movingTimeType.length() > 2) {
//				return null;
//			}
			
			if (dateTime.length() == 6) {
				SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
				Date da = sdf.parse(dateTime);  // Date need exception handle: catch (ParseException e) .
				Calendar cal = Calendar.getInstance();
				cal.setTime(da);
				
				if (movingTimeType == TimeType.s) {
					cal.add(Calendar.SECOND, movingTimeLength);
				}
				else if (movingTimeType == TimeType.m) {
					cal.add(Calendar.MINUTE, movingTimeLength);
				}
				else if (movingTimeType == TimeType.h) {
					cal.add(Calendar.HOUR_OF_DAY, movingTimeLength);
				}
				
				newDate = sdf.format(cal.getTime());
			}
			else if (dateTime.length() == 8) {
				if (movingTimeType == TimeType.D) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
					Date da = sdf.parse(dateTime);  // Date need exception handle: catch (ParseException e) .
					Calendar cal = Calendar.getInstance();
					cal.setTime(da);
					cal.add(Calendar.DAY_OF_MONTH, movingTimeLength);
					newDate = sdf.format(cal.getTime());
				}
			}
			else if (dateTime.length() == 16) {  // 16 = 8 x date + 2 x space + 6 x time.
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd  HHmmss");
				Date da = sdf.parse(dateTime);  // Date need exception handle: catch (ParseException e) .
				Calendar cal = Calendar.getInstance();
				cal.setTime(da);
				
				if (movingTimeType == TimeType.s) {
					cal.add(Calendar.SECOND, movingTimeLength);
				}
				else if (movingTimeType == TimeType.m) {
					cal.add(Calendar.MINUTE, movingTimeLength);
				}
				else if (movingTimeType == TimeType.h) {
					cal.add(Calendar.HOUR_OF_DAY, movingTimeLength);
				}
				
				newDate = sdf.format(cal.getTime());
			}
			else if (dateTime.length() == 20) {  // 20 = 8 x date + 2 x space + 10 x time.
				return null;
			}
		}
		catch (ParseException ex) {
			smLib.messageReceiver.message(MessageType.N1_FATAL, 
					MessageList.assemblePlacement(this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName()), 
					"ParseException:  " + ex.toString());
			return null;
		}
		
		return newDate;
	}
	
	
	public int return_datePlusTimeLength(int dateOrTime, TimeType movingTimeType, int movingTimeLength) {
		String dateOrTimeStr = Integer.toString(dateOrTime);
		int dateOrTimeStr_length = dateOrTimeStr.length();
		if (dateOrTimeStr_length < 6) {
			for (int i1 = 0; i1 < (6 - dateOrTimeStr_length); i1++) {
				dateOrTimeStr = "0" + dateOrTimeStr;
			}
		}
		
		return Integer.parseInt(return_datePlusTimeLength(dateOrTimeStr, movingTimeType, movingTimeLength));
	}
	
	
	public int return_differenceBetweenDates_days(String date1_string, String date2_string) {
		// Date format: 'yyyyMMdd'.
		if (date1_string.length() != 8 || date2_string.length() != 8) {
			smLib.messageReceiver.message(MessageType.N1_FATAL, 
					MessageList.assemblePlacement(this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName()), 
					"Not valid received values.");
			return 0;
		}
		
		int differenceDays = 0;
		try {
			Date date1 = sdf_date_withoutSeparators_descending.parse(date1_string);
			Date date2 = sdf_date_withoutSeparators_descending.parse(date2_string);
			long diff = date2.getTime() - date1.getTime();
			differenceDays = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		}
		catch (ParseException ex) {
			smLib.messageReceiver.message(MessageType.N1_FATAL, 
					MessageList.assemblePlacement(this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName()), 
					"ParseException:  " + ex.toString());
			return 0;
		}
		
		return differenceDays;
	}
	
	
	public static int epochToDate(long timeStamp_nanos) {
		Instant instant = Instant.ofEpochSecond(timeStamp_nanos / 1_000);
		Date date = Date.from(instant);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String format = formatter.format(date);
		
//		System.out.println("test epochToDate() - with time:      " + (new SimpleDateFormat("yyyyMMdd-HHmmss")).format(date));  // Debug. With time.
		
		return Integer.parseInt(format);
	}
	
	
	public static String epochToDateTime(long timeStamp_nanos) {  // Not tested.
		Instant instant = Instant.ofEpochSecond(timeStamp_nanos / 1_000);
		Date dateTime = Date.from(instant);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd-HHmmss");
		
		return formatter.format(dateTime);
	}

}
