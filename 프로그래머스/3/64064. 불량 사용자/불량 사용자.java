import java.util.*;

class Solution {
    ArrayList<Integer>[] banned_id_list;
    HashSet<Integer> result = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        //패턴 매칭 확인
        banned_id_list = new ArrayList[banned_id.length];
        for(int i=0; i<banned_id.length; i++) {
            banned_id_list[i] = new ArrayList<>();
            for(int j=0; j<user_id.length; j++) {
                if(patternMatching(banned_id[i], user_id[j])) {
                    banned_id_list[i].add(j);
                }
            }
        }
                    
        tracking(0, 0);
        return result.size();
    }
    
    void tracking(int idx, int mask) {
        if(idx == banned_id_list.length) {
            result.add(mask);
            return;
        }
        
        for(int i : banned_id_list[idx]) {
            if((mask & 1 << i) == 0) {
                tracking(idx+1, mask | (1 << i));
            }
        }
    }
    
    boolean patternMatching(String pattern, String userId) {
        if(pattern.length() != userId.length()) return false;
        char[] p = pattern.toCharArray();
        char[] u = userId.toCharArray();
        for(int i=0; i<u.length; i++) {
            if(p[i] != '*' && p[i] != u[i]) return false;
        }
        return true;
    }
}