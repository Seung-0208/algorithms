import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        boolean[] isDeleted = new boolean[N+1];
        isDeleted[1] = true;

        for(int i=4; i<=N; i+=2) {
            isDeleted[i] = true;
        }

        for(int i=6; i<=N; i+=3) {
            isDeleted[i] = true;
        }

        for(int i=5; i<=N; i++) {
            if(!isDeleted[i]) {
                for(int j=i*2; j<=N; j+=i) {
                    isDeleted[j] = true;
                }
            }
        }

        for(int i=M; i<=N; i++) {
            if(!isDeleted[i]) bw.write(i+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}