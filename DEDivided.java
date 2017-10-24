//Filename DeadlyEncounters.java modified to work with multiple subs
//Written by Richard Supak
//Written on 19October2017

import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.io.PrintWriter;

public class DEDivided {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    PrintWriter pw = new PrintWriter(System.out, true);

    //Sprites
    PlayerSprite player = new PlayerSprite();
    EnemySprite enemy = new EnemySprite();

    //player numbers
    player.setHP();
    player.setMP();
    player.setAttkPow();
    player.setDefPow();
    int baseHP = player.getHP();
    int baseMP = player.getMP();
    int baseATT = player.getAttkPow();
    int baseDEF = player.getDefPow();
    int playerHealth = baseHP;
    int playerMagic = baseMP;
    int attackPower = baseATT;
    int defensePower = baseDEF;
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
    pw.println("Welcome to Deadly Encounter!");
    pw.println("Please enter your name >>");
    playerName = keyboard.nextLine();
    player.displayPlayer();
    boolean gameRunning = true;
    boolean fighting;
    int turnCount = 1;
    int sequence; //sets player & enemy turns


    //event tables
    HashMap<Integer, String> eventList = new HashMap<>();
      eventList.put(1, "a Trap");
      eventList.put(2, "a Locked Door");
      eventList.put(3, "a Chest");
      eventList.put(4, "an Enemy");
      eventList.put(5, "no Encounter");
    String eventName;
    int eventSet;

    //movement tables
    HashMap<Integer, String> movementList = new HashMap<>();
      movementList.put(1, "NORTH");
      movementList.put(2, "EAST");
      movementList.put(3, "SOUTH");
      movementList.put(4, "WEST");
    int movement;
    List<String> map = new ArrayList<String>();

    //Main Menu
    HashMap<Integer, String> mainMenu = new HashMap<>();
      mainMenu.put(1, "Move");
      mainMenu.put(2, "Item");
      mainMenu.put(3, "Map");
      mainMenu.put(0, "Quit");
    int menu;

    //enemy actions
    HashMap<Integer, String> enemyPhase = new HashMap<>();
      enemyPhase.put(1, "Attack");
      enemyPhase.put(2, "Block");
      enemyPhase.put(3, "Cast");
      enemyPhase.put(4, "Flee");

