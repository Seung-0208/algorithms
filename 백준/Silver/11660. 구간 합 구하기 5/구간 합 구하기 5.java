import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] nums = new int[N+1][N+1];
        int[][] haps = new int[N+1][N+1];

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                nums[i][j] = sc.nextInt();
            }
        }

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                haps[i][j] = haps[i-1][j] + haps[i][j-1] - haps[i-1][j-1] + nums[i][j];
            }
        }

        for(int i=0; i<M; i++) {
            int[] xy = new int[4];
            for(int j=0; j<4; j++) {
                xy[j] = sc.nextInt();
            }
            int x1 = xy[0], y1 = xy[1], x2 = xy[2], y2 = xy[3];
            int temp = haps[x2][y2] - haps[x1-1][y2] - haps[x2][y1-1] + haps[x1-1][y1-1];
            bw.write(String.valueOf(temp));
            bw.newLine();
        }
        bw.flush();
    }
}