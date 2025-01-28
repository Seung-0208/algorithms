import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(st.nextToken()); //수열의 개수
        int[] nums = new int[N];
        int[] ans = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) nums[i] = Integer.parseInt(st.nextToken());
        int idx = 0;
        while(idx <= N-1) {
            while(!stack.empty() && nums[stack.peek()] < nums[idx]) {
                ans[stack.pop()] = nums[idx];
            }
            stack.push(idx);
            idx++;
        }
        while(!stack.empty()) {
            ans[stack.pop()] = -1;
        }
        for(int i=0; i<N; i++) bw.write(ans[i] + " ");
        bw.flush();
    }
}