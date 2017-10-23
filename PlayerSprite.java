//Filename: PlayerSprite.java
//Written by Richard Supak
//Written on 21October2017

import java.util.*;

public class PlayerSprite {

    private String playerName;
    private int healthPoints, magicPoints, attackPower, defensePower, strength, intelligence, vitality, stamina;

    public void setHP() {
      healthPoints = getVitality() + (30 + (int)(Math.random() * 31));
    }

    public void setMP() {
      magicPoints = getIntelligence() + (25 + (int)(Math.random() * 31));
    }

    public void setAttkPow() {
      attackPower = getStrength() + (20 + (int)(Math.random() * 11));
    }

    public void setDefPow() {
      defensePower = getStamina() + (10 + (int)(Math.random() * 11));
    }

    public void setStrength() {
      strength = 10 + (int)(Math.random() * 5);
    }

    public void setIntelligence() {
      intelligence = 10 + (int)(Math.random() * 5);
    }

    public void setVitality() {
      vitality = 10 + (int)(Math.random() * 5);
    }

    public void setStamina() {
      stamina = 10 + (int)(Math.random() * 5);
    }

    public int getHP() {
      return healthPoints;
    }

    public int getMP() {
      return magicPoints;
    }

    public int getAttkPow() {
      return attackPower;
    }

    public int getDefPow() {
      return defensePower;
    }

    public int getVitality() {
      return vitality;
    }

    public int getIntelligence() {
      return intelligence;
    }

    public int getStrength() {
      return strength;
    }

    public int getStamina() {
      return stamina;
    }

    public void displayPlayer() {
      System.out.println("HP: " + getHP());
      System.out.println("MP: " + getMP());
      System.out.println("ATT: " + getAttkPow());
      System.out.println("DEF: " + getDefPow());
    }

}
