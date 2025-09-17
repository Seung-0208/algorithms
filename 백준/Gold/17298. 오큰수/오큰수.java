
import java.io.*;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.LongStream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] ret = new int[N];
        Stack<Node> stack = new Stack<>();

        st = new StringTokenizer(br.readLine());
        stack.add(new Node(Integer.parseInt(st.nextToken()), 0));
        for(int i=1; i<N; i++) {
            int t = Integer.parseInt(st.nextToken());
            if(!stack.isEmpty()) {
                int latest = stack.peek().value;
                while(latest < t) {
                    Node node = stack.pop();
                    ret[node.idx] = t;
                    if(!stack.isEmpty()) latest = stack.peek().value;
                    else break;
                }
            }
            stack.add(new Node(t, i));
        }

        while(!stack.isEmpty()) {
            Node node = stack.pop();
            ret[node.idx] = -1;
        }

        for(int n : ret) {
            bw.write(n + " ");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    static class Node {
        int value;
        int idx;

        public Node(int value, int idx) {
            this.value = value;
            this.idx = idx;
        }
    }

}