

//imports

public class GameGenerator {
  public Player playerOne;
  public Enemy enemy;
  public Menus menus;
  public XPGenerator gen;
  public TextFields gameText;
  //public Board board;
  //public Loot loot;
  //public Chest chest;


  public GameGenerator() {
    playerOne = new Player();
    enemy = new Enemy(playerOne);
    gen = new XPGenerator(playerOne);
    gameText = new TextFields();
    menus = new Menus(playerOne, enemy, gen, gameText);
    // loot = new Loot();
    // trap = new Trap();

    menus.gameLoop();
  }


}
