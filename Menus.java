//Filename: Menus.java
//sub DEDivided.java

import java.io.PrintWriter;
import java.util.Scanner;

public class Menus {
  public PrintWriter pw = new PrintWriter(System.out, true);
  public Scanner keyboard = new Scanner(System.in);
  public Player playerOne;
  public Enemy enemy = new Enemy();
  private int choice;
  XPGenerator gen = new XPGenerator();

  private boolean traveling, gameRunning;

  public void initializeMenus(Player p, Enemy e) {
    playerOne = p;
    enemy = e;
    // playerOne.setPlayer();
    gameRunning = true;
    while(gameRunning == true) {
      traveling = true;
      while(traveling == true) {
        this.mainMenu();
      }
    }
  }

  public void mainMenu() {
    pw.println("");
    pw.println("Main Menu:");
    pw.println("(1: Move)");
    pw.println("(2: Item)");
    pw.println("(3: Map)");
    pw.println("(4: Status)");
    pw.println("(5: XP Generator)");
    pw.println("(6: Approach Enemy)");
    pw.println("(0: Quit)");
    System.out.print(">> ");
    choice = keyboard.nextInt();
    switch(choice) {
      case 1:
        this.travelMenu();
        break;
      case 2:
        this.itemMenu();
        break;
      case 3: break;
      case 4:
        playerOne.displayPlayer();
        break;
      case 5:
        gen.generateXP(playerOne);
        break;
      case 6:
        enemy.setEnemy(playerOne);
        break;
      case 0:
        pw.println("Sorry to see you go, traveler...");
        traveling = false;
        gameRunning = false;
        break;
    }
  }

  public void travelMenu() {
    pw.println("Choose a direction to travel: ");
    pw.println("(1: North)");
    pw.println("(2: East)");
    pw.println("(3: South)");
    pw.println("(4: West)");
    System.out.print(">> ");
    choice = keyboard.nextInt();
  }

  public void combatMenu() {
    pw.println("Choose your action >> ");
    pw.println("(1: Attack)");
    pw.println("(2: Defend)");
    pw.println("(3: Magic)");
    pw.println("(4: Item)");
    pw.println("(5: Flee)");
    System.out.print(">> ");
    choice = keyboard.nextInt();
  }

  public void magicMenu() {
    pw.println("Choose a magic to use: ");
    pw.println("(1: Arrow)");
    pw.println("(2: Fireball)");
    pw.println("(3: Sleep)");
    pw.println("(4: Cure)");
    System.out.print(">> ");
    choice = keyboard.nextInt();
  }

  public void itemMenu() {
    pw.println("Choose an item to use:");
    pw.println("(1: Health Potion)");
    pw.println("(2: Magic Potion)");
    System.out.print(">> ");
    choice = keyboard.nextInt();
  }
}
