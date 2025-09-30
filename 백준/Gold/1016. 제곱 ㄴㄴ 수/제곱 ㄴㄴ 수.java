import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        boolean[] isDeleted = new boolean[(int)(max-min+1)];

        for(int i=2; i<1000001; i++) {
            long square = (long)i*i;
            long temp = min/square;
            long start = square*temp;
            for(long j = start; j<=max; j+=square) {
                if(j >= min) {
                    isDeleted[(int)(j-min)] = true;
                }
            }
        }
        int cnt = 0;
        for(boolean t : isDeleted) {
            if(!t) cnt++;
        }

        bw.write(cnt+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
