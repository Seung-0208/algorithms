import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int[] copy;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine()); //배열의 개수
        arr = new int[N];
        copy = new int[N];

        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(br.readLine());

        mergeNSort(0, N-1);

        for(int n : arr) {
            sb.append(n).append("\n");
        }


        System.out.println(sb);
        br.close();
    }

    static void mergeNSort(int start, int end) {
        if(start >= end) return;
        int m = (start+end)/2;

        mergeNSort(start, m);
        mergeNSort(m+1, end);

        System.arraycopy(arr, start, copy, start, end-start+1);

        int i = start, j = m+1, now = start;
        while(i <= m && j <= end) {
            if(copy[i] < copy[j]) {
                arr[now] = copy[i];
                i++;
            }
            else {
                arr[now] = copy[j];
                j++;
            }
            now++;
        }

        while(i < m+1) {
            arr[now] = copy[i];
            i++; now++;
        }

        while(j < end+1) {
            arr[now] = copy[j];
            j++; now++;
        }
    }
}