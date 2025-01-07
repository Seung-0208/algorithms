import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //값 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        
        //이진탐색
        int start = 1, end = k;
        int ans = 0;
        while(start <= end) {
            int middle = (start+end)/2; 
            int cnt = 0;
            for(int i=1; i<=N; i++) cnt += Math.min(N, middle/i);
            if(cnt < k) {
                start = middle+1;
                continue;
            }
            end = middle-1;
            ans = middle;
        }//while

        System.out.println(ans);
    }//main
}