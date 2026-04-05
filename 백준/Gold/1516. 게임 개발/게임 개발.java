import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static int[] input;
    static int[] time;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n+1];
        input = new int[n+1]; //진입차수
        time = new int[n+1]; //건물 짓는 데 걸리는 시간
        for(int i=1; i<=n; i++) graph[i] = new ArrayList<>();

//        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
            String[] params = br.readLine().split(" ");
            time[i] = Integer.parseInt(params[0]);
            if(params.length == 2) {
                input[i] = 0;
            } else {
                for(int j=1; j<params.length-1; j++) {
                    int prev = Integer.parseInt(params[j]);
                    graph[prev].add(i);
                    input[i]++;
                }
            }
        }

        Queue<Integer> q = new ArrayDeque<>();
        for(int i=1; i<=n; i++) {
            if(input[i] == 0) q.add(i);
        }

        int[] ans = new int[n+1];
        while(!q.isEmpty()) {
            int cur = q.poll();

            for(int next : graph[cur]) {
                input[next]--;
                ans[next] = Math.max(ans[next], ans[cur]+time[cur]);

                if(input[next] == 0) q.add(next);
            }
        }

        for(int i=1; i<=n; i++) {
            sb.append(time[i]+ans[i]).append("\n");
        }


        System.out.println(sb);
        br.close();
    }
}