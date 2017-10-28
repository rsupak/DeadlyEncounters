//Filename: DED.java
//Rebuild of DEDivided, rebuild of DeadlyEncounters
//Written by Richard Supak
//Written on 24October2017

import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Random;

public class DED {
  public static void main(String[] args) {

    //set imported methods (Scanner, Random, PrintWriter)
    Scanner keyboard = new Scanner(System.in);
    PrintWriter pw = new PrintWriter(System.out, true);
    Random roll = new Random();

    Player playerOne = new Player();
    Menus menus = new Menus();
    XPGenerator gen = new XPGenerator();
    // gen.generateXP(playerOne);
    playerOne.setPlayer();
    menus.initializeMenus(playerOne);
    // //create player
    // public Player playerOne = new Player();

    //
    // boolean addXP = true;
    // while(addXP == true) {
    //   pw.println("Enter XP gained:");
    //   int exp = keyboard.nextInt();
    //   playerOne.setExp(exp);
    //   pw.println("Continue? (y/n)");
    //   String answer = keyboard.next();
    //   if (answer.equals("n")) {
    //     addXP = false;
    //   } else {
    //     pw.println("You need " + (playerOne.getLevelUp() - playerOne.getExp()) + " to level up!");
    //   }
    // }
    // playerOne.displayPlayer();


    // Main menu
    // // create enemy
    // boolean createEnemy = true;
    // while(createEnemy == true) {
    //   Enemy enemy = new Enemy();
    //   //enemy.setEnemy();
    //   enemy.setEnemyName();
    //   enemy.setLevel(playerOne.getLevel() * 0.875);
    //   enemy.setEnemyStats();
    //   enemy.displayEnemy();
    //   pw.println("Roll Again?(y/n)");
    //   String answer = keyboard.next();
    //   if(answer.equals("n")) {
    //     createEnemy = false;
    //   }
    // }
  }
}
