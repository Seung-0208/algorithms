import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] classes = new int[N];
        st = new StringTokenizer(br.readLine());
        int start = 0, end = 0;
        for(int i=0; i<N; i++) {
            classes[i] = Integer.parseInt(st.nextToken());
            if(start < classes[i]) start = classes[i];
        }
        end = IntStream.of(classes).sum();

        while(start <= end) {
            int middle = (start+end)/2;
            int sum = 0;
            int cnt = 0;
            for(int i=0; i<N; i++) {
                if(sum+classes[i] > middle) {
                    sum = 0;
                    cnt++;
                }
                sum += classes[i];
            }
            if(sum != 0) cnt++;
            if(cnt > M) {  //블루레이 시간이 작을 때
                start = middle+1;
            } else { //블루레이 시간이 클 때
                end = middle-1;
            }
        }
        System.out.println(start);
    }

}