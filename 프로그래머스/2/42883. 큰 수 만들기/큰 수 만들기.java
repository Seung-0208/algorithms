class Solution {
    public String solution(String number, int k) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        char[] nums = number.toCharArray();
        int cnt = k;
        for(char n : nums) {
            for(int i=sb.length(); i>=0; i--) {
                if(sb.length() > 0 && sb.charAt(sb.length()-1) < n && cnt > 0) {
                    sb.deleteCharAt(sb.length()-1);
                    cnt--;
                } else{
                    break;
                }
            }
            sb.append(n);
        }
        
        while(cnt > 0) {
            sb.deleteCharAt(sb.length()-1);
            cnt--;
        }
        return sb.toString();
    }
}