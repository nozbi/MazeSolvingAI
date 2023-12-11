package Model.Structs;

import Model.Enums.PathFinderStatus;

public class PathFinderResult 
{
    private PathFinderStatus pathFinderStatus;
    private MazeArray mazeArray;

    public PathFinderResult(PathFinderStatus pathFinderStatusParameter, MazeArray mazeArrayParameter)
    {
        this.pathFinderStatus = pathFinderStatusParameter;
        this.mazeArray = mazeArrayParameter;
    }

    public PathFinderStatus getPathFinderStatus()
    {
        return this.pathFinderStatus;
    }

    public MazeArray getMazeArray()
    {
        return this.mazeArray;
    }
}
