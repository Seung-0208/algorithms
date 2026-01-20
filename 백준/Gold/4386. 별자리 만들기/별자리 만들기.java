
import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        parent = new int[n+1];
        for(int i=1; i<=n; i++) parent[i] = i;
        ArrayList<double[]> points = new ArrayList<>();
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            points.add(new double[]{x, y});
        }

        PriorityQueue<Edge> q = new PriorityQueue<>();
        for(int i=0; i<n-1; i++) {
            for(int j=i+1; j<n; j++) {
                double[] pos1 = points.get(i);
                double[] pos2 = points.get(j);
                q.add(new Edge(i, j, getWeight(pos1, pos2)));
            }
        }

        int edgeN = 0; double sum = 0;
        while(!q.isEmpty()) {
            Edge curr = q.poll();
            int a = curr.s;
            int b= curr.e;
            double w = curr.weight;

            parent[a] = find(a);
            parent[b] = find(b);
            if(parent[a] != parent[b]) {
                union(a, b);
                edgeN++;
                sum += w;
            }

            if(edgeN == n-1) break;
        }

        sb.append(String.format("%.2f", sum));

        System.out.println(sb);
        br.close();
    }

    static int find(int a){
        if(a==parent[a]) return a;
        return find(parent[a]);
    }

    static void union(int a, int b) {
        parent[a] = find(a);
        parent[b] = find(b);

        if(parent[a] != parent[b]) {
            parent[parent[a]] = parent[b];
        }
    }

    static class Edge implements Comparable<Edge>{
        int s, e;
        double weight;
        public Edge(int s, int e, double weight) {
            this.s = s;
            this.e = e;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o1) {
            if(this.weight - o1.weight > 0) return 1;
            else if(this.weight==o1.weight) return 0;
            return -1;
        }
    }

    static double getWeight(double[] pos1, double[] pos2) {
        double x1 = pos1[0], x2 = pos2[0];
        double y1 = pos1[1], y2 = pos2[1];

        double x = Math.pow(x1-x2, 2);
        double y = Math.pow(y1-y2, 2);
        return Math.sqrt(x+y);
    }
}
