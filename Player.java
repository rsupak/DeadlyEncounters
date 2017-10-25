//Filename: Player.java
//sub of DED.java
//Written by Richard Supak
//Written on 24October2017

import java.util.Random;
import java.util.Scanner;
import java.io.PrintWriter;

public class Player {

    private String playerName;
    private int healthPoints, magicPoints, attackPower, defensePower, strength = 5, intelligence = 5, vitality = 5, stamina = 5, exp = 0, level = 0, levelUp = 50;

    Random roll = new Random();
    Scanner keyboard = new Scanner(System.in);
    PrintWriter pw = new PrintWriter(System.out, true);


    public void setPlayerName() {
      System.out.print("Enter your name >> ");
      this.playerName = keyboard.next();
      pw.println("");
      pw.println("Welcome " + playerName + "!");
    }
    public String getPlayerName() {
      return playerName;
    }

    public void setHP() {healthPoints = getVitality() * 3 + 50;}
    public int getHP() {return healthPoints;}

    public void setMP() {magicPoints = getIntelligence() * 3 + 50;}
    public int getMP() {return magicPoints;}

    public void setAttkPow() {attackPower = getStrength() * 2 + 15;}
    public int getAttkPow() {return attackPower;}

    public void setDefPow() {defensePower = getStamina() * 2 + 15;}
    public int getDefPow() {return defensePower;}

    public void setStrength(int str) {strength += str;}
    public int getStrength() {return strength;}

    public void setIntelligence(int intel) {intelligence += intel;}
    public int getIntelligence() {return intelligence;}

    public void setVitality(int vit) {vitality += vit;}
    public int getVitality() {return vitality;}

    public void setStamina(int sta) {stamina += sta;}
    public int getStamina() {return stamina;}

    public void setExp(int xp) {
      exp += xp;
      if(exp >= levelUp) {
        this.setLevel();
      }
    }
    public int getExp() {return exp;}

    public void setLevel() {
      int upgrades = 0;
      if(level == 0) {
        ++level;
        upgrades = 10;
      }
      if(exp >= levelUp) {
        ++level;
        exp -= levelUp;
        levelUp *= 1.25;
        upgrades = roll.nextInt(3) + 1;
      }
      while(upgrades > 0) {
        pw.println("You have " + upgrades + " Stat points to allocate:");
        pw.println("Modify your character:");
        --upgrades;
        pw.println("Choose a stat to update:");
        pw.println("(1: Vitality)\t\tVIT: " + vitality);
        pw.println("(2: Intelligence)\tINT: " + intelligence);
        pw.println("(3: Strength)\t\tSTR: " + strength);
        pw.println("(4: Stamina)\t\tSTA: " + stamina);
        int stat = keyboard.nextInt();

        switch(stat) {
          case 1:
            vitality += 1;
            break;
          case 2:
            intelligence += 1;
            break;
          case 3:
            strength += 1;
            break;
          case 4:
            stamina += 1;
            break;
        }
      }
    }
    public int getLevel() {return level;}

    public void setPlayerStats() {
      this.setPlayerName();
      this.setVitality(vitality);
      this.setIntelligence(intelligence);
      this.setStrength(strength);
      this.setStamina(stamina);
      this.setLevel();
      this.setHP();
      this.setMP();
      this.setAttkPow();
      this.setDefPow();
    }

    public void displayPlayer() {
      pw.println(playerName);
      pw.println("Level: " + getLevel());
      pw.println("HP: " + getHP());
      pw.println("MP: " + getMP());
      pw.println("ATT: " + getAttkPow());
      pw.println("DEF: " + getDefPow());
      pw.println("You need " + (levelUp - exp) + " to level up!");
    }


}
