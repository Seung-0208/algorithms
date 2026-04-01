import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] isVisited;
    static int[][] guide = {{1,-1,0,0}, {0,0,1,-1}};
    static int[][] map;
    static int ans;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        isVisited = new boolean[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                isVisited[i][j] = true;
                DFS(i, j, 1, map[i][j]);
                isVisited[i][j] = false;

                checkT(i, j);
            }
        }

        DFS(0, 0, 0, 0);

        sb.append(ans);
        System.out.println(sb);
        br.close();
    }

    static void checkT(int x, int y) {
        int center = map[x][y];

        int sumNeighbors = 0;
        int minNeighbor = Integer.MAX_VALUE;
        int cnt = 0;

        for(int i=0; i<4; i++) {
            int nx = x+guide[0][i];
            int ny = y+guide[1][i];

            if(nx<0 || nx >=N || ny < 0 || ny >= M) continue;

            cnt++;
            sumNeighbors += map[nx][ny];
            minNeighbor = Math.min(minNeighbor, map[nx][ny]);
        }

        if(cnt < 3) return;

        if(cnt == 4) {
            ans = Math.max(ans, center+(sumNeighbors - minNeighbor));
        } else {
            ans = Math.max(ans, center+sumNeighbors);
        }
    }

    static void DFS(int x, int y, int depth, int sum) {
        if(depth == 4) {
            ans = Math.max(ans, sum);
            return;
        }

        for(int i=0; i<4; i++) {
            int nx = x+guide[0][i];
            int ny = y+guide[1][i];
            if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            if(isVisited[nx][ny]) continue;

            isVisited[nx][ny] = true;
            DFS(nx, ny, depth+1, sum + map[nx][ny]);
            isVisited[nx][ny] = false;
        }
    }
}