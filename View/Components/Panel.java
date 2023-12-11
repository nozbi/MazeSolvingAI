package View.Components;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Panel extends JPanel
{
    public Panel()
    {
        super();

        this.setBackground(Color.BLACK);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 10));
    }
}
