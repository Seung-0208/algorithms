
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
        first = st.nextToken();
        st = new StringTokenizer(br.readLine());
        second = st.nextToken();
        D = new int[first.length()+1][second.length()+1];

        for(int i=1; i<=first.length(); i++) {
            for(int j=1; j<=second.length(); j++) {
                if(first.charAt(i-1)==second.charAt(j-1)) {
                    D[i][j] = D[i-1][j-1]+1;
                } else {
                    D[i][j] = Math.max(D[i-1][j], D[i][j-1]);
                }
            }
        }
        int cnt = D[first.length()][second.length()];
        bw.write(cnt+"\n");
        if(cnt > 0) {
            ans = new StringBuilder();
            getLCS(first.length(), second.length());
            bw.write(ans +"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void getLCS(int i, int j) {
        if(i <= 0 || j <= 0) return;
        if(first.charAt(i-1) == second.charAt(j-1)) {
            ans.insert(0, first.charAt(i-1));
            getLCS(i-1, j-1);
        }
        else {
            if(D[i][j-1] > D[i-1][j]) {
                getLCS(i, j-1);
            } else {
                getLCS(i-1, j);
            }
        }
    }
}