import java.util.*;

class Node
{
    int num;
    Node next;
    Node(int val)
    {
        num = val;
        next = null;
    }
}
class loop {
    static Node insert(Node head, int val)
    {
        Node newnode = new Node(val);
        if(head == null)
        {
            head = newnode;
            return head;
        }
        
        Node temp = head;
        while(temp.next != null) temp = temp.next;
        temp.next = newnode;
        return head;
    }
    
    public static boolean loopdet(Node head)
    {
        if(head == null) return false;
        Node slow = head;
        Node fast = head;
        while(fast.next != null && fast.next.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) return true;
        }
        return false;
    }
    
    public static void display(Node head)
    {
        System.out.println("\nLL:");
        Node temp = head;
        while(temp.next != null)
        {
            System.out.print(temp.num + " -> ");
            temp = temp.next;
        }
        System.out.println(temp.num + "-> NULL\n");
    }
    
    public static void createCycle(int a, int b, Node head)
    {
        int ca = 1, cb = 1;
        Node t1 = head, t2 = head;
        while(t1 != null && ca != a)
        {
            ca++; t1 = t1.next;
        }
        while(t2 != null && cb != b)
        {
            cb++; t2 = t2.next;
        }
        t2.next = t1;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        System.out.print("How many nodes? ");
        int n = sc.nextInt();
        System.out.println("\nEnter nodes: ");
        for(int i = 0; i < n; i++)
        {
            int m = sc.nextInt();
            head = insert(head, m);
        }
        display(head);
        
        System.out.print("Enter from which nodes form loop: ");
        int a = sc.nextInt(), b = sc.nextInt();
        createCycle(a, b, head);
        
        if(loopdet(head)) System.out.print("\nLoop detected.");
        else System.out.print("\nNo Loop");
        
    }
}
    

