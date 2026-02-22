import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] parent;
    static ArrayList<Integer>[] graph;
    static int N, K;
    static int[] depth;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        K = 1;
        int temp = 2;

        while(temp <= N) {
            temp *= 2;
            K++;
        }

        parent = new int[N+1][K+1];
        depth = new int[N+1];
        graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++) graph[i] = new ArrayList<>();
        StringTokenizer st;
        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        BFS();

        for(int i=1; i<=K; i++) {
            for(int j=1; j<=N; j++) {
                parent[j][i] = parent[parent[j][i-1]][i-1];
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
        if(depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        for(int k = K; k>=0; k--) {
            if((int)(Math.pow(2, k)) <= depth[a]-depth[b]) {
                a = parent[a][k];
            }
        }

        for(int k=K; k>=0; k--) {
            if(parent[a][k] != parent[b][k]) {
                a = parent[a][k];
                b = parent[b][k];
            }
        }

        if(a!=b) {
            a = parent[a][0];
        }
        return a;
    }

    static void BFS() {
        boolean[] isVisited = new boolean[N+1];
        isVisited[1] = true;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);

        int level = 1;
        int cnt = 0;
        int childCnt = 1;

        while(!q.isEmpty()) {
            int cur = q.poll();
            depth[cur] = level;

            for(int next : graph[cur]) {
                if(!isVisited[next]) {
                    parent[next][0] = cur;
                    q.add(next);
                    isVisited[next] = true;
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
}