import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        long A = Long.parseLong(st.nextToken());

        /*
        * 곱셈역 구할 때
        * Ax + Ny = 1 을 만족하는 x값을 구해야 함
        * */

        long r1 = A;
        long r2 = N;
        long x1 = 1;
        long x2 = 0;
        
        while(r2 > 0) {
            long q = r1/r2;
            long temp = r1;
            r1 = r2;
            r2 = temp - r2*q;
            
            temp = x1;
            x1 = x2;
            x2 = temp - x2*q;
        }
        
        long multi = x1;
        if(r1 == 1) {
            if(x1 <= 0) multi += N;
        } else multi = -1;
        
        bw.write(String.format("%d %d\n", N-A, multi));

        bw.flush();
        br.close();
        bw.close();
    }
}
