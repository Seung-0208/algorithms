import java.io.*;
import java.util.*;

public class Main {
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //0부터 n까지의 집합
        parents = new int[n+1];
        for(int i=0; i<=n; i++) parents[i] = i;
        int m = Integer.parseInt(st.nextToken()); //연산의 개수

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            parents[a] = find(a);
            parents[b] = find(b);
            if(type == 0) { //합집합
                union(a,b);
            } else if(type == 1) { //같은집합인지 계산
                if(parents[a] == parents[b]) {
                    bw.write("YES\n");
                } else {
                    bw.write("NO\n");
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static int find(int n) {
        if(parents[n] == n) return n;
        return find(parents[n]);
    }
    
    static void union(int a, int b) {
        if(parents[a] != parents[b]) {
            parents[parents[a]] = parents[b];
        }
    }
}
