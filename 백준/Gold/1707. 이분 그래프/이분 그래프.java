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
        //K번의 케이스가 주어짐.
        for(int i=0; i<K; i++) {
            isBipartiteGraph = true;
            //한 케이스 당 정점의 개수와 간선의 개수가 주어짐
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            //정점의 개수만큼 값을 업데이트
            visited = new boolean[V+1];
            check = new int[V+1];
            graph = new ArrayList[V+1];
            for(int j = 1; j<=V; j++) {
                graph[j] = new ArrayList<>();
            }
            //간선의 개수만큼 값을 받아야 함.
            for(int j=0; j<E; j++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                graph[u].add(v);
                graph[v].add(u);
            }
            for(int k=1; k<=V; k++) {
                DFS(k);
                if(!isBipartiteGraph) {
                    break;
                }
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
                check[n] = (check[node]+1) % 2; //집합 나누기
                DFS(n);
            }
            else if(check[n] == check[node]) {
                isBipartiteGraph = false;
                return;
            }
        }
    }
}