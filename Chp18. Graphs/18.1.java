import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class SearchMaze {
    static class Coordinate {
      int row;
      int col;
    
      public Coordinate() {}
    
      public Coordinate(int row, int col) {
        this.row = row;
        this.col = col;
      }
    }

    static enum Color { WHITE, BLACK }
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

      List<Coordinate> paths = searchMaze(maze);
      for(Coordinate p: paths) {
        System.out.println(p.row + " " + p.col);
      }       
    }

    public static List<Coordinate> searchMaze(int[][] maze){
      Coordinate start = new Coordinate(9, 0);
      Coordinate end = new Coordinate(0, 9);
      List<Coordinate> path = new ArrayList<Coordinate>();
      if(hasPath(maze, start, end, path)) {
        return path;
      }
      return Collections.EMPTY_LIST;
    }

    public static boolean hasPath(int[][] maze, Coordinate cur, Coordinate dest, List<Coordinate> path) {
      if(!isCoordinateWithinBoundsAndNotVisited(maze, cur)) { return false; }
      if(cur.row == dest.row && cur.col == dest.col) { return true; }
      
      for(int[] d : DIRECTIONS) {
        maze[cur.row][cur.col] = Color.BLACK.ordinal();
        path.add(cur);
        if(hasPath(maze, new Coordinate(cur.row + d[0], cur.col + d[1]), dest, path)){
          return true;
        }
        path.remove(path.size() - 1);
      }
      return false;
    }

    public static boolean isCoordinateWithinBoundsAndNotVisited(int[][] maze, Coordinate cur) {
        return cur.row >= 0 && cur.row < 10 && 
        cur.col >= 0 && cur.col < 10 &&
        maze[cur.row][cur.col] == Color.WHITE.ordinal();
    }
}