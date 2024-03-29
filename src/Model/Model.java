package Model;

import Controller.Controller;
import Model.Classes.Maze;
import Model.Classes.MazeChooser;
import Model.Classes.PathFinder;
import Model.Classes.PathFinderTimer;
import Model.Structs.PathFinderResult;

public class Model 
{
    private Controller controller; 
    private Maze sourceMaze;
    private PathFinderTimer pathFinderTimer;
    private PathFinder pathFinder;

    public Model()
    {
        this.pathFinderTimer = new PathFinderTimer();
    }

    private void handlePathFinderResult(PathFinderResult pathFinderResultParameter) 
    {
        switch(pathFinderResultParameter.getPathFinderStatus())
        {
            case PATH_FOUND:
                this.pathFinderTimer.stop();
                this.controller.refreshMazePanel(pathFinderResultParameter.getMazeArray(), true);
                this.controller.showAlert("Path found!");
                break;
            case PATH_NOT_FOUND:
                this.pathFinderTimer.stop();
                this.controller.refreshMazePanel(pathFinderResultParameter.getMazeArray(), true);
                this.controller.showAlert("Path does not exist!");
                break;
            case SEARCHING:
                this.controller.refreshMazePanel(pathFinderResultParameter.getMazeArray(), false);
                break;
        }
    }

    public void setController(Controller controllerParameter) 
    {
        this.controller = controllerParameter;
    }

    public void loadFile() 
    {
        try
        {
            Maze maze = MazeChooser.getChoosenMaze();
            if(maze != null)
            {
                this.pathFinderTimer.stop();
                this.sourceMaze = maze;
                this.controller.setMazePanel(maze.getMazePanelConstructInfo());
                this.controller.refreshMazePanel(maze.getMazeArray(), true);
                this.controller.setPathFindingButtonsEnabled(true);
            } 
        }
        catch(Exception exception)
        {
            this.controller.showAlert("Incorrect file format!");
        }
    }

    public void showPath() 
    {
        this.pathFinder = new PathFinder(this.sourceMaze.getCopy());
        this.handlePathFinderResult(this.pathFinder.getPathFinderResult());
    }

    public void findPath(int delayParameter)
    { 
        this.controller.refreshMazePanel(this.sourceMaze.getMazeArray(), true);
        this.pathFinder = new PathFinder(this.sourceMaze.getCopy());
        this.pathFinderTimer.start(delayParameter, actionEvent -> {this.handlePathFinderResult(this.pathFinder.getNextFindingStepResult());});
    }
}
