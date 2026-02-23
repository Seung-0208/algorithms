import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;
    static ArrayList<int[]> chickens = new ArrayList<>();
    static ArrayList<int[]> homes = new ArrayList<>();
    static int N,M;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) chickens.add(new int[] {i, j});
                if(map[i][j] == 1) homes.add(new int[] {i, j});
            }
        }

        M = chickens.size()-M; //폐점시켜야 하는 치킨집의 수

        tracking(0, 0);
        sb.append(min);

        System.out.println(sb);
    }

    static void tracking(int idx, int cnt) {
        if(cnt == M) {
            calculate();
            return;
        }

        for(int i=idx; i<chickens.size(); i++) {
            int nr = chickens.get(i)[0];
            int nc = chickens.get(i)[1];
            if(map[nr][nc] == 2) {
                map[nr][nc] = 0;
                tracking(i+1, cnt+1);
                map[nr][nc] = 2;
            }
        }
    }

    static void calculate() {
        ArrayList<int[]> chickensT = new ArrayList<>();
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j] == 2) {
                    chickensT.add(new int[] {i, j});
                }
            }
        }

        int sum = 0;
        for(int[] h : homes) {
            int t = Integer.MAX_VALUE;
            for(int[] c : chickensT) {
                t = Math.min(t, Math.abs(h[0]-c[0])+Math.abs(h[1]-c[1]));
            }
            sum += t;
        }

        min = Math.min(sum, min);
    }
}