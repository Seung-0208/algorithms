
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //숫자의 개수
        boolean[] isUsed = new boolean[N+1];
        //경우의 수
        long[] cases = new long[N+1];
        cases[N] = 1;
        cases[N-1] = 1;
        //경우의 수 초기화
        for(int i=N-2; i>=0; i--) {
            cases[i] = (N-i)*cases[i+1];
        }


        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken()); //소문제 번호

        if(p==1) { //수열을 구해야함
            long k = Long.parseLong(st.nextToken());
            int[] permutation = new int[N+1]; //순열
            for(int i=1; i<=N; i++) {
                for(int j=1, cnt=1; j<=N; j++) {
                    if(isUsed[j])
                        continue;
                    if(k <= cases[i] * cnt) {
                        permutation[i] = j;
                        isUsed[j] = true;
                        k = k - (cases[i]*(cnt-1));
                        break;
                    }
                    cnt++;
                }
            }

            for(int i=1; i<=N; i++) {
                bw.write(permutation[i]+" ");
            }
            bw.write("\n");
        } else { //순서 구하기
            long k = 1;
            int[] permutation = new int[N+1];
            for(int i=1; i<=N; i++){
                permutation[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=1; i<=N; i++) { //주어진 수열의 현재 자릿수
                isUsed[permutation[i]] = true;
                int cnt = 0;
                for(int j=1; j<=permutation[i]; j++) {
                    if(!isUsed[j]) cnt++;
                }
                k += cases[i] * cnt;
            }

            bw.write(k+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}