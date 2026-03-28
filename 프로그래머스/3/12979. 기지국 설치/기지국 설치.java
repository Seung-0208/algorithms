class Solution {
    public int solution(int n, int[] stations, int w) {
        int range = w*2+1;
        int answer = 0;
        int e=0;
        for(int a : stations) {
            if(a-w-1-e > 0) {
                answer += (a-w-1-e+range-1)/range;
            }
            e = a+w;
        }
        if(e < n) {
            answer += (n-e+range-1)/range;
        }

        return answer;
    }
}