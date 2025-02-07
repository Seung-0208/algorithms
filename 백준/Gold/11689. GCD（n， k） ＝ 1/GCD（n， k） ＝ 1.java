import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //GCD = 최대공약수

        //입력값이자, 따지고 보면 배열의 역할을 함.
        //소인수의 배수를 n에서 지워주기 때문
        long n = Long.parseLong(st.nextToken());

        long ret = n;
        for(long p = 2; p<=Math.sqrt(n); p++) {
            if(n%p==0) { //p가 소인수 (약수 중 소수인 숫자)
                ret = ret - ret/p;
                while(n%p == 0){ //p(소인수)의 배수에 해당하는 값 지우기
                    n /= p;
                }
            }
        }

        //n이 1보다 크면 n이 마지막 소수라는 의미
        if(n > 1) ret = ret-ret/n;
        bw.write(String.valueOf(ret));
        bw.flush();
        bw.close();
    }
}
