import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int N = routes.length;
        Node[] graph = new Node[N];
        int idx = 0;
        for(int[] r : routes){
            graph[idx] = new Node(r[0], r[1]);
            idx++;
        }
        Arrays.sort(graph);
        
        int cnt = 1;
        int point = graph[0].end;
        
        for(int i=1; i<N; i++) {
            Node curr = graph[i];
            boolean isInRange = point >= curr.start && point <= curr.end;
            if(!isInRange) {
                cnt++;
                point = curr.end;
            }
        }
        
        return cnt;
    }
    
    class Node implements Comparable<Node>{
        int start, end;
        
        @Override
        public int compareTo(Node o1) {
            return this.end - o1.end;
        }
        
        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}