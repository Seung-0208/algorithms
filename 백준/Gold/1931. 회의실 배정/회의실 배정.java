import java.util.*;

public class Main {
    public static void main(String[] args) {
        //회의가 끝나는 시간을 기준으로 그리디 알고리즘 적용
        //회의가 끝나자마자 다른 회의를 시작할 수 있음 -> end와 start가 같아도 됨 
        // => 시작하자마자 끝나는 회의도 있음을 고려해야 함.
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Meeting> q = new PriorityQueue<>(new Comparator<Meeting>(){
            @Override
            public int compare(Meeting o1, Meeting o2) {
                //(1,2), (2,2)가 있을 때 우선순위 큐에 (2,2)가 먼저 나오면 (1,2)는 반영할 수 없음
                //(1,2)가 먼저 나오면 (1,2), (2,2) 모두 반영 가능하므로 가능한 회의 수가 늘어남
                //따라서 end 시간이 같다면 start 시간을 기준으로 오름차순해줘야 함.
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

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
