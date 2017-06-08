/*
    PROBLEM URL: http://www.geeksforgeeks.org/write-a-function-to-reverse-the-nodes-of-a-linked-list/
*/
import java.io.*;
import java.util.*;
class Node
{
    Node next;
    /*
        Creating a reference variable next of class Node not pointing to any
        object
    */
    int data;
    Node(int d)
    {
      data = d;
    }
}
class LinkedList
{
    Node head;
    /*
        Creating a reference variable of class Node not pointing to any object
    */

    /*
        push() -> Function to push an element at front of the list
    */
    public void push(int node_data)
    {
        /*
            Checking if head is empty if so
            we will be pointing it to an object
        */
        if(head == null)
        {
          head = new Node(node_data);
          return; //end the function
        }
        Node last = head;
        /*
            Creating a reference variable last
            pointing to same object head is pointing to
        */
        /*
            Iterating towards the loop inorder to find the last node
        */
        while(last.next!=null)
        {
            last = last.next;
        }
        Node new_node = new Node(node_data);
        /*
            Creating a reference variable new_node
            pointing to an object

            This new_node.next should be null -->since its a last node
        */
        new_node.next = null;
        last.next = new_node;
        return;

    }

    /*
        Printing the element in the linked list
    */
    public void printlist()
    {
        Node tnode = head;
        while(tnode!=null)
        {
          System.out.print(tnode.data+" ");
          tnode = tnode.next;
        }
        System.out.println();
    }
    /*
        Reverse element of a linked list
    */
    public void reverse()
    {
        Node current = head;
        /*
            current is a reference variable pointing to same object
            head reference variable is pointing to.
        */
        Node prev = null;
        Node next = null;
        while(current != null)
        {
          next = current.next;
          current.next = prev;
          prev = current;
          current = next;

          /*
            Head | next
            ++++++++++      ++++++++++      ++++++++++       ++++++++++
            + 1 +---------> + 2 +-------->  + 3 +--------->  + 4 +--------> NULL
            ++++++++++      ++++++++++      ++++++++++       ++++++++++

            At every iteration at the  last line of the loop
            we will be updating the current node as the Previous_Node

            Initially 1) prev  = null
                      2) current = 1 (head)
                      3) next = null
            While Loop Execution:
            1) 1 != null
                        next = 2
                        current.next = 1---next---> prev =null
                        prev = current = 1
                        current = next = 2
            2) 2 != null
                        next = 3
                        current.next = 2---next---> prev = 1
                        prev = current = 2
                        current = next = 3
           3) 3 != null
                        next = 4
                        current.next = 3---next---> prev = 2
                        prev = current = 3
                        current =  next = 4
          4) 4 != null
                        next  = null
                        current.next = 4---next---> prev = 3
                        prev = current = 4
                        current = null
          5) null != null(FALSE)

          Head | next
          ++++++++++      ++++++++++      ++++++++++       ++++++++++
          + 4 +---------> + 3 +-------->  + 2 +--------->  + 1 +--------> NULL
          ++++++++++      ++++++++++      ++++++++++       ++++++++++
          */
        }
        head = prev;
        /*
            Changing the head Node to previous value = 4
        */
    }

    /*
        Driver program
    */
    public static void main(String[] args)
    {
        LinkedList llist = new LinkedList();
        llist.push(1);
        llist.push(2);
        llist.push(3);
        llist.push(4);
        System.out.println("Elements in the linked list are: ");
        llist.printlist();
        System.out.println("Reverse Elements in the linked list are: ");
        llist.reverse();
        llist.printlist();
    }
}
