import java.util.*;

public class sort {
    static int minin(Queue<Integer> list, int sindex)
    {
        int min = 999;
        int mindex = -1;
        int s = list.size();
        for(int i = 0; i < s; i++)
        {
            int curr = list.peek();
            list.poll();
            if(curr < min && i < sindex)
            {
                min = curr;
                mindex = i;
            }
            list.add(curr);
        }
        return mindex;
    }

    static void minins(Queue<Integer> list, int id)
    {
        int min = 0;
        int s = list.size();
        for(int i = 0; i < s; i++)
        {
            int curr = list.peek();
            list.poll();

            if(i != id) list.add(curr);
            else min = curr;
        }
        list.add(min);
    }

    static void sort(Queue<Integer> list)
    {
        int s = list.size();
        for(int i = 0; i < s; i++)
        {
            int mid = minin(list, list.size()-i);
            minins(list, mid);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> list = new LinkedList<>();
        int n = sc.nextInt();

        for(int i = 0; i < n; i++)
        {
            int x = sc.nextInt();
            list.add(x);
        }

        sort(list);

        while(!list.isEmpty())
        {
            System.out.print(list.peek() + " ");
            list.poll();
        }
    }
}
