/*
  Find Length of a Linked List (Iterative Approach)
  URL: http://www.geeksforgeeks.org/find-length-of-a-linked-list-iterative-and-recursive/
*/
class linkedlist
{
  Node head;
  /*
      head -> reference variable not pointing to any object
      & default is null
  */
  class Node //LinkedList Node
  {
    int data;
    Node next;
    /*
        next -> reference variable of class node pointing to
        an object
    */
    /*
      Creating a parametrized constructor and it gets invoked
      when an object is being created
    */
    Node(int d)
    {
        data = d;
        next = null;
    }
  }
  /*
      TO push an element node at the front of the list
  */
  public void push(int node_data)
  {
      Node new_node = new Node(node_data);
      /*
          Creating a reference variable new_node pointing to an object
      */
      /*
          if head is null i.e linkedlist is empty
      */
      if(head ==  null)
      {
        head = new Node(node_data);
        /*
          head --> reference variable pointing to an object of class Node
        */
        return ; //end the function
      }
      /*
        new_node should be a head
        new_node --next--> previous head
        and Finally Assign new_node as next
      */
      new_node.next = head;
      head = new_node;
      /*
        Finally new_node becomes head
      */
  }
  /*
    to count the no of elements in the linkedlist
  */

  public int get_count()
  {
      Node tnode = head;
/*
          Here reference variable tnode  pointing to the same object
          reference variable head is pointing to
*/
      int count = 0;
      while (tnode!=null)
      {
          count++;
          tnode = tnode.next;
      }
      return count;
  }

  /*
      To print the elements in the linked list
  */
  public void printlist()
  {
    Node tnode = head;
    while (tnode!=null)
    {
        System.out.print(tnode.data+" ");
        tnode = tnode.next;
    }
    System.out.println();
  }
  /*
      Driver program
  */
  public static void main(String[] args)
  {
        linkedlist llist = new linkedlist();
        /*
            We are creating a reference variable llist pointing to
            an object
        */
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);
        /*
            LinkedList contains 1-->2-->3-->4-->5
        */
        System.out.println("Elements in the linkedlist are:");
        llist.printlist();
      System.out.println("LinkedList length: "+llist.get_count());
}
}
