import java.io.*;
import java.util.*;

public class Main{

    static boolean[] visited;
    static ArrayList<Integer>[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        A = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            A[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            A[u].add(v);
            A[v].add(u);
        }
        int cnt = 0;
        for(int i=1; i<=N; i++) {
            if(!visited[i]) {
                DFS(i);
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    static void DFS(int node) {
        if(visited[node]) return;
        visited[node] = true;
        for(int n : A[node]) {
            if(!visited[n]) DFS(n);
        }
    }
}