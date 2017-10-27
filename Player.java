//Filename: Player.java
//sub of DED.java
//Written by Richard Supak
//Written on 24October2017

import java.util.Random;
import java.util.Scanner;
import java.io.PrintWriter;

public class Player {
  Random roll = new Random();
  Scanner keyboard = new Scanner(System.in);
  PrintWriter pw = new PrintWriter(System.out, true);
  private String playerName;
  private int healthPoints, magicPoints, attackPower, defensePower, strength = 2, intelligence = 2, vitality = 2, stamina = 2, exp, level, levelUp, upgrades = 0;

  //initialize Player
  public void setPlayer() {
    this.setPlayerName();
    boolean rollCheck = true;
    while(rollCheck == true) {
      this.baseStats();
      this.displayPlayer();
      pw.println("Keep roll? (1. yes)/(2. no)");
      int rollAgain = keyboard.nextInt();
      switch(rollAgain) {
        case 1:
          rollCheck = false;
          pw.println("You need " + (levelUp - exp) + " to level up!");
          break;
        case 2:
          break;
      }
    }
  }

  public void setPlayerName() {
    System.out.print("Enter your name >> ");
    this.playerName = keyboard.next();
    pw.println("");
    pw.println("Welcome " + playerName + "!");
  }

  public void baseStats() {
    level = 1;
    levelUp = 28;
    healthPoints =
      ((1+roll.nextInt(10))+(1+roll.nextInt(10))+(1+roll.nextInt(10)))/2+level*(getVitality()+1)-1;
    magicPoints =
      ((1+roll.nextInt(10))+(1+roll.nextInt(10))+(1+roll.nextInt(10)))/2+level*(getIntelligence()+1)-1;
    attackPower =
      ((1+roll.nextInt(10))+(1+roll.nextInt(10))+(1+roll.nextInt(10)))/2+level*(getStrength()+1)-1;
    defensePower =
      ((1+roll.nextInt(10))+(1+roll.nextInt(10))+(1+roll.nextInt(10)))/2+level*(getStamina()+1)-1;
  }

  //End Initialization

  //Player setters
  public void setStrength(int str) {strength += str;}
  public void setIntelligence(int intel) {intelligence += intel;}
  public void setVitality(int vit) {vitality += vit;}
  public void setStamina(int sta) {stamina += sta;}
  public void setExp(int xp) {
    exp += xp;
    if(exp >= levelUp) {
      this.updatePlayer();
    }
  }

  //Player getters
  public String getPlayerName() {return playerName;}
  public int getHP() {return healthPoints;}
  public int getMP() {return magicPoints;}
  public int getAttkPow() {return attackPower;}
  public int getDefPow() {return defensePower;}
  public int getStrength() {return strength;}
  public int getIntelligence() {return intelligence;}
  public int getVitality() {return vitality;}
  public int getStamina() {return stamina;}
  public int getExp() {return exp;}
  public int getLevel() {return level;}
  public int getLevelUp() {return levelUp;}


  //Player updaters
  public void updateHP() {healthPoints = getHP() + ((1+roll.nextInt(10))/4+level+(getVitality()+1));}

  public void updateMP() {magicPoints = getMP() + ((1+roll.nextInt(10))/4+level+(getIntelligence()+1));}

  public void updateAttk() {attackPower = getAttkPow() + ((1+roll.nextInt(10))/4+level+(getStrength()+1));}

  public void updateDef() {defensePower = getDefPow() + ((1+roll.nextInt(10))/4+level+(getStamina()+1));}

  public void updatePlayer() {
    while(exp >= levelUp || level == 1) {
      int x = level;
      if(exp >= levelUp) {
        exp -= levelUp;
        levelUp = (int)(Math.floor(-0.00003 * Math.pow(level, 6) + 0.00387 * Math.pow(level, 5) - 0.17588 * Math.pow(level, 4) + 3.60646 * Math.pow(level, 3) - 18.64023 * Math.pow(level, 2) + 116.75063 * level));
        upgrades += roll.nextInt(3) + 1;
        level++;
        pw.println("Congratulations, you have progressed to Level " + level + "!");
      } else {
        levelUp = (int)(Math.floor(-0.00003 * Math.pow(level, 6) + 0.00387 * Math.pow(level, 5) - 0.17588 * Math.pow(level, 4) + 3.60646 * Math.pow(level, 3) - 18.64023 * Math.pow(level, 2) + 116.75063 * level));
      }
      while(upgrades > 0) {
        pw.println("You have " + upgrades + " Stat points to allocate.");
        pw.println("Modify your character >>");
        pw.println("Choose a stat to update >>");
        pw.println("(1: Vitality)\t\tVIT: " + vitality);
        pw.println("(2: Intelligence)\tINT: " + intelligence);
        pw.println("(3: Strength)\t\tSTR: " + strength);
        pw.println("(4: Stamina)\t\tSTA: " + stamina);
        System.out.print(">> ");
        int stat = keyboard.nextInt();
        switch(stat) {
          case 1:
            vitality += 1;
            this.updateHP();
            break;
          case 2:
            intelligence += 1;
            this.updateMP();
            break;
          case 3:
            strength += 1;
            this.updateAttk();
            break;
          case 4:
            stamina += 1;
            this.updateDef();
            break;
        }
        --upgrades;
        this.displayPlayer();
      }
    }
    pw.println("You need " + (levelUp - exp) + " to level up!");
  }

  public void displayPlayer() {
    pw.println(playerName);
    pw.println("Level: " + getLevel());
    pw.println("HP: " + getHP());
    pw.println("MP: " + getMP());
    pw.println("ATT: " + getAttkPow());
    pw.println("DEF: " + getDefPow());
    // pw.println("You need " + (levelUp - exp) + " to level up!");
  }

}
