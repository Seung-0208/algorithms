
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long[] D = new long[n+1];
        D[1] = 1;

        if(n > 1) D[2] = 2;

        for(int i=3; i<=n; i++) {
            D[i] = (D[i-2] + D[i-1])%10007;
        }

        bw.write(D[n]+"\n");
        bw.flush();
        br.close();
        bw.close();
    }
}