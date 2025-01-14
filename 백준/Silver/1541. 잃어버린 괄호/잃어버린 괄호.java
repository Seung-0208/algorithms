import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String exp = sc.nextLine();
        String[] added = exp.split("-");
        int[] subs = new int[added.length];
        
        for(int i=0; i<added.length; i++) {
            StringBuilder tempStr = new StringBuilder();
            int temp = 0;
            for(int j=0; j<added[i].length(); j++) {
                if(added[i].charAt(j) == '+') {
                    temp += Integer.valueOf(tempStr.toString());
                    tempStr = new StringBuilder();
                    continue;
                }
                tempStr.append(added[i].substring(j, j + 1));
            }
            temp += Integer.valueOf(tempStr.toString());
            subs[i] = temp;
        }
        int ans = subs[0];
        for(int i=1; i < subs.length; i++) {
            ans -= subs[i];
        }
        System.out.println(ans);
    }
}