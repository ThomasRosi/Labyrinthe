package code;

import java.awt.*;
import javax.swing.*;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;

public class MenuPanel extends JPanel {

    public MenuPanel(PlayButton b1, OptionButton b2, QuitButton b3){

        this.setBackground(new Color(150, 150, 0));

        GridBagLayout gbl = new GridBagLayout();
        this.setLayout(gbl);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = 0;
        gbc.insets = new Insets(10,0,10,0);
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        this.add(b1, gbc);
        gbc.gridy = 1;
        this.add(b2, gbc);
        gbc.gridy = 2;
        this.add(b3, gbc);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
     
        int w = this.getWidth();
        int h = this.getHeight();

        try{
            Image img = ImageIO.read(new File("src/img/background.png"));
            g.drawImage(img, 0,0,w,h,this);
        } catch(IOException e){
            e.printStackTrace();
        }

        try{
            Image img = ImageIO.read(new File("src/img/title.png"));
            g.drawImage(img, w/8,h/10,3*w/4,h/4,this);
        } catch(IOException e){
            e.printStackTrace();
        }
    
    }

}