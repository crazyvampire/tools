
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 日期工具类
 * @version 1.0
 * @created 2018年1月26日
 */
public class DateUtil {

    private DateUtil() {
    }

    public final static String SDF_LONG = "yyyy-MM-dd HH:mm:ss,SSS";
    public final static String SDF_STANDARD = "yyyy-MM-dd HH:mm:ss";
    public final static String SDF_FORMAT = "yyyy-MM-dd HH:mm";
    public final static String SDF_SHORT = "yyyy-MM-dd";
    public final static String SDF_MSEC = "yyyyMMddHHmmssSSS";
    public final static String SDF_SEC = "yyyyMMddHHmmss";

    private final static ReentrantLock lock = new ReentrantLock();

    private static Map<String, ThreadLocal<SimpleDateFormat>> sdfMap = new HashMap<String, ThreadLocal<SimpleDateFormat>>();

    private static SimpleDateFormat getSdf(final String pattern) {
        ThreadLocal<SimpleDateFormat> tl = sdfMap.get(pattern);
        if (tl == null) {
            lock.lock();
            try {
                tl = new ThreadLocal<SimpleDateFormat>() {
                    @Override
                    protected SimpleDateFormat initialValue() {
                        return new SimpleDateFormat(pattern);
                    }
                };
                sdfMap.put(pattern, tl);
            } finally {
                lock.unlock();
            }
        }
        return tl.get();
    }

    public static String format(Date date, String pattern) {
        return getSdf(pattern).format(date);
    }

    public static Date parse(String dateString, String pattern) throws ParseException {
        return getSdf(pattern).parse(dateString);
    }

    public static Date addMinutes(Date date, int minutes) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, minutes);
        date = calendar.getTime();
        return date;
    }

    public static Date addSecends(Date date, int secends) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.SECOND, secends);
        date = calendar.getTime();
        return date;
    }

    public static Date addDays(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, days);
        date = calendar.getTime();
        return date;
    }

    public static long diffDate(Date start, Date end) {
        return (end.getTime() - start.getTime()) / 1000;
    }

    public static void main(String[] args) throws ParseException {
        Date startTime = DateUtil.parse(DateUtil.format(new Date(), DateUtil.SDF_SHORT), DateUtil.SDF_SHORT);
        Date endTime = DateUtil.addSecends(DateUtil.addDays(startTime, 3), -1);

        System.out.println(startTime);
        System.out.println(endTime);
    }
}