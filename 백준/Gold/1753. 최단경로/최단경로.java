import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken()); //정점의 개수
        //방문여부
        boolean[] isVisited = new boolean[V+1];
        //그래프 정보
        ArrayList<Node>[] graph = new ArrayList[V+1];
        for(int i=1; i<=V; i++) graph[i] = new ArrayList<>();
        //거리
        int[] distance = new int[V+1];
        for(int i=1; i<=V; i++) distance[i] = Integer.MAX_VALUE;

        int E = Integer.parseInt(st.nextToken()); //간선의 개수

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()); //시작점
        distance[start] = 0;

        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v, w));
        }

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));

        while(!queue.isEmpty()) {
            Node now = queue.poll();
            if(isVisited[now.num]) continue;
            isVisited[now.num] = true;
            for(Node next : graph[now.num]) {
                if(!isVisited[next.num] && distance[next.num] > distance[now.num] + next.weight) {
                    distance[next.num] = distance[now.num] + next.weight;
                    queue.add(new Node(next.num, distance[next.num]));
                }
            }
        }

        for(int i=1; i<=V; i++) {
            if(isVisited[i]) bw.write(String.valueOf(distance[i])+"\n");
            else bw.write("INF\n");
        }
        bw.flush();
    }

    static class Node implements Comparable<Node> {
        int num;
        int weight;

        public Node(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}