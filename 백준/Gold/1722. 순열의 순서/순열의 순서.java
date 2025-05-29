
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long[] cases = new long[N+1];
        cases[N] = 1;
        cases[N-1] = 1;
        //0 1 2 3
        //4 3 2 1
        for(int i=N-2; i>=0; i--) {
            cases[i] = cases[i+1] * (N-i);
        }

        boolean[] isUsed = new boolean[N+1];

        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken()); //소문제 번호

        int[] permutation = new int[N+1];
        if(p==1) { //순열 구하기
            long k = Long.parseLong(st.nextToken());
            for(int i=1; i<=N; i++) {
                for(int j=1, cnt=1; j<=N; j++) {
                    if(isUsed[j]) continue;
                    if(k <= cnt * cases[i]) {
                        permutation[i] = j;
                        isUsed[j] = true;
                        k -= cases[i] * (cnt-1);
                        break;
                    }
                    cnt++;
                }
            }

            for(int i=1; i<=N; i++) {
                bw.write(permutation[i]+" ");
            }
            bw.write("\n");
        } else if(p==2) { //순서 구하기
            for(int i=1; i<=N; i++) {
                permutation[i] = Integer.parseInt(st.nextToken());
            }
            long k = 1;
            for(int i=1; i<=N; i++) {
                int cnt = 0;
                isUsed[permutation[i]] = true;
                for(int j=1; j<=permutation[i]; j++) {
                    if(!isUsed[j]) cnt++;
                }
                k += cnt * cases[i];
            }
            bw.write(k+"\n");
        }



        bw.flush();
        bw.close();
        br.close();
    }
}