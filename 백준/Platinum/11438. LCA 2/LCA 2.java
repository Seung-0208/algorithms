import java.io.*;
import java.util.*;

public class Main {
    static int kmax;
    static ArrayList<Integer>[] graph;
    static int[][] parent;
    static int[] depth;
    static boolean[] isVisited;
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++) graph[i] = new ArrayList<>();
        isVisited = new boolean[N+1];
        depth = new int[N+1];

        //최대 k값(kmax) 구하기
        int temp = 1;
        kmax = 0;
        while(temp<=N) {
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

        BFS();

        //부모 정보 채우기
        for(int i=1; i<=kmax; i++) {
            for(int j=1; j<=N; j++) {
                parent[i][j] = parent[i-1][parent[i-1][j]];
            }
        }

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());//쌍의 개수

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int LCA = getLCA(a, b);
            bw.write(LCA+"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    static int getLCA(int a, int b) {
        if(depth[a] < depth[b]) {
            int temp = a;
            a  = b;
            b = temp;
        }
        //a와 b의 높이 맞추기
        for(int k = kmax; k>=0; k--) {
            if((int)Math.pow(2,k) <= depth[a]-depth[b]) {
                a = parent[k][a];
            }
        }

        //a와 b의 값 맞추기
        for(int k=kmax; k>=0; k--) {
            if(parent[k][a] != parent[k][b]) {
                a = parent[k][a];
                b = parent[k][b];
            }
        }
        int LCA = a;
        if(a!=b) {
            LCA = parent[0][LCA];
        }

        return LCA;
    }

    static void BFS() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        int level = 1;
        int cnt = 0;
        int childCnt = 1;

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
            if(cnt == childCnt) {
                level++;
                cnt = 0;
                childCnt = q.size();
            }
        }
    }
}