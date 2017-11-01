
package maze;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Board extends JPanel implements ActionListener{
    private Timer timer;
    
    private Map m;
    private Player p;
    public Board(){
        
        m = new Map();
        p = new Player();
        addKeyListener(new Al());
        setFocusable(true);
                
        
        timer = new Timer(25, this);
        timer.start();
    }
    
    public void actionPerformed(ActionEvent e){
        repaint();
    }
    
    public void paint(Graphics g){
        super.paint(g);
        
        for(int y = 0;y < 14; y++){
            for(int x = 0; x < 14; x++){
                if(m.getMap(x, y).equals("g")){
                    g.drawImage(m.getGrass(), x * 32, y * 32, null);
                }
                
                if(m.getMap(x, y).equals("w")){
                    g.drawImage(m.getWall(), x * 32, y * 32, null);
                }
                
            }
        }
        
        g.drawImage(p.getPlayer(), p.getTileX() * 32, p.getTileY() * 32, null);
  
    }
    
    public class Al extends KeyAdapter{
        public void keyPressed(KeyEvent e){
            int keyCode = e.getKeyCode();
            if(keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_UP){
                if(!m.getMap(p.getTileX(), p.getTileY() - 1).equals("w"))
            p.move(0,-1);
            }
        if(keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_DOWN){
            if(!m.getMap(p.getTileX(), p.getTileY() + 1).equals("w"))
            p.move(0, 1);
        }
        if(keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_LEFT){
            if(!m.getMap(p.getTileX() - 1, p.getTileY()).equals("w"))
            p.move(-1, 0);
        }
        if(keyCode == KeyEvent.VK_D || keyCode == KeyEvent.VK_RIGHT){
            if(!m.getMap(p.getTileX() + 1, p.getTileY()).equals("w"))
            p.move(1, 0);
        }
        }
        public void keyReleased(KeyEvent e){
            
        }
        public void keytyped(KeyEvent e){
            
        }
    }

}
