// Linked List | Set 2 (Inserting a node)
// URL: http://www.geeksforgeeks.org/linked-list-set-2-inserting-a-node/
class linkedlist
{
  /*Head of the node*/
   Node head; // Reference variable of class Node not pointing to any object
   /*LinkedList node*/
   class Node
   {
     int data;
     Node next;
     // parametrized constructor
     Node(int d)
     {
       data = d;
       next = null;
     }
   }
   /*Insert a node at the front of the list*/
   public void push(int new_data)
   {
        /*1 & 2 Allocate the node and put in data*/
        /*Pointing reference variable to an object*/
        Node new_node = new Node(new_data);
        /*
          3. Make next of new node as the head
        */
        new_node.next =  head;
        /*
         4. Make head to point to the given the given node
        */
        head = new_node;
   }

   /* Insert a node after the given prev_node position*/
   public void insertAfter(Node prev_node,int new_data)
   {
      /* 1.Check if the give Node is NULL*/
      if(prev_node ==  null)
      {
        System.out.println("The given node cannot be NULL");
        return;
      }
      /* 2 & 3 Allocate the node and put data into it */
      Node new_node = new Node(new_data);
      /* 4. Make next of new_node as the next of prev_node */
      new_node.next = prev_node.next;
      /*5. Make next of prev_node as new_node*/
      prev_node.next = new_node;
   }

   /*Append a new node at the end*/
   public void append(int new_data)
   {
     /*1 & 2 Allocate and  put in the data*/
     Node new_node = new Node(new_data);
     /*3. If LinkedList is Empty, make the new node as head*/
     if(head ==  null)
     {
       head = new Node(new_data);
       return;
     }
     /*4. New node is going to be last node, so make next of it as NULL*/
     new_node.next = null;
     /*5. Traverse till the last node */
     Node last = head;
     while( (last.next)!=null)
     {
       last = last.next;
     }
     /* 6. Change last of next as the new node */
     last.next = new_node;
     return;
   }


   /*
      Function prints the contents of the linkedlist starting from the given node
   */
   public void printlist()
   {
     /*
        Create a reference variable tnode of class Node pointing to the same object of
        the reference variable head
     */
     Node tnode = head;
     while(tnode!=null) //until last  node
     {
       System.out.print(tnode.data+" ");
       tnode = tnode.next;
     }
   }

   /*
      Driver program to test above functions.
      Ideally this function should be in a separate user class.
      It is kept here to keep code compact.
   */
   public static void main(String[] args)
   {
      /* Start with the empty list*/
      linkedlist listl = new linkedlist();
      /*
        Insert '6'. So linkedlist becomes
        6-->NULL_LIST
      */
      listl.append(6);
      /*
        Insert 7 at the beginning. So linked list becomes
        7-->6-->NULL_LIST
      */
      listl.push(7);
      /*
        Insert 1 at the beginning so linkedlist becomes
        1-->7-->6-->NULL_LIST
      */
      listl.push(1);
      /*
        Insert 4 at the end so linked list becomes
        1-->7-->6-->4-->NULL_LIST
      */
      listl.append(4);
      /*
        Insert 8 after 7.So linked list becomes
        1-->7-->8-->6-->4-->NULL_LIST
      */
      listl.insertAfter(listl.head.next,8);
      System.out.println("Created Linked list is :");
      listl.printlist();
   }
}
