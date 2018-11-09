package com.fit;

public class SquareMatrix
{
    private int[][] matrix;

    public SquareMatrix()
    {
        this.matrix  = new int[1][1];
    }
    public SquareMatrix(int size)
    {
        if(size <= 0)
        {
            System.out.println("Заданы неверные размеры матрицы. Будет создана матрица 1х1");
            size = 1;
        }
        this.matrix  = new int[size][size];
        randomMatrix(this.matrix);
    }
    public static void randomMatrix(int[][] matrix)
    {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int)(Math.random()*100) - 50;
            }
        }
    }
    public void reverse()
    {
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = i+1; j < matrix[i].length ; j++)
            {
                int ar = matrix[i][j];
                matrix[i][j] = matrix[matrix.length-i-1][matrix[i].length-j-1];
                matrix[matrix.length-i-1][matrix[i].length-j-1] = ar;
            }
        }
        for (int i = 0; i < (int) matrix.length/2; i++)
        {
            int diag =  matrix[matrix.length-1-i][matrix.length-1-i];
            matrix[matrix.length-1-i][matrix.length-1-i] = matrix[i][i];
            matrix[i][i] = diag;
        }
    }
    public void print() {

        for(int[] line : matrix) {
            for(int element : line){
                System.out.printf("%5d", element);
            }
            System.out.println();
        }
        System.out.println();
    }
}