import java.io.*;
import java.util.*;

public class Main{
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        DFS(1,2);
        DFS(1,3);
        DFS(1,5);
        DFS(1,7);
    }
    public static void DFS(int pos, int num) {
        if(pos == N) {
            if(isPrime(num)) System.out.println(num);
            return;
        }
        for(int i=1; i<10; i++) {
            if(i%2 == 0) continue;
            if(isPrime(10*num + i)) DFS(pos+1, 10*num+i);
        }
    }
    public static boolean isPrime(int num) {
        for(int i=2; i<num/2; i++) {
            if(num%i == 0) return false;
        }
        return true;
    }
}