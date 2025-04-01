import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //학생의 수
        int M = Integer.parseInt(st.nextToken()); //키를 비교한 횟수

        Map<Integer,Integer> temp = new HashMap<>(); //진입차수 정보
        for (int i=1; i<=N; i++) temp.put(i, 0);
        ArrayList<Integer>[] graph = new ArrayList[N+1]; //연결정보
        for(int i=1; i<N+1; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            temp.put(B, temp.get(B)+1);
            graph[A].add(B);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=N; i++) {
            if(temp.get(i) == 0) {
                queue.add(i);
                temp.remove(i);
            }
        }

        while(!queue.isEmpty()) {
            int curr = queue.poll();
            bw.write(String.valueOf(curr)+" ");
            for(Integer neigh : graph[curr]) {
                temp.put(neigh, temp.get(neigh)-1);
                if(temp.get(neigh) == 0) {
                    queue.add(neigh);
                    temp.remove(neigh);
                }
            }
        }
        bw.newLine();
        bw.flush();
    }
}