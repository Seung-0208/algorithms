import java.util.*;

class Solution {
    ArrayList<Integer>[] matchPattern;
    Set<Integer> cases = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        matchPattern = new ArrayList[banned_id.length];
        for(int i=0; i<banned_id.length; i++) {
            matchPattern[i] = new ArrayList<>();
        }
        caculatePattern(user_id, banned_id);
        DFS(0, 0, banned_id, user_id);
        return cases.size();
    }
    
    void DFS(int idx, int isUsed, String[] banned_id, String[] user_id) {
        if(idx == banned_id.length) {
            cases.add(isUsed);
            return;
        }
        
        String pattern = banned_id[idx];
        for(int user : matchPattern[idx]) {
            int temp = 1 << user;
            if((temp & isUsed) == 0) {
                
                DFS(idx+1, temp | isUsed, banned_id, user_id);
            }
        }
    }
    
    void caculatePattern(String[] user_id, String[] banned_id) {
        for(int i=0; i<banned_id.length; i++) {
            String pattern = banned_id[i];
            int idx = 0;
            for(String id : user_id) {
                if(pattern.length() == id.length()) {
                    char[] patternArr = pattern.toCharArray();
                    char[] idArr = id.toCharArray();
                    boolean isMatch = true;
                    for(int j=0; j<idArr.length; j++) {
                        if(patternArr[j] != '*' && patternArr[j] != idArr[j]) {
                            isMatch = false;
                            break;
                        }
                    }
                    if(isMatch) {
                        matchPattern[i].add(idx);
                    }
                }
                idx++;  
            }
        }
    }
}