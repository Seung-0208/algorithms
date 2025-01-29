import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        PriorityQueue<Meeting> q = new PriorityQueue<>(new Comparator<Meeting>() {
            @Override
            public int compare(Meeting o1, Meeting o2) {
                int gap = o1.end - o2.end;
                if(gap==0) return o1.start - o2.start;
                return gap;
            }
        });

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            q.add(new Meeting(start, end));
        }

        int cnt = 0;
        while(!q.isEmpty()) {
            cnt++;
            Meeting cur = q.poll();
            while(!q.isEmpty() && q.peek().start < cur.end) {
                q.poll();
            }
        }
        System.out.println(cnt);
    }
    static class Meeting{
        int start;
        int end;
        public Meeting(int start, int end) {
            this.start =start;
            this.end= end;
        }
    }
}