
import java.io.*;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.LongStream;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long[] haps = new long[N+1];
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for(int i=1; i<=N; i++)
            haps[i] = Integer.parseInt(st.nextToken()) + haps[i-1];

        long[] moded = LongStream.of(haps).map(e -> e%M).toArray();

        long ans = 0;
        for(int i=0; i<M; i++) {
            int temp = i;
            long cnt = LongStream.of(moded).filter(e->e==temp).count();
            ans += cnt*(cnt-1)/2;
        }

        bw.write(ans+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}