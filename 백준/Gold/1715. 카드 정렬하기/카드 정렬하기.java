import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //작은수부터 비교해나가는 게 가장 적은 비교 횟수를 내는 거 아닌가?
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            q.add(Integer.parseInt(st.nextToken()));
        }
        int cnt = 0;
        while(q.size() != 1) {
            int temp = q.poll() + q.poll();
            cnt += temp;
            q.add(temp);
        }
        System.out.println(cnt);
    }//main
}