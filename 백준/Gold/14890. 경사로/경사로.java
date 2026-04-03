import java.io.*;
import java.util.*;

public class Main {
    static int N, L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken()); //경사로의 길이

        int[][] map = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = 0;

        //행 기준
        for(int i=0; i<N; i++) {
            int[] line = new int[N];
            System.arraycopy(map[i], 0, line, 0, N);
            if(canPass(line)) ans++;
        }

        for(int i=0; i<N; i++) {
            int[] line = new int[N];
            for(int j=0; j<N; j++) line[j] = map[j][i];
            if(canPass(line)) ans++;
        }

        sb.append(ans);
        System.out.println(sb);
        br.close();
    }

    static boolean canPass(int[] line) {
        boolean[] isUsed = new boolean[line.length];

        for(int i=0; i<N-1; i++) {
            int cur = line[i];
            int next = line[i+1];

            if(cur== next) continue;

            if(Math.abs(cur-next) >= 2) return false;

            if(cur < next) {
                for(int j=i; j>=i-L+1; j--) {
                    if(j < 0) return false;
                    if(cur != line[j]) return false;
                    if(isUsed[j]) return false;
                }
                for(int j=i; j>=i-L+1; j--) {
                    isUsed[j] = true;
                }
            }

            if(cur > next) {
                for(int j=i+1; j<=i+L; j++) {
                    if(j >= N) return false;
                    if(next != line[j]) return false;
                    if(isUsed[j]) return false;
                }
                for(int j=i+1; j<=i+L; j++) {
                    isUsed[j] = true;
                }
            }
        }
        return true;
    }
}