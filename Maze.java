
package maze;

import javax.swing.*;
public class Maze {

    public static void main(String[] args) {
       new Maze();
    }
    public Maze(){
        JFrame f = new JFrame();
        f.setTitle("DE");
        f.add(new Board());
        f.setSize(528, 438);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
    }
}
