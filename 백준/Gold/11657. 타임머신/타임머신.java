
import java.io.*;
import java.util.*;

public class Main {
    static long[] dist;
    static ArrayList<Node> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //도시의 개수
        graph = new ArrayList<>();
        dist = new long[N+1];
        for(int i=1; i<=N; i++) {
            dist[i] = Long.MAX_VALUE;
        }
        int M = Integer.parseInt(st.nextToken()); //버스 노선의 개수

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            graph.add(new Node(A, B, C));
        }

        dist[1] = 0;

        for(int i=0; i<N; i++) {
            for(Node n : graph) {
                if(dist[n.start] != Long.MAX_VALUE && dist[n.end] > dist[n.start] + n.weight) {
                    dist[n.end] = dist[n.start] + n.weight;
                }
            }
        }

        boolean isInfinite = false;
        for(Node n : graph) {
            if(dist[n.start] != Long.MAX_VALUE && dist[n.end] > dist[n.start] + n.weight) {
                isInfinite = true;
                break;
            }
        }

        if(isInfinite) sb.append(-1);
        else {
            for(int i=2; i<=N; i++) sb.append(dist[i] == Long.MAX_VALUE ? -1 : dist[i]).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    static class Node {
        int start, end, weight;
        public Node(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
}