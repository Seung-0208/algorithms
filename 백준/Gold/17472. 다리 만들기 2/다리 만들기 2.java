
import java.io.*;
import java.util.*;

public class Main{
    static int[][] map;
    static int[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());


        int M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp == 0) map[i][j] = 0;
                else map[i][j] = -1;
            }
        }

        int temp = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] == -1) {
                    temp++;
                    map[i][j] = temp;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[] {i,j});
                    while(!queue.isEmpty()) {
                        int[] point = queue.poll();
                        int[] x = {-1, 1, 0, 0};
                        int[] y = {0, 0, -1, 1};
                        for(int k=0; k<4; k++) {
                            int nextX = point[0]+x[k];
                            int nextY = point[1]+y[k];
                            if(nextX >= 0 && nextY >= 0 && nextX < N && nextY < M) {
                                if(map[nextX][nextY]==-1) {
                                    queue.add(new int[]{nextX, nextY});
                                    map[nextX][nextY] = map[i][j];
                                }
                            }
                        }
                    }
                }
            }
        }

        graph = new int[temp+1];
        for(int i=1; i<=temp; i++) graph[i] = i;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] != 0) {
                    int[] x = {-1, 1, 0, 0};
                    int[] y = {0, 0, -1, 1};
                    for(int k=0; k<4; k++) {
                        int nextX = i+x[k];
                        int nextY = j+y[k];
                        int dist = 0;
                        while(nextX >= 0 && nextY >= 0 && nextX < N && nextY < M) {
                            if(map[nextX][nextY] == 0) {
                                nextX += x[k];
                                nextY += y[k];
                                dist++;
                            } else if(map[nextX][nextY]!=0 && dist<=1) break;
                            else if(map[nextX][nextY]!=0 && dist > 1) {
                                int node1 = map[i][j];
                                int node2 = map[nextX][nextY];
                                pq.add(new Edge(node1, node2, dist));
                                break;
                            }
                        }
                    }
                }
            }
        }

        //최소 신장 트리 그래프 확인
        int edgeN = 0;
        int ans = 0;
        while(!pq.isEmpty() && edgeN < temp-1) {
            Edge e = pq.poll();
            int node1 = e.node1;
            int node2 = e.node2;
            int weight = e.weight;
            graph[node1] = find(node1);
            graph[node2] = find(node2);
            if(graph[node1] != graph[node2]) {
                graph[graph[node1]] = graph[node2];
                ans+=weight;
                edgeN++;
            }
        }


        if(edgeN == temp-1) bw.write(String.valueOf(ans));
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
        if(graph[node] == node) return node;
        return find(graph[node]);
    }
}