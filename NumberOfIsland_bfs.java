import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIsland_bfs {
    public static void main(String[] args) {
        char[][] grid=  {
            {'1','1','1','0','1'},
            {'1','1','0','0','0'},
            {'0','0','0','0','1'},
            {'0','0','0','0','1'}
            };

        NumberOfIsland_bfs a = new NumberOfIsland_bfs();
        System.out.println(a.numberOfIsland_bfs(grid));
    }

    int numberOfIsland_bfs(char[][] grid) {
        if(grid==null || grid.length==0 ) return 0;
        int count = 0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='1'){
                    count++;
                    bfs(grid,i,j);
                }
            }
        }


        return count;
    }
    int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
    void bfs(char[][] grid, int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x,y});
        while(!q.isEmpty()){
            int size = q.size();
            int[] point = q.poll();
            for(int i=0;i<size;i++){
                for(int[] dir : dirs){
                    int x1 = point[0]+dir[0];
                    int y1 = point[1]+dir[1];
                    if(x1>=0 && y1>=0 && x1<grid.length && y1<grid[0].length && grid[x1][y1]=='1'){
                        grid[x1][y1]='0';
                        q.offer(new int[] {x1,y1});
                    }
                }
            }

        }

    }
}
