import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(st.nextToken());

        int start = 1, end = 1, sum = 1, cnt = 1;
        while(end != N) {
            if(sum == N) {
                cnt++;
                end++;
                sum += end;
            } else if(sum < N) {
                end++;
                sum += end;
            } else {
                sum -= start;
                start++;
            }
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
    }
}