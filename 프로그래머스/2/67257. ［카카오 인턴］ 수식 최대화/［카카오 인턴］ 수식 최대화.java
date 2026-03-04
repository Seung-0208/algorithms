import java.util.*;

class Solution {
    ArrayList<Long> nums = new ArrayList<>();
    ArrayList<Character> ops = new ArrayList<>();
    char[] temp = {'+', '-', '*'};
    boolean[] isVisited = new boolean[3];
    ArrayList<char[]> cases = new ArrayList<>();
    long max = Long.MIN_VALUE;
    public long solution(String expression) {
        separate(expression);
        
        tracking(new char[] {'0', '0', '0'}, 0);
        System.out.printf("개수: %d\n", cases.size());
        for(char[] c : cases) {
            System.out.println(c);
            calculate(c);
        }
        
        return max;
    }
    
    void calculate(char[] orders) {
        ArrayList<Long> copyNums = new ArrayList<>(nums);
        ArrayList<Character> copyOps = new ArrayList<>(ops);
        for(char order : orders) {
            for(int i=0; i<copyOps.size();) {
                char op = copyOps.get(i);
                if(op == order) {
                    long t = operator(copyNums.get(i), copyNums.get(i+1), op);
                    copyNums.set(i, t);
                    copyNums.remove(i+1);
                    System.out.println(copyNums.toString());
                    copyOps.remove(i);
                } else {
                    i++;
                }
            }
        }
//         if(copyOps.size() == 1) {
            
//             for(int i=0; i<copyNums.size()-1; i++) {
//                 int temp = operator(copyNums.get(i), copyNums.get(i+1), copyOps.get(0));
//                 copyNums.set(i, temp);
//                 copyNums.remove(i+1);
//             }
//         }
        
        max = Math.max(max, Math.abs(copyNums.get(0)));
    }
    
    long operator(long a, long b, char oper) {
        if(oper == '+') return a+b;
        if(oper == '-') return a-b;
        if(oper == '*') return a*b;
        else return 0;
    }
    
    void tracking(char[] c, int cnt) {
        if(cnt==3) {
            cases.add(new char[] {c[0], c[1], c[2]});
            return;
        }
        
        for(int i=0; i<3; i++) {
            if(!isVisited[i]) {
                c[cnt] = temp[i];
                isVisited[i] = true;
                tracking(c, cnt+1); 
                isVisited[i] = false;
            }
        }
    }
    
    void separate(String expression) {
        char[] token = expression.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<token.length; i++) {
            if(token[i] != '-' && token[i] != '*' && token[i] != '+') {
                sb.append(token[i]);
            } else {
                nums.add(Long.parseLong(sb.toString()));
                sb.delete(0, sb.length());
                ops.add(token[i]);
            }
        }
        nums.add(Long.parseLong(sb.toString()));
    }
}