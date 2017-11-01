package maze;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Maze {
  public static void main(String[] args) {
    new Maze();
  }

  public Maze() {
    JFrame frame = new JFrame();
    Table gameTable = new Table();
    frame.setTitle("DE");
    frame.add(gameTable);
    frame.setSize(528, 438);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
