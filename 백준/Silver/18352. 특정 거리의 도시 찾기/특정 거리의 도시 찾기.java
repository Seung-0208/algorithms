import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] graph = new ArrayList[N+1];
        for(int i=0; i<=N; i++) graph[i] = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[N+1];
        for(int i=0; i<=N; i++) visited[i] = -1;

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
        }

        queue.add(X);
        visited[X]++;
        while(!queue.isEmpty()) {
            int node = queue.poll();
            for(int v : graph[node]) {
                if(visited[v] == -1) {
                    queue.add(v);
                    visited[v] = visited[node] + 1;
                }
            }
        }

        boolean isExist = false;
        for(int i=1; i<=N; i++) {
            if(visited[i] == K) {
                isExist = true;
                bw.write(String.valueOf(i)+"\n");
            }
        }


        if(!isExist) bw.write(String.valueOf(-1));
        bw.flush();
        bw.close();

    }
}