import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); //테스트 케이스 개수
        for(int i=0; i<T; i++) {
            int M = Integer.parseInt(br.readLine());
            int line = M%10 == 0 ? M/10 : M/10+1;
            sb.append(M%2 == 0 ? M/2 : M/2+1).append("\n");
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            int cnt = 0;

            for(int l=0; l<line; l++) {
                int m = M-10 >= 0 ? 10 : M;
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<m; j++) {
                    int x = Integer.parseInt(st.nextToken());

                    if(maxHeap.isEmpty() || x <= maxHeap.peek()) maxHeap.add(x);
                    else minHeap.add(x);

                    if(maxHeap.size() > minHeap.size()+1) minHeap.add(maxHeap.poll());
                    else if(minHeap.size() > maxHeap.size()) maxHeap.add(minHeap.poll());

                    if(j%2==0) {
                        cnt++;
                        sb.append(maxHeap.peek()).append(" ");
                        if(cnt == 10) {

                            sb.append("\n");
                            cnt = 0;
                        }
                    }
                }
                M -= 10;
            }

            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}