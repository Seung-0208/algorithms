
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //표의 크기
        int M = Integer.parseInt(st.nextToken()); //구해야 하는 구간의 횟수
        int[][] table = new int[N+1][N+1];
        int[][] sum = new int[N+1][N+1];

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + table[i][j];
            }
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int row1 = Integer.parseInt(st.nextToken());
            int col1 = Integer.parseInt(st.nextToken());
            int row2 = Integer.parseInt(st.nextToken());
            int col2 = Integer.parseInt(st.nextToken());
            int ans = sum[row2][col2] - sum[row1-1][col2] - sum[row2][col1-1] + sum[row1-1][col1-1];
            sb.append(ans).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}