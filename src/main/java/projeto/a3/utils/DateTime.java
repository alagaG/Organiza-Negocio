/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto.a3.utils;

import java.util.regex.MatchResult;
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
    
    public DateTime(String datetime, boolean invert) {
        Pattern pattern = Pattern.compile("([\\d]+)-([\\d]+)-([\\d]+) ([\\d]+):([\\d]+):([\\d]+)");
        Matcher matcher = pattern.matcher(datetime);
        MatchResult result = matcher.toMatchResult();
        matcher.find();
        this.year = Integer.parseInt(matcher.group(invert ? 3 : 1));
        this.month = Integer.parseInt(matcher.group(2));
        this.day = Integer.parseInt(matcher.group(invert ? 1 : 3));
        this.hour = Integer.parseInt(matcher.group(4));
        this.minute = Integer.parseInt(matcher.group(5));
        this.second = Integer.parseInt(matcher.group(6));
    }
    
    public DateTime(String datetime) {
        this(datetime, false);
    }
    
    public String toMySQL() {
        return String.format("%04d-%02d-%02d %02d:%02d:%02d", year, day, month, hour, minute, second);
    }
    
    public String toString() {
        return String.format("%02d/%02d/%04d %02d:%02d:%02d", day, month, year, hour, minute, second);
    }
    
}
