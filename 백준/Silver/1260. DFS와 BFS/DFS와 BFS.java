import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main{
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static boolean[] visitedBFS;
    static String dfsResult;
    static String bfsResult;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        visitedBFS = new boolean[N+1];
        A = new ArrayList[N+1];
        dfsResult = new String();
        bfsResult = new String();
        for(int i=1; i<=N; i++) A[i] = new ArrayList<>();
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            A[u].add(v);
            A[v].add(u);
        }
        for(int i=1; i<=N; i++) Collections.sort(A[i]);
        visited[V] = true;
        dfsResult += String.valueOf(V) + " ";
        for(Integer i : A[V]) {
            if(!visited[i]) DFS(i);
        }
        System.out.println(dfsResult);
        BFS(V);
        System.out.println(bfsResult);
    }

    static void DFS(int node) {
        if(visited[node]) return;
        visited[node] = true;
        dfsResult += String.valueOf(node) + " ";
        for(Integer i : A[node]) {
            if(!visited[i]) DFS(i);
        }
    }

    static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(start);
        visitedBFS[start] = true;
        while(!queue.isEmpty()) {
            int node = queue.poll();
            bfsResult += String.valueOf(node) + " ";
            for(Integer i : A[node]) {
                if(!visitedBFS[i]) {
                    visitedBFS[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
