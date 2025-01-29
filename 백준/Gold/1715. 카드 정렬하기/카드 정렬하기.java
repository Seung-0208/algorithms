import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            q.add(Integer.parseInt(st.nextToken()));
        }

        int sum = 0;
        while(q.size() > 1) {
            int a = q.poll();
            int b = q.poll();
            sum+=(a+b);
            q.add(a+b);
        }
        System.out.println(sum);
    }

}