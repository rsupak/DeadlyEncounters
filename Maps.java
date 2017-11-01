package maze;

import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class Maps {
  private Scanner mapFile;
  private String Maps[] = new String[14];
  private Image grass, wall;

  public Maps() {
    ImageIcon img = new ImageIcon("grass.png");
    grass = img.getImage();
    img = new ImageIcon("wall.png");
    wall = img.getImage();

    openFile();
    readFile();
    closeFile();
  }
  public Image getGrass() {return grass;}
  public Image getWall() {return wall;}
  public String getMap(int x, int y) {
    String index = Maps[y].substring(x, x + 1);
    return index;
  }

  public void openFile() {
    try {
      mapFile = new Scanner(new File("Map.txt"));
    }
    catch(Exception e) {
      System.out.println("Error loading map!");
    }
  }
  public void readFile() {
    while(mapFile.hasNext()) {
      for(int i = 0; i < 14; i++) {
        Maps[i] = mapFile.next();
      }
    }
  }
  public void closeFile() {
    mapFile.close();
  }

}
