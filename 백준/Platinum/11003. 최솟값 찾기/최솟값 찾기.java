import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //N과 L값 받기
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        //A_i 값 받기
        long[] nums = new long[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<N; i++) nums[i] = Integer.parseInt(st.nextToken());

        /*
        고려해야 할 점
        1. 최솟값이여야 함
        2. 주어진 L 범위에 속해야 함
         */
        Deque<Node> queue = new LinkedList<>();
        queue.add(new Node(nums[0], 0));
        bw.write(String.valueOf(nums[0])+" ");
        for(int i=1; i<N; i++) {
            long cur = nums[i];
            long pri = queue.getLast().value;
            while(pri > cur) {
                queue.removeLast();
                if(!queue.isEmpty()) pri = queue.getLast().value;
                else break;
            }
            queue.add(new Node(cur, i));
            if(i-queue.getFirst().idx+1 > L) queue.removeFirst();
            bw.write(String.valueOf(queue.getFirst().value) + " ");
        }
        bw.flush();
    }

    static class Node{

        public long value;
        public int idx;

        public Node(long value, int idx) {
            this.value = value;
            this.idx = idx;
        }
    }
}