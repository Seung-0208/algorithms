import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int answer = Integer.MAX_VALUE;
        Deque<Integer> q = new ArrayDeque<>();
        int sum = 0;
        for(int i=0; i<N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            q.add(temp);
            sum+=temp;
            int first = q.getFirst();
            while(sum-first >= S) {
                q.removeFirst();
                sum-=first;
                if(q.isEmpty()) break;
                first = q.getFirst();
            }
            if(sum >= S) {
                answer = Math.min(answer, q.size());
            }
        }
        if(answer == Integer.MAX_VALUE) answer = 0;
        sb.append(answer);
        System.out.println(sb);
    }

}