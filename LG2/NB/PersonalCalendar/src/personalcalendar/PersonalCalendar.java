package personalcalendar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonalCalendar {

    private static int year;
    private static int day;
    private static boolean unique;
    private static String[] dayInitials = new String[]{"SUN", "MON", "TUE", "WED",
        "THU", "FRI", "SAT"};
    private static String[] monthNames = new String[]{"January", "February", "March",
        "April", "May", "June", "July",
        "August", "September", "October", "November", "December"};
    private static ArrayList[] months;
    private static Scanner scanner = new Scanner(System.in);
    private static StringBuilder builder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        startUserCapture();
        printToFile(calculateGregorianCalendar());
        calculateJulianCalendar();
    }

    private static void startUserCapture() {
        System.out.println("\tPersonal Calendar - Welcome\n");
        System.out.print("Input the year: ");
        year = scanner.nextInt();
        System.out.print("Input the first day as a number representing the day [0 - SUN /1 - MON...]: ");
day = scanner.nextInt() % 7;
        System.out.print("Do you want to show only this year? [true/false] ");
        unique = scanner.nextBoolean();
    }

    private static StringBuilder calculateGregorianCalendar() {
        builder.setLength(0);
        int _year = year;
        int _month = 1;
        int _dayLimit = 1;
        int _day = 1;
        int _weekEnd = 7 - day;
        int _finalYear = unique ? _year : LocalDate.now().getYear() <= _year
                ? _year : LocalDate.now().getYear();
        for (; _year <= _finalYear; _year++) {
            builder.append(String.format("\r\n\t\t• %d\r\n", _year));
            for (; _month <= 12; _month++) {
                builder.append(" → ").append(monthNames[_month
                        - 1]).append("\r\n");
                if (_month == 2) {
                    if (_year % 4 == 0) {
                        _dayLimit = 29;
                    } else {
                        _dayLimit = 28;
                    }
                } else if (_month < 8) {
                    if (_month % 2 == 0) {
                        _dayLimit = 30;
                    } else {
                        _dayLimit = 31;
                    }
                } else {
                    if (_month % 2 == 0) {
                        _dayLimit = 31;
                    } else {
                        _dayLimit = 30;
                    }
                }
                for (int i = 0; i < 7; i++) {
                    builder.append(String.format("%5s",
                            dayInitials[i]));
                }
                builder.append("\r\n");
                for (int i = 0; i < day; i++) {
                    builder.append(String.format("%5s", ""));
                }
                for (; _day <= _dayLimit; _day++) {
                    builder.append(String.format("%5d", _day));
                    for (int i = 0; i <= 5; i++) {
                        if (i * 7 + _weekEnd == _day) {
                            builder.append("\r\n");
                        }
                    }
                }
                _day--;
                builder.append("\r\n");
                day = (_day % 7 + day) % 7;
                _weekEnd = 7 - day;
                _day = 1;
            }
            _month = 1;
        }
        return builder;
    }

    private static StringBuilder calculateJulianCalendar() {
        builder.setLength(0);
        int _year = year;
        int _day = 1;
        int _weekEnd = 7 - day;
        int _finalYear = unique ? _year : LocalDate.now().getYear() <= _year
                ? _year : LocalDate.now().getYear();
        for (; _year <= _finalYear; _year++) {
            int _dayLimit = _year % 4 == 0 ? 366 : 365;
            System.out.printf("\n\t\t • %d\n", _year);
            for (int i = 0; i < 7; i++) {
                System.out.printf("%5s", dayInitials[i]);
            }
            System.out.println();
            for (int i = 0; i < day; i++) {
                System.out.printf("%5s", "");
            }
            for (; _day <= _dayLimit; _day++) {
                System.out.printf("%5d", _day);
                for (int i = 0; i <= 53; i++) {
                    if (i * 7 + _weekEnd == _day) {
                        System.out.println();
                    }
                }
            }
            _day--;
            day = (_day % 7 + day) % 7;
            _weekEnd = 7 - day;
            _day = 1;
        }
        return builder;
    }

    private static void printToFile(StringBuilder builder) throws
            FileNotFoundException, IOException {
        String fileName = "gregorianCalendar.txt";
        File f = new File(fileName);
        FileOutputStream fos = new FileOutputStream(f);
        fos.write(builder.toString().getBytes());
    }
}
