import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static int[] edgeCnt;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++) graph[i] = new ArrayList<>();
        edgeCnt = new int[N+1];

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int singerCnt = Integer.parseInt(st.nextToken());
            ArrayList<Integer> singerList = new ArrayList<>();
            for(int j=0; j<singerCnt; j++) {
                singerList.add(Integer.parseInt(st.nextToken()));
            }
            for(int j=0; j<singerCnt-1; j++) {
                graph[singerList.get(j)].add(singerList.get(j+1));
                edgeCnt[singerList.get(j+1)]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=1; i<=N; i++) {
            if(edgeCnt[i] == 0) q.add(i);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()) {
            int curr = q.poll();
            ans.add(curr);
            for(int n : graph[curr]) {
                if(edgeCnt[n] > 0) {
                    edgeCnt[n]--;
                    if(edgeCnt[n] == 0) q.add(n);
                }
            }
        }

        boolean isPossible = true;
        for(int i=1; i<=N; i++) {
            if(edgeCnt[i] > 0) {
                isPossible = false;
                break;
            }
        }

        if(!isPossible) bw.write("0\n");
        else {
            for(int n : ans) {
                bw.write(n+"\n");
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
