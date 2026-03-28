class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        char[] ch = number.toCharArray();
        sb.append(ch[0]);
        int cnt = 0;
        
        for(int i=1; i<ch.length; i++) {
            while(sb.length() > 0 && sb.charAt(sb.length()-1) < ch[i] && cnt < k) {
                cnt++;
                sb.deleteCharAt(sb.length()-1);
            }
            sb.append(ch[i]);
        }
        
        while(cnt < k) {
            sb.deleteCharAt(sb.length()-1);
            cnt++;
        }
        return sb.toString();
    }
}