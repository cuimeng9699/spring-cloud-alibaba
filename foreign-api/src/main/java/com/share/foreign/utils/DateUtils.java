package com.share.foreign.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.FastDateFormat;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Slf4j
public class DateUtils {
    public static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String DEFAULT_PATTERN_HOURS = "HH:mm";
    public static final String PATTERN1 = "yyyyMMdd";
    public static final String PATTERN2 = "yyyy-MM-dd-HH-mm-ss";
    public static final DateTimeFormatter DEFAULT_FORMATTER = DateTimeFormatter.ofPattern(DEFAULT_PATTERN);
    public static final String YYMMDD_PATTERN = "yyyy-MM-dd";
    public static final String YY_PATTERN = "yyyy";
    public static final String NO_BLANK_PATTERN = "yyyyMMddHHmmss";

    public static final String LOCAL_TIME_START = " 00:00:00";
    public static final String LOCAL_TIME_FINISH = " 23:59:59";

    /**
     * 根据给定的格式把指定时间转换成字符串
     *
     * @param pattern       字符串格式
     * @param localDateTime 时间
     * @return 时间字符串
     */
    public static String formatDatetime(String pattern, LocalDateTime localDateTime) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern(pattern);
        return localDateTime.format(fmt);
    }

    /**
     * 根据给定的格式把指定时间字符串转换成时间 yyyy-MM-dd
     *
     * @param timeStr 时间字符串
     * @return date
     */
    public static Date getDateOnlyByTimeString(String timeStr) {
        if (StringUtils.isBlank(timeStr)) {
            return null;
        }
        SimpleDateFormat formatter = new SimpleDateFormat(YYMMDD_PATTERN);
        ParsePosition pos = new ParsePosition(0);
        Date date = formatter.parse(timeStr, pos);
        return date;
    }

    /**
     * 将固定格式的时间转换成long
     */
    public static Long timeStr2Timestamp(String timeStr, String pattern) {
        FastDateFormat fdf = FastDateFormat.getInstance(pattern);
        try {
            Date date = fdf.parse(timeStr);
            return date.getTime();
        } catch (ParseException e) {
            return 0L;
        }
    }

    public static String formatDatetime(LocalDateTime localDateTime) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern(DEFAULT_PATTERN);
        return localDateTime.format(fmt);
    }

    public static String formatTimeHour(LocalDateTime localDateTime) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern(DEFAULT_PATTERN_HOURS);
        return localDateTime.format(fmt);
    }

    /**
     * 毫秒时间戳 转 LocalDateTime
     *
     * @param timestamp
     * @return
     */
    public static LocalDateTime long2LocalDateTime(Long timestamp) {
        return Instant.ofEpochMilli(timestamp).atZone(ZoneOffset.ofHours(8)).toLocalDateTime();
    }

    public static long localDateTime2Long(LocalDateTime time) {
        return time.toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }

    public static long localDateTime2Second(LocalDateTime time) {
        return time.toInstant(ZoneOffset.of("+8")).getEpochSecond();
    }

    public static LocalDateTime parse(String time) {
        return LocalDateTime.parse(time, DEFAULT_FORMATTER);
    }

    public static String currentTime() {
        return LocalDateTime.now().format(DEFAULT_FORMATTER);
    }

    public static LocalDateTime now() {
        return LocalDateTime.now();
    }


    public static String getDateBeforeMonth(int month) {
        SimpleDateFormat sdf = new SimpleDateFormat(YYMMDD_PATTERN);
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, -month);
        String result = sdf.format(c.getTime());
        return result;
    }

    public static String getDateBeforeDay(int day) {
        SimpleDateFormat sdf = new SimpleDateFormat(YYMMDD_PATTERN);
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, -day);
        String result = sdf.format(c.getTime());
        return result;
    }

    public static String getDateBeforeSec(int sec) {
        SimpleDateFormat sdf = new SimpleDateFormat(DateUtils.DEFAULT_PATTERN);
        Calendar c = Calendar.getInstance();
        c.add(Calendar.SECOND, -sec);
        String result = sdf.format(c.getTime());
        return result;
    }

    // 获取传入时间与当前时间的日期差
    public static long diffDays(LocalDateTime time) {
        Duration duration = Duration.between(time, LocalDateTime.now());
        return duration.toDays();
    }

    public static LocalDateTime getDefaultLocalDateTime() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse("1971-01-01 00:00:00", dateTimeFormatter);
    }

    public static LocalDateTime getDateBeforeDayWithStartTime(int day) {
        LocalDateTime localDateTime = LocalDateTime.now().minusDays(day);
        return localDateTime.with(LocalTime.MIN);
    }

    public static LocalDateTime getDateBeforeDayWithEndTime(int day) {
        LocalDateTime localDateTime = LocalDateTime.now().minusDays(day);
        return localDateTime.with(LocalTime.MAX);
    }

    public static LocalDateTime getDateBeforeSeconds(long second) {
        return LocalDateTime.now().minusSeconds(second);
    }


    public static LocalDateTime yesterdayEnd() {
        LocalDateTime yesterdaySameTime = LocalDateTime.now().minusDays(1);
        return yesterdaySameTime.withHour(23).withMinute(59).withSecond(59);
    }

    public static LocalDateTime yesterdayStart() {
        LocalDateTime yesterdaySameTime = LocalDateTime.now().minusDays(1);
        return yesterdaySameTime.withHour(0).withMinute(0).withSecond(0);
    }

    public static LocalDateTime todayEnd() {
        return LocalDateTime.now().withHour(23).withMinute(59).withSecond(59);
    }

    /**
     * 今天的开始时间
     *
     * @return LocalDateTime
     */
    public static LocalDateTime todayStart() {
        return LocalDateTime.now().withHour(0).withMinute(0).withSecond(0);
    }

    // 获得某天最大时间 2020-02-19 23:59:59
    public static LocalDateTime getEndOfDay(String date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(YYMMDD_PATTERN);
        LocalDate da = LocalDate.parse(date, dateTimeFormatter);
        return da.atTime(LocalTime.MAX);
    }

    /**
     * 获得某天最小时间 2020-02-17 00:00:00
     */
    public static LocalDateTime getStartOfDay(String date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(YYMMDD_PATTERN);
        LocalDate da = LocalDate.parse(date, dateTimeFormatter);
        return da.atTime(LocalTime.MIN);
    }

    public static LocalDateTime string2LocalDateTime(String timeString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(timeString, formatter);
    }

    public static String formatTime(Long ms) {
        Integer ss = 1000;
        Integer mi = ss * 60;
        Integer hh = mi * 60;
        Integer dd = hh * 24;

        Long day = ms / dd;
        Long hour = (ms - day * dd) / hh;
        Long minute = (ms - day * dd - hour * hh) / mi;
        Long second = (ms - day * dd - hour * hh - minute * mi) / ss;
        Long milliSecond = ms - day * dd - hour * hh - minute * mi - second * ss;

        StringBuffer sb = new StringBuffer();
        if (day > 0) {
            sb.append(day + "天");
        }
        if (hour > 0) {
            sb.append(hour + "小时");
        }
        if (minute > 0) {
            sb.append(minute + "分");
        }
        if (second > 0) {
            sb.append(second + "秒");
        }
        if (milliSecond > 0) {
            sb.append(milliSecond + "毫秒");
        }
        return sb.toString();
    }

    /**
     * 秒转年月日
     *
     * @param day
     * @return
     */
    public static String getDayTime(int day) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime dateTime = LocalDateTime.ofEpochSecond(day, 0, ZoneOffset.ofHours(8));
        return dateTime.format(dateTimeFormatter);
    }

    public static String localDateTime2String(LocalDateTime time, String format) {
        return time != null ? time.format(DateTimeFormatter.ofPattern(format)) : "";
    }

    /**
     * 获取俩个日期内所有日期
     *
     * @param begin
     * @param end
     * @return
     */
    public static List<String> getBetweenDate(String begin, String end) {
        SimpleDateFormat format = new SimpleDateFormat(YYMMDD_PATTERN);
        List<String> betweenList = new ArrayList<String>();
        Calendar startDay = Calendar.getInstance();
        startDay.setTime(getDateOnlyByTimeString(begin));
        startDay.add(Calendar.DATE, -1);

        while (true) {
            startDay.add(Calendar.DATE, 1);
            Date newDate = startDay.getTime();
            String newend = format.format(newDate);
            betweenList.add(newend);
            if (end.equals(newend)) {
                break;
            }
        }
        return betweenList;
    }

    /**
     * 获取当前时间之前的时间戳
     *
     * @param day    前几日
     * @param hour   小时
     * @param minute 分钟
     * @param second 秒
     * @return
     */
    public static Long subTimeMillis(Integer day, Integer hour, Integer minute, Integer second) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH) - day, hour, minute, second);
        long timeMillis = calendar.getTime().getTime() / 1000;
        return timeMillis;
    }

    public static LocalDateTime getDateFormat(Date date, String dateFormat) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dateFormat);
        SimpleDateFormat sdf = new SimpleDateFormat(YYMMDD_PATTERN);
        String dateFormatToString = sdf.format(date) + " 00:00:00";
        return LocalDateTime.parse(dateFormatToString, dateTimeFormatter);
    }

    /**
     * 今天的开始时间
     *
     * @return LocalDateTime
     */
    public static LocalDateTime strToLocalDateTime(String time) {
        return LocalDateTime.parse(time, DEFAULT_FORMATTER);
    }

    /**
     * @param seconds 秒
     * @return 字符串的时间数据 参考格式"3时42分28秒","50时42分28秒"
     */
    public static String timeConversion(Long seconds) {
        if (seconds == null){
            return "";
        }
        Long temp = 0L;
        StringBuffer sb = new StringBuffer();
        temp = seconds / 3600;
        if (temp > 0) {
            sb.append(temp + "时");
        }
        temp = seconds % 3600 / 60;
        sb.append(temp + "分");

        temp = seconds % 3600 % 60;
        sb.append(temp + "秒");
        return sb.toString();
    }

    /**
     * 获取两个间隔时间之前差的秒
     *
     * @param start
     * @param end
     * @return
     */
    public static Long getDateSecondsDuration(LocalDateTime start, LocalDateTime end) {
        return Duration.between(start, end).getSeconds();
    }

    /**
     * 获取两个间隔时间之前差的分钟
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return
     */
    public static Long getDateMinutesDuration(LocalDateTime start, LocalDateTime end) {
        return Duration.between(start, end).toMinutes();
    }

    public static LocalDateTime Date2LocalDateTime(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public static String stringToLocalDateTime(String time, String fromFormatter, String resFormatter) {
        // 入参数据格式
        DateTimeFormatter timeDtf = DateTimeFormatter.ofPattern(fromFormatter);
        LocalDateTime localDateTime = LocalDateTime.parse(time, timeDtf);
        return localDateTime2String(localDateTime, resFormatter);
    }

    public static LocalDateTime stringToLocalDateTime(String time, String fromFormatter) {
        // 入参数据格式
        DateTimeFormatter timeDtf = DateTimeFormatter.ofPattern(fromFormatter);
        LocalDateTime localDateTime = LocalDateTime.parse(time, timeDtf);
        return localDateTime;
    }

    /**
     * 获取两个时间的日期差
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public static long diffDays(LocalDateTime startTime, LocalDateTime endTime) {
        Duration duration = Duration.between(startTime, endTime);
        return duration.toDays();
    }

    /**
     * 两日期是否同一天
     *
     * @param tmpDate
     * @param toLocalDate
     * @return
     */
    public static boolean isOnSameDay(LocalDate tmpDate, LocalDate toLocalDate) {
        return tmpDate.equals(toLocalDate);
    }

    /**
     * 获取当天开始时间
     *
     * @param plusDays
     * @return
     */
    public static LocalDateTime getDateDayStart(LocalDateTime plusDays) {
        return LocalDateTime.of(plusDays.toLocalDate(), LocalTime.of(0, 0, 0));
    }

    /**
     * 获取当天结束时间
     *
     * @param plusDays
     * @return
     */
    public static LocalDateTime getDateDayEnd(LocalDateTime plusDays) {
        return LocalDateTime.of(plusDays.toLocalDate(), LocalTime.of(23, 59, 59));
    }
    /**
     * 把时间字符串变为毫秒值
     * @param dateTime
     * @return
     */
    public static long dateToLong(String dateTime){
        Date startDate = null;
        try {
            startDate = new SimpleDateFormat(DEFAULT_PATTERN).parse(dateTime);
        } catch (ParseException e) {
            log.error("isEffectiveDateByNowTime error", e);
        }
        return startDate.getTime();
    }
    public static String  getCreateDateByTime(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(YYMMDD_PATTERN);
        return simpleDateFormat.format(date);
    }
}

