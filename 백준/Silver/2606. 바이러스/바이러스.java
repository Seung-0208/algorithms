
import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] isVisited;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        graph = new ArrayList[N+1];
        isVisited = new boolean[N+1];
        for(int i=1; i<=N; i++) graph[i] = new ArrayList<>();
        StringTokenizer st;
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        isVisited[1] = true;
        search(1);
        sb.append(cnt);

        System.out.println(sb);
        br.close();
    }

    static void search(int curr) {
        for(int n : graph[curr]) {
            if(!isVisited[n]) {
                cnt++;
                isVisited[n] = true;
                search(n);
            }
        }
    }
}
