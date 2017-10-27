//Filename: Enemy.java
//sub of DED.java
//Written by Richard Supak
//Written on 24October2017

import java.util.Random;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.HashMap;

public class Enemy {

  private String enemyName;
  private int healthPoints, magicPoints, attackPower, defensePower, level, exp;
  private double multiplier = 0;

  Random roll = new Random();
  Scanner keyboard = new Scanner(System.in);
  PrintWriter pw = new PrintWriter(System.out, true);

  //initialize EnemySprite
  // public void setEnemy() {
  //   this.setEnemyStats();
  // }

  public void baseStats() {
    switch(enemyName) {
      case "Slime":
        healthPoints = 5; magicPoints = 0; attackPower = 2; defensePower = 1;
        exp = 3;
        break;
      case "Skeleton":
        healthPoints = 10; magicPoints = 0; attackPower = 3; defensePower = 2;
        exp = 5;
        break;
      case "Imp":
        healthPoints = 3; magicPoints = 5; attackPower = 2; defensePower = 1;
        exp = 10;
        break;
      case "Mage":
        healthPoints = 5; magicPoints = 10; attackPower = 2; defensePower = 3;
        exp = 15;
        break;
      case "Black Knight":
        healthPoints = 12; magicPoints = 0; attackPower = 4; defensePower = 4;
        exp = 20;
        break;
      case "Dragon":
        healthPoints = 20; magicPoints = 20; attackPower = 10; defensePower = 10;
        exp = 50;
        break;
    }
  }

  //Enemy setters
  public void setEnemyName() {
    HashMap<Integer, String> enemyList = new HashMap<>();
      enemyList.put(1, "Slime");
      enemyList.put(2, "Skeleton");
      enemyList.put(3, "Imp");
      enemyList.put(4, "Mage");
      enemyList.put(5, "Black Knight");
      enemyList.put(6, "Dragon");
    enemyName = enemyList.get(1 + (int)(Math.random() * 6));
  }

  public void setLevel(double lvl) {
    level = (int)lvl;
  }

  public void setEnemyStats() {
    this.baseStats();
    this.setMultiplier();
    this.updateStats();
  }

  public void setMultiplier() {
    if(level <= 10) {
      multiplier = getLevel() * (1 + getLevel()/200);
    } else {
      multiplier = getLevel() * (1 + getLevel()/100);
    }
  }


  //Enemy getters
  public String getEnemyName() {return enemyName;}
  public int getLevel() {return level;}
  public int getHP() {return healthPoints;}
  public int getMP() {return magicPoints;}
  public int getAttkPow() {return attackPower;}
  public int getDefPow() {return defensePower;}
  public double getMultiplier() {return multiplier;}

  //Enemy updaters
  public void updateStats() {
    healthPoints = (int)(getHP() * getMultiplier());
    magicPoints = (int)(getMP() * getMultiplier());
    attackPower = (int)(getAttkPow() * getMultiplier());
    defensePower = (int)(getDefPow() * getMultiplier());
  }

  public void displayEnemy() {
    pw.println("You have encountered a " + enemyName + "!");
    pw.println("Level: " + getLevel());
    pw.println("HP: " + getHP());
    pw.println("MP: " + getMP());
    pw.println("ATT: " + getAttkPow());
    pw.println("DEF: " + getDefPow());
  }

}
