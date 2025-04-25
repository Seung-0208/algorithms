
import java.io.*;
import java.util.*;

public class Main{
    static int[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //컴퓨터의 개수
        graph = new int[N];
        for(int i=0; i<N; i++) graph[i] = i;

        int[][] map = new int[N][N];
        int total = 0;
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        for(int i=0; i<N; i++) { //랜선의 길이
            st = new StringTokenizer(br.readLine());
            char[] lines = st.nextToken().toCharArray();
            int j=0;
            for(char tmp : lines) {
                if(Character.isDigit(tmp)) {
                    map[i][j] = 0;
                }else if(Character.isLowerCase(tmp)) {
                    map[i][j] = tmp-97+1;
                    total += (map[i][j]);
                    queue.add(new Edge(i, j, map[i][j]));
                } else {
                    map[i][j] = tmp-65+1+26;
                    total += (map[i][j]);
                    queue.add(new Edge(i, j, map[i][j]));
                }

                j++;
            }
        }

        int edgeNum = 0;
        int sum = 0;
        while(!queue.isEmpty() && edgeNum < N-1) {
            Edge edge = queue.poll();
            int n1 = edge.node1;
            int n2 = edge.node2;
            int w = edge.weight;
            graph[n1] = find(n1);
            graph[n2] = find(n2);
            if(graph[n1] != graph[n2]) {
                graph[graph[n1]] = graph[n2];
                edgeNum++;
                sum+=w;
            }
        }

        if(edgeNum == N-1) bw.write(String.valueOf(total-sum));
        else bw.write("-1");



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

    static int find(int node) {
        if(node == graph[node]) return node;
        return find(graph[node]);
    }
}