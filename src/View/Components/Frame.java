package View.Components;

import javax.swing.JFrame;

public class Frame extends JFrame
{
    public Frame()
    {
        super("Pathfinder");

        this.setSize(1000, 1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }
}
