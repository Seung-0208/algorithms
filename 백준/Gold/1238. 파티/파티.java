
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //학생 수(=마을의 수)
        int M = Integer.parseInt(st.nextToken()); //단방향 도로의 개수
        int X = Integer.parseInt(st.nextToken()); //파티하는 마을

        int[][] dist = new int[N+1][N+1];
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) if(i!=j) dist[i][j] = Integer.MAX_VALUE;
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            dist[s][e] = t;
        }

        for(int k=1; k<=N; k++) {
            for(int s=1; s<=N; s++) {
                for(int e=1; e<=N; e++) {
                    if(dist[s][k] != Integer.MAX_VALUE && dist[k][e] != Integer.MAX_VALUE) {
                        dist[s][e] = Math.min(dist[s][e], dist[s][k]+dist[k][e]);
                    }
                }
            }
        }

        int max = 0;
        for(int i=1; i<=N; i++) {
            max = Math.max(max, dist[i][X] + dist[X][i]);
        }

        sb.append(max);


        System.out.println(sb);
        br.close();
    }

}
