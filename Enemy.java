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
    private int healthPoints, magicPoints, attackPower, defensePower, level = 0, multiplier = 0;

    Random roll = new Random();
    Scanner keyboard = new Scanner(System.in);
    PrintWriter pw = new PrintWriter(System.out, true);


    public void setEnemyName() {
      HashMap<Integer, String> enemyList = new HashMap<>();
        enemyList.put(1, "Slime");
        enemyList.put(2, "Skeleton");
        enemyList.put(3, "Imp");
        enemyList.put(4, "Mage");
        enemyList.put(5, "Black Knight");
        enemyList.put(6, "Dragon");
      enemyName = enemyList.get(1/* + (int)(Math.random() * 6)*/);
    }

    public String getEnemyName() {
      return enemyName;
    }

    public void setStats() {
      switch(enemyName) {
        case "Slime": multiplier = 3; break;
        case "Skeleton": multiplier = 5; break;
        case "Imp": multiplier = 6; break;
        case "Mage": multiplier = 7; break;
        case "Black Knight": multiplier = 11; break;
        case "Dragon": multiplier = 13; break;
      }
      healthPoints = level + (int)(Math.pow(multiplier, level/2));
      magicPoints = level + (int)(Math.pow(multiplier, level/3));
      attackPower = level + (int)(Math.pow(multiplier, level/(4 + roll.nextInt(3))));
      defensePower = level + (int)(Math.pow(multiplier, level/(4 + roll.nextInt(3))));
    }
    public int getHP() {return healthPoints;}
    public int getMP() {return magicPoints;}
    public int getAttkPow() {return attackPower;}
    public int getDefPow() {return defensePower;}

    // public void setMP() {magicPoints = getIntelligence() * 3 + 50;}
    // public int getMP() {return magicPoints;}
    //
    // public void setAttkPow() {attackPower = getStrength() * 2 + 5;}
    // public int getAttkPow() {return attackPower;}
    //
    // public void setDefPow() {defensePower = getStamina() * 2 + 5;}
    // public int getDefPow() {return defensePower;}
    //
    public void setLevel(int lvl) {
      level = lvl;
    }
    public int getLevel() {return level;}

    // public void setPlayerStats() {
    //   this.setPlayerName();
    //   this.updatePlayerStats();
    // }

    // public void updatePlayerStats() {
    //   this.setLevel();
    //   this.setHP();
    //   this.setMP();
    //   this.setAttkPow();
    //   this.setDefPow();
    // }

    public void displayEnemy() {
      pw.println("You have encountered a " + enemyName + "!");
      pw.println("Level: " + getLevel());
      pw.println("HP: " + getHP());
      pw.println("MP: " + getMP());
      pw.println("ATT: " + getAttkPow());
      pw.println("DEF: " + getDefPow());
      // pw.println("You need " + (levelUp - exp) + " to level up!");
    }


}
