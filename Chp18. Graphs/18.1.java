class SearchMaze {
    final static int[][] DIRECTIONS = {{0,1},{1,0},{-1,0},{0,-1}};

    public static void main(String[] args) {
      int[][] maze = new int[10][10];

      //col    0 1 2 3 4 5 6 7 8 9
      //r0     1 0 0 0 0 0 1 1 0 2
      //r1     0 0 1 0 0 0 0 0 0 0
      //r2     1 0 1 0 0 1 1 0 1 1
      //r3     0 0 0 1 1 1 0 0 1 0
      //r4     0 1 1 0 0 0 0 0 0 0
      //r5     0 1 1 1 0 1 0 1 1 0
      //r6     0 0 0 0 0 0 0 0 0 0
      //r7     1 0 1 0 1 0 1 0 0 0
      //r8     1 0 1 1 0 0 0 1 1 1
      //r9     0 0 0 0 0 0 0 0 1 1
      // 1 == blocked path.
      maze[0][0] = 1;   
      maze[0][6] = 1;
      maze[0][7] = 1;
      maze[0][9] = 2;   // Destination
      maze[1][2] = 1;
      maze[2][0] = 1;
      maze[2][2] = 1;
      maze[2][5] = 1;
      maze[2][6] = 1;
      maze[2][8] = 1;
      maze[2][9] = 1;
      maze[3][3] = 1;
      maze[3][4] = 1;
      maze[3][5] = 1;
      maze[3][8] = 1;
      maze[4][1] = 1;
      maze[4][2] = 1;
      maze[5][1] = 1;
      maze[5][2] = 1;
      maze[5][3] = 1;
      maze[5][5] = 1;
      maze[5][7] = 1;
      maze[5][8] = 1;
      maze[7][0] = 1;
      maze[7][2] = 1;
      maze[7][4] = 1;
      maze[7][6] = 1;
      maze[8][0] = 1;
      maze[8][2] = 1;
      maze[8][3] = 1;
      maze[8][7] = 1;
      maze[8][8] = 1;
      maze[8][9] = 1;
      maze[9][8] = 1;
      maze[9][9] = 1;

      var hasPath = searchMaze(maze);
      System.out.println(hasPath);
    }

    public static boolean searchMaze(int[][] maze){
      return navigate(maze, 9, 0, 9, 0); // starts at x = 9 and y = 0
    }

    public static boolean navigate(int[][] maze, int x, int y, int px, int py) {
      if(!isXAndYWithinBounds(x, y)) { return false; }
      if(maze[x][y] == 1) { return false; }   // Hit a wall
      if(maze[x][y] > 1) { return true; }
    
      for(int[] d : DIRECTIONS) {
        if(px == x + d[0] && py == y + d[1]) { continue; }  // Don't go back to where we came from.
          navigate(maze, x + d[0], y + d[1], x, y);
      }

      return false;
    }

    public static boolean isXAndYWithinBounds(int x, int y) {
        return x >= 0 && x < 10 && y >= 0 && y < 10;
    }
}