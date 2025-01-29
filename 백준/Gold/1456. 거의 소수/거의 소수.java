import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        //소수 판정
        int[] isPrime = new int[10000001];
        for(int i=2; i<=10000000; i++) isPrime[i] = i;
        for(int i=2; i<Math.sqrt(10000000); i++) {
            if(isPrime[i] != 0) {
                int temp = 2;
                int j = i*temp;
                while(j<=10000000) {
                    isPrime[j] = 0;
                    temp++;
                    j = i*temp;
                }
            }
        }
        int cnt = 0;
        for(int i=2; i<=10000000; i++) {
            if(isPrime[i] != 0) {
                int temp = 2;
                long j = (long) Math.pow(i, temp);
                while(j<=B) {
                    if(j>=A) cnt++;
                    temp++;
                    j = (long) Math.pow(i, temp);
                }
            }
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
    }
}