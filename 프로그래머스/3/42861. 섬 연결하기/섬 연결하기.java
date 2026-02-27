import java.util.*;

class Solution {
    int[] parent;
    public int solution(int n, int[][] costs) {
        parent = new int[n];
        for(int i=0; i<n; i++) parent[i] = i;
        PriorityQueue<Node> q = new PriorityQueue<>();
        for(int [] c : costs){
            q.add(new Node(c[0],c[1],c[2]));
        }
        int cnt = 0;
        int sum = 0;
        while(!q.isEmpty()) {
            Node curr = q.poll();
            int a = curr.s;
            int b = curr.e;
            int w = curr.w;
            
            parent[a] = find(a);
            parent[b] = find(b);
            if(parent[a] != parent[b]) {
                union(a, b);
                cnt++;
                sum += w;
            }
            
            if(cnt == n-1) break;
        }
        
        
        int answer = sum;
        return answer;
    }
    
    int find(int n) {
        if(parent[n]==n) return n;
        return find(parent[n]);
    }
    
    void union(int a, int b){
        parent[a] = find(a);
        parent[b] = find(b);
        if(parent[a] != parent[b]) {
            parent[parent[a]] = parent[b];
        }
    }
    
    class Node implements Comparable<Node>{
        int s, e, w;
        public Node (int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }
        
        @Override
        public int compareTo(Node o1) {
            return this.w - o1.w;
        }
    }
}