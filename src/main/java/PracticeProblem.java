import java.util.*;

public class PracticeProblem {

	public static void main(String args[]) {

	}

	public static int searchMazeMoves(String[][] maze) {
        int rows = maze.length;
        int cols = maze[0].length;
        int startRow = rows - 1, startCol = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startRow, startCol, 0});
        visited[startRow][startCol] = true;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0], c = curr[1], moves = curr[2];
            if ("F".equals(maze[r][c])) {
                return moves;
            }
            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols
                    && !visited[nr][nc]
                    && !"*".equals(maze[nr][nc])) {
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc, moves+1});
                }
            }
        }
        return -1;
    }

}