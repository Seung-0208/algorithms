import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // TC : 테스트 케이스 개수
        // N(지점의 수), M(도로의 개수), W(웜홀의 개수)
        // M 개 만큼의 도로 정보 - 방향이 없음
        // W 개 만큼의 웜홀 정보 -> 시간을 거꾸로

        int TC = Integer.parseInt(st.nextToken()); //테스트 케이스 개수
        for(int i=0; i<TC; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            ArrayList<Edge> graph = new ArrayList<>();

            for(int j=0; j<M; j++) { //도로 정보(방향X)
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                graph.add(new Edge(S, E, T));
                graph.add(new Edge(E, S, T));
            }

            for(int j=0; j<W; j++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken()) * (-1);
                graph.add(new Edge(S, E, T));
            }

            //distance 초기화
            long[] distance = new long[N+1];
            for(int j=1; j<=N; j++) distance[j] = 0;

            boolean isPossible = false;
            //벨만포드 알고리즘 적용
            for(int j=0; j<N; j++) {
                for(Edge e : graph) {
                    if(distance[e.E] > distance[e.S] + e.T) {
                        distance[e.E] = distance[e.S] + e.T;
                    }
                }
            }

            for(Edge e : graph) {
                if(distance[e.S] != Long.MAX_VALUE && distance[e.E] > distance[e.S] + e.T) {
                    isPossible = true;
                    break;
                }
            }

            if(isPossible) bw.write("YES\n");
            else bw.write("NO\n");

        }

        bw.flush();
        br.close();
        bw.close();
    }

    static class Edge {
        int S;
        int E;
        int T;
        public Edge(int S, int E, int T) {
            this.S = S;
            this.E = E;
            this.T = T;
        }
    }
}
