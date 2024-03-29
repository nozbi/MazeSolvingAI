package View;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import Model.Structs.MazeArray;
import Model.Structs.MazePanelConstructInfo;
import View.Components.Button;
import View.Components.Frame;
import View.Components.LocationPanel;
import View.Components.MarkerPanel;
import View.Components.MenuBar;
import View.Components.Panel;
import View.Components.Spinner;

public class View 
{
    private final Color BLOCKED_COLOR = Color.BLACK;
    private final Color UNVISITED_COLOR = Color.WHITE;
    private final Color VISITED_COLOR = Color.LIGHT_GRAY;
    private final Color PATH_COLOR = Color.DARK_GRAY;
    private final Color START_COLOR = Color.GRAY;
    private final Color END_COLOR = Color.RED;

    private Panel panel;
    private Button loadFileButton;
    private Button findPathButton;
    private Button showPathButton;
    private Spinner delaySpinner;

    public View()
    {
        //FRAME
        Frame frame = new Frame();

            //MENU BAR
            MenuBar menuBar = new MenuBar();

                this.loadFileButton = new Button("Load file");
                menuBar.add(loadFileButton);

                this.showPathButton = new Button("Show path");
                menuBar.add(this.showPathButton);

                this.findPathButton = new Button("Find Path with delay:");
                menuBar.add(this.findPathButton);

                this.delaySpinner = new Spinner();
                menuBar.add(this.delaySpinner);

            frame.setJMenuBar(menuBar);

            //PANEL
            this.panel = new Panel();
            frame.add(this.panel);
            
        frame.setVisible(true);
    }

    public void addOnClickActionListenerToLoadFileButton(ActionListener actionListenerParameter)
    {
        this.loadFileButton.addActionListener(actionListenerParameter);
    }

    public void addOnClickActionListenerToShowPathButton(ActionListener actionListenerParameter)
    {
        this.showPathButton.addActionListener(actionListenerParameter);
    }

    public void addOnClickActionListenerToFindPathButton(ActionListener actionListenerParameter)
    {
        this.findPathButton.addActionListener(actionListenerParameter);
    }

    public void setPathFindingButtonsEnabled(boolean enabledParameter)
    {
        this.showPathButton.setEnabled(enabledParameter);
        this.findPathButton.setEnabled(enabledParameter);
        this.delaySpinner.setEnabled(enabledParameter);
    }

    public int getDelaySpinnerValue()
    {
        return (int)(double)this.delaySpinner.getValue();
    }

    public void showAlert(String alertStringParameter)
    {
        JOptionPane.showMessageDialog(this.panel, alertStringParameter);
    }

    public void setMazePanel(MazePanelConstructInfo mazePanelConstructInfoParameter)
    {
        this.panel.removeAll();
        
        this.panel.setLayout(new GridLayout(mazePanelConstructInfoParameter.getMazeMatrixSizeY(), mazePanelConstructInfoParameter.getMazeMatrixSizeX()));
        for(int i = 0; i < mazePanelConstructInfoParameter.getMazeArrayLength(); i++)
        {
            this.panel.add(new LocationPanel());
        }

        JPanel startLocationPanel = (JPanel)this.panel.getComponent(mazePanelConstructInfoParameter.getMazeArrayStartIndex());
        JPanel endLocationPanel = (JPanel)this.panel.getComponent(mazePanelConstructInfoParameter.getMazeArrayEndIndex());
        startLocationPanel.add(new MarkerPanel(this.START_COLOR));
        endLocationPanel.add(new MarkerPanel(this.END_COLOR));
        
        this.panel.revalidate();
        this.panel.repaint();
    }

    public void refreshMazePanel(MazeArray mazeArrayParameter, boolean refreshWholeMazePanelParameter)
    {
        Component[] locationPanels = this.panel.getComponents();
        for(int i = 0; i < mazeArrayParameter.getLength(); i++)
        {
            switch(mazeArrayParameter.getLocationStateAt(i))
            {
                case BLOCKED:
                    locationPanels[i].setBackground(this.BLOCKED_COLOR);
                    break;
                case UNVISITED:
                    locationPanels[i].setBackground(this.UNVISITED_COLOR);
                    break;
                case VISITED:
                    locationPanels[i].setBackground(this.VISITED_COLOR);
                    break;
                case PATH:
                    locationPanels[i].setBackground(this.PATH_COLOR);
                    break;
            }
        }

        if(refreshWholeMazePanelParameter == true)
        {
            this.panel.repaint();
        }
    }
}
