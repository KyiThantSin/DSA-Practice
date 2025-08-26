package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class practice {
    public void floodFill(int[][] images, int sr, int sc, int newColor) {
        int targetColor = images[sr][sc];
        int row = images.length;
        int col = images[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { sr, sc });

        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];

            if (images[r][c] != targetColor)
                continue;

            images[r][c] = newColor;
            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr >= 0 && nr < row && nc >= 0 && nc < col && images[nr][nc] == targetColor) {
                    queue.offer(new int[] { nr, nc });
                }
            }
        }

    }

    public boolean isExitExist(int[][] images, int sr, int sc) {
        int rows = images.length;
        int cols = images[0].length;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];

        visited[sr][sc] = true;
        queue.offer(new int[] { sr, sc });

        int[][] dirs = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();

            int r = cell[0];
            int c = cell[1];
            if (images[r][c] == 2)
                return true;
            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && !visited[nr][nc]
                        && (images[nr][nc] == 0 || images[nr][nc] == 2)) {
                    queue.offer(new int[] { nr, nc });
                    visited[nr][nc] = true;
                }
            }
        }

        return false;
    }

    public int maxLand(int[][] images, int sr, int sc) {
        int count = 0;
        int rows = images.length;
        int cols = images[0].length;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];
        queue.offer(new int[] { sr, sc });

        visited[sr][sc] = true;
        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, -1, 1 };
        
        if (images[sr][sc] != 1) return 0;

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();

            count++;
            for (int i = 0; i < dr.length; i++) {
                int nr = cell[0] + dr[i];
                int nc = cell[1] + dc[i];
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && !visited[nr][nc] && images[nr][nc] == 1) {
                    queue.offer(new int[] { nr, nc });
                    visited[nr][nc] = true;
                }
            }
        }
        return count;
    }

    public void printGrid(int[][] grid) {
        for (int[] rows : grid) {
            for (int col : rows) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String args[]) {
        practice p = new practice();
        int[][] grids = {
                { 1, 1, 1 },
                { 1, 1, 0 },
                { 1, 0, 1 }
        };

        System.out.println("Before ");
        p.printGrid(grids);
        System.out.println("After");
        p.floodFill(grids, 1, 1, 2);
        p.printGrid(grids);

        int[][] images = {
                { 1, 1, 1 },
                { 1, 0, 2 },
                { 1, 1, 1 },
        };

        System.out.println("Finding Exits");
        System.out.println(p.isExitExist(images, 1, 1));

        System.out.println("Finding Max Land");
        int[][] lands = {
                { 1, 1, 0, 0 },
                { 1, 0, 0, 1 },
                { 0, 0, 1, 1 }
        };

        int max = 0;

        for(int i=0; i < lands.length; i++){
            for(int j=0; j < lands[0].length; j++){
                int area = p.maxLand(lands, i, j);
                max = Math.max(max, area); 
            }
        }

        System.out.println("Max Length -> "+ max);
    }
}
