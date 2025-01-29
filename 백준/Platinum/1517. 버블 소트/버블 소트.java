import java.io.*;
import java.util.*;

public class Main{
    public static int[] A;
    public static int[] tmp;
    public static long result;
    public static void main(String[] args) throws IOException {
        //값 입력받기
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        A = new int[N+1]; tmp = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        result = 0;
        mergeNsort(1, N);
        System.out.println(result);
    }
    public static void mergeNsort(int s, int e){
        if(e-s <1) return;
        int m = s+(e-s)/2; //두 배열로 나누는 지점 구하기
        mergeNsort(s, m);
        mergeNsort(m+1, e);
        for(int i=s; i<=e; i++) tmp[i] = A[i]; //0부터 끝까지 복사하지 않고 s부터 e까지 복사
        int k = s;
        int idx1 = s, idx2 = m+1;
        while(idx1 <= m && idx2 <= e){
            if(tmp[idx1]>tmp[idx2]){
                A[k] = tmp[idx2];
                result = result + idx2-k;
                idx2++; k++;
            }
            else {
                A[k] = tmp[idx1];
                k++; idx1++;
            }
        }
        while(idx1<=m) {
            A[k] = tmp[idx1];
            k++;
            idx1++;
        }
        while(idx2<=e) {
            A[k] = tmp[idx2];
            k++; //k++ 안해서 계속 틀렸다..
            idx2++;
        }
    }
}
