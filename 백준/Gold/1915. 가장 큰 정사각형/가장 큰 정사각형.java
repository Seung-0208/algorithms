
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

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] D = new int[n+1][m+1];

        int ret = 0;
        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for(int j=1; j<=m; j++) {
                D[i][j] = Integer.parseInt(String.valueOf(line.charAt(j-1)));
                if(D[i][j] != 0) {
                    D[i][j] = Math.min(D[i-1][j], D[i][j-1]);
                    D[i][j] = Math.min(D[i][j], D[i-1][j-1]);
                    D[i][j]++;
                    ret = Math.max(D[i][j], ret);
                }
            }
        }

        bw.write(ret*ret+"\n");


        bw.flush();
        bw.close();
        br.close();
    }

}