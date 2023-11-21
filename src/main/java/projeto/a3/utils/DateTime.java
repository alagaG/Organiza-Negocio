/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto.a3.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author 82323467
 */
public class DateTime {
    
    public int day;
    public int month;
    public int year;
    
    public int hour;
    public int minute;
    public int second;
    
    public DateTime(int day, int month, int year, int hour, int minute, int second) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }
    
    public DateTime(String datetime) {
        Pattern pattern = Pattern.compile("([\\d]+)-([\\d]+)-([\\d]+)T([\\d]+):([\\d]+):([\\d]+)Z");
        Matcher matcher = pattern.matcher(datetime);
        this.year = Integer.parseInt(matcher.group(0));
        this.month = Integer.parseInt(matcher.group(1));
        this.day = Integer.parseInt(matcher.group(2));
        this.hour = Integer.parseInt(matcher.group(3));
        this.minute = Integer.parseInt(matcher.group(4));
        this.second = Integer.parseInt(matcher.group(5));
    }
    
    public String toString() {
        return String.format("%d-%d-%d %d:%d:%d", year, month, day, hour, minute, second);
    }
    
}
