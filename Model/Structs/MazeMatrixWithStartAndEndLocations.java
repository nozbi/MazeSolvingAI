package Model.Structs;

public class MazeMatrixWithStartAndEndLocations 
{
    private final MazeMatrix mazeMatrix;
    private final Location startLocation;
    private final Location endLocation;

    public MazeMatrixWithStartAndEndLocations(MazeMatrix mazeMatrixParameter, Location startLocationParameter, Location endLocationParameter)
    {
        this.mazeMatrix = mazeMatrixParameter;
        this.startLocation = startLocationParameter;
        this.endLocation = endLocationParameter;
    }

    public MazeMatrix getMazeMatrix()
    {
        return this.mazeMatrix;
    }

    public Location getStartLocation()
    {
        return this.startLocation;
    }

    public Location getEndLocation()
    {
        return this.endLocation;
    }
}
