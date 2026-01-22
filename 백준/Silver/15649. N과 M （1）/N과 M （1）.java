
import java.io.*;
import java.util.*;

public class Main {
    static boolean[] isVisited;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        isVisited = new boolean[N+1];
        int[] nums = new int[M];
        tracking(0, sb, nums);

        System.out.println(sb);
        br.close();
    }

    static void tracking(int cnt, StringBuilder sb, int[] nums) {
        if(cnt == M) {
            for(int n : nums) {
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1; i<=N; i++) {
            if(!isVisited[i]) {
                isVisited[i] = true;
                nums[cnt] = i;
                tracking(cnt+1, sb, nums);
                isVisited[i] = false;
            }
        }
    }
}
