//Filename: EnemySprite.java
//Written by Richard Supak
//Written on 21October2017

import java.util.*;

public class EnemySprite {

    private String enemyName;
    private int enemyHealth, enemyMagic, attackPower, defensePower, exp;

    public void setEnemyName() {
      Hashtable<Integer, String> enemyList = new Hashtable<>();
        enemyList.put(1, "Slime");
        enemyList.put(2, "Skeleton");
        enemyList.put(3, "Imp");
        enemyList.put(4, "Mage");
        enemyList.put(5, "Black Knight");
        enemyList.put(6, "Dragon");
      enemyName = enemyList.get(1 + (int)(Math.random() * 6));
    }

    public void setHP() {
      if(getEnemyName().equals("Slime")) {
        enemyHealth = (1 + (int)(Math.random() * 10));
      }else if(getEnemyName().equals("Skeleton")) {
        enemyHealth = (5 + (int)(Math.random() * 11));
      }else if(getEnemyName().equals("Imp")) {
        enemyHealth = (10 + (int)(Math.random() * 11));
      }else if(getEnemyName().equals("Mage")) {
        enemyHealth = (20 + (int)(Math.random() * 11));
      }else if(getEnemyName().equals("Black Knight")) {
        enemyHealth = (50 + (int)(Math.random() * 11));
      }else if(getEnemyName().equals("Dragon")) {
        enemyHealth = (80 + (int)(Math.random() * 30));
      }
    }

    public void setMP() {
      if(getEnemyName().equals("Slime")) {
        enemyMagic = 0;
      }else if(getEnemyName().equals("Skeleton")) {
        enemyMagic = 0;
      }else if(getEnemyName().equals("Imp")) {
        enemyMagic = (5 + (int)(Math.random() * 11));
      }else if(getEnemyName().equals("Mage")) {
        enemyMagic = (10 + (int)(Math.random() * 11));
      }else if(getEnemyName().equals("Black Knight")) {
        enemyMagic = 0;
      }else if(getEnemyName().equals("Dragon")) {
        enemyMagic = (50 + (int)(Math.random() * 50));
      }
    }

    public void setAttkPow() {
      if(getEnemyName().equals("Slime")) {
        attackPower = (1 + (int)(Math.random() * 5));
      }else if(getEnemyName().equals("Skeleton")) {
        attackPower = (3 + (int)(Math.random() * 7));
      }else if(getEnemyName().equals("Imp")) {
        attackPower = (5 + (int)(Math.random() * 7));
      }else if(getEnemyName().equals("Mage")) {
        attackPower = (10 + (int)(Math.random() * 7));
      }else if(getEnemyName().equals("Black Knight")) {
        attackPower = (15 + (int)(Math.random() * 11));
      }else if(getEnemyName().equals("Dragon")) {
        attackPower = (30 + (int)(Math.random() * 30));
      }
    }

    public void setDefPow() {
      if(getEnemyName().equals("Slime")) {
        defensePower = 0;
      }else if(getEnemyName().equals("Skeleton")) {
        defensePower = (3 + (int)(Math.random() * 5));
      }else if(getEnemyName().equals("Imp")) {
        defensePower = (1 + (int)(Math.random() * 5));
      }else if(getEnemyName().equals("Mage")) {
        defensePower = (5 + (int)(Math.random() * 8));
      }else if(getEnemyName().equals("Mage")) {
        defensePower = (10 + (int)(Math.random() * 11));
      }else if(getEnemyName().equals("Dragon")) {
        defensePower = (20 + (int)(Math.random() * 11));
      }
    }

    public void setXP() {
      if(getEnemyName().equals("Slime")) {
        exp = 3;
      }else if(getEnemyName().equals("Skeleton")) {
        exp = 5;
      }else if(getEnemyName().equals("Imp")) {
        exp = 10;
      }else if(getEnemyName().equals("Mage")) {
        exp = 20;
      }else if(getEnemyName().equals("Black Knight")) {
        exp = 50;
      }else if(getEnemyName().equals("Dragon")) {
        exp = 200;
      }
    }

    public String getEnemyName() {
      return enemyName;
    }

    public int getHP() {
      return enemyHealth;
    }

    public int getMP() {
      return enemyMagic;
    }

    public int getAttkPow() {
      return attackPower;
    }

    public int getDefPow() {
      return defensePower;
    }

    public int getXP() {
      return exp;
    }

    public void displayFogOfWar() {
      System.out.println("");
      System.out.println(getEnemyName() + "\nHP: ??\nMP: ??");
      System.out.println("");
    }

    public void displayEnemy() {
      System.out.println("HP: " + getHP());
      System.out.println("MP: " + getMP());
      System.out.println("ATT: " + getAttkPow());
      System.out.println("DEF: " + getDefPow());
    }

}
