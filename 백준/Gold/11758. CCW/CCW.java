
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long x1 = Integer.parseInt(st.nextToken());
        long y1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long x2 = Integer.parseInt(st.nextToken());
        long y2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long x3 = Integer.parseInt(st.nextToken());
        long y3 = Integer.parseInt(st.nextToken());

        long CCW = (x1*y2+x2*y3+x3*y1) - (x2*y1+x3*y2+x1*y3);

        if(CCW < 0) bw.write("-1\n");
        if(CCW > 0) bw.write("1\n");
        if(CCW == 0) bw.write("0\n");

        bw.flush();
        bw.close();
        br.close();
    }

}