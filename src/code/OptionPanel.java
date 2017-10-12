package code;

import java.awt.*;
import javax.swing.*;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;

public class OptionPanel extends JPanel {

    public OptionPanel(BackButton b, OptionBox box){

        this.setBackground(new Color(150, 150, 0));
        GridBagLayout gbl = new GridBagLayout();
        this.setLayout(gbl);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,0,10,0);
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.gridwidth = 5;
        this.add(box, gbc);
        gbc.gridy = 1;
        this.add(b, gbc);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        int h = this.getHeight();
        int w = this.getWidth();

        try{
            Image img = ImageIO.read(new File("src/img/background.png"));
            g.drawImage(img, 0,0,w,h,this);
        } catch(IOException e){
            e.printStackTrace();
        }

        try{
            Image img = ImageIO.read(new File("src/img/option.png"));
            g.drawImage(img, w/8,h/10,3*w/4,h/4,this);
        } catch(IOException e){
            e.printStackTrace();
        }
    }

}