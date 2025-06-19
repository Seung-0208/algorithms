
import java.io.*;
import java.util.*;

public class Main {
    public static String first;
    public static String second;
    public static int[][] D;
    public static StringBuilder ans;
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] params = br.readLine().split(" ");
        int N = Integer.parseInt(params[0]);
        int L = Integer.parseInt(params[1]);
        int R = Integer.parseInt(params[2]);

        long[][][] D = new long[N+1][L+1][R+1];

        D[1][1][1] = 1;
        if(R > 1) D[2][1][2] = 1;
        if(L > 1) D[2][2][1] = 1;

        for(int i=3; i<=N; i++) {
            for(int j=1; j<=i && j<=L; j++) {
                for(int k=1; k<=i && k<=R; k++) {
                    D[i][j][k] = (D[i-1][j-1][k] + D[i-1][j][k-1] + D[i-1][j][k] * (i-2))%1000000007;
                }
            }
        }

        bw.write(String.valueOf(D[N][L][R]));
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }

}