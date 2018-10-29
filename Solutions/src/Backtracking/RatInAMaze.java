package Backtracking;

public class RatInAMaze {

    /*

    A Maze is given as N*N binary matrix of blocks where source block is the
    upper left most block i.e., maze[0][0] and destination block is lower
    rightmost block i.e., maze[N-1][N-1]. A rat starts from source and
    has to reach the destination. The rat can move only in two
    directions: forward and down.

    In the maze matrix, 0 means the block is a dead end and 1 means the block can
    be used in the path from source to destination. Note that this is a simple
    version of the typical Maze problem. For example, a more complex version
    can be that the rat can move in 4 directions and a more complex version
    can be with a limited number of moves.

    */

    public static void main(String[] args) {
        int[][] maze = {{1, 0, 0, 0}, {1, 1, 0, 1}, {0, 1, 0, 0}, {1, 1, 1, 1}};
        RatInAMaze ratInAMaze = new RatInAMaze();
        boolean result = ratInAMaze.solve(maze, 0, 0, 4);
        System.out.println(result);
    }

    public boolean solve(int[][] maze, int i, int j, int n) {
        if (i == n - 1 && j == n - 1) return true; // reached the end
        if (i == n || j == n) return false; // invalid block
        if (maze[i][j] == 0) return false; // blocked path, go back
        return solve(maze, i + 1, j, n) || solve(maze, i, j + 1, n); // try two possible blocks
    }

}
