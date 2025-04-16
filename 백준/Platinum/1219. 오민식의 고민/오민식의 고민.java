import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //도시의 수
        int start = Integer.parseInt(st.nextToken()); //출발
        int end = Integer.parseInt(st.nextToken()); //도착
        int M = Integer.parseInt(st.nextToken()); //교통수단의 수

        long[] distances = new long[N]; //거리
        int[] money = new int[N]; //각 도시별 수익
        ArrayList<Edge> graph = new ArrayList<>();

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.add(new Edge(a, b, w));
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            money[i] = Integer.parseInt(st.nextToken());
            distances[i] = Long.MIN_VALUE;
        }

        distances[start] = money[start];

        for(int i=0; i<=N+100; i++) {
            for(Edge edge : graph) {
                if(distances[edge.start] != Long.MIN_VALUE) {
                    if(distances[edge.start] == Long.MAX_VALUE) {
                        distances[edge.end] = Long.MAX_VALUE;
                    }
                    else if(distances[edge.end] < distances[edge.start]+money[edge.end]-edge.weight) {
                        distances[edge.end] = distances[edge.start]+money[edge.end]-edge.weight;
                        if(i>=N-1) {
                            distances[edge.end] = Long.MAX_VALUE;
                        }
                    }
                }
            }
        }

        if(distances[end] == Long.MIN_VALUE) bw.write("gg\n");
        else if(distances[end] == Long.MAX_VALUE) bw.write("Gee\n");
        else bw.write(distances[end] +"\n");

        bw.flush();


    }

    static class Edge {
        int start, end, weight;
        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
}