import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken()); //도시의 개수
        int[][] distance = new int[n+1][n+1];
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(i==j) distance[i][j] = 0;
                else distance[i][j] = Integer.MAX_VALUE;
            }
        }
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        //초기화
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); //시작
            int b = Integer.parseInt(st.nextToken()); //끝
            int c = Integer.parseInt(st.nextToken()); //비용
            if(distance[a][b] > c) distance[a][b] = c;
        }

        for(int k=1; k<=n; k++) {
            for(int s=1; s<=n; s++) {
                for(int e=1; e<=n; e++) {
                    if(distance[s][k] != Integer.MAX_VALUE && distance[k][e] != Integer.MAX_VALUE && distance[s][e] > distance[s][k] + distance[k][e])
                        distance[s][e] = distance[s][k] + distance[k][e];
                }
            }
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(distance[i][j] == Integer.MAX_VALUE) sb.append("0 ");
                else sb.append(distance[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
