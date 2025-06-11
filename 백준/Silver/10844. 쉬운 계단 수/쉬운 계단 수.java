
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //자릿수
        long[][] D = new long[N+1][10]; //자릿수, 높이

        int flag = 1000000000;

        for(int j=1; j<=9; j++) {
            D[1][j] = 1;
        }

        for(int i=2; i<=N; i++) {
            for(int j=0; j<=9; j++) {
                if(j-1 >= 0) D[i][j] = (D[i][j] + D[i-1][j-1])%flag;
                if(j+1 <= 9) D[i][j] = (D[i][j] + D[i-1][j+1])%flag;
            }
        }

        long ans = 0;
        for(int i=0; i<=9; i++) {
            ans  = (ans+D[N][i])%flag;
        }

        bw.write(ans+"\n");
        bw.flush();
        bw.close();
        br.close();

    }
}