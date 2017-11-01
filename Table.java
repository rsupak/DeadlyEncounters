package maze;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Table extends JPanel implements ActionListener {
  private Timer timer;
  private Maps map = new Maps();
  private MappedPlayer player = new MappedPlayer();

  public Table() {
    addKeyListener(new Al());
    setFocusable(true);

    timer = new Timer(25, this);
    timer.start();
  }

  public void actionPerformed(ActionEvent e) {
    repaint();
  }

  public void paint(Graphics g) {
    super.paint(g);

    for(int y = 0; y < 14; y++) {
      for (int x = 0; x < 14; x++) {
        if(map.getMap(x, y).equals("g")) {
          g.drawImage(map.getGrass(), x * 32, y * 32, null);
        }

        if(map.getMap(x, y).equals("w")) {
          g.drawImage(map.getGrass(), x * 32, y * 32, null);
        }
      }
    }

    g.drawImage(player.getPlayer(), player.getTileX() * 32, player.getTileY() * 32, null);
  }

  public class Al extends KeyAdapter {
    public void keyPressed(KeyEvent e) {
      int keyCode = e.getKeyCode();
      if(keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_UP) {
        if(!map.getMap(player.getTileX(), player.getTileY() - 1).equals("w"))
          player.move(0, -1);
      }
      if(keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_DOWN){
          if(!map.getMap(player.getTileX(), player.getTileY() + 1).equals("w"))
            player.move(0, 1);
      }
      if(keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_LEFT){
          if(!map.getMap(player.getTileX() - 1, player.getTileY()).equals("w"))
            player.move(-1, 0);
      }
      if(keyCode == KeyEvent.VK_D || keyCode == KeyEvent.VK_RIGHT){
          if(!map.getMap(player.getTileX() + 1, player.getTileY()).equals("w"))
            player.move(1, 0);
      }
    }
    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}
  }
}
