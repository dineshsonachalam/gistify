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
  */
  public void swap(int key1,int key2)
  {
      /*
          We need to swap node containing data key1 & key2
      */
      /*
          Suppose LinkedList contains
          1-->2-->3-->4-->5
                            key1 = 2 , key2 = 5
                            after Swapping
          1-->5-->3-->4-->2
          Now we need following nodes
          prev1,prev2
          key_swap1,key_swap2
          After1,After2
      */
      /*
        Inorder to make connections
        prev1.next = key_swap2
        key_swap2.next = After1

        prev2.next = key_swap1
        key_swap1.next = After2
      */
      Node prev1 = null;
      Node prev2 = null;
      Node After1 = null;
      Node After2 = null;
      Node key_swap1 = null;
      Node key_swap2 = null;
      /*
          tnode is a reference variable pointing to the same
          object , reference variable head is pointing to
      */
      Node tnode = head;
      while(tnode.next != null)
      {
          if((tnode.data == key1) && (tnode == head)) //if data present in head
          {
              key_swap1 = tnode;
              After1 = tnode.next;
          }
          else if((tnode.data == key2) && (tnode == head)) //if data present in head
          {
              key_swap2 = tnode;
              After2 = tnode.next;
          }
          else if(tnode.next.data == key1)
          {
              prev1 = tnode;
              key_swap1 = tnode.next;
              After1 = key_swap1.next;
          }
          else if(tnode.next.data == key2)
          {
              prev2 = tnode;
              key_swap2 = tnode.next;
              After2 = key_swap2.next;
          }
          tnode = tnode.next;
      }
      /*
      Suppose LinkedList contains
      1-->2-->3-->4-->5
                        key1 = 2 , key2 = 5
      While loop execution:
      1. tnode = 1
         tnode.data ! = key1 & key2
         tnode.next.data = key1 (TRUE)
              prev1 = tnode = 1
              key_swap1 = tnode.next = 2
              After1 = key_swap1.next = 3
         tnode = tnode.next = 2

      2. tnode =2
         tnode!=head
         tnode.next.data = 3 !(key1 & key2)
         tnode = tnode.next = 3

      3. tnode =3
         tnode!=head
         tnode.next.data = 4!(key1 & key2)
         tnode = tnode.next = 4

      4. tnode = 4
         tnode!=head
         tnode.next.data = 5 (key2) -true
              prev2 = tnode = 4
              key_swap2 = tnode.next = 5
              After2 = null
         tnode = tnode.next = 5
      5. while(5.next == null) --FAILS
      */
      /*
        Make right connections
        Now we have
                    prev1 = 1
                    prev2 = 4
                    After1 = 3
                    After2 = null
                    key_swap1 = 2
                    key_swap2 = 5
        LinkedList after swapping looks like these
        1-->5-->3-->4-->2
                         Inorder to make right swapping make right connections
        prev1(1).next ---> key_swap2(5)
        key_swap2(5).next --->After1(3)
        Similary
        prev2(4).next ---> key_swap1(2)
        key_swap1(2).next --->After1(null)

      */
      prev1.next = key_swap2;
      key_swap2.next = After1;
      prev2.next = key_swap1;
      key_swap1.next =After2;

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
