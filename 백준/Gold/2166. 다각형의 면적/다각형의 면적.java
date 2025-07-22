
import java.io.*;
import java.util.*;

public class Main {
    static int[][] lineInfo;
    static int[] parent;

    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long[][] points = new long[N+1][2];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
        }

        points[N][0] = points[0][0];
        points[N][1] = points[0][1];

        double ans = 0;
        for(int i=1; i<=N; i++) {
            long CCW = points[i-1][0]*points[i][1] - points[i][0]*points[i-1][1];
            ans += CCW;
        }

        String ansString = String.format("%.1f", Math.abs(ans) / 2.0);

        bw.write(ansString+"\n");

        bw.flush();
        bw.close();
        br.close();
    }
}