import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        //n과 k의 최대공약수가 1이다 = 최대공약수가 존재하지 않는다 = n과 서로소인 자연수의 개수
        long n = Long.parseLong(st.nextToken());

        long result = n;

        for(long i=2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) { //i는 result의 약수
                result = result - result/i;
                while(n%i == 0) {
                    n /= i;
                }
            }
        }
        if (n>1) {
            result = result - result/n;
        }
        bw.write(String.valueOf(result));
        bw.flush();
    }
}