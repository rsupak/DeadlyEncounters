package maze;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MappedPlayer {
  private int tileX, tileY;
  private Image player;

  public MappedPlayer() {
    ImageIcon img = new ImageIcon("char1.png");
    player = img.getImage();

    tileX = 1;
    tileY = 1;
  }

  public Image getPlayer() {
    return player;
  }

  public int getTileX() {
    return tileX;
  }

  public int getTileY() {
    return tileY;
  }

  public void move(int dx, int dy) {
    tileX += dx;
    tileY += dy;
  }
}
