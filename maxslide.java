import java.util.*;

public class maxslide {
    static int[] ms(int[] arr, int k)
    {
        int n = arr.length;
        Deque<Integer> dq = new LinkedList<>();
        int[] res = new int[n-k+1];

        for(int i = 0; i < n; i++)
        {
            while(!dq.isEmpty() && dq.peek() < i-k+1) dq.poll();
            while(!dq.isEmpty() && arr[i] > arr[dq.peekLast()]) dq.pollLast();
            dq.addLast(i);

            if(i >= k-1) res[i-k+1] = arr[dq.peek()];
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[] arr = {4,2,1,-4,7,2,4,9,1};
        int k = 3;
        int[] res = ms(arr, k);
        for(int i: res) System.out.print(i + " ");
    }
}
