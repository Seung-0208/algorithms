import java.io.*;
import java.util.*;

public class Main {
    static boolean[] isVisited;
    static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        isVisited = new boolean[N+1];
        graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        int ans = 0;
        for(int i=1; i<=N; i++) {
            if(!isVisited[i]) {
                ans++;
                DFS(i);
            }
        }

        sb.append(ans);
        System.out.println(sb);
        br.close();
    }

    static void DFS(int n) {
        for(int child : graph[n]) {
            if(!isVisited[child]) {
                isVisited[child] = true;
                DFS(child);
            }
        }
    }
}