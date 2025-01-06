import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static int[] classes;
    static int M, N;
    public static void main(String[] args) throws IOException {
        /*
        * 9 <= 블루레이의 크기 <= 45
        * 9부터 45의 숫자 중 9개의 강의를 다 넣을 수 있는 블루레이 크기의 최솟값이 되는 숫자를 찾아야 함
        * */

        //입력값 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //강의 개수
        M = Integer.parseInt(st.nextToken()); //블루레이 개수
        st = new StringTokenizer(br.readLine());
        classes = new int[N];
        int start = -1;
        for(int i=0; i<N; i++) {
            classes[i] = Integer.parseInt(st.nextToken());
            //주어진 class들의 시간이 오름차순 정렬되어 주어진다는 보장이 없음에 유의해야 함.
            if(start < classes[i]) start = classes[i];
        }

        //이진탐색
        int end = Arrays.stream(classes).sum();
        int ans = 0;
        while(start <= end) {
            int middle = (start + end) / 2;
            //블루레이의 크기를 size로 정했을 때
            //M개의 블루레이 안에 모든 강의를 담을 수 있는지 체크해야 함
            if(sizeChecker(middle)) {
                ans = middle;
                end = middle - 1;
            }
            else {
                start = middle + 1;
            }
        }
        System.out.println(ans);
    }//main

    static boolean sizeChecker(int size) {
        int expected = 0;
        int accrued = 0;
        for(int i=0; i<N; i++) {
            accrued += classes[i];
            if(accrued > size) {
                accrued = classes[i];
                expected++;
                //expected가 M인데 i가 N-1이하라면
                //아직 블루레이에 담기지 못한 강의가 존재한다는 뜻이므로 false 반환
                if(expected == M && i <= N-1) return false;
            }
        }
        return expected <= M;
    }
}