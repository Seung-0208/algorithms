import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] nums = new int[N];
        int[] ans = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) nums[i] = Integer.parseInt(st.nextToken());

        //스택에는 인덱스 값을 기준으로 넣어줘야 한다
        //인덱스 값을 기준으로 하지 않으면 값을 순서대로 출력할 수 없음
        Stack<Integer> stack = new Stack<>();
        int topIdx = 0;
        while(topIdx <= N-1){
            while(!stack.isEmpty() && nums[stack.peek()] < nums[topIdx]) {
                int tmpIdx = stack.pop();
                ans[tmpIdx] = nums[topIdx];
            }
            stack.push(topIdx);
            topIdx++;
        }

        //스택에 남아있는 값들은 오큰수가 없다는 뜻이므로 -1로 채워줌
        while(!stack.isEmpty()) {
            ans[stack.pop()] = -1;
        }

        for(int i=0; i<N; i++) bw.write(String.valueOf(ans[i])+" ");
        bw.flush();
    }

}
