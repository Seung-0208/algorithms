class Solution {
    public int solution(String name) {
        int answer = 0;
        char[] chs = name.toCharArray();
        int N = chs.length;
        for(char c : chs) {
            answer += Math.min(c-'A', 'Z'-c+1);
        }
        int move = N-1;
        for(int i=0; i<N; i++) {
            if(chs[i] == 'A') {
                int s = i;
                while(chs[i] == 'A') {
                    i++;
                    if(i>=N) {
                        break;
                    }
                }
                if(s==0) s=1;
                int temp = Math.min((s-1)*2+1+N-1-i, s+(N-1-i)*2+1);
                move = Math.min(temp, move);
            }
        }
        if(move < 0) move = 0;
        System.out.println("move="+move);
        return answer+move;
    }
}