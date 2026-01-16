
import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] guide = {{0,0,-1,1}, {1,-1,0,0}};
    static int ans;
    static ArrayList<int[]> empties = new ArrayList<>();
    static ArrayList<int[]> viruses = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //행
        M = Integer.parseInt(st.nextToken()); //열
        map = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0) empties.add(new int[]{i, j});
                if(map[i][j] == 2) viruses.add(new int[]{i,j});
            }
        }

        tracking(0, 0);

        sb.append(ans);
        System.out.println(sb);
        br.close();
    }

    static void tracking(int startIdx, int cnt) {
        if(cnt == 3) {
            ans = Math.max(ans, spread());
            return;
        }

        for(int i=startIdx; i<empties.size(); i++) {
            int[] pos = empties.get(i);
            int r = pos[0], c = pos[1];

            map[r][c] = 1;
            tracking(i+1, cnt+1);
            map[r][c] = 0;
        }
    }

    static int spread() {
        int[][] copy = new int[N][M];
        for(int i=0; i<N; i++) {
            if(M >= 0) System.arraycopy(map[i], 0, copy[i], 0, M);
        }

        ArrayDeque<int[]> q = new ArrayDeque<>();
        for(int[] v : viruses) q.add(new int[]{v[0], v[1]});

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            for(int i=0; i<4; i++) {
                int nr = r + guide[0][i], nc = c + guide[1][i];
                if(nr >= 0 && nr < N && nc >= 0 && nc < M && copy[nr][nc] == 0) {
                    copy[nr][nc] = 2;
                    q.add(new int[]{nr, nc});
                }
            }
        }

        int safe = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(copy[i][j] == 0) safe++;
            }
        }

        return safe;
    }
}