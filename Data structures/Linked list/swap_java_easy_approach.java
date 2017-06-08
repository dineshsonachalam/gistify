/*
  Problem URL: http://www.geeksforgeeks.org/swap-nodes-in-a-linked-list-without-swapping-data/
*/
/*
  Find the other way of swapping which is given in the website
*/
/* LinkedList Node*/
class Node
{
    int data;
    Node next;
    /*
        next-> reference varibale of class Node
        not pointing to any object and default a null
    */
    /*
        Creating a parametrized constructor
        and it get invoked when an object is being created
    */
    Node(int d)
    {
      data = d;
      next = null;
    }
}

class linkedlist
{
  Node head;
  /*
    Creation of  a reference variable head
    of class Node, not pointing to any object
  */


  /*
      Pushing an element at the front of the list
  */
  public void push(int node_data)
  {
    Node new_node = new Node(node_data);
    /*
      Reference variable new_node of class Node is now pointing to an object
    */
    if(head == null) //linkedlist is empty
    {
      head = new Node(node_data);
      /*
        reference variable head is now pointing to an object of class Node
      */
      return; //end the function
    }
    /*
      new_node supposed to be the new_head so
      new_node of next element should be old head
    */
    new_node.next =  head;
    /*
      Replace now the old head by new head
    */
    head = new_node;
  }

  /*
      Swapping the nodes in the LinkedList without swapping data

      The idea it to first search x and y in given linked list.
      If any of them is not present, then return.
      While searching for x and y,
      keep track of current and previous pointers.
      First change next of previous pointers, then change next of current pointers. 
      Following are Java implementations of this approach.
  */
  public void swap(int key1,int key2)
  {

      Node prev1 = null;
      Node prev2 = null;
      Node current_var1 = null;
      Node current_var2 = null;
      /*
          tnode is a reference variable pointing to the same
          object , reference variable head is pointing to
      */
      Node tnode = head;
      while(tnode.next != null)
      {
          if((tnode.data == key1) && (tnode == head)) //if data present in head
          {
              current_var1 = tnode; // now changing the pointer position
          }
          else if((tnode.data == key2) && (tnode == head)) //if data present in head
          {
              current_var2 = tnode; // now changing the pointer postion
          }
          else if(tnode.next.data == key1)
          {
              prev1 = tnode;
              current_var1 = tnode.next;
          }
          else if(tnode.next.data == key2)
          {
              prev2 = tnode;
              current_var2 = tnode.next;
          }
          tnode = tnode.next;
      }

      // If x is not head of linked list
     if (prev1 != null)
         prev1.next = current_var2;
     else //make y the new head
         head = current_var2;

     // If y is not head of linked list
     if (prev2 != null)
         prev2.next = current_var1;
     else // make x the new head
         head = current_var1;

      Node temp = current_var1.next;
      current_var1.next = current_var2.next;
      current_var2.next = temp;



  }

  /*
      Print the elements in a linkedlist
  */
  public void printlist()
  {
      Node tnode = head;
      /*
        Now the reference variable tnode is pointing to same object
        the reference variable head is pointing to
      */
      while (tnode != null)
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
          Reference variable llist now pointing to an object
          of class Node
      */
      llist.push(5);
      llist.push(4);
      llist.push(3);
      llist.push(2);
      llist.push(1);
      /*
        LinkedList contains 1-->2-->3-->4-->5
      */
      System.out.println("LinkedList contains:");
      llist.printlist();
      System.out.println("LinkedList after swapping:");
      llist.swap(2,5);
      llist.printlist();
  }

}
/*
  Output:
  LinkedList contains:
  1 2 3 4 5
  LinkedList after swapping:
  1 5 3 4 2
*/
