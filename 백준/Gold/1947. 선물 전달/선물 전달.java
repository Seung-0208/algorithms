
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long[] D = new long[N+1];

        if(N>=2) D[2] = 1; //총 2명일 때는 서로 주고받는 경우밖에 없으므로 1
        for(int i=3; i<=N; i++) {
            D[i] = (i-1) * (D[i-2] + D[i-1])%1000000000;
        }

        bw.write(D[N]+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}