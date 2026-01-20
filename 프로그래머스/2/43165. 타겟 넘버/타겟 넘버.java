class Solution {
    int[][] isUsed;
    int n;
    int ans = 0;
    public int solution(int[] numbers, int target) {
        isUsed = new int[numbers.length+1][2]; //인덱스가 0이면-, 1이면 +, 썼으면 1, 안썼으면 0, 
        n = numbers.length;
        
        tracking(numbers, 0, 0, target);
        return ans;
    }
    
    void tracking(int[] numbers, int idx, int value, int target) {
        if(idx == n && value == target) {
            ans++;
            return;
        } else if(idx == n) return;
        
        for(int i=0; i<2; i++) {
            if(isUsed[idx][i] == 0) {
                int temp = 0;
                
                if(i==0) {
                    temp = value - numbers[idx];
                }
                else {
                    temp = value + numbers[idx];
                }
                
                isUsed[idx][i] = 1;
                tracking(numbers, idx+1, temp, target);
                isUsed[idx][i] = 0;
            }
        }
    }
}