class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int wDist = w*2+1;
        
        int min = 0;
        int max = -1;
        for(int i=0; i<stations.length; i++) {
            int s = stations[i]-1;
            min = Math.max(0, s-w);
            
            int temp = min-max-1;
            if(temp != 0) {
                answer += ((temp+wDist-1)/wDist);
            }
            max = Math.min(n-1, s+w);
        }
        if(max < n-1) {
            int temp = n-max-1;
            answer += temp/wDist;
            if(temp%wDist != 0) answer++;
        }

        return answer;
    }
}