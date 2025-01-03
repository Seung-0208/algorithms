import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //N입력
        int N = Integer.parseInt(st.nextToken());
        //배열 A입력
        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        //M입력
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        //탐색 대상 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            int temp = Integer.parseInt(st.nextToken());
            binarySearch(temp);
        }
    }

    static void binarySearch(int target) {
        int start = 0;
        int end = A.length - 1;
        while(start <= end) {
            int middle = (start+end)/2;
            if(A[middle] == target) {
                System.out.println(1);
                return;
            }
            else if(A[middle] < target) start = middle+1;
            else end = middle-1;
        }
        System.out.println(0);
    }
}