import java.io.*;
import java.util.*;

public class Main{
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static boolean arrive;
    public static void main(String[] args) throws IOException {
        //값 입력받기
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        A = new ArrayList[N];
        for(int i=0; i<N; i++) A[i] = new ArrayList<>();
        visited = new boolean[N];
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            A[v].add(u);
            A[u].add(v);
        }
        arrive = false;
        for(int i=0; i<N; i++) {
            DFS(i, 1);
            if(arrive) break;
        }
        if(arrive) System.out.println("1");
        else System.out.println("0");
    }
    //DFS 로직 구현
    static void DFS(int n, int depth){
        if(depth == 5) {
            arrive = true;
            return;
        }
        visited[n] = true;
        for(int i : A[n]) {
            if(!visited[i]) DFS(i, depth+1);
        }
        visited[n] = false;
    }
}
