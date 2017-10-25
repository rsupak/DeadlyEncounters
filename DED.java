//Filename: DED.java
//Rebuild of DEDivided, rebuild of DeadlyEncounters
//Written by Richard Supak
//Written on 24October2017

import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.io.PrintWriter;
import java.util.Random;

public class DED {
  public static void main(String[] args) {

    //set imported methods (Scanner, Random, PrintWriter)
    Scanner keyboard = new Scanner(System.in);
    PrintWriter pw = new PrintWriter(System.out, true);
    Random roll = new Random();

    //create player
    Player playerOne = new Player();

    playerOne.setPlayerStats();

    boolean addXP = true;
    while(addXP == true) {
      playerOne.displayPlayer();
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
