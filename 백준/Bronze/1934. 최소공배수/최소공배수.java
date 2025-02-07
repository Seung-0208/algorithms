import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for(int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int gcd = gcd(A, B);
            int ret = gcd * (A/gcd) * (B/gcd);
            bw.write(String.valueOf(ret)+"\n");
        }
        bw.flush();
        bw.close();
    }
    static int gcd(int a, int b){
        int bigger, smaller;
        bigger = Math.max(a, b);
        smaller = Math.min(a, b);

        int rest = bigger % smaller;
        while(rest != 0) {
            bigger = smaller;
            smaller = rest;
            rest = bigger%smaller;
        }
        return smaller;
    }

}