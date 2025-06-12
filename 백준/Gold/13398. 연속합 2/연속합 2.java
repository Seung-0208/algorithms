
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] num = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int[] L = new int[n];
        int[] R = new int[n];

        L[0] = num[0];
        int ans = L[0];
        for(int i=1; i<n; i++) {
            L[i] = Math.max(L[i-1]+num[i], num[i]);
            ans = Math.max(ans, L[i]);
        }
        R[n-1] = num[n-1];
        for(int i=n-2; i>=0; i--) {
            R[i] = Math.max(R[i+1]+num[i], num[i]);
            ans = Math.max(ans, R[i]);
        }

        for(int i=1; i<n-1; i++) {
            ans = Math.max(ans, L[i-1]+R[i+1]);
        }
        bw.write(ans+"\n");
        bw.flush();
        bw.close();
        br.close();


    }
}