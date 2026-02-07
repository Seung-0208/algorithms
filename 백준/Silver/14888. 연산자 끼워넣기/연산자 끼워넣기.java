import java.io.*;
import java.util.*;

public class Main {
    static int[] count = new int[4];
    static int[] nums;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++) {
            count[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(nums[0], 1);

        sb.append(max).append("\n").append(min);

        System.out.println(sb);
        br.close();
    }

    static void backtracking(int now, int idx) {
        if(idx == N) {
            max = Math.max(now, max);
            min = Math.min(now, min);
            return;
        }

        for(int i=0; i<4; i++) {
            if(count[i] > 0) {
                count[i]--;
                backtracking(calculate(i, now, nums[idx]), idx+1);
                count[i]++;
            }
        }
    }

    static int calculate(int type, int f, int s) {
        if(type == 0) return f+s;
        if(type == 1) return f-s;
        if(type == 2) return f*s;
        else return f/s;
    }
}