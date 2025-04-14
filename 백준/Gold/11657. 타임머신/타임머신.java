import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //도시의 개수
        long[] distance = new long[N+1]; //가장 빠른 시간 정보
        for(int i=1; i<=N; i++) distance[i] = Long.MAX_VALUE;
        distance[1] = 0;
        int M = Integer.parseInt(st.nextToken()); //버스 노선의 개수
        List<Edge> edges = new ArrayList<>();

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());;
            int b = Integer.parseInt(st.nextToken());;
            int t = Integer.parseInt(st.nextToken());;
            edges.add(new Edge(a, b, t));
        }

        for(int i=0; i<N; i++) {
            for(Edge edge : edges) {
                if(distance[edge.start] != Long.MAX_VALUE &&
                    distance[edge.end] > distance[edge.start] + edge.time) {
                    distance[edge.end] = distance[edge.start] + edge.time;
                }
            }
        }


        for(Edge edge : edges) {
            if(distance[edge.end] != Long.MAX_VALUE && distance[edge.end] > distance[edge.start] + edge.time) {
                bw.write("-1\n");
                bw.flush();
                return;
            }
        }

        for(int i=2; i<=N ;i++) {
            if(distance[i] == Long.MAX_VALUE) {
                bw.write("-1\n");
            } else {
                bw.write(String.valueOf(distance[i])+"\n");
            }
        }
        bw.flush();
    }

    static class Edge {
        int start, end, time;
        public Edge(int start, int end, int time) {
            this.start = start;
            this.end = end;
            this.time = time;
        }
    }

}