import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int result = Math.abs(o1) - Math.abs(o2);
                if(result==0) {
                    result = o1-o2;
                }
                return result;
            }
        });
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int temp = Integer.parseInt(st.nextToken());
            if(temp != 0) queue.add(temp);
            else {
                if(!queue.isEmpty()) bw.write(String.valueOf(queue.poll()));
                else bw.write(String.valueOf(0));
                bw.newLine();
            }
        }
        bw.flush();
    }
}