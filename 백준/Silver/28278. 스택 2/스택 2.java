import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        //값 입력받기
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> s = new Stack<>();
        int N = Integer.parseInt(st.nextToken());
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int temp = Integer.parseInt(st.nextToken());
            switch(temp) {
                case 1:
                    int x = Integer.parseInt(st.nextToken());
                    s.push(x);
                    break;
                case 2:
                    if(s.empty()) bw.write(String.valueOf(-1)+"\n");
                    else bw.write(String.valueOf(s.pop())+"\n");
                    break;
                case 3:
                    bw.write(String.valueOf(s.size())+"\n");
                    break;
                case 4:
                    if(s.empty()) bw.write(String.valueOf(1)+"\n");
                    else bw.write(String.valueOf(0)+"\n");
                    break;
                case 5:
                    if(s.empty()) bw.write(String.valueOf(-1)+"\n");
                    else bw.write(String.valueOf(s.peek())+"\n");
                    break;
            }
        }
        bw.flush();
    }
}
