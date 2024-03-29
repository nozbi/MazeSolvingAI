package Model.Structs;

import Model.Enums.LocationState;

public class MazeMatrix 
{
    private LocationState[][] locationsStatesMatrix;

    public MazeMatrix(LocationState[][] locationsStatesMatrixParameter)
    {
        this.locationsStatesMatrix = locationsStatesMatrixParameter;
    }

    public int getSizeX()
    {
        return this.locationsStatesMatrix[0].length;
    }

    public int getSizeY()
    {
        return this.locationsStatesMatrix.length;
    }

    public LocationState getLocationState(Location locationParameter)
    {
        return this.locationsStatesMatrix[locationParameter.getY()][locationParameter.getX()];
    }

    public void setLocationState(Location locationParameter, LocationState valueParameter)
    {
       this.locationsStatesMatrix[locationParameter.getY()][locationParameter.getX()] = valueParameter;
    }

    public MazeMatrix getCopy()
    {
        LocationState[][] matrixCopy = new LocationState[this.getSizeY()][this.getSizeX()];
        for(int y = 0; y < this.getSizeY(); y++)
        {
            for(int x = 0; x < this.getSizeX(); x++)
            {
                matrixCopy[y][x] = this.locationsStatesMatrix[y][x];
            }
        }
        return new MazeMatrix(matrixCopy);
    }
}


