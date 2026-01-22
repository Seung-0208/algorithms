
import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[] isVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        isVisited = new boolean[N+1];
        int[] nums = new int[M];

        tracking(0, nums, 1, sb);

        System.out.println(sb);
        br.close();
    }

    static void tracking(int cnt, int[] nums, int idx, StringBuilder sb) {
        if(cnt==M) {
            for(int n : nums) {
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=idx; i<=N; i++) {
            if(!isVisited[i]) {
                isVisited[i] = true;
                nums[cnt] = i;
                tracking(cnt+1, nums, i+1, sb);
                isVisited[i] = false;
            }
        }
    }
}
