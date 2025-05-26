
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        int[] rock = new int[M];
        double[] prop = new double[M];
        st = new StringTokenizer(br.readLine());
        int totalRocks = 0;
        for(int i=0; i<M; i++) {
            rock[i] = Integer.parseInt(st.nextToken());
            totalRocks += rock[i];
        }

        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());

        double ans = 0.0;
        for(int i=0; i<M; i++) {
            if(rock[i] >= K) {
                prop[i] = 1.0;
                for(int j=0; j<K; j++) {
                    prop[i] *= (double) (rock[i]-j)/(totalRocks-j);
                }
                ans += prop[i];
            }
        }

        bw.write(ans+"\n");
        bw.flush();
        bw.close();
        br.close();

    }
}