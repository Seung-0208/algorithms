
import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph; //연결정보 저장
    static boolean[] isVisited; //트리 탐색에서 사용할 방문 여부 값
    static int[] depth; //각 노드가 위치한 height 값
    static int[] parent; //각 노드의 부모 노드 정보
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++) graph[i] = new ArrayList<>();
        isVisited = new boolean[N+1];
        depth = new int[N+1];
        parent = new int[N+1];

        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        BFS(1); //루트 노드부터 탐색 시작

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
        //a가 b보다 깊이가 깊다고 가정
        if(depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }
        //두 노드의 깊이 맞추기
        while(depth[a] != depth[b]) {
            a = parent[a];
        }
        while(a != b) {
            a = parent[a];
            b = parent[b];
        }

        return a;
    }

    //그래프를 탐색하며 트리 정보 저장
    static void BFS(int node) {
        Queue<Integer> q = new LinkedList();
        q.add(node);

        int level = 1;
        int childCnt = 1;
        int cnt = 0;

        while(!q.isEmpty()) {
            int now = q.poll();

            depth[now] = level;

            isVisited[now] = true;
            for(int next : graph[now]) {
                if(!isVisited[next]) {
                    q.add(next);
                    parent[next] = now;
                }
            }
            cnt++;
            if(childCnt == cnt) {
                level++;
                childCnt = q.size();
                cnt = 0;
            }
        }
    }
}