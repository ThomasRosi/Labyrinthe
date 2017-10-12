package code;

import java.awt.*;
import javax.swing.*;

public class PlayPanel extends JPanel {

    protected Labyrinthe laby;

    public PlayPanel(BackButton b1, ResetButton b2, Labyrinthe laby){
        
        this.laby = laby;
        this.setFocusable(true);
        laby.setBlack();
        laby.setLight();
        this.setBackground(new Color(150, 150, 0));
        this.setLayout(new BorderLayout());
        this.add(b1, BorderLayout.SOUTH);
        this.add(b2, BorderLayout.EAST);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        int h = this.getHeight();
        int w = this.getWidth();

        int px = 30;
        int starty = h/4;
        int startx = (w/2)-(5*px);

        g.setColor(Color.BLACK);

        Ground[][] labTab = this.laby.getLabyrinthe();
        Ground gr;
        int c;

        for(int i = 0; i < 11; i++){
            for(int j = 0; j < 11; j++){
                gr = labTab[i][j];
                c = gr.getColor();
                if(c == -1){
                    g.setColor(Color.BLACK);
                }
                else if(c == 0){
                    g.setColor(Color.YELLOW);
                }
                else if(c == 1){
                    g.setColor(Color.WHITE);
                }
                else if(c == 2){
                    g.setColor(Color.LIGHT_GRAY);
                }
                else if(c == 3){
                    g.setColor(Color.BLUE);
                }
                else if(c == 4){
                    g.setColor(Color.GREEN);
                }
                else if (c == 5){
                    g.setColor(Color.RED);
                }
                g.fillRect(startx,starty,px,px);
                startx += px;
            }
            startx -= 11*px;
            starty += px;
        }
    }

}