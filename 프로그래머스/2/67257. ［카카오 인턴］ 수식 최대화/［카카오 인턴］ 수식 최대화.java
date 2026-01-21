import java.util.*;

class Solution {
    char[] base = {'+', '-', '*'};
    boolean[] isUsed = new boolean[3];
    char[] order = new char[3];
    long max = 0;
    public long solution(String expression) {
        
        
        ArrayList<Long> nums = new ArrayList<>();
        ArrayList<Character> opers = new ArrayList<>();
        tokenize(expression, nums, opers);
        
        tracking(nums, opers, 0);
        
        return max;
    }
    
    void tracking(ArrayList<Long> nums, ArrayList<Character> opers, int depth) {
        if(depth == 3) {
            long temp = calculate(nums, opers);
            temp = Math.max(temp, temp*(-1));
            max = Math.max(max, temp);
            return;
        }
        
        for(int i=0; i<3; i++) {
            if(!isUsed[i]) {
                isUsed[i] = true;
                order[depth] = base[i];
                tracking(nums, opers, depth+1);
                isUsed[i] = false;
            }
        }
    }
    
    long calculate(ArrayList<Long> nums, ArrayList<Character> opers) {
        
        ArrayList<Long> copyNums = new ArrayList<>(nums);
        ArrayList<Character> copyOpers = new ArrayList<>(opers);
        
        for(char orderOP : order) {
            for(int i=0; i<copyOpers.size();) {
                if(copyOpers.get(i) == orderOP) {
                    long temp = 0;
                    if(orderOP == '+') {
                        temp = copyNums.get(i) + copyNums.get(i+1);
                    } else if(orderOP == '-') {
                        temp = copyNums.get(i) - copyNums.get(i+1);
                    } else if(orderOP == '*') {
                        temp = copyNums.get(i) * copyNums.get(i+1);
                    }
                    copyNums.set(i, temp);
                    copyNums.remove(i+1);
                    
                    copyOpers.remove(i);
                } else {
                    i++;
                }
            }
        }
        
        return copyNums.get(0);
    }
    
    void tokenize(String expression, ArrayList<Long> nums, ArrayList<Character> opers) {
        StringBuilder temp = new StringBuilder();
        for(char c : expression.toCharArray()) {
            if(c == '+' || c=='-' || c=='*') {
                opers.add(c);
                nums.add(Long.parseLong(temp.toString()));
                temp = new StringBuilder();
            } else {
                temp.append(c);
            }
        }
        nums.add(Long.parseLong(temp.toString()));
    }
}