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
    Enemy enemy = new Enemy();
    playerOne.setPlayer();

    menus.initializeMenus(playerOne, enemy);


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
