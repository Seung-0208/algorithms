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

        //cnt를 1부터 시작하는 것은, 연속된 자연수의 합으로 나타낼 때 N 자신의 수도 포함되기 때문
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
