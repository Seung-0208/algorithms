import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K;
    static ArrayList<Node>[] graph;
    static int[][] parent, dist;
    static int[] depth;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        int t =2;
        K = 1;
        while(t<=N) {
            t = t*2;
            K++;
        }
        parent = new int[N+1][K+1];
        dist = new int[N+1][K+1];
        depth = new int[N+1];
        graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++) graph[i] = new ArrayList<>();
        StringTokenizer st;
        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, w));
            graph[b].add(new Node(a, w));
        }

        BFS();

        for(int k=1; k<=K; k++) {
            for(int i=1; i<=N; i++) {
                parent[i][k] = parent[parent[i][k-1]][k-1];
                dist[i][k] = dist[i][k-1] + dist[parent[i][k-1]][k-1];
            }
        }

        int M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(getLCA(a, b)).append("\n");
        }


        System.out.println(sb);
    }

    static int getLCA(int a, int b) {
        int ans = 0;
        if(depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        for(int k=K; k>=0; k--) {
            if((int)Math.pow(2,k) <= depth[a]-depth[b]) {
                ans += dist[a][k];
                a = parent[a][k];
            }
        }

        for(int k=K; k>=0; k--) {
            if(parent[a][k] != parent[b][k]) {
                ans += dist[a][k];
                ans += dist[b][k];
                a = parent[a][k];
                b = parent[b][k];
            }
        }

        if(a != b) {
            ans += dist[a][0];
            ans += dist[b][0];
        }

        return ans;
    }

    static void BFS() {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        int level = 1;
        int cnt = 0;
        int childCnt = 1;
        boolean[] isVisited = new boolean[N+1];

        while(!q.isEmpty()) {
            int now = q.poll();
            isVisited[now] = true;
            depth[now] = level;
            for(Node next : graph[now]) {
                if(!isVisited[next.node]) {
                    parent[next.node][0] = now;
                    dist[next.node][0] = next.weight;
                    q.add(next.node);
                }
            }

            cnt++;
            if(cnt == childCnt) {
                cnt = 0;
                level++;
                childCnt = q.size();
            }
        }
    }

    static class Node {
        int node, weight;
        public Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
}