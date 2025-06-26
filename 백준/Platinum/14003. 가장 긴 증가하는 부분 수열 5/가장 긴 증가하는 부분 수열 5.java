
import java.io.*;
import java.util.*;

public class Main {
    static int[] B;
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //수열의 길이
        int[] A = new int[N+1]; //수열
        int[] D = new int[N+1]; //DP 계산용 수열
        B = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        int index = 1;
        D[++max] = 1;
        B[1] = A[1];

        for(int i=2; i<=N; i++) {
            if(A[i] > B[max]) {
                B[++max] = A[i];
                index = max;
            } else {
                index = binarySearch(1, max, A[i]);
                B[index] = A[i];
            }
            D[i] = index;
        }

        bw.write(max+"\n");

        int[] ans = new int[max+1];
        int x =  B[max]+1;
        for(int i=N; i>0; i--) {
            if(D[i] == max && A[i] < x) {
                ans[max] = A[i];
                max--;
                x = A[i];
            }
        }
        for(int i=1; i<ans.length; i++) {
            bw.write(ans[i]+" ");
        }


        bw.flush();
        bw.close();
        br.close();
    }

    static int binarySearch(int s, int e, int now) {
        int m;
        while(s < e) {
            m = (s+e)/2;
            if(now > B[m]) s = m+1;
            else e = m;
        }
        return s;
    }

}