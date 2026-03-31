import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
        public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        LinkedList<Integer> people = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            people.add(Integer.parseInt(st.nextToken()));
        }

        for(int i=1; i<N; i++) {
            int temp = people.get(i);
            int j;
            for(j=0; j<i; j++) {
                if(people.get(j) > people.get(i)) {
                    break;
                }
            }
            people.remove(i);
            people.add(j, temp);
        }



        int[] sum = new int[N];
        sum[0] = people.get(0);
        for(int i=1; i<N; i++) {
            sum[i] = sum[i-1] + people.get(i);
        }
        int ans = 0;
        for(int i=0; i<N; i++) {
            ans += sum[i];
        }

        sb.append(ans);
        System.out.println(sb);
        br.close();
    }
}