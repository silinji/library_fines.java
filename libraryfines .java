import java.util.Scanner;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class LibraryFineCalculation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // i. Input from user
        System.out.print("Enter Book ID: ");
        String bookID = sc.nextLine();

        System.out.print("Enter Due Date (yyyy-mm-dd): ");
        String dueDateStr = sc.nextLine();
        LocalDate dueDate = LocalDate.parse(dueDateStr);

        System.out.print("Enter Return Date (yyyy-mm-dd): ");
        String returnDateStr = sc.nextLine();
        LocalDate returnDate = LocalDate.parse(returnDateStr);

        // ii. Calculate days overdue
        long daysOverdue = ChronoUnit.DAYS.between(dueDate, returnDate);
        if (daysOverdue < 0) {
            daysOverdue = 0; // no fine if returned before or on due date
        }

        // iii. Determine fine rate using if..else
        int fineRate;
        if (daysOverdue == 0) {
            fineRate = 0;
        } else if (daysOverdue <= 7) {
            fineRate = 20;
        } else if (daysOverdue <= 14) {
            fineRate = 50;
        } else {
            fineRate = 100;
        }

        long fineAmount = daysOverdue * fineRate;

        // iv. Display results
        System.out.println("\n--- Library Fine Details ---");
        System.out.println("Book ID     : " + bookID);
        System.out.println("Due Date    : " + dueDate);
        System.out.println("Return Date : " + returnDate);
        System.out.println("Days Overdue: " + daysOverdue);
        System.out.println("Fine Rate   : Ksh. " + fineRate);
        System.out.println("Fine Amount : Ksh. " + fineAmount);

        sc.close();
    }
}