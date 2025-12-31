import java.io.*;
import java.util.*;

public class Main {
    static int[] graph; //인덱스는 자식, 값은 부모
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());

        for(int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            graph = new int[N+1];

            for(int i=0; i<N-1; i++) {
                st = new StringTokenizer(br.readLine());
                int p = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                graph[c] = p;
            }
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            ArrayList<Integer> aLoad = new ArrayList<>();
            ArrayList<Integer> bLoad = new ArrayList<>();

            int aChild = graph[A];
            aLoad.add(A);
            aLoad.add(aChild);
            while(aChild != 0) {
                aChild = graph[aChild];
                aLoad.add(aChild);
            }

            int bChild = graph[B];
            bLoad.add(B);
            bLoad.add(bChild);
            while(bChild != 0) {
                bChild = graph[bChild];
                bLoad.add(bChild);
            }

            int aIdx = aLoad.size() - 1;
            int bIdx = bLoad.size() - 1;

            int ans = 0;
            while(aIdx >= 0 && bIdx >= 0) {
                if(Objects.equals(aLoad.get(aIdx), bLoad.get(bIdx))) ans = aLoad.get(aIdx);
                aIdx--; bIdx--;
            }

            sb.append(ans).append("\n");
        }


        System.out.println(sb);
        br.close();
    }
}
