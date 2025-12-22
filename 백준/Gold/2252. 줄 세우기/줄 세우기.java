import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static int[] edgeCnt;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //학생 수
        int M = Integer.parseInt(st.nextToken()); //비교 횟수

        graph = new ArrayList[N+1];
        edgeCnt = new int[N+1];
        for(int i=1; i<=N; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph[A].add(B);
            edgeCnt[B]++;
        }
        Queue<Integer> q = new LinkedList<Integer>();

        for(int i=1; i<=N; i++) {
            if(edgeCnt[i] == 0) {
                q.add(i);
            }
        }


        while(!q.isEmpty()) {
            int curr = q.poll();
            bw.write(curr+" ");
            for(int n : graph[curr]) {
                if(edgeCnt[n] > 0) {
                    edgeCnt[n]--;
                    if(edgeCnt[n] == 0) q.add(n);
                }
            }
        }
        bw.write("\n");
        bw.flush();
        bw.close();
        br.close();

    }
}
