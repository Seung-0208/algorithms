import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //도시의 개수
        int M = Integer.parseInt(st.nextToken()); //도로의 수
        int k = Integer.parseInt(st.nextToken()); //단계
        ArrayList<Edge>[] graph = new ArrayList[N+1]; //그래프
        for(int i=1; i<=N; i++) graph[i] = new ArrayList<>();
        PriorityQueue<Integer>[] distances = new PriorityQueue[N+1];
        Comparator<Integer> cp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        };
        for(int i=1; i<=N; i++) distances[i] = new PriorityQueue<>(k, cp);

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[a].add(new Edge(b, w));
        }

        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.add(new Edge(1, 0));
        distances[1].add(0);
        while(!queue.isEmpty()) {
            Edge now = queue.poll();
            for(Edge next : graph[now.node]) {
                if(distances[next.node].size()<k){
                    distances[next.node].add(now.weight + next.weight);
                    queue.add(new Edge(next.node, now.weight + next.weight));
                } else if(distances[next.node].peek() > now.weight+next.weight) {
                    distances[next.node].poll();
                    distances[next.node].add( now.weight+next.weight);
                    queue.add(new Edge(next.node, now.weight+next.weight));
                }
            }
        }

        for(int i=1; i<=N; i++) {
            if(distances[i].size() < k) {
                bw.write(String.valueOf(-1)+"\n");
            } else {
                bw.write(String.valueOf(distances[i].peek())+"\n");
            }
        }

        bw.flush();
    }


    public static class Edge implements Comparable<Edge>{
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