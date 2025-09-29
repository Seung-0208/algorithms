import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(st.nextToken());
        int RANGE = 10000001;
        boolean[] isDeleted = new boolean[RANGE];
        List<Integer> primes = new ArrayList<>();
        isDeleted[1] = true;

        for(int i=2; i<Math.sqrt(RANGE); i++) {
            if(!isDeleted[i]) {
                primes.add(i);
                for(int j=i*2; j<RANGE; j+=i) {
                    isDeleted[j] = true;
                }
            }
        }

        int ans = 0;
        for(int i=N; i<RANGE; i++) {
            if(!isDeleted[i] && isPalindromic(i)) {
                ans = i;
                break;
            }
        }

        bw.write(ans+"\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static boolean isPalindromic(int num) {
        String temp = String.valueOf(num);

        int s = 0, e = temp.length()-1;

        while(s<=e) {
            if(temp.charAt(s) != temp.charAt(e)) return false;
            s++; e--;
        }

        return true;
    }
}
