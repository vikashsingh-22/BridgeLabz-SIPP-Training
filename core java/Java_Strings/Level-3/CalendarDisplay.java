import java.util.Scanner;

public class CalendarDisplay {

    static String[] months = {
        "January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"
    };

    static int[] daysInMonth = {
        31, 28, 31, 30, 31, 30,
        31, 31, 30, 31, 30, 31
    };

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static int getDaysInMonth(int month, int year) {
        if (month == 1 && isLeapYear(year)) {
            return 29;
        }
        return daysInMonth[month];
    }

    public static int getStartDay(int day, int month, int year) {
        int y0 = year - (14 - month) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = month + 12 * ((14 - month) / 12) - 2;
        return (day + x + (31 * m0) / 12) % 7;
    }

    public static void displayCalendar(int month, int year) {
        int startDay = getStartDay(1, month, year);
        int totalDays = getDaysInMonth(month, year);

        System.out.println("     " + months[month] + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        for (int i = 0; i < startDay; i++) {
            System.out.print("    ");
        }

        for (int day = 1; day <= totalDays; day++) {
            System.out.printf("%3d ", day);
            if ((day + startDay) % 7 == 0 || day == totalDays) {
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int month = scanner.nextInt();
        int year = scanner.nextInt();

        month = month - 1; 
        displayCalendar(month, year);
    }
}
