import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    static int edgeCnt;
    static int sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken()); //집의 개수
        int M = Integer.parseInt(st.nextToken()); //길의 개수
        parent = new int[N+1];
        for(int i=1; i<=N; i++) parent[i] = i;

        PriorityQueue<Edge> q = new PriorityQueue<>();
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            q.add(new Edge(A, B, C));
        }

        while(!q.isEmpty()) {
            Edge curr = q.poll();
            merge(curr.a, curr.b, curr.weight);
            if(edgeCnt == N-1) {
                sum -= curr.weight;
                break;
            }
        }

        sb.append(sum).append("\n");
        System.out.println(sb);
    }

    static int find(int node) {
        if(parent[node] == node) return node;
        return find(parent[node]);
    }

    static void merge(int a, int b, int weight) {
        parent[a] = find(a);
        parent[b] = find(b);
        if(parent[a] == parent[b]) return;
        parent[parent[a]] = parent[b];
        sum+=weight;
        edgeCnt++;
    }

    static class Edge implements Comparable<Edge>{
        int a, b, weight;
        public Edge(int a, int b, int weight) {
            this.a = a;
            this.b = b;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o1) {
            return this.weight - o1.weight;
        }
    }
}
