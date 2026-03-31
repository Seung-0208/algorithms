import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        Deque<Node> q = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        int first = Integer.parseInt(st.nextToken());
        q.add(new Node(first, 0));
        sb.append(first).append(" ");

        for(int i=1; i<N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            int latest = q.getLast().value;

            while(latest > temp) {
                q.removeLast();
                if(!q.isEmpty()) latest = q.getLast().value;
                else break;
            }

            q.add(new Node(temp, i));
            if(i-q.getFirst().idx+1 > L) q.removeFirst();
            sb.append(q.getFirst().value).append(" ");
        }

        System.out.println(sb);
        br.close();
    }
    static class Node {
        int value, idx;
        public Node (int value, int idx) {
            this.value = value;
            this.idx = idx;
        }
    }
}