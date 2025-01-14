import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //회의가 끝나는 시간을 기준으로 그리디 알고리즘 적용
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Meeting> q = new PriorityQueue<>(new Comparator<Meeting>(){
            @Override
            public int compare(Meeting o1, Meeting o2) {
                if(o1.end == o2.end) {
                    return o1.start - o2.start;
                }
                return o1.end - o2.end;
            }
        });

        for(int i=0; i<N; i++) {
            q.add(new Meeting(sc.nextInt(), sc.nextInt()));
        }

        int cnt = 1;
        Meeting cur = q.poll();
        while(!q.isEmpty()) {
            Meeting temp = q.poll();
            assert cur != null;
            if(cur.end > temp.start) continue;
            else {
                cur = temp;
                cnt++;
            }
        }
        System.out.println(cnt);
    }//main
    static class Meeting{
        int start;
        int end;

        public Meeting(){};
        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}