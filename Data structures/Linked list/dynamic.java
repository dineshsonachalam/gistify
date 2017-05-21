import java.io.*;
import java.util.*;
class linkedlist
{
    Node head;
 static class Node
 {
    int data;
    Node next;
    Node(int d)
    {
        data = d;
        next = null;
    }
 }


    // Print elements of a linked list on console
    // head pointer input could be NULL as well
    // for empty list
    void printList(Node head)
    {

    }
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt(); // no of test cases
        for(int i=0;i<t;i++)
        {
            int n = scan.nextInt(); // no of nodes in the linked list
            for(int j=0;j<n;j++)
            {
                linkedlist llist = new linkedlist();
                llist.head = new Node(scan.next());
            }
        }
    }
}
