package Model.Classes;

import Model.Enums.LocationState;
import Model.Structs.Location;
import Model.Structs.MazeArray;
import Model.Structs.MazeArrayWithStartAndEndIndexes;
import Model.Structs.MazeMatrix;
import Model.Structs.MazeMatrixWithStartAndEndLocations;
import Model.Structs.MazePanelConstructInfo;

public class Maze 
{
    private MazeMatrix mazeMatrix;
    private final Location startLocation;
    private final Location endLocation;

    public Maze(MazeMatrixWithStartAndEndLocations mazeMatrixWithStartAndEndLocationsParameter)
    {
        this.mazeMatrix = mazeMatrixWithStartAndEndLocationsParameter.getMazeMatrix();
        this.startLocation = mazeMatrixWithStartAndEndLocationsParameter.getStartLocation();
        this.endLocation = mazeMatrixWithStartAndEndLocationsParameter.getEndLocation();
    }

    private boolean isLocationOutOfBounds(Location locationParameter)
    {
        if((locationParameter.getX() < 0) || (locationParameter.getX() >= this.mazeMatrix.getSizeX()))
        {
            return true;
        }
        if((locationParameter.getY() < 0) || (locationParameter.getY() >= this.mazeMatrix.getSizeY()))
        {
            return true;
        }
        return false;
    }

    private MazeArrayWithStartAndEndIndexes getMazeArrayWithStartAndEndIndexes()
    {
        return MazeMatrixToMazeArrayConverter.convert(new MazeMatrixWithStartAndEndLocations(this.mazeMatrix, this.startLocation, this.endLocation));
    }

    public void setLocationAsPath(Location locationParameter)
    {
        this.mazeMatrix.setLocationState(locationParameter, LocationState.PATH);
    }

    public void setLocationAsVisited(Location locationParameter)
    {
        this.mazeMatrix.setLocationState(locationParameter, LocationState.VISITED);
    }

    public boolean isLocationUnvisited(Location locationParameter)
    {
        if(this.isLocationOutOfBounds(locationParameter))
        {
            return false;
        }

        switch(this.mazeMatrix.getLocationState(locationParameter))
        {
            case UNVISITED: 
                return true;
            case BLOCKED: case VISITED: case PATH:
                return false;
        }

        return false;
    }

    public boolean isLocationPath(Location locationParameter)
    {
        return (this.mazeMatrix.getLocationState(locationParameter) == LocationState.PATH);
    }

    public boolean isLocationTheTarget(Location locationParameter)
    {
        return locationParameter.isLocationEqual(this.endLocation);
    }

    public Location getStartLocationCopy()
    {
        return this.startLocation.getCopy();
    }

    public Maze getCopy()
    {
        MazeMatrixWithStartAndEndLocations mazeMatrixWithStartAndEndLocations = new MazeMatrixWithStartAndEndLocations(this.mazeMatrix.getCopy(), this.startLocation.getCopy(), this.endLocation.getCopy());
        return new Maze(mazeMatrixWithStartAndEndLocations);
    }

    public MazeArray getMazeArray()
    {
        return this.getMazeArrayWithStartAndEndIndexes().getMazeArray();
    }

    public MazePanelConstructInfo getMazePanelConstructInfo()
    {
        MazeArrayWithStartAndEndIndexes mazeArrayWithStartAndEndIndexes = this.getMazeArrayWithStartAndEndIndexes();
        return new MazePanelConstructInfo(this.mazeMatrix.getSizeX(), this.mazeMatrix.getSizeY(), mazeArrayWithStartAndEndIndexes.getMazeArray().getLength(), mazeArrayWithStartAndEndIndexes.getStartIndex(), mazeArrayWithStartAndEndIndexes.getEndIndex());
    }
}
