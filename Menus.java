//Filename: Menus.java
//sub DEDivided.java

import java.io.PrintWriter;

public class Menus {
  PrintWriter pw = new PrintWriter(System.out, true);

  public void mainMenu() {
    pw.println("Main Menu:");
    pw.println("(1: Move)");
    pw.println("(2: Item)");
    pw.println("(3: Map)");
    pw.println("(0: Quit)");
    System.out.print(">> ");
  }

  public void travelMenu() {
    pw.println("Choose a direction to travel: ");
    pw.println("(1: North)");
    pw.println("(2: East)");
    pw.println("(3: South)");
    pw.println("(4: West)");
    System.out.print(">> ");
  }

  public void combatMenu() {
    pw.println("Choose your action >> ");
    pw.println("(1: Attack)");
    pw.println("(2: Defend)");
    pw.println("(3: Magic)");
    pw.println("(4: Item)");
    pw.println("(5: Flee)");
    System.out.print(">> ");
  }

  public void magicMenu() {
    pw.println("Choose a magic to use: ");
    pw.println("(1: Arrow)");
    pw.println("(2: Fireball)");
    pw.println("(3: Sleep)");
    pw.println("(4: Cure)");
    System.out.print(">> ");
  }

  public void itemMenu() {
    pw.println("Choose an item to use:");
    pw.println("(1: Health Potion)");
    pw.println("(2: Magic Potion)");
    System.out.print(">> ");
  }
}
