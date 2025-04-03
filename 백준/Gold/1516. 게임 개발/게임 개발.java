import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //건물의 수

        int[] degree = new int[N+1]; //진입차수 저장
        int[] timeInfo = new int[N+1]; //각 건물별 소요 시간 저장
        ArrayList<Integer>[] graph = new ArrayList[N+1]; //연결정보 저장
        for(int i=1; i<=N; i++) graph[i] = new ArrayList<>();

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            timeInfo[i] = time;
            int temp = Integer.parseInt(st.nextToken());
            while(temp != -1) {
                graph[temp].add(i);
                degree[i]++;
                temp = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=N; i++) {
            if(degree[i] == 0) queue.add(i);
        }

        int[] ans = new int[N+1];
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            for(Integer node : graph[curr]) {
                degree[node]--;
                //이전 건물이 완공된 후에 건물을 지을 수 있음.
                ans[node] = Math.max(ans[curr] + timeInfo[curr], ans[node]);
                if(degree[node] == 0) queue.add(node);
            }
        }



        for(int i=1; i<=N; i++) {
            bw.write(String.valueOf(ans[i]+timeInfo[i])+"\n");
        }

        bw.flush();
    }
}