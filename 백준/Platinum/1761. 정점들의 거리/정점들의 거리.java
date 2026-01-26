
import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Node>[] graph;
    static boolean[] isVisited;
    static int[] depth;
    static int[][] parent;
    static int[][] upDist;
    static int kMax;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //수의 개수
        graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++) graph[i] = new ArrayList<>();
        isVisited = new boolean[N+1];
        depth = new int[N+1];

        int temp = 1;
        kMax = 0;
        while(temp <= N) {
            temp <<= 1;
            kMax++;
        }

        parent = new int[kMax+1][N+1];
        upDist = new int[kMax+1][N+1];

        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, w));
            graph[b].add(new Node(a, w));
        }

        BFS();

        for(int k=1; k<=kMax; k++) {
            for(int i=1; i<=N; i++) {
                parent[k][i] = parent[k-1][parent[k-1][i]];
                upDist[k][i] = upDist[k-1][i] + upDist[k-1][parent[k-1][i]];
            }
        }

        int M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(getDist(a, b)).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    static int getDist(int a, int b) {
        int deeper, lighter;
        int sum = 0;
        if(depth[a] > depth[b]) {
            deeper = a;
            lighter = b;
        } else {
            deeper = b;
            lighter = a;
        }

        for(int k=kMax; k>=0; k--) {
            if(Math.pow(2, k) <= depth[deeper]-depth[lighter]) {
                sum += upDist[k][deeper];
                deeper = parent[k][deeper];
            }
        }

        for(int k=kMax; k>=0; k--) {
            if(parent[k][deeper] != parent[k][lighter]) {
                sum += upDist[k][deeper];
                deeper = parent[k][deeper];
                sum += upDist[k][lighter];
                lighter = parent[k][lighter];
            }
        }

        if(deeper != lighter) {
            sum += upDist[0][deeper];
            sum += upDist[0][lighter];
        }
        return sum;
    }

    static void BFS() {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        isVisited[1] = true;

        int cnt = 0;
        int level = 1;
        int childCnt = 1;
        while(!q.isEmpty()) {
            int cur = q.poll();
            depth[cur] = level;

            for(Node n : graph[cur]) {
                if(!isVisited[n.node]) {
                    isVisited[n.node] = true;
                    q.add(n.node);
                    parent[0][n.node] = cur;
                    upDist[0][n.node] = n.weight;
                }
            }

            cnt++;

            if(cnt == childCnt) {
                level++;
                cnt = 0;
                childCnt = q.size();
            }
        }
    }

    static class Node {
        int node, weight;
        public Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
}