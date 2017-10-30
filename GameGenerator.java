

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
  //public Trap trap;


  public GameGenerator() {
    playerOne = new Player();
    enemy = new Enemy(playerOne);
    gen = new XPGenerator(playerOne);
    gameText = new TextFields();
    menus = new Menus(playerOne, enemy, gen, gameText);
    // chest = new Chest();
    // loot = new Loot();
    // trap = new Trap();

    this.gameLoop();
  }

  public void gameLoop() {
    while(menus.getGameRunning() == true) {
      // gameText.intro();
      playerOne.setPlayer();
      // gameText.gameStart();
      while(menus.getTraveling() == true) {
        menus.mainMenu();
      }
      menus.getGameRunning();
    }
  }

}
