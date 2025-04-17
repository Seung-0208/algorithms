import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

public class Main{
    static int MAX_VALUE =10000001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //도시의 개수
        int[][] D = new int[n+1][n+1];
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(i!=j) D[i][j] = MAX_VALUE;
                else D[i][j] = 0;
            }
        }
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken()); //버스의 개수

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(D[a][b] > c) D[a][b] = c;
        }

        for(int k=1; k<=n; k++) {
            for(int s=1; s<=n; s++) {
                for(int e=1; e<=n; e++) {
                    if(D[s][e] > D[s][k]+D[k][e]) {
                        D[s][e] = D[s][k] + D[k][e];

                    }
                }
            }
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(D[i][j]==MAX_VALUE) bw.write("0 ");
                else bw.write(D[i][j]+" ");
            }
            bw.write("\n");
        }
        bw.flush();
    }
}