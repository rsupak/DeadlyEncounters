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
  private int healthPoints, magicPoints, attackPower, defensePower, strength, intelligence, vitality, agility, exp, level, levelUp, updateStatCheck;

  //initialize Player
  public void setPlayer() {
    this.setPlayerName();
    this.baseStats();
    this.displayPlayer();
  }

  public void setPlayerName() {
    System.out.print("Enter your name >> ");
    this.playerName = keyboard.next();
    pw.println("");
    pw.println("Welcome " + playerName + "!");
  }

  public void baseStats() {
    level = 1;
    healthPoints = 40;
    magicPoints = 15;
    attackPower = 10;
    defensePower = 10;
    levelUp = 28;
    strength = 10;
    vitality = 10;
    intelligence = 10;
    agility = 10;
  }

  //End Initialization

  //Player setters
  public void setStrength() {
    updateStatCheck = 1 + roll.nextInt(4);
    if(updateStatCheck % 4 == 1) {
      strength += 1;
    }
  }
  public void setIntelligence() {
    updateStatCheck = 1 + roll.nextInt(4);
    if(updateStatCheck % 4 == 2) {
      intelligence += 1;
    }
  }
  public void setVitality() {
    updateStatCheck = 1 + roll.nextInt(4);
    if(updateStatCheck % 4 == 3) {
      vitality += 1;
    }
  }
  public void setAgility() {
    updateStatCheck = 1 + roll.nextInt(4);
    if(updateStatCheck % 4 == 0) {
      agility += 1;
    }
  }
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
  public int getAgility() {return agility;}
  public int getExp() {return exp;}
  public int getLevel() {return level;}
  public int getLevelUp() {return levelUp;}
  public int toNextLevel() {return getLevelUp() - getExp();}


  //Player updaters
  public void updateHP() {
    healthPoints += (int)(level + (vitality * (100 + roll.nextInt(51))/100));
  }

  public void updateMP() {
    magicPoints += Math.pow(intelligence,2)/32;
  }

  public void updateAttk() {
    attackPower += strength/4 * agility/16;
  }

  public void updateDef() {
    defensePower += vitality/2 * agility/32;
  }

  public void updatePlayer() {
    while(exp >= levelUp) {
      if(exp >= levelUp) {
        exp -= levelUp;
        levelUp = (int)(Math.floor(-0.00003 * Math.pow(level, 6) + 0.00387 * Math.pow(level, 5) - 0.17588 * Math.pow(level, 4) + 3.60646 * Math.pow(level, 3) - 18.64023 * Math.pow(level, 2) + 116.75063 * level));
        this.setStrength();
        this.setVitality();
        this.setIntelligence();
        this.setAgility();
        this.updateHP();
        this.updateMP();
        this.updateAttk();
        this.updateDef();
        level++;
        pw.println("Congratulations, you have progressed to Level " + level + "!");
      } else {
        levelUp = (int)(Math.floor(-0.00003 * Math.pow(level, 6) + 0.00387 * Math.pow(level, 5) - 0.17588 * Math.pow(level, 4) + 3.60646 * Math.pow(level, 3) - 18.64023 * Math.pow(level, 2) + 116.75063 * level));
      }
      this.displayPlayer();
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
    pw.println("Str:" + strength + " Int:" + intelligence + " Vit:" + vitality + " Agl:" + agility);
  }

}
