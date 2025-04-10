import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //도시의 개수
        int m = Integer.parseInt(st.nextToken()); //도로의 개수
        int k = Integer.parseInt(st.nextToken());

        //그래프 정보
        ArrayList<Edge>[] graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++) graph[i] = new ArrayList<>();
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Edge(b, c));
        }

        //거리
        PriorityQueue<Integer>[] distance = new PriorityQueue[n+1];
        Comparator<Integer> cp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        };
        for(int i=1; i<=n; i++) distance[i] = new PriorityQueue<>(k, cp);

        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.add(new Edge(1, 0));
        distance[1].add(0);

        while(!queue.isEmpty()) {
            Edge now = queue.poll();
            for(Edge next : graph[now.node]) {
                if(distance[next.node].size()<k) {
                    distance[next.node].add(now.weight + next.weight);
                    queue.add(new Edge(next.node, now.weight+next.weight));
                } else if(distance[next.node].peek() > now.weight + next.weight) {
                    distance[next.node].poll();
                    distance[next.node].add(now.weight + next.weight);
                    queue.add(new Edge(next.node, now.weight+next.weight));
                }
            }
        }

        for(int i=1; i<=n; i++) {
            if(distance[i].size() < k) {
                bw.write("-1\n");
            } else {
                bw.write(String.valueOf(distance[i].peek())+"\n");
            }
        }

        bw.flush();
    }

    static class Edge implements Comparable<Edge> {
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