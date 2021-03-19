public class Maze1_dfs {
    public static void main(String[] args) {
        int[][] maze ={ {0,0,1,0,0},
                        {0,0,0,0,0},
                        {0,0,0,1,0},
                        {1,1,0,1,1},
                        {0,0,0,0,0} };
                int[] start = {0,4};
                // int[] desti = {4,4};
                int[] desti ={3,2};

        Maze1_dfs a = new Maze1_dfs();
        System.out.println(a.hasPath(maze,start,desti));
    }
    int[][] dirs =  {{-1,0},{1,0},{0,-1},{0,1}};
    int m, n;

    public boolean hasPath(int[][] maze, int[] start, int[] desti){
        if(maze==null || maze.length==0)
            return false;
        m = maze.length;
        n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        return dfs(maze, start, desti, visited);
        
    }

    public boolean dfs(int[][] maze, int[] start, int[] desti, boolean[][] visited){
        if(start[0]<0 || start[0] >= m || start[1] <0 || start[1] >=n || visited[start[0]][start[1]]){
            return false;
        }
        visited[start[0]][start[1]] = true;
        if(start[0]==desti[0]&&start[1]==desti[0]) return true;

        for(int[] dir : dirs){
            int x=start[0];
            int y=start[1];
            while(x>=0 && x<m && y>=0 && y<n && maze[x][y]!=1){
                x+=dir[0];
                y+=dir[1];
            }
                x-=dir[0];
                y-=dir[1];
            if(dfs(maze,new int[] {x,y},desti,visited)) return true;
        }


        return false;
    }
}
