
import java.io.*;
import java.util.*;

public class Main {
    static int[] B;
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //수열의 크기
        int[] A = new int[N+1]; //수열 저장용
        int[] D = new int[N+1]; //DP 계산용
        B = new int[N+1]; //유리한 순열 계산용

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        int index;
        B[++max] = A[1];
        D[1] = 1;

        for(int i=2; i<=N; i++) {
            if(B[max] < A[i]) {
                B[++max] = A[i];
                D[i] = max;
            } else {
                index = binarySearch(1, max, A[i]);
                B[index] = A[i];
                D[i] = index;
            }
        }

        index = max;

        bw.write(max+"\n");
        int x = B[max] + 1;
        int[] ans = new int[N];
        int idx = 0;
        for(int i=N; i>0; i--){
            if(D[i] == index && A[i] < x){
                ans[idx] = A[i];
                idx++;
                index--;
                x = A[i];
            }
        }

        for(int i=idx-1; i>=0; i--) {
            bw.write(ans[i] + " ");
        }
        bw.newLine();



        bw.flush();
        bw.close();
        br.close();
    }

    static int binarySearch(int s, int e, int now) {
        int m;
        while (s < e) {
            m = (s+e)/2;
            if(B[m] < now) {
                s = m+1;
            }
            else {
                e = m;
            }
        }
        return s;
    }

}