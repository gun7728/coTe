import java.io.*;
import java.util.*;

public class War {
    static int n, m;
    static int[][] arr;
    static boolean[][] isVisit;
    static int count;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        isVisit = new boolean[n][m];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                if (str.charAt(j) == 'W') arr[i][j] = 1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isVisit[i][j] || arr[i][j] == 0) continue;
                count = 0;
                dfs(i,j, 1);
                sum += count * count;
            }
        }

        System.out.println(sum);
        isVisit = new boolean[n][m];
        sum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isVisit[i][j] || arr[i][j] == 1) continue;
                else {
                    count = 0;
                    dfs(i, j, 0);
                    sum += count * count;
                }
            }
        }

        System.out.println(sum);
    }
    static int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

    public static void dfs(int x, int y, int find) {
        isVisit[x][y] = true;
        count++;
        for(int[] dir : dirs){
            int dx = dir[0];
            int dy = dir[1];

            int nextX = x + dx;
            int nextY = y + dy;
            if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) continue;

            if (!isVisit[nextX][nextY] && arr[nextX][nextY] == find) {
                dfs(nextX, nextY, find);
            }
            
        }
        
    }
}
