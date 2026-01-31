import java.util.*;

public class oddneven_ll 
{
    static class Node
    {
        int data;
        Node next;
        Node(int val)
        {
            data = val;
            next = null;
        }
        Node(){};

        public static Node insert(Node head, int data)
        {
            Node newnode = new Node(data);
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

        public static Node sort(Node head)
        {
            Node even = null;
            Node evenstart = null;
            Node odd = null;
            Node oddstart = null;
            Node curr = head;

            while(curr != null)
            {
                if(curr.data%2 == 0)
                {
                    if(even == null)
                    {
                        even = curr;
                        evenstart = even;
                    }
                    else 
                    {
                        even.next = curr;
                        even = even.next;
                    }
                }

                else
                {
                    if(odd == null)
                    {
                        odd = curr;
                        oddstart = odd;
                    }
                    else
                    {
                        odd.next = curr;
                        odd = odd.next;
                    }
                }
                curr = curr.next;
            }
            if(odd == null || even == null) return head;
            odd.next = evenstart;
            even.next = null;
            return oddstart;
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

        public static void main(String[] args) 
        {
            Scanner sc = new Scanner(System.in);
            Node head = null;
            int n = sc.nextInt();
            for(int i = 0; i < n; i++)
            {
                int m = sc.nextInt();
                head = insert(head, m);
            }
            System.out.println("Original");
            display(head);

            head = sort(head);
            System.out.println("Sorted");
            display(head);
        }
    }
}
