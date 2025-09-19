import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] ns = new int[N];
        for(int i=0; i<N; i++) {
            ns[i] = Integer.parseInt(st.nextToken());
        }
        quickSort(ns, 0, N-1, K-1);
        bw.write(String.valueOf(ns[K-1]));
        bw.flush();
    }
    public static void quickSort(int[] arr, int start, int end, int K) throws IOException {
        if(start < end) {
            int pivot = partition(arr, start, end);
            if(pivot == K) return;
            else if(K<pivot) quickSort(arr, start, pivot-1, K);
            else quickSort(arr, pivot+1, end, K);
        }
    }
    public static int partition(int[] arr, int start, int end){
        if(start+1 == end) {
            if(arr[start] > arr[end]) swap(arr, start, end);
            return end;
        }
        int m = (start+end)/2;
        swap(arr, start, m);
        int pivot = arr[start];
        int i = start+1, j = end;
        while(i <= j) {
            //⚠️여기서 pivot과 arr값을 비교 시 =을 추가하면 시간 초과 됨
            while(j >= start+1 && pivot < arr[j]) j--;
            while(i <= end && pivot > arr[i]) i++;
            if(i <= j) swap(arr, i++, j--);
        }
        arr[start] = arr[j];
        arr[j] = pivot;
        return j;
    }

    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

