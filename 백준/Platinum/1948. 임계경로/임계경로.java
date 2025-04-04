import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //도시의 개수
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken()); //도로의 개수

        int[] go = new int[n+1]; //정방향 진입차수
        ArrayList<Node>[] goGraph = new ArrayList[n+1];
        ArrayList<Node>[] backGraph = new ArrayList[n+1];
        for(int i=1; i<=n; i++) {
            goGraph[i] = new ArrayList<>();
            backGraph[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            go[b]++;
            goGraph[a].add(new Node(b, time));
            backGraph[b].add(new Node(a, time));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] movingTime = new int[n+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()) {
            int now = queue.poll();
            for(Node nextNode : goGraph[now]) {
                if(movingTime[nextNode.num] < movingTime[now] + nextNode.time) {
                    movingTime[nextNode.num] = movingTime[now] + nextNode.time;
                }
                go[nextNode.num]--;
                if(go[nextNode.num] == 0) {
                    queue.add(nextNode.num);
                }
            }
        }
        boolean[] isVisited = new boolean[n+1]; //중복방지
        queue = new LinkedList<>();
        queue.add(end);
        isVisited[end] = true;
        int cnt = 0;
        while(!queue.isEmpty()) {
            int now = queue.poll();
            for(Node prevNode : backGraph[now]) {
                if(movingTime[now] == movingTime[prevNode.num] + prevNode.time) {
                    cnt++;
                    if(!isVisited[prevNode.num]) {
                        queue.add(prevNode.num);
                        isVisited[prevNode.num] = true;
                    }
                }
            }
        }

        bw.write(String.valueOf(movingTime[end])+"\n");
        bw.write(String.valueOf(cnt)+"\n");
        bw.flush();
    }

    static class Node {
        int num;
        int time;

        public Node(int num, int time) {
            this.num = num;
            this.time = time;
        }
    }
}