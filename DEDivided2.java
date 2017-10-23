//Filename DeadlyEncounters.java modified to work with multiple subs
//Written by Richard Supak
//Written on 19October2017
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.util.*;

public class DEDivided2 {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);


    //Sprites
    PlayerSprite player = new PlayerSprite();
    EnemySprite enemy = new EnemySprite();

    //player numbers
    player.setHP();
    player.setMP();
    player.setAttkPow();
    player.setDefPow();
    int playerHealth = player.getHP();
    int playerMagic = player.getMP();
    int attackPower = player.getAttkPow();
    int defensePower = player.getDefPow();
    int xP = 0;

    //enemy numbers
    int enemyHealth;
    int enemyMagic;
    int enemyAttackPower;
    int enemyDefensePower;
    int exp;

    //sleep counters
    int playerSleepCount = 0, sleepCount = 0;

    //item numbers
    int healthPotion = 10, magicPotion = 10;

    //random numbers
    int attack;
    // int defend = (defensePower + (int)(Math.random() * 3));
    int cure = (5 + (int)(Math.random() * 6));
    int damage;
    int chestNumber;
    int countDown;
    boolean chestTurn;
    int treasure;

    //player choices
    int command = 0, itemChoice = 0, magic = 0;
    String playerName;
    boolean defense = false;
    int userGuess;

    //enemy choices
    String eCommand, enemyName;
    boolean eDefense = false;

    //game begins
    System.out.print("Welcome to Deadly Encounter!\nPlease enter your name >> ");
    playerName = keyboard.nextLine();
    player.displayPlayer();
    boolean gameRunning = true;
    boolean fighting;
    int turnCount = 1;
    int sequence; //sets player & enemy turns


    //event tables
    Hashtable<Integer, String> eventList = new Hashtable<>();
      eventList.put(1, "a Trap");
      eventList.put(2, "a Locked Door");
      eventList.put(3, "a Chest");
      eventList.put(4, "an Enemy");
      eventList.put(5, "no Encounter");
    String eventName;
    int eventSet;

    //movement tables
    Hashtable<Integer, String> movementList = new Hashtable<>();
      movementList.put(1, "NORTH");
      movementList.put(2, "EAST");
      movementList.put(3, "SOUTH");
      movementList.put(4, "WEST");
    int movement;
    List<String> map = new ArrayList<String>();

    //Main Menu
    Hashtable<Integer, String> mainMenu = new Hashtable<>();
      mainMenu.put(1, "Move");
      mainMenu.put(2, "Item");
      mainMenu.put(3, "Map");
      mainMenu.put(0, "Quit");
    int menu;

    //enemy actions
    Hashtable<Integer, String> enemyPhase = new Hashtable<>();
      enemyPhase.put(1, "Attack");
      enemyPhase.put(2, "Block");
      enemyPhase.put(3, "Cast");
      enemyPhase.put(4, "Flee");

    while(gameRunning == true) {
      System.out.print("\n\n.\n..\n...\nYou awaken in a dimly lit area of a dark, dank hole in the earth.\nBeside you is a torch set in a nook in the ground \nthat casts its light in a small circle.\nShadows move silently just beyond the glow of your meager light.\nYou pick up the torch and consider for a moment what you'll do \nto the bastard that put you here.\n\n");
      boolean traveling = true;

      while(traveling == true) {
        System.out.print("Main Menu:\n(1: Move)\n(2: Item)\n(3: Map)\n(0: Quit)\n>> ");
        menu = keyboard.nextInt();
        System.out.println("");
        switch(menu) {
          case 0:
            System.out.println("Sorry to see you go, traveler...");
            traveling = false;
            gameRunning = false;
            break;

		      //player movement
          case 1:
            System.out.print("Choose a direction to travel: \n(1: North)\n(2: East)\n(3: South)\n(4: West)\n>> ");
            movement = keyboard.nextInt();
            System.out.println("");
            map.add(movementList.get(movement));

            //begin encounter checks
            eventSet =  1 + (int)(Math.random() * 5);
            eventName = eventList.get(eventSet);
            System.out.println("You decided to set out to the " + movementList.get(movement));
            switch(eventName) {
              case "an Enemy":
                System.out.println("Suddenly you encounter " + eventName + "!");
                fighting = true;

                //setup enemy
                enemy.setEnemyName();
                enemy.setHP();
                enemy.setMP();
                enemy.setAttkPow();
                enemy.setDefPow();
                enemy.setXP();
                enemyName = enemy.getEnemyName();
                enemyHealth = enemy.getHP();
                enemyMagic = enemy.getMP();
                enemyAttackPower = enemy.getAttkPow();
                enemyDefensePower = enemy.getDefPow();
                exp = enemy.getXP();

                System.out.println("You have encountered a(n) " + enemyName);

                //begin combat sequence
                sequence = (int)(1 + Math.random() * 2);
                while(enemyHealth > 0 && playerHealth > 0 && fighting == true) {
                  switch(sequence % 2) {
                    case 0:
                      if(playerSleepCount > 0) {
                        --playerSleepCount;
                        ++sequence;
                      } else {
                        ++sequence;
                        System.out.println("");
                        System.out.println(playerName);
                        System.out.println("HP: " + playerHealth);
                        System.out.println("MP: " + playerMagic);
                        System.out.println("");
                        if(turnCount <= 1){
                          enemy.displayFogOfWar();
                        } else {
                          System.out.println("");
                          System.out.println(enemyName);
                          System.out.println("HP: " + enemyHealth);
                          System.out.println("MP: " + enemyMagic);
                          System.out.println("");
                        }
                        turnCount++;
                        while(command < 1 || command > 5) {
                          System.out.print("Choose your action >> \n(1: Attack)\n(2: Defend)\n(3: Magic)\n(4: Item)\n(5: Flee)\n>> ");
                          command = keyboard.nextInt();
                        }
                        switch(command) {
                          case 1:
                            System.out.println(playerName + " attacks!");
                            attack = (attackPower + (int)(Math.random() * 3));
                            if((attack - enemyDefensePower) >= 0) {
                              if(eDefense == true) {
                                enemyHealth = enemyHealth - (attack - enemyDefensePower) + 2;
                                System.out.println(enemyName + " takes " + ((attack - enemyDefensePower) + 2) + " points of damage.");
                              } else {
                                enemyHealth = enemyHealth - (attack - enemyDefensePower);
                                System.out.println(enemyName + " takes " + (attack - enemyDefensePower) + " points of damage.");
                              }
                            } else {
                              System.out.println("Glancing blow! " + enemyName + " takes no damage.");
                            }
                            command = 0;
                            break;
                          case 2:
                            System.out.println(playerName + " defends.");
                            defense = true;
                            command = 0;
                            break;
                          case 3:
                            System.out.println("You are casting a spell!");

                            //magic selection
                            System.out.println("Choose a magic to use: \n(1: Arrow)\n(2: Fireball)\n(3: Sleep)\n(4: Cure)\n>>");
                            magic = keyboard.nextInt();
                            if(magic == 1 && playerMagic >= 2) {
                              enemyHealth -= 2;
                              playerMagic -= 2;
                            } else if(magic == 2 && playerMagic >= 5) {
                              damage = (3 + (int)(Math.random() * 5));
                              System.out.println("You did " + damage + " points of damage to the " + enemyName);
                              enemyHealth -= damage;
                              playerMagic -= 5;
                            } else if(magic == 3 && playerMagic >= 3) {
                              int sleepCheck = (1 + (int)(Math.random() * 10));
                              if(sleepCheck >= 7) {
                                System.out.println("Enemy is asleep");
                                sleepCount = 2;
                              } else if(sleepCheck == 5 || sleepCheck == 6){
                                System.out.println("Enemy is dazed");
                                sleepCount = 1;
                              } else {
                                System.out.println("Spell ineffective!");
                                sleepCount = 0;
                              }
                              playerMagic -= 3;
                            } else if(magic == 4 && playerMagic >= 4){
                              System.out.println(playerName + "casts Cure!");
                              playerHealth += cure;
                              System.out.println("Current HP: " + playerHealth);
                              playerMagic -= 4;
                            } else {
                              System.out.println("Insufficient MP! You only have " + playerMagic + "MP! Using a magic potion to help!");
                              magicPotion -= 1;
                              playerMagic += 10;
                            }
                            command = 0;
                            break;
                          case 4:
                            while(itemChoice < 1 || itemChoice > 2) {
                              System.out.println("Item List:\nHealth Potions: " + healthPotion + "\nMagic Potions: " + magicPotion);
                              System.out.print("Choose an item to use:\n(1: Health Potion)\n(2: Magic Potion)\n>> ");
                              itemChoice = keyboard.nextInt();
                            }

							              //item selection
                            switch(itemChoice) {
                              case 1:
                                if(healthPotion > 0) {
                                  playerHealth += 10;
                                  healthPotion -= 1;
                                  System.out.println("Player HP: " + playerHealth);
                                } else {
                                  System.out.println("You have no more Health Potions!");
                                  System.out.println("Player HP: " + playerHealth);
                                }
                                break;
                              case 2:
                                if(magicPotion > 0) {
                                  playerMagic += 10;
                                  magicPotion -= 1;
                                  System.out.println("Player MP: " + playerMagic);
                                } else {
                                  System.out.println("You have no more Magic Potions!");
                                  System.out.println("Player MP: " + playerMagic);
                                }
                                break;
                            }
                            itemChoice = 0;
                            command = 0;
                            break;
                          case 5:
							              //escape sequence
                            int fleeChance = (1 + (int)(Math.random() * 10));
                            if(fleeChance > 5) {
                              System.out.println(playerName + " successfully escapes!");
                              fighting = false;
                              xP += 0;
                            } else {
                              System.out.println(playerName + " cannot escape!");
                              System.out.println(playerName + " is stunned for 1 turn.");
                              playerSleepCount = 1;
                            }
                            command = 0;
                            break;
                        }
                        break;
                      }
                    case 1:
					            //begin enemy combat sequence
                      if(sleepCount > 0) {
                        --sleepCount;
                        ++sequence;
                      } else {
                        ++sequence;

						            //set random command probability
                        int enemyCommandSet = (1 + (int)(Math.random() * 20));
                        if(enemyCommandSet >= 1 && enemyCommandSet <= 7) {
                          eCommand = enemyPhase.get(1);
                        } else if(enemyCommandSet >= 8 && enemyCommandSet <= 13) {
                          eCommand = enemyPhase.get(2);
                        } else if(enemyCommandSet >= 14 && enemyCommandSet <= 18) {
                          eCommand = enemyPhase.get(3);
                        } else {
                          eCommand = enemyPhase.get(4);
                        }

						            //enemy random command selections
                        switch(eCommand) {
                          case "Attack":
                            System.out.println("The " + enemyName + " attacks!");
                            if((enemyAttackPower - defensePower) >= 0) {
                              if (defense == true) {
                                playerHealth = playerHealth - ((enemyAttackPower - defensePower) + 2);
                                System.out.println(playerName + " takes " + ((enemyAttackPower - defensePower) + 2) + " damage.");
                              } else {
                                playerHealth = playerHealth - (enemyAttackPower - defensePower);
                                System.out.println(playerName + " takes " + (enemyAttackPower - defensePower) + " damage.");
                              }
                            } else {
                              System.out.println(playerName + " takes no damage!");
                            }
                            break;
                          case "Block":
                            System.out.println("The " + enemyName + " blocks.\n");
                            eDefense = true;
                            break;
                          case "Cast":
                            if(enemyMagic > 2) {
                              System.out.println("The " + enemyName + " casts Magic Arrow!\nDeals " + 2 + " damage.");
                              playerHealth -= 2;
                              enemyMagic -= 2;
                            } else {
                              System.out.println("The " + enemyName + " casts Magic Arrow!");
                              System.out.println("Enemy spell fizzles...");
                            }
                            break;
                          case "Flee":
                            System.out.println("The " + enemyName + " tries an escape!");
                            int eFleeChance = (1 + (int)(Math.random() * 10));
                            if(eFleeChance < 3) {
                              System.out.println(enemyName + " successfully escapes!");
                              fighting = false;
                              xP += 0;
                            } else {
                              System.out.println(enemyName + " cannot escape!");
                              System.out.println(enemyName + " is stunned for 1 turn.");
                              sleepCount = 1;
                            }
                        }
                      }
                  }
                }
                //end combat sequence
                if(enemyHealth <= 0) {
                  System.out.println("You have successfully killed the " + enemyName + "!");
                  System.out.println("You have earned " + exp + "XP!");
                  xP += exp;
                  System.out.println("Total XP is " + xP);
                  turnCount = 1;
                }
                if(playerHealth <= 0) {
                  System.out.println(playerName + " has perished...may his shade find the peace he never found in life.");
                  gameRunning = false;
                  traveling = false;
                }
                break;
              case "a Locked Door":
JFrame frame1 = new JFrame();
              ImageIcon door = new ImageIcon("door.jpg");
              JLabel label = new JLabel(door);
              frame1.add(label);
              frame1.setDefaultCloseOperation
                    (JFrame.DISPOSE_ON_CLOSE);
              frame1.pack();
              frame1.setVisible(true);
                System.out.println("Locked Door");
              break;
              case "a Chest":
JFrame frame2 = new JFrame();
              ImageIcon chest = new ImageIcon("chest.jpg");
              JLabel chest1 = new JLabel(chest);
              frame2.add(chest1);
              frame2.setDefaultCloseOperation
                  (JFrame.DISPOSE_ON_CLOSE);
              frame2.pack();
              frame2.setVisible(true);
                System.out.println("Locked Door");
                System.out.println("You've encountered " + eventName);
                System.out.println("The chest has a numerical lock attached to the front.\nGuess the correct number and the treasure is yours.");
                treasure = (1 + (int)(Math.random() * 2));
                chestNumber = (1 + (int)(Math.random() * 50));
                countDown = (3 + (int)(Math.random() * 3));
                chestTurn = true;
                while(countDown > 0 && chestTurn == true) {
                  System.out.println("You have " + countDown + " guesses left. Make them count!");
                  System.out.print("Guess A Number Between 1 and 50 >> ");
                  userGuess = keyboard.nextInt();
                  --countDown;
                  if(userGuess < chestNumber) {
                    System.out.println("Too low!");
                  } else if(userGuess > chestNumber) {
                    System.out.println("Too high!");
                  } else if(userGuess == chestNumber) {
                    System.out.println("You chose wisely!");
                    if(treasure == 1) {
                      healthPotion++;
                      System.out.println("You now have: " + healthPotion + " health potions");
                    } else if(treasure == 2) {
                      magicPotion++;
                      System.out.println("You now have: " + magicPotion + " magic potions");
                    }
                    chestTurn = false;
                  }

                  if(countDown == 0 || chestTurn == false){
                    chestTurn = false;
                    System.out.println("The chest suddenly disappears!");

                  }
                }
                break;
              case "a Trap":
JFrame frame3 = new JFrame();
              ImageIcon trap = new ImageIcon("trap.jpg");
              JLabel trap1 = new JLabel(trap);
              frame3.add(trap1);
              frame3.setDefaultCloseOperation
                   (JFrame.DISPOSE_ON_CLOSE);
              frame3.pack();
              frame3.setVisible(true);
                System.out.println("You've run into a TRAP!\nYou take 5 points of damage.");
                playerHealth -= 5;
                System.out.println("Player HP: " + playerHealth);
                if(playerHealth <= 0) {
                  System.out.println(playerName + " has perished...may his shade find the peace he never found in life.");
                  gameRunning = false;
                  traveling = false;
                }
                break;
              case "no Encounter":
JFrame frame4 = new JFrame();
              ImageIcon path = new ImageIcon("path.jpg");
              JLabel path1 = new JLabel(path);
              frame4.add(path1);
             frame4.setDefaultCloseOperation
                     (JFrame.DISPOSE_ON_CLOSE);
              frame4.pack();
              frame4.setVisible(true);
                System.out.println("The darkness feels like it is closing in around you.\nEven the crickets have grown quiet.\nYou do not feel safe enough to rest for the night.\nYou decide to keep moving.");
                break;
            }
//            frame.setVisible(false);
//            frame.dispose();
           break;
          case 2:
            System.out.println("Item List:\nHealth Potions: " + healthPotion + "\nMagic Potions: " + magicPotion);
            System.out.print("Choose an item to use:\n(1: Health Potion)\n(2: Magic Potion)\n>>");
            itemChoice = keyboard.nextInt();
            switch(itemChoice) {
              case 1:
                if(healthPotion > 0) {
                  playerHealth += 10;
                  healthPotion -= 1;
                  System.out.println("Player HP: " + playerHealth);
                } else {
                  System.out.println("You have no more Health Potions!");
                  System.out.println("Player HP: " + playerHealth);
                }
                break;
              case 2:
                if(magicPotion > 0) {
                  playerMagic += 10;
                  magicPotion -= 1;
                  System.out.println("Player MP: " + playerMagic);
                } else {
                  System.out.println("You have no more Magic Potions!");
                  System.out.println("Player MP: " + playerMagic);
                }
                break;
            }
            itemChoice = 0;
            command = 0;
            break;
          case 3:
            System.out.println(map);
            break;
        }
        //player death
        if(playerHealth <= 0) {
          System.out.println(playerName + " has perished...may his shade find the peace he never found in life.");
          gameRunning = false;
          traveling = false;
        }
      }
    }
  }
}
