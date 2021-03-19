import java.util.*;

public class Maze1_bfs {
    public static void main(String[] args) {
        int[][] maze ={ {0,0,1,0,0},
                        {0,0,0,0,0},
                        {0,0,0,1,0},
                        {1,1,0,1,1},
                        {0,0,0,0,0} };
        int[] start = {0,4};
        int[] desti = {4,4};
        // int[] desti ={3,2};

        Maze1_bfs a = new Maze1_bfs();
        System.out.println(a.hasPath(maze,start,desti));
    }

    int[][] dirs =  {{-1,0},{1,0},{0,-1},{0,1}};
    int m, n;

    public boolean hasPath(int[][] maze, int[] start, int[] desti){
        m = maze.length;        //5
        n = maze[0].length;     //5
        if(start[0]==desti[0] && start[1] == desti[1]){
            return true;
        }  
        boolean[][] visited = new boolean[m][n];
        visited[start[0]][start[1]] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {start[0],start[1]});

        while(!queue.isEmpty()){
            int[] p = queue.poll();
            for(int[] dir : dirs){
                int x = p[0]+dir[0];
                int y = p[1]+dir[1];
                while(x>=0 && x<m && y>=0 && y<n && maze[x][y]==0){
                    x+=dir[0];
                    y+=dir[1];
                }
                    x-=dir[0];
                    y-=dir[1];
                    if(visited[x][y]) continue;
                    visited[x][y] = true;      
                    System.out.println("========");              
                    print(visited);
                    if(x==desti[0] && y==desti[1]) return true;
                    queue.offer(new int[] {x,y});           
            }
        }
        return false;
    }

    public void print(boolean[][] visitied) {
        if(visitied ==null || visitied.length==0) return;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(visitied[i][j]+"\t");
            }
            System.err.println();
        }
    }
}
