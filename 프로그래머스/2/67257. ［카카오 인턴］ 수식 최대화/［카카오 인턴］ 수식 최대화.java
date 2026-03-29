import java.util.*;

class Solution {
    ArrayList<Long> nums = new ArrayList<>();
    ArrayList<Character> ops = new ArrayList<>();
    ArrayList<char[]> cases = new ArrayList<>();
    char[] operator = {'+', '-', '*'};
    boolean[] isVisited = new boolean[3];
    public long solution(String expression) {
        separate(expression);
        getCases(0, new char[] {'+', '-', '*'});
        
        long answer = 0;
        for(char[] c : cases) {
            long temp = calculate(c);
            answer = Math.max(answer, temp);
        }
        return answer;
    }
    
    long calculate(char[] cases) {
        ArrayList<Long> cpNums = new ArrayList<>(nums);
        ArrayList<Character> cpOps = new ArrayList<>(ops);
        for(char c : cases) {
            for(int i=0; i<cpOps.size();) {
                if(cpOps.get(i) == c) {
                    long temp = oper(cpNums.get(i), cpNums.get(i+1), c);
                    cpNums.set(i, temp);
                    cpNums.remove(i+1);
                    cpOps.remove(i);
                } else {
                    i++;
                }
            }
        }
        return Math.abs(cpNums.get(0));
    }
    
    long oper(long a, long b, char op) {
        if(op=='+') return a+b;
        if(op=='-') return a-b;
        if(op=='*') return a*b;
        else return Integer.MIN_VALUE;
    }
    
    void getCases(int cnt, char[] temp) {
        if(cnt == 3) {
            cases.add(new char[] {temp[0], temp[1], temp[2]});
            return;
        }
        
        for(int i=0; i<3; i++) {
            if(!isVisited[i]) {
                isVisited[i] = true;
                temp[cnt] = operator[i];
                getCases(cnt+1, temp);
                isVisited[i] = false;
            }
        }
    }
    
    void separate(String expression) {
        char[] temp = expression.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char c : temp) {
            if(c=='+' || c=='-' || c=='*') {
                ops.add(c);
                nums.add(Long.parseLong(sb.toString()));
                sb.delete(0, sb.length());
            } else {
                sb.append(c);
            }
        }
        nums.add(Long.parseLong(sb.toString()));
    }
}