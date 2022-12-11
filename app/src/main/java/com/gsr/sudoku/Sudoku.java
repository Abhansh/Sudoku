package com.gsr.sudoku;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Sudoku {

    private int GRID_SIZE;

    private int[][] grid;

    private final Random random;
    private int[][] solvedGrid;
    private List<Integer> numbers;

    public Sudoku(int gridSize) {
        this.GRID_SIZE = gridSize;
        this.grid = new int[GRID_SIZE][GRID_SIZE];
        this.solvedGrid = new int[GRID_SIZE][GRID_SIZE];

        this.random = new Random();

        this.numbers = new ArrayList<>();

        for (int i = 1; i <= this.GRID_SIZE; i++) this.numbers.add(i);

        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                this.grid[i][j] = 0;
                this.solvedGrid[i][j] = 0;
            }
        }
    }

    private boolean checkSafeMove(int[][] grid, int num, int row, int col) {
        boolean safeRow = this.checkSafeRow(grid, num, row);
        boolean safeCol = this.checkSafeCol(grid, num, col);
        boolean safeCell = this.checkSafeCell(grid, num, row, col);
        return safeRow && safeCol && safeCell;
    }

    private boolean checkSafeRow(int[][] grid, int num, int row) {
        for (int i = 0; i < this.GRID_SIZE; i++) {
            if (grid[row][i] == num) {
                return false;
            }
        }
        return true;
    }

    private boolean checkSafeCol(int[][] grid, int num, int col) {
        for (int i = 0; i < this.GRID_SIZE; i++) {
            if (grid[i][col] == num) {
                return false;
            }
        }
        return true;
    }

    private boolean checkSafeCell(int[][] grid, int num, int row, int col) {
        int cellRow = row / 3;
        int cellColl = col / 3;

        boolean res = true;
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (grid[cellRow * 3 + r][cellColl * 3 + c] == num) {
                    res = false;
                    break;
                }
            }
        }
        return res;
    }

    private int findFreeLocation(int[][] grid) {
        int pos = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (grid[i][j] == 0) {
                    return pos;
                }
                pos++;
            }
        }
        return pos;
    }

    private void createSeed() {
        for (int c = 0; c < this.GRID_SIZE; c++) {
            int row = random.nextInt(this.GRID_SIZE);
            int col = random.nextInt(this.GRID_SIZE);
            int value = random.nextInt(this.GRID_SIZE) + 1;
            while (!this.checkSafeMove(this.grid, value, row, col))
                value = random.nextInt(this.GRID_SIZE) + 1;
            this.grid[row][col] = value;
            this.solvedGrid[row][col] = value;
        }
    }

    private boolean solve() {
        int pos = this.findFreeLocation(this.solvedGrid);
        if (pos >= this.GRID_SIZE * this.GRID_SIZE)
            return true;
        int i = pos / this.GRID_SIZE;
        int j = pos % this.GRID_SIZE;
        Collections.shuffle(this.numbers);
        for (int x = 0; x < 9; x++) {
            if (this.checkSafeMove(this.solvedGrid, this.numbers.get(x), i, j)) {
                this.solvedGrid[i][j] = this.numbers.get(x);
                if (this.solve())
                    return true;
                this.solvedGrid[i][j] = 0;
            }
        }
        return false;
    }

    public void createGame() {
        this.createSeed();
        this.solve();
        for (int i = 0; i < this.GRID_SIZE; i++) {
            for (int j = 0; j < this.GRID_SIZE; j++) {
                this.grid[i][j] = 0;
            }
        }

        for (int i = 0; i < 36; i++) {
            int row = random.nextInt(this.GRID_SIZE);
            int col = random.nextInt(this.GRID_SIZE);
            while (!(this.grid[row][col] == 0)) {
                row = random.nextInt(this.GRID_SIZE);
                col = random.nextInt(this.GRID_SIZE);
            }
            this.grid[row][col] = this.solvedGrid[row][col];
        }
    }

    public void reset() {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                this.grid[i][j] = 0;
                this.solvedGrid[i][j] = 0;
            }
        }
    }

    public int getGridSize() {
        return this.GRID_SIZE;
    }

    public int[][] getGrid() {
        return this.grid;
    }
}
