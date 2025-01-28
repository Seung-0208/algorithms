import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Main{
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = sc.nextInt();
        long[] nums = new long[N];
        for(int i=0; i<N; i++) nums[i] = sc.nextLong();

        Arrays.sort(nums);

        int cnt = 0;
        for(int i=0; i<N; i++) {
            long cur = nums[i];
            int start = 0, end = N-1;
            while(start < end) {
                long tmp = nums[start] + nums[end];
                if(cur > tmp) start++;
                else if(cur < tmp) end--;
                else {
                    if(start != i && end != i) {
                        cnt++;
                        break;
                    } 
                    //start와 end가 모두 i인 경우가 있을 수 있으므로 else if가 아닌 if로 작성
                    if(start==i) start++;
                    if(end==i) end--;
                }
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
    }
}
