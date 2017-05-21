/*
  Delete last occurence of item from the linkedlist
*/
class linkedlist
{
    Node head;
    /*
        head -> reference variable of class Node not pointing to any object
                by default it is null
    */
    /*linkedlist node*/
    class Node
    {
        int data;
        Node next;
        /*
          next -> reference variable not pointing to any object
        */
        /*
          Creating a parametrized constructor and it gets invoked
          when object is being created.
        */
        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    /*
      push() --> to push an node element at the end of the linkedlist
    */
    public void push(int node_data)
    {
        /*
            If it's a 1st node i.e head
            now point reference variable head to point to an object
        */
        if(head == null)
        {
          head = new Node(node_data);
          return ; //stop the function
        }
        /*
          push the node at end of the list we need to iterate
          to find the lastnode and attaching a new node to lastnode
          such that new node becomes the lastnode
        */
        Node new_node = new Node(node_data);
        /*
          Creating a reference variable new_node pointing to an object.
        */
        Node lastnode = head;
        /*
            Here lastnode is a reference variable pointing to the same object
            of the reference variable head
        */
        /*Iterate node link to find the lastnode*/
        while(lastnode.next != null)
        {
          lastnode = lastnode.next;
        }
        /*
          Suppose linkedlist contains 1-->2-->3-->4-->5
          lastnode = 1(head) initially
          while loop execution
          1. lastnode.next = 2 != null
             lastnode = 2
          2. lastnode.next = 3 != null
             lastnode = 3
          3. lastnode.next = 4 != null
             lastnode = 4
          4. lastnode.next = 5 != null
             lastnode = 5
          5. lastnode.next = null != null(FALSE)
        */
        /*
            Since new_node will become lastnode its next
            element should be a null
        */
        new_node.next = null;
        /*
          lastnode.next --> should be the new_node as it becomes
          new lastnode.
        */
        lastnode.next = new_node;

    }

    /*
        Delete last occurence of an item from the linkedlist
        key --> node whose last occurence should be deleted
    */
    public  void deleteNode(int key)
    {
      /*
          Inorder to delete the last occurence of the node
          You need:
          1. To keep track of prev_node
          2. To keep tack of the last occurence of the key
      */
      Node prev_node = null;
      Node last_occurence = null;
      /*
          Here prev_node and last_occurence are reference variable
          not pointing to any object
      */
      Node temp = head;
      /*
          temp is a reference variable of class Node pointing to same object
          reference variable head is pointing to.
      */
      /*
          We need to iterate the loop inorder to find the last occurence
          of the key
      */
      while (temp.next != null)
      {
        if((temp == head) && (temp.data == key))
        {
          last_occurence = temp;
          /*
            Dont need to care about prev_node as its a head
          */
        }
        else if(temp.next.data == key)
        {
            last_occurence = temp.next;
            prev_node = temp;
        }
        temp = temp.next;
      }
      /*
          If linkedlist contains 1-->2-->3-->4-->2-->5
          key(to be deleted) = 2
          prev_node = null
          last_occurence = null
          temp = 1 (head)

          While loop execution:
          1. temp == head (true) && temp.data(1) == 2 (FALSE)
             else
             temp.next.data = 2 == key
             last_occurence = 2
             prev = 1
             temp = 2

          2. temp == head (false)
             else
             temp.next.data = 3 !=key (FALSE)
             temp = temp.next
             temp = 3

          3. temp == head (false)
             else
             temp.next.data = 4 !=key (FALSE)
             temp = temp.next
             temp = 4

          4. temp == head (false)
             else
             temp.next.data = 2 == key (True)
             last_occurence = 2 (position 4 in the linkedlist)
             prev = 4
             temp = temp.next
             temp = 2

          5. temp == head (false)
             else
             temp.next.data =5 ==key (FALSE)
             temp = temp.next
             temp = 5

        6. while(temp.next! = null)
              5 -> next element is null
              While loop terminates
      */
      /*
          If last occurence is head
      */
      if(last_occurence == head)
      {
        head = head.next; //delete the key
        return ; // terminate the function
      }
      /*
        last occurence of node to be deleted
        prev = 4 and temp = 2 (node to be deleted)
        prev.next -linked to-> temp.next
        We need to unlink temp i.e deleting it
      */
      prev_node.next = last_occurence.next;
    }



    /*
        To print the elements in the linkedlist
    */
    public void printlist()
    {
        Node tnode = head;
        /*
            Now the reference variable tnode pointing to same object
            reference variable head is pointing to.
        */
        while (tnode!=null)
        {
            /*
                Print the data present in the nodes in the linkedlist
            */
            System.out.print(tnode.data+"--->");
            tnode = tnode.next;
        }
        System.out.print("null");
        System.out.println();
    }
    /*Driver program*/
    public static void main(String[] args)
    {
          linkedlist llist  = new linkedlist();
          llist.push(1);
          llist.push(2);
          llist.push(3);
          llist.push(4);
          llist.push(2);
          llist.push(5);
          System.out.println("linkedlist contains:");
          llist.printlist();
          /*
              Delete the last_occurence of the node having data 2
          */
          llist.deleteNode(2);
          System.out.println("LinkedList after deletion of node having data 2 in its last occurence:");
          llist.printlist();
    }
}

/*
Output:

linkedlist contains:
1--->2--->3--->4--->2--->5--->null
LinkedList after deletion of node having data 2 in its last occurence:
1--->2--->3--->4--->5--->null

*/
