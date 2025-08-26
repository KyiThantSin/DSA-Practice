package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class practice {
    public void floodFill(int[][] images, int sr, int sc, int newColor){
        int targetColor = images[sr][sc];
        int row = images.length;
        int col = images[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr,sc});

        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0]; 
            int c = cell[1];

            if(images[r][c] != targetColor) continue;

            images[r][c] = newColor;
            for(int[] dir: dirs){
                int nr = r + dir[0];
                int nc = c + dir[1];
                if(nr >= 0 && nr < row && nc >= 0 && nc < col && images[nr][nc] == targetColor){
                    queue.offer(new int[]{nr, nc});
                }
            }
        }

    }

    public void printGrid(int[][] grid){
        for(int[] rows: grid){
            for(int col: rows){
                System.out.print(col+ " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String args[]){
        practice p = new practice();
        int[][] grids = {
            {1,1,1},
            {1,1,0},
            {1,0,1}
        };

        System.out.println("Before ");
        p.printGrid(grids);
        System.out.println("After");
        p.floodFill(grids, 1, 1, 2);
        p.printGrid(grids);
    }
}
