
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] D = new int[N+1][K+1];
        for(int i=1; i<=N; i++) {
            D[i][0] = 1;
            if(K >= 1) D[i][1] = 1;
            if(i<=K) D[i][i] = 1;
        }

        for(int i=2; i<=N; i++) {
            for(int j=1; j<=K && j<=i; j++) {
                D[i][j] = D[i-1][j] + D[i-1][j-1];
            }
        }
        bw.write(D[N][K]+"\n");
        bw.flush();
        bw.close();
        br.close();
    }

}