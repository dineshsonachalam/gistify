/*
    Delete a Linked List node at a given position
*/
class linkedlist
{
    /*
      Creating a reference variable head of class Node.
      Not pointing to any object
    */
    Node head;
    /*LinkedList node*/
    class Node
    {
      int data;
      /*
        Creating a reference variable next of class Node.
        Not pointing to any object
      */
      Node next;
      /*
        Parametrized Constructor
        It gets invoked when an object gets created
      */
      Node(int d)
      {
        data = d;
        next = null;
      }
    }
    /*
      Now creating push() function to
      push elements at the end of the list
    */
    public void push(int node_data)
    {
      /*
          Creating a reference variable new_node
          of class Node pointing to an object
      */
      Node new_node = new Node(node_data);
      /*
          If the head -->Null
      */
      if(head == null)
      {
        // head is now pointing to an object
        head = new Node(node_data);
        return; //end the function
      }
      /*
          Now we have to push the new_node in the last positon
          of the linkedlist
      */
      Node lastnode = head; //both reference pointing to same object
      /*
          Now iterate the refernce variable to the last node.
      */
      while(lastnode.next!=null)
      {
        lastnode = lastnode.next;
      }
      /*
          suppose LinkedList contains 1-->2-->3-->4-->5
          lastnode = 1
          While loop execution
          1. lastnode.next(2)! = null
             lastnode = 3
          2. lastnode.next(4)! = null
             lastnode = 5
          3. lastnode.next == null (Loop condion FAILS)
          so lastnode = 5
      */
      /*
          Now new_node should become lastnode
          so next element of new_node should be a null
      */
      new_node.next = null;
      /*To link new_node to the lastnode*/
      lastnode.next = new_node;
    }

    /*
        Now we have to delete a node at a given positon
    */
    public void deleteNode(int pos)
    {
        /*
          If node to be deleted is a first node i.e. head
          You can end the function Assigning next element of
          nod as head
        */
        if(pos==0) //head
        {
          head = head.next;
          return; //ending the function here
        }
        /*
            For deleting a node we need two reference variable
            1. Node to be deleted (say key)
            2. Previous_Node (say prev_node)
            Finally we link
            prev_node.next = key.next (unlinking the key i.e.
            value to be deleted)
        */
        /*
            key is a reference variable
            pointing to the same object of head
        */
        Node key = head;
        Node prev = null;
        /* Now iterate to find the node to be deleted */
        for(int i=0;i<pos;i++)
        {
            if(i==pos)
            {
               //do nothing
            }
            else
            {
              prev = key;
              key = key.next;
            }
        }
        /*
            Now key contains the elements to be deleted
        */
        /*
            prev ->is the previous element of the key node
        */
        /*
            Suppose linkedlist contains: 1-->2-->3-->4-->5
            Now deletion at position 1  i.e. node 2
            key = 2 (node to be deleted)
            prev = 1
            After deletion linkedlist contains:1-->3-->4-->5
            Now prev.next mapped with key.next
            to unlink key(i.e node to be deleted)
            Map prev.next --with--> key.next
        */
        prev.next = key.next;
        return; //end function
    }
    /*
        Now print the elements of the linked list
    */
    void printlist()
    {
        /*
            tnode is a reference variable of class Node pointing
            to same object head is pointing to.
        */
        Node tnode =  head;

        while(tnode != null)
        {
          System.out.print(tnode.data+" ");
          tnode = tnode.next;
        }
        System.out.println();
    }
    /*
      Now the driver program
    */
    public static void main(String[] args)
    {
        linkedlist llist = new linkedlist();
        llist.push(1);
        llist.push(2);
        llist.push(3);
        llist.push(4);
        llist.push(5);
        System.out.println("Linked list contains:");
        llist.printlist();
        /*
            Linked list after the deletion of a node at position 0
        */
        llist.deleteNode(0);
        System.out.println("Linked list after the deletion of a node at position 0");

        llist.printlist();
        /*
          Linked list after deletion at position 2 (3rd element)
        */
        llist.deleteNode(2);

        System.out.println("Linked list after deletion at position 2 (3rd element)");

        llist.printlist();

    }
}
