import java.util.*;

class mystack
{
    Stack<Integer> s;
    Stack<Integer> a;
    mystack()
    {
        s = new Stack<Integer>();
        a = new Stack<Integer>();
    }

    void peek()
    {
        if(s.isEmpty())
        {
            System.out.println("Stack is empty");
        }
        else
        {
            System.out.println("Top of Stack: "+s.peek());
        }
        
    }

    void pop()
    {
       if(s.isEmpty())
        {
            System.out.println("Stack is empty");
            return;
        }
        
        int t = s.pop();
        System.out.println("Top of stack with value: "+t+" popped");
        if(a.peek() == t) a.pop();
    }

    void getMin()
    {
        if(a.isEmpty()) System.out.println("Stack is empty");
        else System.out.println("Minimum of stack: " + a.peek());
        
    }

    void push(int x)
    {
        if(s.isEmpty())
        {
            s.push(x);
            a.push(x);    
        }
        else
        {
            s.push(x);
            if(x < a.peek()) a.push(x);
        }

        System.out.println("Number inserted: "+x);
    }
}

public class minstack 
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        mystack s = new mystack();
        int n = sc.nextInt();
        for(int i = 0; i < n; i++)
        {
            int m = sc.nextInt();
            s.push(m);
        }

        s.peek();
        s.getMin();
        s.pop();
        s.push(-3);
        s.getMin();
        s.pop();
        s.pop();
        s.getMin();
        sc.close();
    }
}
