
import java.io.*;
import java.util.*;

public class Main {
    static int max = Integer.MIN_VALUE;
    static ArrayList<Node>[] graph;
    static boolean[] isVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n+1];

        for(int i=1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }
        isVisited = new boolean[n+1];
//        StringTokenizer st = new StringTokenizer(br.readLine());

        StringTokenizer st;
        for(int i=0; i<n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, w));
        }

        DFS(1);
        sb.append(max);
        System.out.println(sb);
        br.close();
    }

    static int DFS(int node) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for(Node n : graph[node]) {
            if(!isVisited[n.n]) {
                int distance = DFS(n.n) + n.w;
                if(max1 < distance) {
                    max2 = max1;
                    max1 = distance;
                }
                else if(distance > max2) max2 = distance;
            }
        }
        max = Math.max(max, max1+max2);
        return max1;
    }

    static class Node {
        int n, w;
        public Node(int n, int w) {
            this.n = n;
            this.w = w;
        }
    }

}