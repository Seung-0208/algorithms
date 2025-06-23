
import java.io.*;
import java.util.*;

public class Main {
    static int[][] D;
    static Matrix[] M;
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        D = new int[N+1][N+1];
        for(int i=0; i<=N; i++) {
            for(int j=0; j<=N; j++) {
                D[i][j] = -1;
            }
        }
        M = new Matrix[N+1];
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            M[i] = new Matrix(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int ans = execute(1, N);
        bw.write(ans+"\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static class Matrix {
        public int r;
        public int c;

        public Matrix(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int execute(int s, int e) {
        int result = Integer.MAX_VALUE;
        if(D[s][e] != -1) return D[s][e];
        int n = e-s+1; //구간 사이의 행렬 개수
        if(n==1) return 0;
        if(n==2) return M[s].r * M[s].c * M[e].c;

        for(int i=s; i<e; i++) {
            int a = M[s].r * M[i].c * M[e].c;
            result = Math.min(result, execute(s, i) + execute(i+1, e) + a);
        }
        return D[s][e] = result;
    }
}