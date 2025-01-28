import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] nums = new int[N+1];
        int[] sums = new int[N+1];

        //주어진 수 담기
        for(int i=1; i<N+1; i++) {
            nums[i] = sc.nextInt();
            sums[i] = sums[i-1] + nums[i];
        }

        //합 출력하기
        for(int k=0; k<M; k++) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            int temp = sums[j] - sums[i-1];
            bw.write(String.valueOf(temp));
            bw.newLine();
        }
        bw.flush();
    }
}