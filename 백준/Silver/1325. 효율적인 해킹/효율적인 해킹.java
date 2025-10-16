import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] rev;
    static int[] seen, cnt;
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        rev = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) rev[i] = new ArrayList<>();
        seen = new int[N + 1];
        cnt = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // a가 b를 신뢰
            int b = Integer.parseInt(st.nextToken());
            rev[b].add(a); // 해킹 전파: b -> a
        }

        int max = 0;
        for (int s = 1; s <= N; s++) {
            int c = bfs(s);
            cnt[s] = c;
            if (c > max) max = c;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) if (cnt[i] == max) sb.append(i).append(' ');
        System.out.print(sb.toString());
    }

    static int bfs(int start) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(start);
        seen[start] = start;
        int c = 0;

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : rev[u]) {
                if (seen[v] != start) {
                    seen[v] = start;
                    q.add(v);
                    c++;
                }
            }
        }
        return c;
    }
}
