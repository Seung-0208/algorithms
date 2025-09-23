import java.io.*;
import java.util.*;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        int[] odd = {2, 3, 5, 7};
        for(int o : odd) {
            DFS(1, o);
        }
    }

    static void DFS(int n, int number) {
        if(n == N) {
            System.out.println(number);
            return;
        }
        int currNum = number*10;
        for(int i=0; i<10; i++) {
            int temp = currNum + i;
            if(isOdd(temp)) {
                DFS(n+1, temp);
            }
        }
    }

    static boolean isOdd(int n) {
        for(int i=2; i<=n/2; i++) {
            if(n % i == 0) return false;
        }
        return true;
    }
};