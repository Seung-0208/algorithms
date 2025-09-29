import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        int MAX_VALUE = 10000001;

        boolean[] isDeleted = new boolean[10000001];
        List<Integer> prior = new ArrayList<>();
        isDeleted[1] = true;

        for(int i=4; i<=MAX_VALUE; i+=2) {
            isDeleted[i] = true;
        }

        for(int i=6; i<=MAX_VALUE; i+=3) {
            isDeleted[i] = true;
        }

        prior.add(2);
        prior.add(3);

        for(int i=5; i<MAX_VALUE; i++) {
            if(!isDeleted[i]) {
                prior.add(i);
                for(int j=i*2; j<MAX_VALUE; j+=i) {
                    isDeleted[j] = true;
                }
            }
        }

        long cnt = 0;
        for(int i : prior) {
            for(double j = i; j <= (double) B /i; j*=i) {
                if(j >= (double) A /i) cnt++;
            }
        }

        bw.write(cnt+"\n");

        bw.flush();
        bw.close();
        br.close();
    }
}