import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
//        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(br.readLine());
        Node[] nums = new Node[N];
        for(int i=0; i<N; i++) {
            int t = Integer.parseInt(br.readLine());
            nums[i] = new Node(t, i);
        }

        Arrays.sort(nums);

        int ans = 0;
        for(int i=0; i<N; i++) {
            ans = Math.max(ans, nums[i].idx-i);
        }
        
        ans++;

        sb.append(ans);

        System.out.println(sb);
        br.close();
    }

    static class Node implements Comparable<Node>{
        int value, idx;
        public Node(int value, int idx) {
            this.value = value;
            this.idx = idx;
        }

        @Override
        public int compareTo(Node o1) {
            return this.value - o1.value;
        }
    }
}