import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main{
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    static boolean isBipartiteGraph;
    static int[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            //초기화
            visited = new boolean[V+1];
            check = new int[V+1];
            graph = new ArrayList[V+1];
            isBipartiteGraph = true;
            for(int j=1; j<=V; j++) graph[j] = new ArrayList<>();
            //간선에 대한 정보 저장
            for(int j=0; j<E; j++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                graph[u].add(v);
                graph[v].add(u);
            }
            //탐색 시작
            for(int j=1; j<=V; j++) {
                DFS(j);
                if(!isBipartiteGraph) break;
            }
            if(isBipartiteGraph) bw.write("YES\n");
            else bw.write("NO\n");
        }
        bw.flush();
    }
    static void DFS(int node) {
        visited[node] = true;
        for(int n: graph[node]) {
            if(!visited[n]) {
                check[n] = (check[node]+1)%2;
                DFS(n);
            }
            else if(check[n] == check[node]) {
                isBipartiteGraph = false;
                return;
            }
        }
    }
}