package com.gsr.sudoku;

import java.util.Random;

public class Sudoku {

    private int GRID_SIZE;

    private char[][] grid;

    private final Random random;

    public Sudoku(int gridSize) {
        this.GRID_SIZE = gridSize;
        this.grid = new char[GRID_SIZE][GRID_SIZE];

        this.random = new Random();

        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++){
                this.grid[i][j] = ' ';
            }
        }
    }

    private boolean checkEmptyPos(int row, int col){
        return this.grid[row][col] == ' ';
    }

    public void createSeed() {
        int num = (int) (GRID_SIZE*GRID_SIZE*0.375);
        for (int i = 0; i < num; i++) {
            int row = random.nextInt(GRID_SIZE);
            int col = random.nextInt(GRID_SIZE);
            while (!this.checkEmptyPos(row, col)){
                row = random.nextInt(GRID_SIZE);
                col = random.nextInt(GRID_SIZE);
            }
            int value = random.nextInt(GRID_SIZE) + 1;
            this.grid[row][col] = Character.forDigit(value, 10);
        }
    }

    public char[][] getGrid() {
        return this.grid;
    }

    public void reset(){
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                this.grid[i][j] = ' ';
            }
        }
        this.createSeed();
    }

    public int getGridSize(){
        return this.GRID_SIZE;
    }
}
