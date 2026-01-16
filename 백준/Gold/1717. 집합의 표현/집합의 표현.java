
import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        parent = new int[n+1];
        for(int i=0; i<=n; i++) parent[i] = i;

        int m = Integer.parseInt(st.nextToken()); //케이스 개수
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int operator = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(operator == 0) union(a, b);
            else {
                parent[a] = find(a);
                parent[b] = find(b);
                if(parent[a] == parent[b]) sb.append("YES\n");
                else sb.append("NO\n");
            }
        }

        System.out.println(sb);
        br.close();
    }

    static int find(int a) {
        if(a==parent[a]) return a;
        return find(parent[a]);
    }

    static void union(int a, int b) {
        parent[a] = find(a);
        parent[b] = find(b);

        if(parent[a]==parent[b]) return;
        parent[parent[a]] = parent[b];
    }

}