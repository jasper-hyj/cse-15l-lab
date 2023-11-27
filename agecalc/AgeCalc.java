import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.Month;

class AgeCalc {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String s = in.nextLine();

    String[] parts = s.split("/");
    int year = Integer.parseInt(parts[0]);
    Month month = Month.of(Integer.parseInt(parts[1]));
    int day = Integer.parseInt(parts[2]);
    LocalDateTime now = LocalDateTime.now();

    LocalDateTime provided = LocalDateTime.of(year, month, day, 0, 0);
    long difference = provided.until(now, ChronoUnit.YEARS);

    if(provided.isAfter(now)) { System.out.println("You don't exist yet and you might be a time traveler."); }
    else { System.out.println("You're " + difference + " yrs old."); }
  }
}
