import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

public class Main{
    static int[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken()); //정점의 개수
        graph = new int[V+1];
        for(int i=1; i<=V; i++) graph[i] = i;

        int E = Integer.parseInt(st.nextToken()); //간선의 개수

        PriorityQueue<Edge> edges = new PriorityQueue<>();
        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            edges.add(new Edge(A, B, C));
        }

        int edgeN = 0;
        long sum = 0;
        while(!edges.isEmpty()) {
            Edge edge = edges.poll();
            int A = edge.node1;
            int B = edge.node2;
            int C = edge.weight;
            graph[A] = find(A);
            graph[B] = find(B);
            if(graph[A] != graph[B]) {
                graph[graph[A]] = graph[B];
                edgeN++;
                sum+=C;
            }
            if(edgeN == V-1) break;
        }

        bw.write(sum+"\n");
        bw.flush();


    }

    static class Edge implements Comparable<Edge>{
        int node1, node2, weight;
        public Edge(int node1, int node2, int weight) {
            this.node1 = node1;
            this.node2 = node2;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }

    }

    static int find(int node){
        if(graph[node] == node) return node;
        return find(graph[node]);
    }
}