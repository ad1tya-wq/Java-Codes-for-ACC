import java.util.*;



public class mergesort 
{
    static class Node
    {
        int data;
        Node next;
        Node(int data)
        {
            this.data = data;
            next = null;
        }
        Node(){};
    }
    
    static Node insert(Node head, int val)
    {
        Node t = new Node(val);
        if(head == null)
        {
            head = t;
            return head;
        }
        Node temp = head;
        while(temp.next != null) temp = temp.next;
        temp.next = t;
        return head;
    }

    public static void display(Node head)
    {
        if(head == null) return;
        Node temp = head;
        while(temp.next != null)
        {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print(temp.data + " -> null\n\n");
    }

    static Node mergell(Node h1, Node h2)
    {
        Node res = new Node();
        Node temp = res;
        Node t1 = h1;
        Node t2 = h2;

        while(t1 != null && t2 != null)
        {
            if(t1.data <= t2.data)
            {
                temp.next = t1;
                t1 = t1.next;
            }
            else
            {
                temp.next = t2;
                t2 = t2.next;
            }
            temp = temp.next;
        }
        if(t1 != null) temp.next = t1;
        if(t2 != null) temp.next = t2;
        return res.next;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Node h1 = null;
        Node h2 = null;
        System.out.println("For LL1: ");
        int n = sc.nextInt();
        for(int i = 0; i < n; i++)
        {
            int m = sc.nextInt();
            h1 = insert(h1, m);
        }
        System.out.println("\nLL1: ");
        display(h1);

        System.out.println("For LL2: ");
        int n2 = sc.nextInt();
        for(int i = 0; i < n2; i++)
        {
            int m2 = sc.nextInt();
            h2 = insert(h2, m2);
        }
        System.out.println("\nLL2: ");
        display(h2);

        Node dummy = mergell(h1, h2);
        System.out.println("Merged LLs: ");
        display(dummy);
        sc.close();
    }
}
