
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
        int s = 1, e = 2;

        if(N==1) {
            bw.write(1+"\n");
            bw.flush();
            bw.close();
            br.close();
            return;
        }
        int cnt = 1;
        int sum = s+e;
        while(s<e && e<=N){
//            System.out.printf("s: %d, e: %d, sum: %d\n", s, e, sum);
            if(sum > N) {
                sum -= s;
                s++;
            }
            else if(sum < N) {
                e++;
                sum += e;
            }
            else {
                cnt++;
                s++;
                e++;
                sum = sum - (s-1) + e;
            }
        }

        bw.write(cnt+"\n");

        bw.flush();
        bw.close();
        br.close();
    }
}