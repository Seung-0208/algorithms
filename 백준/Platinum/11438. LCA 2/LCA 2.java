
import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph; //연결정보 저장
    static boolean[] isVisited; //트리 탐색에서 사용할 방문 여부 값
    static int[] depth; //각 노드가 위치한 height 값
    static int[][] parent; //각 노드의 부모 노드 정보
    static int kmax;
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //정점의 개수
        graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++) graph[i] = new ArrayList<>();
        isVisited = new boolean[N+1];
        depth = new int[N+1];
        kmax = 0;
        int temp = 1;
        while(temp <= N) {
            temp <<= 1;
            kmax++;
        }
        parent = new int[kmax+1][N+1];

        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        BFS(1);


        for(int i=1; i<=kmax; i++) {
            for(int j=1; j<=N; j++) {
                parent[i][j] = parent[i-1][parent[i-1][j]];
            }
        }
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()); //쌍의 개수

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int LCA = getCLA(a, b);
            bw.write(LCA+"\n");
        }
        bw.flush();
        bw.close();
        br.close();

    }

    static int getCLA(int a, int b) {
        if(depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }
        for(int k=kmax; k>=0; k--) {
            if((int)Math.pow(2,k) <= depth[a] - depth[b]) {
                a = parent[k][a];
            }
        }
        for(int k=kmax; k>=0; k--) {
            if(parent[k][a] != parent[k][b]) {
                a = parent[k][a];
                b = parent[k][b];
            }
        }
        int LCA = a;
        if(a != b) {
            LCA = parent[0][LCA];
        }
        return LCA;
    }

    static void BFS(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);

        int level = 1;
        int cnt = 0;
        int childSize = 1;

        while(!q.isEmpty()) {
            int now = q.poll();
            isVisited[now] = true;
            depth[now] = level;
            for(int next : graph[now]) {
                if(!isVisited[next]) {
                    q.add(next);
                    parent[0][next] = now;
                }
            }
            cnt++;
            if(cnt == childSize) {
                level++;
                cnt = 0;
                childSize = q.size();
            }
        }
    }
}