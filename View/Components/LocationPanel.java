package View.Components;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class LocationPanel extends JPanel
{
    public LocationPanel()
    {
        super();

        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
    }
}
