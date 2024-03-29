package Model.Classes;

import java.io.File;

public class MazeChooser 
{
    public static Maze getChoosenMaze() throws Exception
    {
        File mazeFile = MazeFileChooser.getChoosenMazeFile();
        if (mazeFile != null) 
        {
            return MazeFileReader.getMazeFromFile(mazeFile);
        }
        else
        {
            return null;
        }
    }
}
