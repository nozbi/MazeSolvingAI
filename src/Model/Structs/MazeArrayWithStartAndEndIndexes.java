package Model.Structs;

public class MazeArrayWithStartAndEndIndexes 
{
    private MazeArray mazeArray;
    private int startIndex;
    private int endIndex;

    public MazeArrayWithStartAndEndIndexes(MazeArray mazeArrayParameter, int startIndexParameter, int endIndexParameter)
    {
        this.mazeArray = mazeArrayParameter;
        this.startIndex = startIndexParameter;
        this.endIndex = endIndexParameter;
    }

    public MazeArray getMazeArray()
    {
        return this.mazeArray;
    }

    public int getStartIndex()
    {
        return this.startIndex;
    }

    public int getEndIndex()
    {
        return this.endIndex;
    }
}
