import java.io.*;
import java.util.*;

public class Main {
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); //작은 숫자 넣을 큐
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i=0; i<N; i++) {
            int num = Integer.parseInt(br.readLine());

            if(maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.add(num);
            } else minHeap.add(num);

            if(maxHeap.size() > minHeap.size()+1) {
                minHeap.add(maxHeap.poll());
            } else if(minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.poll());
            }

            sb.append(maxHeap.peek()).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}