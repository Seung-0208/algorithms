import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long ret = gcd(A, B);
        for(int i=0; i<ret; i++) {
            bw.write("1");
        }
        bw.newLine();
        bw.flush();
        bw.close();
    }
    static long gcd(long a, long b){
        long bigger, smaller;
        bigger = Math.max(a, b);
        smaller = Math.min(a, b);

        long rest = bigger % smaller;
        while(rest != 0) {
            bigger = smaller;
            smaller = rest;
            rest = bigger%smaller;
        }
        return smaller;
    }

}