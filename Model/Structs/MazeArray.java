package Model.Structs;

import Model.Enums.LocationState;

public class MazeArray 
{
    private LocationState[] locationsStatesArray;

    public MazeArray(LocationState[] locationsStatesArrayParameter)
    {
        this.locationsStatesArray = locationsStatesArrayParameter;
    }

    public int getLength()
    {
        return this.locationsStatesArray.length;
    }

    public LocationState getLocationStateAt(int indexParameter)
    {
        return this.locationsStatesArray[indexParameter];
    }
}
