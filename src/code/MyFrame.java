package code;

import javax.swing.*;
import java.awt.event.*;

public class MyFrame extends JFrame {

    protected Labyrinthe laby = new Labyrinthe();

    protected OptionBox optionbox = new OptionBox();
    protected JOptionPane jop = new JOptionPane();

    protected PlayButton b1 = new PlayButton("Play"); 
    protected OptionButton b2 = new OptionButton("Options");
    protected QuitButton b3 = new QuitButton("Quit");
    protected BackButton b4 = new BackButton("Back");
    protected BackButton b5 = new BackButton("Back");
    protected ResetButton b6 = new ResetButton("Reset");

    protected MenuPanel menupanel = new MenuPanel(b1,b2,b3);
    protected PlayPanel playpanel = new PlayPanel(b4,b6,laby);
    protected OptionPanel optionpanel = new OptionPanel(b5, optionbox);

    protected int l = 0;

    public MyFrame(){

        this.setTitle("Labyrinthe");
        this.setSize(1024,768);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                laby.resetLab();
                MyFrame.this.changePanel(playpanel);
            }
        });

        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                MyFrame.this.changePanel(optionpanel);
            }
        });

        b4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                MyFrame.this.changePanel(menupanel);
            }
        });

        b5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                MyFrame.this.changePanel(menupanel);
                if(optionbox.getSelectedIndex()==0){
                    MyFrame.this.setTextEn();
                }
                else if(optionbox.getSelectedIndex()==1){
                    MyFrame.this.setTextFr();
                }
            }
        });

        b6.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                laby.resetLab();
                MyFrame.this.changePanel(playpanel);
            }
        });

        playpanel.addKeyListener(new DirectionListener());

        this.setContentPane(menupanel);
        this.setVisible(true);
    }

    public void changePanel(JPanel pan){
        this.setContentPane(pan);
        this.revalidate();
    }

    public void setTextEn(){
        l = 0;
        b1.setText("Play");
        b2.setText("Options");
        b3.setText("Quit");
        b4.setText("Back");
        b5.setText("Back");
        b6.setText("Reset");
    }

    public void setTextFr(){
        l = 1;
        b1.setText("Jouer");
        b2.setText("Options");
        b3.setText("Quitter");
        b4.setText("Retour");
        b5.setText("Retour");
        b6.setText("Rejouer");
    }

    class DirectionListener implements KeyListener {

        public void keyTyped(KeyEvent e){
        }

        public void keyPressed(KeyEvent e){
            int keyCode = e.getKeyCode();
            Ground g = MyFrame.this.laby.getPlayerGround();
            int x = g.getX();
            int y = g.getY();
            if(keyCode == KeyEvent.VK_UP){
                MyFrame.this.laby.up(x,y);
                laby.setBlack();
                laby.setLight();
            }
            else if(keyCode == KeyEvent.VK_DOWN){
                MyFrame.this.laby.down(x,y);
                laby.setBlack();
                laby.setLight();
            }
            else if(keyCode == KeyEvent.VK_RIGHT){
                MyFrame.this.laby.right(x,y);
                laby.setBlack();
                laby.setLight();
            }
            else if(keyCode == KeyEvent.VK_LEFT){
                MyFrame.this.laby.left(x,y);
                laby.setBlack();
                laby.setLight();
            }
            playpanel.repaint();
            MyFrame.this.revalidate();
            if(laby.end()){
                if(l == 0){
                    jop.showMessageDialog(null, "You Won !", "Victory !", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    jop.showMessageDialog(null, "Vous avez gagne !", "Victoire !", JOptionPane.INFORMATION_MESSAGE);
                }
                laby.resetLab();
                MyFrame.this.changePanel(menupanel);
            }
        }

        public void keyReleased(KeyEvent e){}

    }

}