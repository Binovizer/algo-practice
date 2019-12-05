package arraysandstring;

import utils.AssortedMethods;

/**
 * The type RotateMatrix
 *
 * @author Mohd Nadeem
 */
public class RotateMatrix {

    public boolean rotate(int[][] matrix){
        if (matrix.length == 0 || matrix.length != matrix[0].length) return false; // Not a square
        int n = matrix.length;

        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for(int i = first; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i]; // save top

                // left -> top
                matrix[first][i] = matrix[last-offset][first];

                // bottom -> left
                matrix[last-offset][first] = matrix[last][last - offset];

                // right -> bottom
                matrix[last][last - offset] = matrix[i][last];

                // top -> right
                matrix[i][last] = top; // right <- saved top
            }
        }
        return true;
    }

    public boolean rotateNew(int[][] matrix){
//        if (matrix.length == 0 || matrix.length != matrix[0].length) return false; // Not a square
//        int n = matrix.length;
//
//        for(int layer = 0; layer < n/2; layer++){
//
//        }
        return true;
    }

    public static void main(String[] args) {
        int[][] mat =
                {
                        {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12},
                        {13, 14, 15, 16}
                };
        AssortedMethods.printMatrix(mat);
        RotateMatrix rotateMatrix = new RotateMatrix();
        rotateMatrix.rotateNew(mat);
//        rotateMatrix.rotate(mat);
        AssortedMethods.printMatrix(mat);
    }
}
