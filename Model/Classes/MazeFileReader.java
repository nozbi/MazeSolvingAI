package Model.Classes;

import java.io.File;

public class MazeFileReader 
{
    public static Maze getMazeFromFile(File fileParameter) throws Exception
    {
        int[][] matrix = MatrixFileReader.getMatrixFromFile(fileParameter);
        return MatrixToMazeConverter.getMazeFromMatrix(matrix);
    }
}
