class Solution {
    public int solution(String name) {
        char[] token = name.toCharArray();
        int answer = 0;
        
        for(char c : token) {
            answer += Math.min(c-'A', 'Z'-c+1);
        }
        
        int move = token.length-1;
        for(int i=0; i<token.length; i++) {
            int next = i+1;
            while(next < token.length && token[next]=='A') next++;
            
            int case1 = i*2 + (token.length-next);
            move = Math.min(move, case1);
            int case2 = i + (token.length-next)*2;
            move = Math.min(move, case2);
        }
        answer += move;
        
        return answer;
    }
}