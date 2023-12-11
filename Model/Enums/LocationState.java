package Model.Enums;

public enum LocationState 
{
    BLOCKED,
    UNVISITED,
    VISITED,
    PATH;

    public static LocationState getLocationStateByIndex(int indexParameter)
    {
        return LocationState.values()[indexParameter];
    }
}
