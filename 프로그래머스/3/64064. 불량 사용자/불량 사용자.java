import java.util.*;

class Solution {
    HashSet<Integer> cases = new HashSet<>();
    ArrayList<Integer>[] matchedUser;
    int N;
    public int solution(String[] user_id, String[] banned_id) {
        N = banned_id.length;
        matchedUser = new ArrayList[banned_id.length];
        matchUserNBanned(user_id, banned_id);
        
        tracking(0, 0);
        
        return cases.size();
    }
    
    void tracking(int idx, int isVisited) {
        if(idx==N) {
            cases.add(isVisited);
            return;
        }
        
        for(int user : matchedUser[idx]) {
            int mask = 1 << user;
            if((isVisited & mask) == 0) {
                tracking(idx+1, isVisited|mask);
            }
        }
    }
    
    void matchUserNBanned(String[] user_id, String[] banned_id) {
        for(int i=0; i<banned_id.length; i++) {
            matchedUser[i] = new ArrayList<>();
            char[] temp = banned_id[i].toCharArray();
            for(int k=0; k<user_id.length; k++) {
                String id = user_id[k];
                char[] idTemp = id.toCharArray();
                if(id.length() == temp.length) {
                    boolean isMatch = true;
                    for(int j=0; j<idTemp.length; j++) {
                        if(temp[j]!='*' && temp[j] != idTemp[j]) {
                            isMatch = false;
                            break;
                        }
                    }
                    if(isMatch) matchedUser[i].add(k);
                }
            }
        }
    }
}