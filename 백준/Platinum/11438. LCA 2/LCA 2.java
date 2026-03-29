import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K;
    static ArrayList<Integer>[] graph;
    static int[][] parent;
    static int[] depth;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        K =1;
        while(Math.pow(2, K) <= N) {
            K++;
        }
        graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++) graph[i] = new ArrayList<>();
        parent = new int[K+1][N+1];
        depth = new int[N+1];

        StringTokenizer st;
        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        initialize();

        for(int k=1; k<=K; k++) {
            for(int i=1; i<=N; i++) {
                parent[k][i] = parent[k-1][parent[k-1][i]];
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
        br.close();
    }

    static int getLCA(int a, int b) {
        if(depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        for(int k=K; k>=0; k--) {
            if(Math.pow(2, k) <= depth[a] - depth[b]) {
                a = parent[k][a];
            }
        }

        for(int k=K; k>=0; k--) {
            if(parent[k][a] != parent[k][b]) {
                a = parent[k][a];
                b = parent[k][b];
            }
        }

        if(a != b) {
            a = parent[0][a];
        }

        return a;
    }

    static void initialize() {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        boolean[] isVisited = new boolean[N+1];
        isVisited[1] = true;
        int level = 1;
        int cnt = 0;
        int childCnt = 1;
        while(!q.isEmpty()) {
            int curr = q.poll();
            depth[curr] = level;

            for(int child : graph[curr]) {
                if(!isVisited[child]) {
                    q.add(child);
                    isVisited[child] = true;
                    parent[0][child] = curr;

                }
            }

            cnt++;

            if(cnt == childCnt) {
                childCnt = q.size();
                cnt = 0;
                level++;
            }
        }
    }
}