
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken()); //테스트 케이스 개수

        for(int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); //서쪽의 사이트
            int M = Integer.parseInt(st.nextToken()); //동쪽의 사이트 >= N
            int ret = getCombination(N, M);
            bw.write(ret+"\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }

    static int getCombination(int n, int m) {
        int [][] d = new int[m+1][n+1];
        for(int i=1; i<=m; i++) {
            d[i][0] = 1;
            d[i][1] = 1;
            if(i<=n) d[i][i] = 1;
        }
        for(int i=2; i<=m; i++) {
            for(int j=1; j<=n && j<=i; j++) {
                d[i][j] = d[i-1][j-1] + d[i-1][j];
            }
        }
        return d[m][n];
    }

}