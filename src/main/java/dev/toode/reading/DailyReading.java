package dev.toode.reading;

import org.apache.tomcat.jni.Local;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DailyReading implements Comparable<DailyReading>{
    private String date;
    private int value;

    public DailyReading(String date, int value) {
        this.date = date;
        this.value = value;
    }

    public String getDate() {
        return date;
    }

    public Long getDateTime() {
        DateTimeFormatter df = DateTimeFormat.forPattern("yyyy-MM-dd");
        System.out.println(df.parseMillis(this.date));
        return df.parseMillis(this.date);
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "DailyReading{" +
                "date='" + date + '\'' +
                ", value=" + value +
                '}';
    }

    @Override
    public int compareTo(DailyReading o) {
        return getDateTime().compareTo(o.getDateTime());
    }
}
