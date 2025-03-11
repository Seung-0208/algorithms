import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main{
    static ArrayList<Integer>[] graph;
    static int[] record;
    static boolean[] visited;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //N개의 컴퓨터
        int M = Integer.parseInt(st.nextToken()); //M개의 경우의 수
        graph = new ArrayList[N+1];
        record = new int[N+1];
        visited = new boolean[N+1];
        for(int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[A].add(B);
        }

        for(int i=1; i<=N; i++) {
            BFS(i);
        }

        int max = 0;
        for(int i=1; i<=N; i++) {
            if(record[i] > max) max = record[i];
        }

        for(int i=1; i<=N; i++) {
            if(record[i]==max) bw.write(String.valueOf(i) + " ");
        }
        bw.flush();
    }
    static void BFS(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        visited = new boolean[N+1];
        visited[n] = true;
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for(int node : graph[cur]) {
                if(!visited[node]) {
                    visited[node] = true;
                    queue.add(node);
                    record[node] += 1;
                }
            }
        }

    }
}