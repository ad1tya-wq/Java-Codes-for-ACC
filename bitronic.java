import java.util.*;

class bitronic {
    static class Node
    {
        int val;
        Node next;
        Node prev;
    }
    
    public static Node sort(Node head)
    {
        if(head == null || head.next == null) return head;
        Node res = new Node();
        Node resEnd = res;
        Node front = head, last = head;
        Node next;
        while(last.next != null) last = last.next;
        
        while(front != last)
        {
            if(front.val >= last.val)
            {
                resEnd.next = last;
                next = last.prev;
                last.prev.next = null;
                last.prev = resEnd;
                last = next;
                resEnd = resEnd.next;
            }
            
            else
            {
                resEnd.next = front;
                next = front.next;
                front.next = null;
                front.prev = resEnd;
                front = next;
                resEnd = resEnd.next;
            }
        }
        resEnd.next = front;
        front.prev = resEnd;
        return res.next;
    }
    
    static Node push(Node head, int data)
    {
        Node newnode = new Node();
        newnode.val = data;
        newnode.next = head;
        newnode.prev = null;
        if(head != null) head.prev = newnode;
        head = newnode;
        return head;
    }
    
    static void display(Node head)
    {
        if(head == null) return;
        System.out.println();
        Node temp = head;
        while(temp.next != null)
        {
            System.out.print(temp.val + " <--> ");
            temp = temp.next;
        }
        System.out.println(temp.val + " -> NULL\n");
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        int n = sc.nextInt();
        for(int i = 0; i < n; i++)
        {
            int m = sc.nextInt();
            head = push(head, m);
        }
        display(head);
        
        head = sort(head);
        display(head);
    }
}