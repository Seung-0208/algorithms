import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long A = Long.parseLong(st.nextToken());

        bw.write(String.valueOf(N-A)+" ");

        long r1 = A, r2 = N;
        long x1 = 1, x2 = 0;

        long multi;

        while(r2 > 0) {
            long quotient = r1 / r2;

            long temp = r1;
            r1 = r2;
            r2 = temp - quotient * r2;

            temp = x1;
            x1 = x2;
            x2 = temp - quotient * x2;
        }

        if(r1 == 1) {
            if(x1 <= 0) x1 += N;
            multi = x1;
        } else {
            multi = -1;
        }

        bw.write(String.valueOf(multi));
        bw.flush();
        bw.close();
    }

}