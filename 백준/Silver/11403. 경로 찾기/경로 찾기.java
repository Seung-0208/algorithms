import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

public class Main{
    static int MAX = 100001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] distance = new int[N+1][N+1];
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                distance[i][j] = tmp;
            }
        }

        for(int k=1; k<=N; k++) {
            for(int s=1; s<=N; s++) {
                for(int e=1; e<=N; e++) {
                    if(distance[s][e] != 1 && distance[s][k] == 1 && distance[k][e]==1) {
                        distance[s][e] = 1;
                    }
                }
            }
        }

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                bw.write(distance[i][j]+" ");
            }
            bw.write("\n");
        }
        bw.flush();
    }
}