//Filename: PlayerSprite.java
//Written by Richard Supak
//Written on 21October2017

import java.util.Random;

public class PlayerSprite {

    private String playerName;
    private int healthPoints, magicPoints, attackPower, defensePower, strength, intelligence, vitality, stamina;
    Random roll = new Random();

    public void setHP() {
      healthPoints = getVitality() * 3 + 50;
    }

    public void setMP() {
      magicPoints = getIntelligence() * 3 + 50;
    }

    public void setAttkPow() {
      attackPower = getStrength() * 2 + 15;
    }

    public void setDefPow() {
      defensePower = getStamina() * 2 + 15;
    }

    public void setStrength() {
      strength = roll.nextInt(15) + 1;
    }

    public void setIntelligence() {
      intelligence = roll.nextInt(15) + 1;
    }

    public void setVitality() {
      vitality = roll.nextInt(15) + 1;
    }

    public void setStamina() {
      stamina = roll.nextInt(15) + 1;
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

    public void Player() {
      setVitality();
      setIntelligence();
      setStrength();
      setStamina();
      setHP();
      setMP();
      setAttkPow();
      setDefPow();
    }

    public void Player(int hp, int mp, int att, int def) {
      this.healthPoints = hp;
      this.magicPoints = mp;
      this.attackPower = att;
      this.defensePower = def;
    }



    public void displayPlayer() {
      System.out.println("HP: " + getHP());
      System.out.println("MP: " + getMP());
      System.out.println("ATT: " + getAttkPow());
      System.out.println("DEF: " + getDefPow());
    }


}
