
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //a의 개수
        int M = Integer.parseInt(st.nextToken()); //z의 개수
        int total = N+M;
        long K = Long.parseLong(st.nextToken()); //몇번째 순열

        //조합 경우의 수
        long[][] D = new long[total+1][total+1];
        D[0][0] = 1;

        for(int i=1; i<=total; i++) {
            D[i][0] = D[i][i] = 1;
            for(int j=1; j<=i; j++) {
                D[i][j] = D[i-1][j] + D[i-1][j-1];
                if (D[i][j] > 1_000_000_000) D[i][j] = 1_000_000_001;
            }
        }

        if(K > D[total][M]) {
            bw.write("-1\n");
            bw.flush();
            br.close();
            bw.close();
            return;
        }


        char[] permutation = new char[N+M+1];
        for(int i=1; i<=total; i++) {
            if(N==0) {
                permutation[i] = 'z';
                continue;
            }
            if(M==0) {
                permutation[i] = 'a';
                continue;
            }
            //해당 자릿수에 a가 들어올 때의 경우의 수
            long casesN = D[(N-1)+M][M];

            if(K <= casesN) {
                N--;
                permutation[i] = 'a';
            } else {
                M--;
                K -= casesN;
                permutation[i] = 'z';
            }
        }

        for(int i=1; i<=total; i++) bw.write(permutation[i]);
        bw.flush();
        bw.close();
        br.close();
    }
}