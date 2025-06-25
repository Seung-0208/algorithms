
import java.io.*;
import java.util.*;

public class Main {
    private static final int INF = 1000000 * 16 + 1;
    static int N; //도시의 수
    static int[][] W; //가중치
    static int[][] D; //DP용
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        W = new int[N][N];
        D = new int[N][1<<N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = tsp(0, 1);
        bw.write(ans+"\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static int tsp(int node, int visit) {
        if(visit == (1<<N)-1) {
            return W[node][0] == 0 ? INF : W[node][0];
        }
        if(D[node][visit] != 0 ){
            return D[node][visit];
        }
        int min = INF;
        for(int i=0; i<N; i++) {
            if((visit & (1<<i)) == 0 && W[node][i] != 0) {
                min = Math.min(min, tsp(i, (visit | (1<<i))) + W[node][i]);
            }
        }
        D[node][visit] = min;
        return D[node][visit];
    }

}