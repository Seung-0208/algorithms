
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

        int[][] power = new int[5][5];
        for(int i=0; i<=4; i++) {
            for(int j=1; j<=4; j++) {
                if(i==j) power[i][j] = 1;
                else if(i==0) {
                    power[i][j] = 2;
                    power[j][i] = 2;
                }
                else if((i==1 && j==3) || (i==3 && j==1) || (i==2 && j==4) || (i==4 && j==2)) power[i][j] = 4;
                else {
                    power[i][j] = 3;
                }
            }
        }

        String[] params = br.readLine().split(" ");
        int N = params.length-1;
        int[] nums = new int[N];
        for(int i=0; i< N; i++) {
            nums[i] = Integer.parseInt(params[i]);
        }

        int[][][] D = new int[N+1][5][5];
        for(int i=0; i<=N; i++) {
            for(int j=0; j<=4; j++) {
                //각 지점에서 모두 4의 힘을 사용하게 될 경우가 가장 최댓값
                for(int k=0; k<=4; k++) D[i][j][k] = 100001*4;
            }
        }

        D[0][0][0] = 0;

        for(int i=0; i<N; i++) {
            int n = nums[i];
            for(int k=0; k<5; k++) { //왼발을 옮겼을 때
                if(k==n) continue;
                for(int j=0; j<5; j++) {
                    D[i+1][n][k] = Math.min(D[i][j][k] + power[j][n], D[i+1][n][k]);
                }
            }

            for(int k=0; k<5; k++) { //오른발을 옮겼을 때
                if(k==n) continue;
                for(int j=0; j<5; j++) {
                    D[i+1][k][n] = Math.min(D[i][k][j] + power[n][j], D[i+1][k][n]);
                }
            }
        }

        int ret = Integer.MAX_VALUE;

        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                ret = Math.min(ret, D[N][i][j]);
            }
        }

        bw.write(String.valueOf(ret));
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }

}