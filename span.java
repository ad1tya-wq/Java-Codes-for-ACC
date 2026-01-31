import java.util.*;

public class span {
    static void calc(int arr[], int n, int[] stkspan)
    {
        Stack<Integer> s = new Stack<>();
        s.push(0);
        stkspan[0] = 1;

        for(int i = 1; i < n; i++)
        {
            while(!s.isEmpty() && arr[s.peek()] <= arr[i]) s.pop();
            stkspan[i] = s.isEmpty() ? (i+1) : (i - s.peek());
            s.push(i);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();

        int[] span = new int[n];
        calc(arr, n, span);

        for(int i = 0; i < n; i++) System.out.print(span[i] + " ");
        sc.close();
    }
}
