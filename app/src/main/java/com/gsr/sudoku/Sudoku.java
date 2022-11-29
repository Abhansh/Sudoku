package com.gsr.sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Character.UNASSIGNED;

public class Sudoku {

    private int[][] grid;
    private int[][] solnGrid;
    private int[] guessNum;
    private int[] gridPos;
    private int difficultyLevel;
    private boolean grid_status;

    private int row, col;

    private Util util;

    public Sudoku() {
        this.grid = new int[9][9];
        this.solnGrid = new int[9][9];
        this.guessNum = new int[9];
        this.gridPos = new int[81];
        this.difficultyLevel = 0;

        this.util = new Util();

        for (int i = 0; i < 81; i++) {
            this.gridPos[i] = i;
        }

        util.random_shuffle(this.gridPos);

        for (int i = 0; i < 9; i++) {
            this.guessNum[i] = i + 1;
        }

        util.random_shuffle(this.guessNum);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                this.grid[i][j] = 0;
            }
        }

        this.grid_status = true;
    }

    public boolean FindUnassignedLocation() {
        for (this.row = 0; this.row < 9; this.row++) {
            for (this.col = 0; this.col < 9; this.col++) {
                if (this.grid[this.row][this.col] == UNASSIGNED)
                    return true;
            }
        }
        return false;
    }

    public void fillEmptyDiagonalBox(int idx) {
        int start = idx * 3;
        this.util.random_shuffle(this.guessNum);
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                this.grid[start + i][start + j] = guessNum[i * 3 + j];
            }
        }
    }

    public void createSeed() {
          /* Fill diagonal boxes to form:
      x | . | .
      . | x | .
      . | . | x
  */
        this.fillEmptyDiagonalBox(0);
        this.fillEmptyDiagonalBox(1);
        this.fillEmptyDiagonalBox(2);

  /* Fill the remaining blocks:
      x | x | x
      x | x | x
      x | x | x
  */
        this.solveGrid(); // TODO: not truly random, but still good enough because we generate random diagonals.

        // Saving the solution grid
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                this.solnGrid[i][j] = this.grid[i][j];
            }
        }
    }

    public boolean solveGrid() {
        // If there is no unassigned location, we are done

        if (!this.FindUnassignedLocation())
            return true; // success!

        // Consider digits 1 to 9
        for (int num = 0; num < 9; num++) {
            // if looks promising
            if (this.util.isSafe(this.grid, this.row, this.col, this.guessNum[num])) {
                // make tentative assignment
                this.grid[this.row][this.col] = this.guessNum[num];

                // return, if success, yay!
                if (solveGrid())
                    return true;

                // failure, unmake & try again
                this.grid[this.row][this.col] = UNASSIGNED;
            }
        }

        return false;
    }

    public int[][] getGrid() {
        return this.grid;
    }

    public void countSoln(int number) {
        if (!this.FindUnassignedLocation()) {
            number++;
            return;
        }


        for (int i = 0; i < 9 && number < 2; i++) {
            if (this.util.isSafe(this.grid, this.row, this.col, this.guessNum[i])) {
                this.grid[this.row][this.col] = this.guessNum[i];
                countSoln(number);
            }

            this.grid[this.row][this.col] = UNASSIGNED;
        }
    }

    public void genPuzzle() {
        for (int i = 0; i < 81; i++) {
            int x = (this.gridPos[i]) / 9;
            int y = (this.gridPos[i]) % 9;
            int temp = this.grid[x][y];
            this.grid[x][y] = UNASSIGNED;

            // If now more than 1 solution , replace the removed cell back.
            int check = 0;
            countSoln(check);
            if (check != 1) {
                this.grid[x][y] = temp;
            }
        }
        System.out.println("-------------------------");
        for (int i = 0; i < this.grid.length; i++)
            System.out.println(Arrays.toString(this.grid[i]));
    }

    public boolean verifyGridStatus() {
        return this.grid_status;
    }

    public void calculateDifficulty() {
        int B = branchDifficultyScore();
        int emptyCells = 0;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (this.grid[i][j] == 0)
                    emptyCells++;
            }
        }

        this.difficultyLevel = B * 100 + emptyCells;
    }

    public int branchDifficultyScore() {
        int emptyPositions = -1;
        int[][] tempGrid = new int[9][9];
        int sum = 0;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                tempGrid[i][j] = this.grid[i][j];
            }
        }

        while (emptyPositions != 0) {
            List<List<Integer>> empty = new ArrayList<>();

            for (int i = 0; i < 81; i++) {
                if (tempGrid[(int) (i / 9)][(int) (i % 9)] == 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);

                    for (int num = 1; num <= 9; num++) {
                        if (this.util.isSafe(tempGrid, i / 9, i % 9, num)) {
                            temp.add(num);
                        }
                    }

                    empty.add(temp);
                }

            }

            if (empty.size() == 0) {
                System.out.println("Hello: " + sum);
                return sum;
            }

            int minIndex = 0;

            int check = empty.size();
            for (int i = 0; i < check; i++) {
                if (empty.get(i).size() < empty.get(minIndex).size())
                    minIndex = i;
            }

            int branchFactor = empty.get(minIndex).size();
            int rowIndex = empty.get(minIndex).get(0) / 9;
            int colIndex = empty.get(minIndex).get(0) % 9;

            tempGrid[rowIndex][colIndex] = this.solnGrid[rowIndex][colIndex];
            sum = sum + ((branchFactor - 2) * (branchFactor - 2));

            emptyPositions = empty.size() - 1;
        }

        return sum;
    }

    public void reset(){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                this.grid[i][j] = 0;
            }
        }
        this.createSeed();
        this.genPuzzle();
    }
}
