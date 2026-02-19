class Solution {
    public String solution(String number, int K) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        char[] nums = number.toCharArray();
        K = nums.length-K;
        int start = 0;
        for(int k=K-1; k>=0; k--) {
            char max = '0';
            for(int i=start; i<nums.length-k; i++) {
                if(max-'0' < nums[i]-'0') {
                    max = nums[i];
                    start = i+1;
                }
            }
            sb.append(max);
        }
        
        
        return sb.toString();
    }
}