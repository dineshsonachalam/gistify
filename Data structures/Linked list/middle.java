/*
    Find the middle element of a linkedlist
    URL:http://www.geeksforgeeks.org/write-a-c-function-to-print-the-middle-of-the-linked-list/
*/
import java.io.*;

/*
    LinkedList Node
*/
class Node
{
    int data;
    Node next;
    /*
        next --> reference variable of class Node not pointing
        to any object
    */
    /*
        Creating a parametrized constructor thats beeing invoked when
        an object is being created.
    */
    Node(int d)
    {
      data = d;
      next = null;
    }
}

class LinkedList
{
    Node head;
    /*
        head-->reference variable not pointing to any object
    */
    /*
        pushing the node elements at  the end of the list
    */
    public void push(int node_data)
    {
        /*
            if head is not pointing to an object
            point it to an object
        */
        if(head == null)
        {
            head = new Node(node_data);
            /*
                head -> reference variable of class Node pointing
                to an object.
            */
            return ; // end the function
        }
        Node new_node = new Node(node_data);
        /*
            new_node -> reference variable of class Node pointing
            to an object
        */
        Node last = head;
        /*
            Here last--> a reference variable pointing to the
            same object head is pointing to
        */
        while(last.next != null)
        {
            last = last.next;
        }
        /*
            new_node is the last element and next of it
            is a null
        */
        new_node.next = null;
        last.next = new_node;
    }
    /*
      Finding the middle element of the linkedlist
    */
    public void middle()
    {
      int count = 0;
      Node tnode = head;
      System.out.println("Elements in the linked list are: ");
      while(tnode != null)
      {
        System.out.print(tnode.data+" ");
        tnode = tnode.next;
        count++;
      }
      System.out.println();
      count = count/2;
      System.out.println("Count:"+count);
      Node temporary = head;
      Node middle;
      for(int i=0;i<count;i++)
      {
        System.out.println(temporary.data);
        temporary = temporary.next;
        if((i+1) == count)
        {
            middle = temporary;
        }
        /*
            Initially i=0, count =2
            1) i=0,0<2
               temporary = 2
               0+1 == count(2) -->FASLE
            2) i=1,1<2
               1+1 == count(2) -->true
               temporary = 3
               MIDDLE = temporary
        */
      }
      System.out.println("Middle element:"+temporary.data);

}
    /*Driver program*/
    public static void main(String[] args)
    {
        LinkedList llist = new LinkedList();
        llist.push(1);
        llist.push(2);
        llist.push(3);
        llist.push(4);
        llist.middle();
    }
}
