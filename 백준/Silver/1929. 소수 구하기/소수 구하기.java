import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] isPrime = new int[N+1];
        for(int i=2; i<N+1; i++) isPrime[i] = i;
        for(int i=2; i<=Math.sqrt(N); i++) {
            if(isPrime[i] != 0) {
                int temp = 2;
                int j = i*temp;
                while(j<=N) {
                    isPrime[j] = 0;
                    temp++;
                    j = i*temp;
                }
            }
        }

        for(int i=M; i<=N; i++) {
            if(isPrime[i] != 0) bw.write(String.valueOf(i)+"\n");
        }
        bw.flush();
    }
}