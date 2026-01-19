import java.util.*;

class Solution {
    
    Map<Character, Integer> count = new HashMap<>(); //주어진 수 각각의 개수 파악
    Set<Integer> ans = new HashSet<>();
    int total = 0;
    StringBuilder sb = new StringBuilder();
    
    public int solution(String numbers) {
        total = numbers.length();
        for(char c : numbers.toCharArray()) {
            if(!count.containsKey(c)) count.put(c, 1);
            else count.put(c, count.get(c)+1);
        }
        for(Character c : count.keySet()) {
            count.put(c, count.get(c)-1);
            tracking(String.valueOf(c));
            count.put(c, count.get(c)+1);
        }
        
        return ans.size();
    }
    
    public void tracking(String updated) {
        if(isPossible(Integer.parseInt(updated))) {
            sb.append(updated).append("\n");
            ans.add(Integer.parseInt(updated));
        }
        if(updated.length() == total) return;
        
        for(Character k : count.keySet()) {
            if(count.get(k) > 0) {
                count.put(k, count.get(k)-1);
                tracking(String.format("%s%c", updated, k));
                count.put(k, count.get(k)+1);
            }
        }
    }
    
    //소수 판별
    public boolean isPossible(int num) {
        if(num == 1 || num == 0) return false;
        if(num == 2) return true;
        for(int i=2; i<num; i++) {
            if(num%i == 0) return false;
        }
        return true;
    }
}