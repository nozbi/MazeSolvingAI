package Model.Classes;

import Model.Enums.LocationState;
import Model.Structs.Location;
import Model.Structs.MazeArray;
import Model.Structs.MazeArrayWithStartAndEndIndexes;
import Model.Structs.MazeMatrixWithStartAndEndLocations;

public class MazeMatrixToMazeArrayConverter 
{
    public static MazeArrayWithStartAndEndIndexes convert(MazeMatrixWithStartAndEndLocations mazeMatrixWithStartAndEndLocationsParameter)
    {
        int sizeY = mazeMatrixWithStartAndEndLocationsParameter.getMazeMatrix().getSizeY();
        int sizeX = mazeMatrixWithStartAndEndLocationsParameter.getMazeMatrix().getSizeX();

        LocationState[] locationsStatesArray = new LocationState[sizeY * sizeX];
        for (int y = 0; y < sizeY; y++) 
        {
            for (int x = 0; x < sizeX; x++) 
            {
                locationsStatesArray[(y * sizeX) + x] = mazeMatrixWithStartAndEndLocationsParameter.getMazeMatrix().getLocationState(new Location(x, y));
            }
        }

        int startIndex = (sizeX * mazeMatrixWithStartAndEndLocationsParameter.getStartLocation().getY()) + mazeMatrixWithStartAndEndLocationsParameter.getStartLocation().getX();
        int endLocation = (sizeX * mazeMatrixWithStartAndEndLocationsParameter.getEndLocation().getY()) + mazeMatrixWithStartAndEndLocationsParameter.getEndLocation().getX();
        
        return new MazeArrayWithStartAndEndIndexes(new MazeArray(locationsStatesArray), startIndex, endLocation);
    }
}
