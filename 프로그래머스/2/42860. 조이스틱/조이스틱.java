class Solution {
    public int solution(String name) {
        char[] alpha = name.toCharArray();
        int count = 0;
        for(char c : alpha) {
            count += Math.min(c-'A', 'Z'-c+1);
        }
        
        int move = alpha.length-1;
        int temp = Integer.MAX_VALUE;
        for(int i=1; i<alpha.length; i++) {
            int s = i;
            if(alpha[i]=='A') {
                while(s<alpha.length && alpha[s]=='A') s++;
                temp = Math.min(temp, (i-1)*2+1 + (alpha.length-s-1));
                temp = Math.min(temp, i-1+(alpha.length-s)*2);
                System.out.println("temp: "+temp);
            }
        }
        if(temp != Integer.MAX_VALUE) move = Math.min(move, temp);
        System.out.println("move: "+move);
        count += move;
        return count;
    }
}