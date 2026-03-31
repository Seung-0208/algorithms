import java.io.*;
import java.util.*;

public class Main {
    static int ans = 0;
    static long[] nums;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        nums = new long[N];
        for(int i=0; i<N; i++) {
            nums[i] = Long.parseLong(st.nextToken());
        }

        if(N > 2) {
            Arrays.sort(nums);

            for(int i=0; i<N; i++) {
                calculate(nums[i], i);
            }
        }

        sb.append(ans);
        System.out.println(sb);
        br.close();
    }

    static void calculate(long n, int idx) {
        int i=0, j=N-1;
        while(i<j) {
            if(i==idx) {
                i++;
                continue;
            }
            if(j==idx) {
                j--;
                continue;
            }
            long temp = nums[i] + nums[j];
            if(temp < n) {
                i++;
            } else if(temp > n) {
                j--;
            } else {
                ans++;
                break;
            }
        }
    }
}