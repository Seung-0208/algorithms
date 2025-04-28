
import java.io.*;
import java.util.*;

public class Main{
    static List<Integer>[] tree;
    static boolean[] isVisited;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        tree = new ArrayList[N+1]; //초기화
        parent = new int[N+1];
        isVisited = new boolean[N+1];
        for(int i=1; i<=N; i++) {
            tree[i] = new ArrayList<>();
            parent[i] = i;
        }

        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }


        DFS(1);

        for(int i=2; i<=N; i++) {
            bw.write(parent[i]+"\n");
        }
        bw.flush();
    }

    static void DFS(int node){
        isVisited[node] = true;
        for(int next : tree[node]) {
            if(!isVisited[next]) {
                parent[next] = node;
                DFS(next);
            }
        }
    }
}