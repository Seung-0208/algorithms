
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        sb.append(getFactorial(N, N));

        System.out.println(sb);
        br.close();
    }

    static int getFactorial(int n, int curr) {
        if(n==0) return 1;
        if(n==1) return curr;
        return getFactorial(n-1, curr*(n-1));
    }
}
