
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long[][] D = new long[N+1][2];
        D[1][0] = 0;
        D[1][1] = 1;

        for(int i=2; i<=N; i++) {
            D[i][0] = D[i-1][1] + D[i-1][0];
            D[i][1] = D[i-1][0];
        }

        bw.write((D[N][0]+D[N][1])+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}