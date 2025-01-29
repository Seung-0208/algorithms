import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        LinkedList<Integer> P = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) P.add(Integer.parseInt(st.nextToken()));


        //삽입 정렬
        for(int i=1; i<N; i++) {
            int temp = P.get(i);
            if(temp>=P.get(i-1)) continue;
            int j = 0;
            for(j=0; j<=i-1; j++) {
                if(temp<=P.get(j)) break;
            }
            P.remove(i);
            P.add(j, temp);
        }

        int[] fin = new int[N];
        for(int i=0; i<N; i++) {
            fin[i] = P.get(i);
        }
        for(int i=1; i<N; i++) {
            fin[i] += fin[i-1];
        }
        bw.write(String.valueOf(Arrays.stream(fin).sum()));
        bw.flush();
    }
}
