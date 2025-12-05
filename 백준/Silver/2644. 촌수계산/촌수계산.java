import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Integer>[] graph;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n+1];
        distance = new int[n+1];
        for(int i=1; i<=n; i++) {
            graph[i] = new ArrayList<>();
            distance[i] = -1;
        }
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }

        bfs(a);

        bw.write(distance[b]+"\n");
        bw.flush();
        bw.close();
        br.close();

    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        distance[start] = 0;
        while(!q.isEmpty()) {
            int now = q.poll();
            for(int child : graph[now]) {
                if(distance[child] == -1) {
                    q.add(child);
                    distance[child] = distance[now]+1;
                }
            }
        }

    }

}
