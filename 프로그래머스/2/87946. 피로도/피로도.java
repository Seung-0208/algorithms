class Solution {
    boolean[] isVisited;
    int max;
    int n;
    public int solution(int k, int[][] dungeons) {
        isVisited = new boolean[dungeons.length];
        n = dungeons.length;
        tracking(k, 0, dungeons);
        int answer = -1;
        return max;
    }
    
    void tracking(int k, int cnt, int[][] dungeons) {
        if(cnt==n) {
            max = n;
            return;
        }
        
        for(int i=0; i<n; i++) {
            if(!isVisited[i] && k >= dungeons[i][0]) {
                isVisited[i] = true;
                max = Math.max(max, cnt+1);
                tracking(k-dungeons[i][1], cnt+1, dungeons);
                isVisited[i] = false;   
            }
        }
        
    }
}