    while(gameRunning == true) {
      pw.println(".");
      pw.println("..");
      pw.println("...");
      pw.println("You awaken in a dimly lit area of a dark, dank hole in the earth.");
      pw.println("Beside you is a torch set in a nook in the ground");
      pw.println("that casts its light in a small circle.");
      pw.println("Shadows move silently just beyond the glow of your meager light.");
      pw.println("You pick up the torch and consider for a moment what you'll do");
      pw.println("to the bastard that put you here.");
      pw.println("");
      pw.println("");
      boolean traveling = true;

      while(traveling == true) {
        pw.println("Main Menu:");
        pw.println("(1: Move)");
        pw.println("(2: Item)");
        pw.println("(3: Map)");
        pw.println("(0: Quit)");
        System.out.print(">> ");
        menu = keyboard.nextInt();
        pw.println("");
        switch(menu) {
          case 0:
            pw.println("Sorry to see you go, traveler...");
            traveling = false;
            gameRunning = false;
            break;

		      //player movement
          case 1:
            pw.println("Choose a direction to travel: ");
            pw.println("(1: North)");
            pw.println("(2: East)");
            pw.println("(3: South)");
            pw.println("(4: West)");
            System.out.print(">> ");
            movement = keyboard.nextInt();
            pw.println("");
            map.add(movementList.get(movement));

            //begin encounter checks
            eventSet =  1 + (int)(Math.random() * 5);
            eventName = eventList.get(eventSet);
            pw.println("You decided to set out to the " + movementList.get(movement));
            switch(eventName) {
              case "an Enemy":
                pw.println("Suddenly you encounter " + eventName + "!");
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

                pw.println("You have encountered a(n) " + enemyName);

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
                        pw.println("");
                        pw.println(playerName);
                        pw.println("HP: " + playerHealth);
                        pw.println("MP: " + playerMagic);
                        pw.println("");
                        if(turnCount <= 1){
                          enemy.displayFogOfWar();
                        } else {
                          pw.println("");
                          pw.println(enemyName);
                          pw.println("HP: " + enemyHealth);
                          pw.println("MP: " + enemyMagic);
                          pw.println("");
                        }
                        turnCount++;
                        while(command < 1 || command > 5) {
                          pw.println("Choose your action >> ");
                          pw.println("(1: Attack)");
                          pw.println("(2: Defend)");
                          pw.println("(3: Magic)");
                          pw.println("(4: Item)");
                          pw.println("(5: Flee)");
                          System.out.print(">> ");
                          command = keyboard.nextInt();
                        }
                        switch(command) {
                          case 1:
                            pw.println(playerName + " attacks!");
                            attack = (attackPower + (int)(Math.random() * 3));
                            if((attack - enemyDefensePower) >= 0) {
                              if(eDefense == true) {
                                enemyHealth = enemyHealth - (attack - enemyDefensePower) + 2;
                                pw.println(enemyName + " takes " + ((attack - enemyDefensePower) + 2) + " points of damage.");
                              } else {
                                enemyHealth = enemyHealth - (attack - enemyDefensePower);
                                pw.println(enemyName + " takes " + (attack - enemyDefensePower) + " points of damage.");
                              }
                            } else {
                              pw.println("Glancing blow! " + enemyName + " takes no damage.");
                            }
                            command = 0;
                            break;
                          case 2:
                            pw.println(playerName + " defends.");
                            defense = true;
                            command = 0;
                            break;
                          case 3:
                            pw.println("You are casting a spell!");

                            //magic selection
                            pw.println("Choose a magic to use: ");
                            pw.println("(1: Arrow)");
                            pw.println("(2: Fireball)");
                            pw.println("(3: Sleep)");
                            pw.println("(4: Cure)");
                            System.out.print(">> ");
                            magic = keyboard.nextInt();
                            if(magic == 1 && playerMagic >= 2) {
                              enemyHealth -= 2;
                              playerMagic -= 2;
                            } else if(magic == 2 && playerMagic >= 5) {
                              damage = (3 + (int)(Math.random() * 5));
                              pw.println("You did " + damage + " points of damage to the " + enemyName);
                              enemyHealth -= damage;
                              playerMagic -= 5;
                            } else if(magic == 3 && playerMagic >= 3) {
                              int sleepCheck = (1 + (int)(Math.random() * 10));
                              if(sleepCheck >= 7) {
                                sleepCount = (int)(1 + Math.random() * 5);
                                pw.println("Enemy is asleep for " + sleepCount + " turns!");
                              } else if(sleepCheck == 5 || sleepCheck == 6){
                                sleepCount = 2;
                                pw.println("Enemy is dazed for " + sleepCount + " turns.");
                              } else {
                                pw.println("Spell ineffective!");
                                sleepCount = 0;
                              }
                              playerMagic -= 3;
                            } else if(magic == 4 && playerMagic >= 4){
                              pw.println(playerName + " casts Cure!");
                              playerHealth += cure;
                              pw.println("Current HP: " + playerHealth);
                              playerMagic -= 4;
                            } else {
                              pw.println("Insufficient MP! You only have " + playerMagic + "MP! Using a magic potion to help!");
                              magicPotion -= 1;
                              playerMagic += 10;
                            }
                            command = 0;
                            break;
                          case 4:
                            while(itemChoice < 1 || itemChoice > 2) {
                              pw.println("Item List:");
                              pw.println("Health Potions: " + healthPotion + "");
                              pw.println("Magic Potions: " + magicPotion);
                              pw.println("Choose an item to use:");
                              pw.println("(1: Health Potion)");
                              pw.println("(2: Magic Potion)");
                              System.out.print(">> ");
                              itemChoice = keyboard.nextInt();
                            }

							              //item selection
                            switch(itemChoice) {
                              case 1:
                                if(healthPotion > 0) {
                                  playerHealth += 10;
                                  healthPotion -= 1;
                                  pw.println("Player HP: " + playerHealth);
                                } else {
                                  pw.println("You have no more Health Potions!");
                                  pw.println("Player HP: " + playerHealth);
                                }
                                break;
                              case 2:
                                if(magicPotion > 0) {
                                  playerMagic += 10;
                                  magicPotion -= 1;
                                  pw.println("Player MP: " + playerMagic);
                                } else {
                                  pw.println("You have no more Magic Potions!");
                                  pw.println("Player MP: " + playerMagic);
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
                              pw.println(playerName + " successfully escapes!");
                              fighting = false;
                              xP += 0;
                            } else {
                              pw.println(playerName + " cannot escape!");
                              pw.println(playerName + " is stunned for 1 turn.");
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
                            pw.println("The " + enemyName + " attacks!");
                            if((enemyAttackPower - defensePower) >= 0) {
                              if (defense == true) {
                                playerHealth = playerHealth - ((enemyAttackPower - defensePower) + 2);
                                pw.println(playerName + " takes " + ((enemyAttackPower - defensePower) + 2) + " damage.");
                              } else {
                                playerHealth = playerHealth - (enemyAttackPower - defensePower);
                                pw.println(playerName + " takes " + (enemyAttackPower - defensePower) + " damage.");
                              }
                            } else {
                              pw.println(playerName + " takes no damage!");
                            }
                            break;
                          case "Block":
                            pw.println("The " + enemyName + " blocks.");
                            pw.println("");
                            eDefense = true;
                            break;
                          case "Cast":
                            if(enemyMagic > 2) {
                              pw.println("The " + enemyName + " casts Magic Arrow!");
                              pw.println("Deals " + 2 + " damage.");
                              playerHealth -= 2;
                              enemyMagic -= 2;
                            } else {
                              pw.println("The " + enemyName + " casts Magic Arrow!");
                              pw.println("Enemy spell fizzles...");
                            }
                            break;
                          case "Flee":
                            pw.println("The " + enemyName + " tries an escape!");
                            int eFleeChance = (1 + (int)(Math.random() * 10));
                            if(eFleeChance < 3) {
                              pw.println(enemyName + " successfully escapes!");
                              fighting = false;
                              xP += 0;
                            } else {
                              pw.println(enemyName + " cannot escape!");
                              pw.println(enemyName + " is stunned for 1 turn.");
                              sleepCount = 1;
                            }
                        }
                      }
                  }
                }
                //end combat sequence
                if(enemyHealth <= 0) {
                  pw.println("You have successfully killed the " + enemyName + "!");
                  pw.println("You have earned " + exp + "XP!");
                  xP += exp;
                  pw.println("Total XP is " + xP);
                  turnCount = 1;
                  while(xP >= 50) {
                      pw.println("Congratulations! " + playerName + " has leveled up!");

                      playerHealth += baseHP + (10 + (int)(Math.random() * 10));
                      playerMagic +=  baseMP + (10 + (int)(Math.random() * 10));
                      attackPower += baseATT + (10 + (int)(Math.random() * 10));
                      defensePower += baseDEF + (10 + (int)(Math.random() * 10));
                      xP -= 50;
                      pw.println(playerName + "");
                      pw.println("HP: " + playerHealth + "");
                      pw.println("MP: " + playerMagic + "");
                      pw.println("ATT: " + attackPower + "");
                      pw.println("DEF: " + defensePower);
                  }
                }
                if(playerHealth <= 0) {
                  gameRunning = false;
                  traveling = false;
                }
                break;
              case "a Locked Door":
                pw.println("Locked Door");
                break;
              case "a Chest":
                pw.println("You've encountered " + eventName);
                pw.println("The chest has a numerical lock attached to the front.");
                pw.println("Guess the correct number and the treasure is yours.");
                treasure = (1 + (int)(Math.random() * 2));
                chestNumber = (1 + (int)(Math.random() * 50));
                countDown = (3 + (int)(Math.random() * 3));
                chestTurn = true;
                while(countDown > 0 && chestTurn == true) {
                  pw.println("You have " + countDown + " guesses left. Make them count!");
                  System.out.print("Guess A Number Between 1 and 50 >> ");
                  userGuess = keyboard.nextInt();
                  --countDown;
                  if(userGuess < chestNumber) {
                    pw.println("Too low!");
                  } else if(userGuess > chestNumber) {
                    pw.println("Too high!");
                  } else if(userGuess == chestNumber) {
                    pw.println("You chose wisely!");
                    if(treasure == 1) {
                      healthPotion++;
                      pw.println("You now have: " + healthPotion + " health potions");
                    } else if(treasure == 2) {
                      magicPotion++;
                      pw.println("You now have: " + magicPotion + " magic potions");
                    }
                    chestTurn = false;
                  }

                  if(countDown == 0 || chestTurn == false){
                    chestTurn = false;
                    pw.println("The chest suddenly disappears!");

                  }
                }
                break;
              case "a Trap":
                pw.println("You've run into a TRAP!");
                pw.println("You take 5 points of damage.");
                playerHealth -= 5;
                pw.println("Player HP: " + playerHealth);
                if(playerHealth <= 0) {
                  pw.println(playerName + " has perished...may his shade find the peace he never found in life.");
                  gameRunning = false;
                  traveling = false;
                }
                break;
              case "no Encounter":
                pw.println("The darkness feels like it is closing in around you.");
                pw.println("Even the crickets have grown quiet.");
                pw.println("You do not feel safe enough to rest for the night.");
                pw.println("You decide to keep moving.");
                break;
            }
            break;
          case 2:
            pw.println("Item List:");
            pw.println("Health Potions: " + healthPotion + "");
            pw.println("Magic Potions: " + magicPotion);
            pw.println("Choose an item to use:");
            pw.println("(1: Health Potion)");
            pw.println("(2: Magic Potion)");
            System.out.print(">>");
            itemChoice = keyboard.nextInt();
            switch(itemChoice) {
              case 1:
                if(healthPotion > 0) {
                  playerHealth += 10;
                  healthPotion -= 1;
                  pw.println("Player HP: " + playerHealth);
                } else {
                  pw.println("You have no more Health Potions!");
                  pw.println("Player HP: " + playerHealth);
                }
                break;
              case 2:
                if(magicPotion > 0) {
                  playerMagic += 10;
                  magicPotion -= 1;
                  pw.println("Player MP: " + playerMagic);
                } else {
                  pw.println("You have no more Magic Potions!");
                  pw.println("Player MP: " + playerMagic);
                }
                break;
            }
            itemChoice = 0;
            command = 0;
            break;
          case 3:
            pw.println(map);
            break;
        }
        //player death
        if(playerHealth <= 0) {
          pw.println(playerName + " has perished...may his shade find the peace he never found in life.");
          gameRunning = false;
          traveling = false;
        }
      }
    }
  }
}
