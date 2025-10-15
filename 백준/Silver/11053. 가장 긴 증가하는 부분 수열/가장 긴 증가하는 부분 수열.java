import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] nums = new int[N];
        int[] dp = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        for(int i=1; i<N; i++) {
            for(int j=0; j<i; j++) {
                if(nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j]+1);
            }
        }

        int max = 0;

        for(int i=0; i<N; i++) max = Math.max(dp[i], max);

        bw.write(max+"\n");

        bw.flush();
        br.close();
        bw.close();

    }
}
