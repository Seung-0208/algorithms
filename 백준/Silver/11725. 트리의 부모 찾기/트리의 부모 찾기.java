
import java.io.*;
import java.util.*;

public class Main{
    static int[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        List<Integer>[] tree = new ArrayList[N+1];
        int[] parent = new int[N+1];
        for(int i=1; i<=N; i++) { //초기화
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


        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        while(!q.isEmpty()){
            int now = q.poll();
            for(int next : tree[now]){
                if(parent[next]==next && next != 1){
                    parent[next] = now;
                    q.add(next);
                }
            }
        }

        for(int i=2; i<=N; i++) {
            bw.write(parent[i]+"\n");
        }
        bw.flush();
    }
}