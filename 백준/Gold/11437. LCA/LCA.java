
import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] tree;
    static int[] parent;
    static int[] depth;
    static boolean[] isVisited;
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //노드의 개수
        tree = new ArrayList[N+1];
        for(int i=1; i<=N; i++) tree[i] = new ArrayList<>();
        isVisited = new boolean[N+1];
        parent = new int[N+1];
        depth = new int[N+1];

        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree[a].add(b);
            tree[b].add(a);
        }

        BFS(1);

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int LCA = getLCA(a, b);
            bw.write(LCA+"\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }

    static int getLCA(int a, int b) {
        //깊이가 더 깊은 노드의 값을 a로 설정
        if(depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }
        while(depth[a] != depth[b]) {
            a = parent[a];
        }
        while(a != b) {
            a = parent[a];
            b = parent[b];
        }
        return a;
    }

    static void BFS(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        int level = 1;
        int nowSize = 1; //같은 레벨의 노드의 개수
        int cnt = 0;
        while(!q.isEmpty()) {
            int now = q.poll();
            isVisited[now] = true;
            for(int next : tree[now]) {
                if(!isVisited[next]) {
                    q.add(next);
                    parent[next] = now;
                    depth[next] = level;
                }
            }
            cnt++;
            if(cnt == nowSize) {
                cnt = 0;
                nowSize = q.size();
                level++;
            }
        }

    }
}