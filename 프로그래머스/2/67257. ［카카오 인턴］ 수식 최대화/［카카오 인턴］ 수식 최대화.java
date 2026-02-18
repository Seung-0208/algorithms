import java.util.*;

class Solution {
    ArrayList<Long> nums = new ArrayList<>();
    ArrayList<Character> ops = new ArrayList<>();
    ArrayList<char[]> cases = new ArrayList<>();
    char[] op = {'+', '-', '*'};
    boolean[] isVisit = new boolean[3];
    long max = Long.MIN_VALUE;
    public long solution(String expression) {
        //경우의 수 구하기
        getCase(new char[3], 0);
        //연산자, 피연산자 분리
        separate(expression);
        //계산
        for(int i=0; i<cases.size(); i++) {
            char[] order = cases.get(i);
            calculateCase(order);
        }
        
        return max;
    }
    
    void getCase(char[] c, int idx) {
        if(idx == 3) {
            cases.add(c.clone());
            return;
        }
        
        for(int i=0; i<3; i++) {
            if(!isVisit[i]) {
                c[idx] = op[i];
                isVisit[i] = true;
                getCase(c, idx+1);
                isVisit[i] = false;
            }
        }
    }
    
    void calculateCase(char[] order) {
        ArrayList<Long> numsT = new ArrayList<>(nums);
        ArrayList<Character> opsT = new ArrayList<>(ops);
        for(char op : order) {
            for(int i=0; i<opsT.size();) {
                if(opsT.get(i) == op) {
                    long temp = calculate(numsT.get(i), numsT.get(i+1), op);
                    opsT.remove(i);
                    numsT.set(i, temp);
                    numsT.remove(i+1);
                } else {
                    i++;
                }
            }
        }
        max = Math.max(max, Math.abs(numsT.get(0)));
    }
    
    
    long calculate(long a, long b, char op) {
        if(op=='-') return a-b;
        if(op=='+') return a+b;
        else return a*b;
    }
    
    void separate(String exp) {
        StringBuilder sb = new StringBuilder();
        for(char t : exp.toCharArray()) {
            if(t=='-' || t=='*' || t=='+') {
                ops.add(t);
                if(sb.length() != 0) {
                    nums.add(Long.parseLong(sb.toString()));
                    sb.setLength(0);
                }
            }
            else {
                sb.append(t);
            }
        }
        nums.add(Long.parseLong(sb.toString()));
    }
}