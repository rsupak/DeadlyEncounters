//Filename: DED.java
//Rebuild of DEDivided, rebuild of DeadlyEncounters
//Written by Richard Supak
//Written on 24October2017


public class DED {
  public static void main(String[] args) {

    //set imported methods (Scanner, Random, PrintWriter)

    Player playerOne = new Player();
    Enemy enemy = new Enemy(playerOne);
    XPGenerator gen = new XPGenerator(playerOne);
    Menus menus = new Menus(playerOne, enemy, gen);
    playerOne.setPlayer();

    menus.gameLoop();
  }
}
