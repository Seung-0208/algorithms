import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    static int sum;
    static int edgeCnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int V = Integer.parseInt(st.nextToken()); //정점
        PriorityQueue<Edge> q = new PriorityQueue<>();
        parent = new int[V+1];
        for(int i=1; i<=V; i++) parent[i] = i;
        int E = Integer.parseInt(st.nextToken()); //간선

        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            q.add(new Edge(A, B, C));
        }

        while(!q.isEmpty()) {
            Edge curr = q.poll();
            merge(curr.a, curr.b, curr.weight);
            if(edgeCnt == V-1) break;
        }

        sb.append(sum).append("\n");
        System.out.println(sb);
    }

    static int find(int node) {
        if(node == parent[node]) return node;
        return find(parent[node]);
    }

    static void merge(int a, int b, int weight) {
        parent[a] = find(a);
        parent[b] = find(b);
        if(parent[a]==parent[b]) return;
        parent[parent[a]] = parent[b];
        edgeCnt++;
        sum+=weight;
    }

    static class Edge implements Comparable<Edge> {
        int a; int b; int weight;
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
