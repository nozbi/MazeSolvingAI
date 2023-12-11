package Controller;

import Model.Model;
import Model.Structs.MazeArray;
import Model.Structs.MazePanelConstructInfo;
import View.View;

public class Controller 
{
    private Model model;  
    private View view;

    public Controller(Model modelParameter, View viewParameter)
    {
        this.model = modelParameter;
        this.view = viewParameter;

        this.model.setController(this);

        this.view.addOnClickActionListenerToLoadFileButton(event -> {this.onLoadFileButtonClicked();});
        this.view.addOnClickActionListenerToShowPathButton(event -> {this.onShowPathButtonClicked();});
        this.view.addOnClickActionListenerToFindPathButton(event -> {this.onFindPathButtonClicked();});
    
        this.setPathFindingButtonsEnabled(false);
    }

    private void onLoadFileButtonClicked()  
    {
        this.model.loadFile();
    }

    private void onShowPathButtonClicked() 
    {
        this.model.showPath();
    }

    private void onFindPathButtonClicked()
    { 
        this.model.findPath(this.view.getDelaySpinnerValue());
    }

    public void setPathFindingButtonsEnabled(boolean enabledParameter)
    {
        this.view.setPathFindingButtonsEnabled(enabledParameter);
    }

    public void refreshMazePanel(MazeArray mazeArrayParameter, boolean refreshWholeMatrixParameter)
    { 
        this.view.refreshMazePanel(mazeArrayParameter, refreshWholeMatrixParameter);
    }

    public void showAlert(String alertStringParameter)
    {
        this.view.showAlert(alertStringParameter);
    }

    public void setMazePanel(MazePanelConstructInfo mazePanelConstructInfoParameter)
    {
        this.view.setMazePanel(mazePanelConstructInfoParameter);
    }
}
