
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] d = new int[N];
        int[] sum = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            d[i] = Integer.parseInt(st.nextToken());
            if(i==0) sum[0] = d[0];
            if(i > 0) {
                sum[i] = sum[i-1] + d[i];
            }
        }
        
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            if(s == 0) sb.append(sum[e]).append("\n");
            else sb.append(sum[e]-sum[s-1]).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}