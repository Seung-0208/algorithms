import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int E = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int V = 10000;


        ArrayList<Edge>[] graph = new ArrayList[V+1];
        int[] distance = new int[V+2];
        for(int i=0; i<=V; i++) {
            graph[i] = new ArrayList<Edge>();
            if(i < V) graph[i].add(new Edge(i+1, 1));
            distance[i] = Integer.MAX_VALUE;
        }
        boolean[] isVisited = new boolean[V+1];

        int K = 0; //시작 정점

        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Edge(v, w));
        }

        PriorityQueue<Edge> q = new PriorityQueue<>();
        q.add(new Edge(K, 0));
        distance[K] = 0;

        while(!q.isEmpty()) {
            Edge curr = q.poll();
            isVisited[curr.node] = true;
            for(Edge n : graph[curr.node]) {
                if(!isVisited[n.node] && distance[n.node] > distance[curr.node] + n.weight) {
                    distance[n.node] = distance[curr.node] + n.weight;
                    q.add(new Edge(n.node, distance[n.node]));
                }
            }
        }

        bw.write(distance[D]+"\n");


        bw.flush();
        br.close();
        bw.close();
    }

    static class Edge implements Comparable<Edge>{
        int node;
        int weight;
        public Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o1) {
            return this.weight - o1.weight;
        }
    }
}
