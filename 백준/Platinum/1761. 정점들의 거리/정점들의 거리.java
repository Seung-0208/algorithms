import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] parent;
    static ArrayList<int[]>[] graph;
    static int[][] distance;
    static int[] depth;
    static int N, k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        k = 1;
        while(Math.pow(2,k)<=N){
            k++;
        }

        parent = new int[k+1][N+1];
        distance = new int[k+1][N+1];
        graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++) graph[i] = new ArrayList<>();
        depth = new int[N+1];

        StringTokenizer st;
        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[a].add(new int[] {b,w});
            graph[b].add(new int[] {a,w});
        }

        initialize();

        for(int i=1; i<=k; i++) {
            for(int j=1; j<=N; j++) {
                parent[i][j] = parent[i-1][parent[i-1][j]];
                distance[i][j] = distance[i-1][parent[i-1][j]] + distance[i-1][j];
            }
        }

        int M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(getDistance(a,b)).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    static int getDistance(int a, int b) {
        if(depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        int ans = 0;
        for(int i=k; i>=0; i--) {
            if(Math.pow(2,i) <= depth[a] - depth[b]) {
                ans += distance[i][a];
                a = parent[i][a];
            }
        }

        for(int i=k; i>=0; i--) {
            if(parent[i][a] != parent[i][b]) {
                ans += distance[i][a];
                ans += distance[i][b];
                a = parent[i][a];
                b = parent[i][b];
            }
        }

        if(a != b) {
            ans += distance[0][a];
            ans += distance[0][b];
        }

        return ans;
    }

    static void initialize() {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        boolean[] isVisited = new boolean[N+1];
        isVisited[1] = true;
        int childCnt = 1;
        int level = 1;
        int cnt = 0;
        while(!q.isEmpty()) {
            int curr = q.poll();
            depth[curr] = level;
            for(int[] child : graph[curr]) {
                int node = child[0];
                int weight = child[1];
                if(!isVisited[node]) {
                    parent[0][node] = curr;
                    distance[0][node] = weight;
                    q.add(node);
                    isVisited[node] = true;
                }
            }

            cnt++;

            if(cnt == childCnt) {
                cnt = 0;
                childCnt = q.size();
                level++;
            }
        }
    }
}