import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;
    static ArrayList<int[]> viruses = new ArrayList<>();
    static ArrayList<int[]> safes = new ArrayList<>();
    static int max = Integer.MIN_VALUE;
    static int N, M;
    static int[][] guide = {{1,-1,0,0}, {0,0,1,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) viruses.add(new int[] {i, j});
                if(map[i][j] == 0) safes.add(new int[] {i, j});
            }
        }


        tracking(0, 0);
        sb.append(max);

        System.out.println(sb);
    }

    static void tracking(int idx, int cnt) {
        if(cnt == 3) {
            getSafeCount();
            return;
        }

        for(int i=idx; i<safes.size(); i++) {
            int nr = safes.get(i)[0];
            int nc = safes.get(i)[1];
            if(map[nr][nc] != 1) {
                map[nr][nc] = 1;
                tracking(i+1, cnt+1);
                map[nr][nc] = 0;
            }
        }
    }

    static void getSafeCount() {
        int[][] copyMap = new int[N][M];
        for(int i=0; i<N; i++) {
            System.arraycopy(map[i], 0, copyMap[i], 0, M);
        }

        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] isVisited = new boolean[N][M];
        for(int[] v : viruses) {
            q.add(v.clone());
            isVisited[v[0]][v[1]] = true;
        }

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            for(int i=0; i<4; i++) {
                int nr = curr[0] + guide[0][i];
                int nc = curr[1] + guide[1][i];
                if(nr >= 0 && nr < N && nc >= 0 && nc < M && !isVisited[nr][nc] && copyMap[nr][nc] == 0) {
                    copyMap[nr][nc] = 2;
                    q.add(new int[] {nr, nc});
                }
            }
        }

        int cnt = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(copyMap[i][j] == 0) cnt++;
            }
        }
        max = Math.max(cnt, max);
    }
}