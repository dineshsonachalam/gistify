import java.io.*;
import java.util.*;
class linkedlist //parent class
{
    Node head; /* Creation of Reference Variable of class Node. head --> null .Since it does not point  to any object or
    intialized to any object */

    /* Inner class made static so that main can access it*/
    static class Node
    {
        int data;
        Node next; /* Creating reference variable not pointing to any object */
        /*Creating a parametrized constructor -- > Invoked when a object is created */
        Node(int d)
        {
          data = d;
          next = null;
        }
     }
     public void printlist()
     {
       Node n = head; //Assigning reference variable 'head' to Reference variable 'n' of class Node
       /*Head element normally points to the address of the memory location where the object is stored.*/
       while(n != null)  //Till the last node. loop runs until last element of a list
       {
         System.out.println(n.data + " ");
         n = n.next; /* Points to next element of the linkedlist  since they are connected to each other */
       }
     }
     /* Method to create simple linkedlist using 3 nodes */
     public static void main(String[] args)
     {
        // Start with a empty list
        linkedlist llist = new linkedlist();
        /*Pointing to reference to an object of class Node*/
        llist.head = new Node(1); // Creation of a new head node
        Node second; //Creation of reference variable of class node. Not pointing to any object. Default a null
        second = new Node(2);// Now pointing reference to an object of class Node. Now we create a second Node
        Node third; //creation of 3 rd node
        third = new Node(3); // Now pointing reference to an object. Creates third Node.
        /*Now we are going to print the element of a linkedlist*/

        /* Three nodes have been allocated  dynamically.
         We have refernces to these three blocks as first,
         second and third

         llist.head        second              third
            |                |                  |
            |                |                  |
        +----+------+     +----+------+     +----+------+
        | 1  | null |     | 2  | null |     |  3 | null |
        +----+------+     +----+------+     +----+------+ */

        /*Now creation of link between these nodes*/
        llist.head.next = second; /* it means list.head.next will point to the same object second is pointing to
 only one object but two references.*/
 /*  Now next of first Node refers to second.  So they
          both are linked.

       llist.head        second              third
          |                |                  |
          |                |                  |
      +----+------+     +----+------+     +----+------+
      | 1  |  o-------->| 2  | null |     |  3 | null |
      +----+------+     +----+------+     +----+------+ */
        second.next = third; //link the second node with the 3rd node
        /*  Now next of second Node refers to third.  So all three
            nodes are linked.

         llist.head        second              third
            |                |                  |
            |                |                  |
        +----+------+     +----+------+     +----+------+
        | 1  |  o-------->| 2  |  o-------->|  3 | null |
        +----+------+     +----+------+     +----+------+ */
        llist.printlist();



     }
}
