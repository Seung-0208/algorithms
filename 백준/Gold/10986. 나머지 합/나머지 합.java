
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
        long[] sum = new long[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            d[i] = Integer.parseInt(st.nextToken());
            if(i==0) sum[0] = d[0];
            if(i > 0) {
                sum[i] = sum[i-1] + d[i];
            }
        }

        for(int i=0; i<N; i++) {
            sum[i] = sum[i] % M;
        }


        long ans = 0;
        for(int i=0; i<M; i++) {
            long cnt = count(sum, i);
            ans += (cnt*(cnt-1))/2;
            if(i==0) ans += cnt;
        }
        sb.append(ans);
        System.out.println(sb);
        br.close();
    }

    static int count(long[] arr, int target) {
        int cnt = 0;
        for(long t : arr) {
            if(target == t) cnt++;
        }
        return cnt;
    }
}