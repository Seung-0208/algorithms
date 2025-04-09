import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //도시의 개수
        boolean[] isVisited = new boolean[N+1]; //방문여부
        ArrayList<Edge>[] graph = new ArrayList[N+1]; //그래프
        for(int i=1; i<=N; i++) graph[i] = new ArrayList<>();
        int[] distance = new int[N+1];
        for(int i=1; i<=N; i++) distance[i] = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()); //버스의 개수

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[s].add(new Edge(e, w));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        distance[start] = 0;

        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.add(new Edge(start, 0));
        while(!queue.isEmpty()) {
            Edge now = queue.poll();
            if(isVisited[now.node]) continue;
            isVisited[now.node] = true;
            for(Edge next : graph[now.node]) {
                if(!isVisited[next.node] &&
                    distance[next.node] > distance[now.node] + next.weight) {
                    distance[next.node] = distance[now.node] + next.weight;
                    queue.add(new Edge(next.node, distance[next.node]));
                }
            }
        }

        bw.write(String.valueOf(distance[end])+"\n");

        bw.flush();
    }

    static class Edge implements Comparable<Edge>{
        int node, weight;
        public Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
}