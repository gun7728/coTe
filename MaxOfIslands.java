public class MaxOfIslands {
    public static void main(String[] args) {
        int[][] island = {
                            {1,1,0,1,1},
                            {0,1,1,0,0},
                            {0,0,0,0,0},
                            {1,1,0,1,1},
                            {1,0,1,1,1},
                            {1,0,1,1,1}    
                         };

        MaxOfIslands a = new MaxOfIslands();
        System.out.println(a.solve(island));
    }
    int m,n;
    public int solve(int[][] grid){
        //1. 섬 개수
        if(grid == null || grid.length==0)
            return 0;

        m = grid.length;
        n = grid[0].length;
        int max = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    int area = dfs(grid,i,j,0);
                    
                    //2. max = Math.max(max, area)
                    max = Math.max(max,area);
                }
            }
        }

        return max;


        
    }

    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    int dfs(int[][] grid, int x, int y, int area){
        //1. 조건
        if(x<0 || x>=m || y<0 || y>=n || grid[x][y]==0){
            return area;
        }
        //2. 1인 육지만 들어온다.
        grid[x][y]=0;
        area++;
        for(int[] dir : dirs){
            area = dfs(grid,x+dir[0],y+dir[1],area);
        }

        return area;

    }
}
