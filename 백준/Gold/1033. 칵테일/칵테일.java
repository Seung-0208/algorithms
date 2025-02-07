import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main{
    static boolean[] visited;
    static ArrayList<Node>[] graph;
    static long[] ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n];
        visited = new boolean[n];
        ans = new long[n];
        for(int i=0; i<n; i++) graph[i] = new ArrayList<>();
        long totalLcm = 1;
        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine());
            int firstIdx = Integer.parseInt(st.nextToken());
            int secondIdx = Integer.parseInt(st.nextToken());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            long tempGcd = gcd(first, second);
            totalLcm *= tempGcd*(first/tempGcd)*(second/tempGcd);
            graph[firstIdx].add(new Node(secondIdx, first, second));
            graph[secondIdx].add(new Node(firstIdx, second, first));
        }
        ans[0] = totalLcm;
        for(int i=0; i<n-1; i++) {
            if(!visited[i]) {
                dfs(i);
            }
        }

        long mgcd = ans[0];
        for(long i : ans) {
            mgcd = gcd(mgcd, i);
        }
        for(long i : ans) {
            bw.write(String.valueOf(i/mgcd) + " ");
        }
        bw.flush();
        bw.close();
    }

    public static class Node {
        int node;
        int first, second;


        public Node(int node, int first, int second) {
            this.node =node;
            this.first =first; //graph index 가 갖는 비율
            this.second =second; //node 가 갖는 비율
        }
    }
    static long gcd(long a, long b){
        long bigger, smaller;
        bigger = Math.max(a, b);
        smaller = Math.min(a, b);

        long rest = bigger % smaller;
        while(rest != 0) {
            bigger = smaller;
            smaller = rest;
            rest = bigger%smaller;
        }
        return smaller;
    }
    /*
    * node : n.node = first : second = ans[node] : ?
    * second * ans[node] = first * ?
    * ? = second * ans[node] / first
    * */
    static void dfs(int node) {
        for(Node n : graph[node]) {
            if(!visited[n.node]) {
                visited[n.node] = true;
                ans[n.node] = n.second * ans[node] / n.first;
                dfs(n.node);
            }
        }
    }
}