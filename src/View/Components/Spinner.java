package View.Components;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class Spinner extends JSpinner
{
    public Spinner()
    {
        super();

        this.setModel(new SpinnerNumberModel(0, 0, 1000, 1.0));
    }
}
