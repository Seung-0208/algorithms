import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //N값 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        //수열 A 받기
        st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for(int i=0; i<N; i++) A[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(A);

        //M값 받기
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        //테스트 값 받기
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            int K = Integer.parseInt(st.nextToken());
            if(isExist(A, K)) bw.write(String.valueOf(1)+"\n");
            else bw.write(String.valueOf(0)+"\n");
        }
        bw.flush();
    }

    //이진탐색
    static boolean isExist(int[] A, int K) {

        int s = 0;
        int e = A.length - 1;
        while(s<=e) {
            int m = (s+e)/2;
            if(A[m] == K) return true;
            if(A[m] < K) s = m+1;
            else e = m-1;
        }
        return false;
    }
}