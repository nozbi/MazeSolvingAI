package Model.Structs;

public class MazePanelConstructInfo 
{
    private int mazeMatrixSizeX;
    private int mazeMatrixSizeY;
    private int mazeArrayLength;
    private int mazeArrayStartIndex;
    private int mazeArrayEndIndex;

    public MazePanelConstructInfo(int mazeMatrixSizeXParameter, int mazeMatrixSizeYParameter, int mazeArrayLengthParameter, int mazeArrayStartIndexParameter, int mazeArrayEndIndexParameter)
    {
        this.mazeMatrixSizeX = mazeMatrixSizeXParameter;
        this.mazeMatrixSizeY = mazeMatrixSizeYParameter;
        this.mazeArrayLength = mazeArrayLengthParameter;
        this.mazeArrayStartIndex = mazeArrayStartIndexParameter;
        this.mazeArrayEndIndex = mazeArrayEndIndexParameter;
    }

    public int getMazeMatrixSizeX()
    {
        return this.mazeMatrixSizeX;
    }

    public int getMazeMatrixSizeY()
    {
        return this.mazeMatrixSizeY;
    }

    public int getMazeArrayLength()
    {
        return this.mazeArrayLength;
    }

    public int getMazeArrayStartIndex()
    {
        return this.mazeArrayStartIndex;
    }

    public int getMazeArrayEndIndex()
    {
        return this.mazeArrayEndIndex;
    }
}
