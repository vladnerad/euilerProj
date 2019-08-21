package com.company.secondten;

public class Task15 {

    // В задаче сказано поле 2х2 - оно имеет 3 узла
    // поле 20х20 имеет 21 узел
    private long[][] grid = new long[21][21];

    public long getAnswer() {
        grid[0][0] = 0;
        for (int i = 1; i < grid.length; i++) {
            grid[i][0] = 1;
            grid[0][i] = 1;
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid.length; j++) {
                grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
            }
        }
        return grid[grid.length - 1][grid.length - 1];
    }
}
