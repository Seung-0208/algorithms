import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int G = Integer.parseInt(br.readLine());
        parent = new int[G+1];
        for(int i=1; i<=G; i++) parent[i] = i;
        int P = Integer.parseInt(br.readLine());
        int cnt = 0;
        for(int i=0; i<P; i++) {
            int g = Integer.parseInt(br.readLine());
            parent[g] = find(g);
            if(parent[g] == 0) break;
            cnt++;
            union(parent[g], --parent[g]);
        }

        sb.append(cnt);

        System.out.println(sb);
        br.close();
    }

    static int find(int a) {
        if(a == parent[a]) return a;
        return find(parent[a]);
    }
    static void union(int a, int b) {
//        parent[a] = find(a);
        parent[b] = find(b);
        if(parent[a] != parent[b]) {
            parent[parent[a]] = parent[b];
        }
    }
}