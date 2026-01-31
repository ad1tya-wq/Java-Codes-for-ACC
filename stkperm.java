import java.util.*;

public class stkperm {
    static boolean check(int[] ip, int[] op, int n)
    {
        Stack<Integer> s = new Stack<>();
        int j = 0;

        for(int i = 0; i < n; i++)
        {
            s.push(ip[i]);
            while(!s.isEmpty() && s.peek() == op[j])
            {
                s.pop();
                j++;
            }
        }

        if(s.isEmpty()) return true;
        return false;
    }

    public static void main(String[] args) {
        int[] ip = {1,2,3};
        int[] op = {3,1,2};
        if(check(ip, op, 3)) System.out.println("yes");
        else System.out.println("no");
    }
}
