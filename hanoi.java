import java.util.*;

public class hanoi 
{
    class Stk
    {
        int cap;
        int top;
        int[] array;
    }

    Stk create(int n)
    {
        Stk s = new Stk();
        s.top = -1;
        s.cap = n;
        s.array = new int[n];
        return s;
    }

    static boolean isFull(Stk s)
    {
        if(s.top+1 == s.cap) return true;
        return false;
    }

    static boolean isEmpty(Stk s)
    {
        if(s.top == -1) return true;
        return false;
    }

    static void push(Stk s, int x)
    {
        if(isFull(s)) return;
        s.top++;
        s.array[s.top] = x; 
    }

    static int pop(Stk s)
    {
        if(isEmpty(s)) return -99;
        return s.array[s.top--];
    }

    static void disc_move(Stk x, Stk y, char a, char b)
    {
        if (isEmpty(x))
        {
            int t = pop(y);
            push(x, t);
            System.out.println("Moved " + t + " from " + b + " to " + a);
        }
        else if (isEmpty(y))
        {
            int t = pop(x);
            push(y, t);
            System.out.println("Moved " + t + " from " + a + " to " + b);
        }
        else if (x.array[x.top] < y.array[y.top])
        {
            int t = pop(x);
            push(y, t);
            System.out.println("Moved " + t + " from " + a + " to " + b);
        }
        else
        {
            int t = pop(y);
            push(x, t);
            System.out.println("Moved " + t + " from " + b + " to " + a);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int disc = sc.nextInt();
        hanoi ob = new hanoi();
        sc.close();
        Stk source, dest, aux;

        source = ob.create(disc);
        dest = ob.create(disc);
        aux = ob.create(disc);

        char s = 'S', d = 'D', a = 'A';
        if(d%2 == 0)
        {
            char t = a;
            a = d;
            d = t;
        }

        for(int i = disc; i > 0; i--) push(source, i);

        int moves = (int)(Math.pow(2, disc)-1);
        for(int i = 1; i <= moves; i++)
        {
            if(i%3 == 1) disc_move(source, dest, s, d);
            else if(i%3 == 2) disc_move(source, aux, s, a);
            else disc_move(aux, dest, a, d);
        }
    }
}
