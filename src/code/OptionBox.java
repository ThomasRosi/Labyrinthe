package code;

import java.awt.*;
import javax.swing.*;

public class OptionBox extends JComboBox {

    public OptionBox(){
        this.setPreferredSize(new Dimension (150,20));
        this.addItem("English");
        this.addItem("Francais");
        this.setSelectedIndex(0);
    }
}