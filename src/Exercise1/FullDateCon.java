package Exercise1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class FullDateCon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try (scanner) {
            System.out.print("Enter a short date (YYYY-MM-DD): ");
            String shortDate = scanner.nextLine();
            SimpleDateFormat sdfInput = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdfInput.parse(shortDate);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);

            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH) + 1;
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            String monthName = getMonthName(month);

            DateFormat dayOfWeekFormat = new SimpleDateFormat("EEEE");
            String dayOfWeek = dayOfWeekFormat.format(date);

            System.out.printf("Full date representation: %s %d, %d (%s)%n", monthName, day, year, dayOfWeek);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please enter date in the format YYYY-MM-DD.");
        }
    }
    private static String getMonthName(int month) {
        String[] monthNames = {
                "January", "February", "March", "April",
                "May", "June", "July", "August",
                "September", "October", "November", "December"
        };

        if (month >= 1 && month <= 12) {
            return monthNames[month - 1];
        } else {
            return "Invalid Month";
        }
    }
}

