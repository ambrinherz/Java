
import java.util.Scanner;


public class MatrixZeroer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the row size of matrix: ");
        int rowSize = scanner.nextInt();

        System.out.println("Enter the column size of matrix: ");
        int columnSize = scanner.nextInt();

        Integer[][] matrix = new Integer[rowSize][columnSize];

        Integer[][] resultMatrix = new Integer[rowSize][columnSize];

        System.out.println("Enter elements of matrix of size: " + rowSize + "x" + columnSize);

        for (int i = 0; i <= rowSize - 1; i++) {
            for (int j = 0; j <= columnSize - 1; j++) {
                int m = scanner.nextInt();
                matrix[i][j] = m;
            }
        }
        System.out.println("Elements in matrix are ");
        for (int i = 0; i <= rowSize - 1; i++) {
            for (int j = 0; j <= columnSize - 1; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        //If any element in input matrix is zero, convert the entire row and column to zero//
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                if (matrix[i][j] == 0) {

                    for (int k = 0; k < columnSize; k++) {
                        resultMatrix[i][k] = 0;
                    }

                    for (int l = 0; l < rowSize; l++) {
                        resultMatrix[l][j] = 0;
                    }

                } else if (resultMatrix[i][j] == null) {

                    resultMatrix[i][j] = matrix[i][j];

                }

            }
        }

        System.out.println("Elements in new matrix are ");
        for (int i = 0; i <= rowSize - 1; i++) {
            for (int j = 0; j <= columnSize - 1; j++) {
                System.out.print(resultMatrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}