
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long L1x1 = Integer.parseInt(st.nextToken()); //A
        long L1y1 = Integer.parseInt(st.nextToken());
        long L1x2 = Integer.parseInt(st.nextToken()); //B
        long L1y2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        long L2x1 = Integer.parseInt(st.nextToken()); //C
        long L2y1 = Integer.parseInt(st.nextToken());
        long L2x2 = Integer.parseInt(st.nextToken()); //D
        long L2y2 = Integer.parseInt(st.nextToken());

        long ABC = getCCW(L1x1, L1y1, L1x2, L1y2, L2x1, L2y1);
        long ABD = getCCW(L1x1, L1y1, L1x2, L1y2, L2x2, L2y2);
        long CDA = getCCW(L2x1, L2y1, L2x2, L2y2, L1x1, L1y1);
        long CDB = getCCW(L2x1, L2y1, L2x2, L2y2, L1x2, L1y2);

        if(ABC*ABD == 0 && CDA*CDB == 0) {
            if(Math.min(L1x1, L1x2) <= Math.max(L2x1, L2x2) && Math.max(L1x1, L1x2) >= Math.min(L2x1,L2x2) &&
            Math.min(L1y1, L1y2) <= Math.max(L2y1, L2y2) && Math.max(L1y1, L1y2) >= Math.min(L2y1, L2y2)) {
                bw.write("1\n");
            } else {
                bw.write("0\n");
            }
        } else if(ABC*ABD <= 0 && CDA*CDB <= 0) {
            bw.write("1\n");
        } else {
            bw.write("0\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static long getCCW(long x1, long y1, long x2, long y2, long x3, long y3) {
        long CCW = (x2 - x1)*(y3 - y1) - (y2 - y1)*(x3 - x1);
        if(CCW==0) return 0;
        if(CCW > 0) return 1;
        else return -1;
    }

}