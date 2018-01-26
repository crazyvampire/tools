
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeUtil {
    public final static String DATE_FORMAT = "yyyy-MM-dd";
    public final static String DATE_FORMAT_HOUR = "yyyy-MM-dd HH:00:00";
    public final static String DATE_FORMAT_HOUR_SHORT = "yyyy-MM-dd HH:mm";
    public final static String DATE_FORMAT_CN = "yyyy年MM月dd日";
    public final static String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public final static String TIME_FORMAT_CN = "yyyy年MM月dd日 HH:mm:ss";
    public final static String MONTH_FORMAT = "yyyy-MM";
    public final static String MONTH_FORMAT_NUM = "yyyyMM";
    public final static String DAY_FORMAT = "yyyyMMdd";
    public final static String TIME_HOUR = "k";
    public final static String DAY_SIMPLE_FORMAT = "dd";
    public final static String DAY_SIMPLE_FORMAT_D = "d";


    public static java.util.Date getCurrDate() {
        return new java.util.Date();
    }

    public static java.sql.Timestamp getCurrTimestamp() {
        return new java.sql.Timestamp(System.currentTimeMillis());
    }

    public static java.sql.Timestamp getFormatTimestamp(String currDate) {
        Date date = getFormatDateTime(currDate);
        return new java.sql.Timestamp(date.getTime());
    }

    public static String getFormatDate(java.util.Date currDate) {
        return getFormatDate(currDate, DATE_FORMAT);
    }

    public static Date getFormatDateToDate(java.util.Date currDate) {
        return getFormatDate(getFormatDate(currDate));
    }

    public static String getFormatDate_CN(java.util.Date currDate) {
        return getFormatDate(currDate, DATE_FORMAT_CN);
    }

    public static Date getFormatDateToDate_CN(java.util.Date currDate) {
        return getFormatDate_CN(getFormatDate_CN(currDate));
    }

    public static Date getFormatDate(String currDate) {
        return getFormatDate(currDate, DATE_FORMAT);
    }

    public static Date getFormatDate_CN(String currDate) {
        return getFormatDate(currDate, DATE_FORMAT_CN);
    }

    public static String getFormatDate(java.util.Date currDate, String format) {
        SimpleDateFormat dtFormatdB = null;
        try {
            dtFormatdB = new SimpleDateFormat(format);
            String str = dtFormatdB.format(currDate);
            if (str.equals("24"))
                str = "0";
            return str;
        } catch (Exception e) {
            dtFormatdB = new SimpleDateFormat(DATE_FORMAT);
            return dtFormatdB.format(currDate);
        }
    }

    public static String getFormatDateTime(java.util.Date currDate) {
        return getFormatDateTime(currDate, TIME_FORMAT);
    }

    public static String getFormatDateHour(java.util.Date currDate) {
        return getFormatDateTime(currDate, DATE_FORMAT_HOUR);
    }

    public static Date getFormatDateHour(String currDate) {
        return getFormatDateTime(currDate, DATE_FORMAT_HOUR);
    }

    public static Date getFormatDateTimeToTime(java.util.Date currDate) {
        return getFormatDateTime(getFormatDateTime(currDate));
    }

    public static Date getFormatDateTime(String currDate) {
        return getFormatDateTime(currDate, TIME_FORMAT);
    }

    public static String getFormatDateTime_CN(java.util.Date currDate) {
        return getFormatDateTime(currDate, TIME_FORMAT_CN);
    }

    public static Date getFormatDateTimeToTime_CN(java.util.Date currDate) {
        return getFormatDateTime_CN(getFormatDateTime_CN(currDate));
    }

    public static Date getFormatDateTime_CN(String currDate) {
        return getFormatDateTime(currDate, TIME_FORMAT_CN);
    }

    public static String getFormatDateTime(java.util.Date currDate,
                                           String format) {
        SimpleDateFormat dtFormatdB = null;
        try {
            dtFormatdB = new SimpleDateFormat(format);
            return dtFormatdB.format(currDate);
        } catch (Exception e) {
            dtFormatdB = new SimpleDateFormat(TIME_FORMAT);
            return dtFormatdB.format(currDate);
        }
    }

    public static Date getFormatDate(String currDate, String format) {
        SimpleDateFormat dtFormatdB = null;
        try {
            dtFormatdB = new SimpleDateFormat(format);
            return dtFormatdB.parse(currDate);
        } catch (Exception e) {
            dtFormatdB = new SimpleDateFormat(DATE_FORMAT);
            try {
                return dtFormatdB.parse(currDate);
            } catch (Exception ex) {
            }
        }
        return null;
    }
    public static Date getFormatDay(String currDate) {
        SimpleDateFormat dtFormatdB = null;
        try {
            dtFormatdB = new SimpleDateFormat(DAY_FORMAT);
            return dtFormatdB.parse(currDate);
        } catch (Exception e) {

        }
        return null;
    }
    public static Date getFormatDateTime(String currDate, String format) {
        SimpleDateFormat dtFormatdB = null;
        try {
            dtFormatdB = new SimpleDateFormat(format);
            return dtFormatdB.parse(currDate);
        } catch (Exception e) {
            dtFormatdB = new SimpleDateFormat(TIME_FORMAT);
            try {
                return dtFormatdB.parse(currDate);
            } catch (Exception ex) {
            }
        }
        return null;
    }

    public static String getCurrDateStr() {
        return getFormatDate(getCurrDate());
    }

    public static String getCurrDateTimeStr() {
        return getFormatDateTime(getCurrDate());
    }

    public static String getCurrDateStr_CN() {
        return getFormatDate(getCurrDate(), DATE_FORMAT_CN);
    }

    public static String getCurrDateTimeStr_CN() {
        return getFormatDateTime(getCurrDate(), TIME_FORMAT_CN);
    }

    public static Date getDateBeforeOrAfter(int iDate) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, iDate);
        return cal.getTime();
    }

    public static Date getDateBeforeOrAfter(Date curDate, int iDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(curDate);
        cal.add(Calendar.DAY_OF_MONTH, iDate);
        return cal.getTime();
    }

    public static String getFormatMonth(java.util.Date currDate) {
        return getFormatDate(currDate, MONTH_FORMAT);
    }

    public static Integer getFormatMonthNumber(java.util.Date currDate) {
        return Integer.parseInt(getFormatDate(currDate, MONTH_FORMAT_NUM));
    }

    public static String getFormatDay(java.util.Date currDate) {
        return getFormatDate(currDate, DAY_FORMAT);
    }

    public static String getFirstDayOfMonth() {
        Calendar cal = Calendar.getInstance();
        int firstDay = cal.getMinimum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, firstDay);
        return getFormatDate(cal.getTime(), DATE_FORMAT);
    }

    public static String getFirstDayOfMonth(Date currDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(currDate);
        int firstDay = cal.getMinimum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, firstDay);
        return getFormatDate(cal.getTime(), DATE_FORMAT);
    }

    public  static  Date getLastDayOfMonth()   {
        Calendar cal = Calendar.getInstance();
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        return cal.getTime();
    }

    public  static  Date getLastDayOfMonth(Date currDate)   {
        Calendar cal = Calendar.getInstance();
        cal.setTime(currDate);
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        return cal.getTime();
    }

    public static Date getDateBeforeOrAfterHours(Date curDate, int iHour) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(curDate);
        cal.add(Calendar.HOUR_OF_DAY, iHour);
        return cal.getTime();
    }

    public static int getIntervalSeconds(Date endDate) {
        return getIntervalSeconds(endDate, new Date());
    }

    public static int getIntervalSeconds(Date endDate, Date startDate) {
        Calendar end = Calendar.getInstance();
        end.setTime(endDate);

        Calendar start = Calendar.getInstance();
        start.setTime(startDate);

        return (int) ((end.getTimeInMillis() - start.getTimeInMillis()) / 1000);
    }

    public static String getMinuteFromSeconds(int seconds) {
        if (seconds == 0) {
            return "0分";
        } else {
            int minute = seconds / 60;
            int second = seconds % 60;
            if (minute > 0)
                return minute + "分" + second + "秒";
            else
                return second + "秒";
        }
    }

    public static int getDiffDaysFrom2Date(Date begin, Date end) {
        Date d_beign = getFormatDate(getFormatDate(begin));
        Date d_end = getFormatDate(getFormatDate(end));
        ;

        int days = 0;
        Calendar c_b = Calendar.getInstance();
        Calendar c_e = Calendar.getInstance();

        c_b.setTime(d_beign);
        c_e.setTime(d_end);

        while (c_b.before(c_e)) {
            days++;
            c_b.add(Calendar.DAY_OF_MONTH, 1);
        }

        return days;
    }

    /**
     * 显示时间，如果与当前时间差别小于一天，则自动用**秒(分，小时)前，如果大于一天则用format规定的格式显示
     *
     * @author wxy
     * @param ctime
     *            时间
     * @param format
     *            格式 格式描述:例如:yyyy-MM-dd yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String showTime(Date ctime, String format) {
        String r = "";
        if (ctime == null)
            return r;
        if (format == null)
            format = "yyyy-MM-dd HH:mm";

        long nowtimelong = System.currentTimeMillis();
        long ctimelong = ctime.getTime();
        long result = Math.abs(nowtimelong - ctimelong);

        if (result < 60000)// 一分钟内
        {
            long seconds = result / 1000;
            r = seconds + "秒钟前";
        } else if (result >= 60000 && result < 3600000)// 一小时内
        {
            long seconds = result / 60000;
            r = seconds + "分钟前";
        } else if (result >= 3600000 && result < 86400000)// 一天内
        {
            long seconds = result / 3600000;
            r = seconds + "小时前";
        } else// 日期格式
        {
            r = getFormatDate(ctime, format);
        }
        return r;
    }


    public static boolean countDown(String time,Long step){
        Long now = System.currentTimeMillis();
        Long pass = Long.parseLong(time);
        Long diff = (pass - now) / 1000;
        if(diff < 0){
            return false;
        }else {
            return true;
        }
    }
    public static int getTimesnight(){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 24);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return (int) (cal.getTimeInMillis()/1000);
    }