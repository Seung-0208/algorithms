import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);
        int total = 0;
        for(int i=1; i<N; i++) {
            nums[i] = nums[i] + nums[i-1];
            total += nums[i];
        }
        total+=nums[0];

        sb.append(total).append("\n");
        System.out.println(sb);
        br.close();
    }
}