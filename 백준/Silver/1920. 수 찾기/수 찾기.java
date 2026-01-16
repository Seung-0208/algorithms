
import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine()); //배열의 개수
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            int t = Integer.parseInt(st.nextToken());
            int ans = binarySearch(t);
            sb.append(ans).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    static int binarySearch(int target) {
        int start = 0;
        int end = N-1;

        while(start <= end) {
            int mIdx = (start+end)/2;
            int middle = arr[mIdx];

            if(target == middle) return 1;
            if(target < middle) {
                end = mIdx-1;
            } else {
                start = mIdx+1;
            }
        }
        return 0;
    }
}