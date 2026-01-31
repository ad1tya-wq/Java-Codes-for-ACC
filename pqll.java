import java.util.*;

public class pqll {
    static class Node{
        int data;
        int pr;
        Node next;
        Node prev;
        Node(int data, int pr)
        {
            this.data = data;
            this.pr = pr;
        }
    }

    static Node head = null;

    static void push(int d, int p)
    {
        Node nn = new Node(d, p);
        if(head == null)
        {
            head = nn;
            return;
        }

        Node temp = head;
        Node parent = null;

        while(temp != null && temp.pr < nn.pr)
        {
            parent = temp;
            temp = temp.next;
        }

        if(parent == null)
        {
            nn.next = head;
            head.prev = nn;
            head = nn;
        }

        else if(temp == null)
        {
            parent.next = nn;
            nn.prev = parent;
        }

        else
        {
            parent.next = nn;
            nn.prev = parent;
            temp.prev = nn;
            nn.next = temp;
        }
    }

    static void peek()
    {
        if(head == null) 
        {
            System.out.print("-1");
            return;
        }
        System.out.println("Highest Prio: "+head.data);
    }

    static void pop()
    {
        if(head == null)
        {
            System.out.println("-1");
            return;
        }
        System.out.println("Node pop with data: " + head.data);
        head = head.next;
        if(head != null) head.prev = null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++)
        {
            int d = sc.nextInt();
            int p = sc.nextInt();
            push(d, p);
        }

        peek();
        pop();
        peek();
        pop();
        peek();
        sc.close();
    }
}
