import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int V = Integer.parseInt(st.nextToken());
        int[][] distance = new int[V+1][V+1];
        for(int i=1; i<=V; i++) {
            for(int j=1; j<=V; j++) {
                if(i==j) distance[i][j] = 0;
                else distance[i][j] = Integer.MAX_VALUE;
            }
        }
        int E = Integer.parseInt(st.nextToken());
        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(distance[a][b] > c) distance[a][b] = c;
        }

        for(int k=1; k<=V; k++) {
            for(int s=1; s<=V; s++) {
                for(int e=1; e<=V; e++) {
                    if(distance[s][k] != Integer.MAX_VALUE && distance[k][e] != Integer.MAX_VALUE &&
                    distance[s][e] > distance[s][k] + distance[k][e])
                        distance[s][e] = distance[s][k] + distance[k][e];
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int i=1; i<=V; i++) {
            for(int j=i; j<=V; j++) {
                if(i!=j && distance[i][j] != Integer.MAX_VALUE && distance[j][i] != Integer.MAX_VALUE) {
                    int temp = distance[i][j] + distance[j][i];
                    if(ans > temp) ans = temp;
                }
            }
        }
        if(ans == Integer.MAX_VALUE) ans = -1;
        
        sb.append(ans).append("\n");
        System.out.println(sb);
        br.close();

    }
}
