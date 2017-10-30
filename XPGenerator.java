import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Random;

public class XPGenerator {

  public PrintWriter pw = new PrintWriter(System.out, true);
  public Scanner keyboard = new Scanner(System.in);
  public Player playerOne;

  public XPGenerator(Player p) {
    playerOne = p;
  }

  public void generateXP() {
    boolean addXP = true;
    while(addXP == true) {
      pw.println("Enter XP gained:");
      int exp = keyboard.nextInt();
      playerOne.setExp(exp);
      pw.println("Continue? (y/n)");
      String answer = keyboard.next();
      if (answer.equals("n")) {
        addXP = false;
      }
    }
  }
}
