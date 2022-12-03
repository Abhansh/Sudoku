package com.gsr.sudoku;

import java.util.Random;

public class Util {

    boolean UsedInCol(int[][] grid, int col, int num) {
        for (int row = 0; row < grid.length; row++) {
            if (grid[row][col] == num)
                return true;
        }

        return false;
    }

    boolean UsedInBox(int[][] grid, int boxStartRow, int boxStartCol, int num) {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row + boxStartRow][col + boxStartCol] == num)
                    return true;
            }
        }

        return false;
    }

    public void random_shuffle(int[] array) {
        Random rand = new Random();

        for (int i = 0; i < array.length; i++) {
            int randomIndexToSwap = rand.nextInt(array.length);
            int temp = array[randomIndexToSwap];
            array[randomIndexToSwap] = array[i];
            array[i] = temp;
        }
    }

    public boolean isSafe(int[][] grid, int row, int col, int num) {
        return !UsedInRow(grid, row, num) && !UsedInCol(grid, col, num) && !UsedInBox(grid, row - row % 2, col - col % 2, num);
    }


    public boolean UsedInRow(int[][] grid, int row, int num) {
        for (int col = 0; col < grid.length; col++) {
            if (grid[row][col] == num)
                return true;
        }

        return false;
    }

}
