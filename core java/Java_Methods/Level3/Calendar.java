package Java_Methods.Level3;

import java.util.Scanner;

public class Calendar {

    static String[] monthNames = {
        "", "January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"
    };

    static int[] daysInMonth = {
        0, 31, 28, 31, 30, 31, 30,
        31, 31, 30, 31, 30, 31
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter month (1-12): ");
        int month = sc.nextInt();

        System.out.print("Enter year: ");
        int year = sc.nextInt();

        printCalendar(month, year);
    }

    public static void printCalendar(int month, int year) {
        System.out.println("\n    " + monthNames[month] + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        int startDay = getStartDay(month, year);
        int numDays = getNumberOfDays(month, year);

        // First loop to print spaces for days before the 1st
        for (int i = 0; i < startDay; i++) {
            System.out.print("    ");
        }

        for (int day = 1; day <= numDays; day++) {
            System.out.printf("%3d ", day);
            if ((day + startDay) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    public static int getNumberOfDays(int month, int year) {
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        return daysInMonth[month];
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static int getStartDay(int month, int year) {
        if (month < 3) {
            month += 12;
            year--;
        }

        int q = 1;
        int m = month;
        int k = year % 100;
        int j = year / 100;

        int h = (q + 13 * (m + 1) / 5 + k + k / 4 + j / 4 + 5 * j) % 7;

        int dayOfWeek = (h + 6) % 7;
        return dayOfWeek;
    }
}
