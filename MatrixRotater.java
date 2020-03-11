import java.io.IOException;
import java.util.Scanner;


public class MatrixRotater {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the size of matrix: ");
        int matrixSize = scanner.nextInt();

        int matrix[][] = new int[matrixSize][matrixSize];

        int secondMatrix[][] = new int[matrixSize][matrixSize];

        System.out.println("Enter elements of matrix of size: " + matrixSize + "x" + matrixSize);

        for (int i = 0; i <= matrixSize - 1; i++) {
            for (int j = 0; j <= matrixSize - 1; j++) {
                int m = scanner.nextInt();
                matrix[i][j] = m;
            }
        }
        System.out.println("Elements in matrix are ");
        for (int i = 0; i <= matrixSize - 1; i++) {
            for (int j = 0; j <= matrixSize - 1; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        //Rotating matrix elements by 90 degrees//
        int s = matrixSize - 1;
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                int k = s - j;
                int l = i;

                secondMatrix[i][j] = matrix[k][l];

            }
            System.out.println();
        }

        System.out.println("Elements in 90 degree matrix are ");
        for (int i = 0; i <= matrixSize - 1; i++) {
            for (int j = 0; j <= matrixSize - 1; j++) {
                System.out.print(secondMatrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}



