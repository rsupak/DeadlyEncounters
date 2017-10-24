//Filename: PlayerSprite.java
//Written by Richard Supak
//Written on 21October2017

import java.util.Random;
import java.util.Scanner;
import java.io.PrintWriter;

public class Player {

    private String playerName;
    private int healthPoints, magicPoints, attackPower, defensePower, strength = 5, intelligence = 5, vitality = 5 , stamina = 5;
    Random roll = new Random();
    Scanner keyboard = new Scanner(System.in);
    PrintWriter pw = new PrintWriter(System.out, true);

    public Player(String playerName, int healthPoints, int magicPoints, int attackPower, int defensePower) {
      this.healthPoints = healthPoints;
      this.magicPoints = magicPoints;
      this.attackPower = attackPower;
      this.defensePower = defensePower;
    }

    public Player() {
      this("PlayerOne",5,5,5,5);
    }

    public void setPlayerName() {
      System.out.print("Enter your name >> ");
      this.playerName = keyboard.next();
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

    public void updatePlayer(int points) {
      while(points > 0) {
        --points;
        pw.println("Choose a stat to update:");
        pw.println("(1: Vitality)");
        pw.println("(2: Intelligence)");
        pw.println("(3: Strength)");
        pw.println("(4: Stamina)");
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

    public void displayPlayer() {
      this.setPlayerName();
      this.setHP();
      this.setMP();
      this.setAttkPow();
      this.setDefPow();
      System.out.println(playerName);
      System.out.println("HP: " + getHP());
      System.out.println("MP: " + getMP());
      System.out.println("ATT: " + getAttkPow());
      System.out.println("DEF: " + getDefPow());
    }


}
