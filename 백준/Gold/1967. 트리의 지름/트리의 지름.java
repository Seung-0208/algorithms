import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Node>[] graph;
    static boolean[] isVisited;
    static long answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken()); //노드의 개수
        isVisited = new boolean[n+1];
        graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[parent].add(new Node(child, weight));
        }
        DFS(1);

        sb.append(answer);
        System.out.println(sb);
        br.close();
    }
    static class Node {
        int node;
        int weight;
        public Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    static long DFS(int node) {
        isVisited[node] = true;
        long max1 = 0;
        long max2 = 0;
        for(Node child : graph[node]) {
            if(!isVisited[child.node]) {
                long childSum = DFS(child.node) + child.weight;
                if(childSum > max1) {
                    max2 = max1;
                    max1 = childSum;
                } else if (childSum > max2) {
                    max2 = childSum;
                }
            }
        }
        answer = Math.max(answer, max1+max2);
        return max1;
    }
}
