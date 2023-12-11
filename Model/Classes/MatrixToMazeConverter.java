package Model.Classes;

import Model.Enums.LocationState;
import Model.Enums.MatrixConversionLocationState;
import Model.Structs.Location;
import Model.Structs.MazeMatrix;
import Model.Structs.MazeMatrixWithStartAndEndLocations;

public class MatrixToMazeConverter 
{
    public static Maze getMazeFromMatrix(int[][] matrixParameter) throws Exception
    {
        return new Maze(MatrixToMazeConverter.convertMatrixToMazeMatrixWithStartAndEndLocations(matrixParameter));
    }

    private static MazeMatrixWithStartAndEndLocations convertMatrixToMazeMatrixWithStartAndEndLocations(int[][] matrixParameter) throws Exception
    {
        int sizeX = matrixParameter[0].length;
        int sizeY = matrixParameter.length;
        LocationState[][] matrix = new LocationState[sizeY][sizeX];
        Location startLocation = null;
        Location endLocation = null;

        for(int y = 0; y < sizeY; y++)
        {
            for(int x = 0; x < sizeX; x++)
            {
                int locationStateIndex = matrixParameter[y][x];
                MatrixConversionLocationState matrixConversionLocationState = MatrixConversionLocationState.getMatrixConversionLocationStateByIndex(locationStateIndex);
                switch(matrixConversionLocationState)
                {
                    case BLOCKED: case UNVISITED:     
                        break;
                    case START:
                        startLocation = new Location(x, y);
                        locationStateIndex = 1;
                        break;
                    case END:
                        endLocation = new Location(x, y);
                        locationStateIndex = 1;
                        break;
                }
                matrix[y][x] = LocationState.getLocationStateByIndex(locationStateIndex);
            }
        }

        if((startLocation == null) || (endLocation == null))
        {
            throw new Exception("Start or End Location is 'null'");
        }

        return new MazeMatrixWithStartAndEndLocations(new MazeMatrix(matrix), startLocation, endLocation);
    }
}
