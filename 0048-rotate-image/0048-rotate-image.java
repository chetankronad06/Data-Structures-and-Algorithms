class Solution {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        for (int k = 0; k < matrix.length; k++) {
            int i = 0;
            int j = matrix[k].length - 1;
            while (i <= j) {
               int curr = matrix[k][j];
               matrix[k][j] = matrix[k][i];
               matrix[k][i] = curr;
               i++;
               j--;
            }
        }
    }

    public void transpose(int[][] matrix) {
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                swap(matrix,i,j);
            }
        }

    }

    public void swap(int[][] matrix, int i, int j) {
        int curr = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = curr;
    }
}