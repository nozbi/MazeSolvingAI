package Model.Classes;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class MatrixFileReader 
{
    public static int[][] getMatrixFromFile(File fileParameter) throws Exception
    {
        Scanner scanner;

        ArrayList<Integer> values = new ArrayList<Integer>();
        scanner = new Scanner(fileParameter);
        while(scanner.hasNextInt())
        {
            values.add(scanner.nextInt());
        }
        scanner.close();

        int numberOfRows = 0;
        scanner = new Scanner(fileParameter);
        while(scanner.hasNextLine())
        {
            numberOfRows++;
            scanner.nextLine();
        }
        scanner.close();

        int numberOfColumns = values.size() / numberOfRows;

        int[][] matrix = new int[numberOfRows][numberOfColumns];
        for(int y = 0; y < matrix.length; y++)
        {
            for(int x = 0; x < matrix[0].length; x++)
            {
                matrix[y][x] = values.get((y * matrix[0].length) + x);
            }
        }

        return matrix;
    }
}
