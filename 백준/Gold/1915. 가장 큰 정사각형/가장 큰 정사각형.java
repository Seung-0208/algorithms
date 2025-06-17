
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

        String[] size = br.readLine().split(" ");
        int n = Integer.parseInt(size[0]);
        int m = Integer.parseInt(size[1]);
        int[][] D = new int[n+1][m+1];

        int ret = 0;

        for(int i=1; i<=n; i++) {
            String line = br.readLine();
            for(int j=1 ;j<=m; j++) {
                if(line.charAt(j-1) == '1') {
                    D[i][j] = Math.min(Math.min(D[i-1][j], D[i][j-1]), D[i-1][j-1]) + 1;
                    ret = Math.max(ret, D[i][j]);
                }
            }
        }

        bw.write(String.valueOf(ret*ret));
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }

}