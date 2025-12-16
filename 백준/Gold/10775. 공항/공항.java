import java.io.*;
import java.util.*;

public class Main {
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int G = Integer.parseInt(st.nextToken()); //게이트 수
        parents = new int[G+1];
        for(int i=1; i<=G; i++) parents[i] = i;
        st = new StringTokenizer(br.readLine());
        int P = Integer.parseInt(st.nextToken()); //비행기 수

        int cnt = 0;
        boolean isBreak = false;
        for(int i=1; i<=P; i++) {
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());
            int parentG = find(g);
            parents[g] = parentG;
            if(parentG != 0 && !isBreak) { //parentG에 도킹
                cnt++;
                union(parentG-1, parentG);
            } else {
                isBreak = true;
            }
        }

        bw.write(cnt+"\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static int find(int n) {
        if(parents[n] == n) return n;
        return find(parents[n]);
    }

    static void union(int a, int b) {
        parents[a] = find(a);
        parents[b] = find(b);
        if(parents[a] != parents[b]) {
            parents[parents[b]] = parents[a];
        }
    }
}
