package Model.Enums;

public enum MatrixConversionLocationState 
{
    BLOCKED,
    UNVISITED,
    START,
    END;

    public static MatrixConversionLocationState getMatrixConversionLocationStateByIndex(int indexParameter)
    {
        return MatrixConversionLocationState.values()[indexParameter];
    }
}
