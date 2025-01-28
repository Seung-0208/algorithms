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
        int M = sc.nextInt();
        long[] nums = new long[N];
        long[] haps = new long[N];
        for(int i=0; i<N; i++) {
            nums[i] = sc.nextLong();
            haps[i] = i==0 ? nums[i] : nums[i] + haps[i-1];
        }

        for(int i=0; i<N; i++) {
            haps[i] = haps[i]%M;
        }

        long cnt = LongStream.of(haps).filter(e->e==0).count();
        for(int i=0; i<=M;i++) {
            int rem = i;
            long rems = LongStream.of(haps).filter(e->e==rem).count();
            cnt += (rems*(rems-1)/2);
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
    }
}