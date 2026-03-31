import java.io.*;
import java.util.*;

public class Main {
    static boolean[] isVisited;
    static ArrayList<Integer>[] graph;
    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
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

        for(int i=1; i<=N; i++) {
            Collections.sort(graph[i]);
        }

        isVisited[start] = true;
        DFS(start);
        sb.append("\n");
        BFS(start);
        System.out.println(sb);
        br.close();
    }

    static void BFS(int n) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(n);
        boolean[] isVisited = new boolean[N+1];
        isVisited[n] = true;

        while(!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur).append(" ");
            for(int child : graph[cur]) {
                if(!isVisited[child]) {
                    isVisited[child] = true;
                    q.add(child);
                }
            }
        }
    }

    static void DFS(int n) {
        sb.append(n).append(" ");
        for(int child : graph[n]) {
            if(!isVisited[child]) {
                isVisited[child] = true;
                DFS(child);
            }
        }
    }
}