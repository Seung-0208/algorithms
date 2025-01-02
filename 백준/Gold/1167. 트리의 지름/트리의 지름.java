import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static ArrayList<int[]>[] A;
    static int V;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());

        //거리가 가장 긴 두 노드를 찾기 위해서는 모든 노드를 방문해야 함

        //주어진 정보를 담을 자료구조
        A = new ArrayList[V + 1]; //연결정보를 저장할 A
        for (int i = 1; i <= V; i++) A[i] = new ArrayList<>();


        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            while (true) {
                int ele = Integer.parseInt(st.nextToken());
                if (ele == -1) break;
                int dist = Integer.parseInt(st.nextToken());
                A[idx].add(new int[] {ele, dist});
            }
        }
        int t_node = BFS(1)[1];
        int ans = BFS(t_node)[0];
        System.out.println(ans);
    }

    static int[] BFS(int start) {
        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[V+1];
        boolean[] visited = new boolean[V + 1];

        q.add(start);
        visited[start] = true;
        dist[start] = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int[] adj : A[node]) {
                if(!visited[adj[0]]) {
                    visited[adj[0]] = true;
                    q.add(adj[0]);
                    dist[adj[0]] = dist[node] + adj[1];
                }
            }
        }//while

        int max_dist = -1;
        int max_node = 0;
        for(int i=1; i<=V; i++) {
            if(max_dist < dist[i]) {
                max_dist = dist[i];
                max_node = i;
            }
        }
        return new int[] {max_dist, max_node};
    }//BFS
}