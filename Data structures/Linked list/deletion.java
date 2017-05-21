 //URL: http://www.geeksforgeeks.org/linked-list-set-3-deleting-node/

 class linkedlist
 {
      /*
        head -> reference variable of class Node
        head is not pointing to any object
      */
      Node head; // head of the linkedlist
      /*
        LinkedList node
      */
      class Node
      {
          int data;
          Node next;
          /*
              Creation of parametrized constructor
              Invoked when object is created
          */
          Node(int d)
          {
            data = d;
            next = null;
          }
      }

      /*
        Given an key, delete the first occurence of the key
        in the given linked list
      */
      public void deleteNode(int key)
      {
          /*
              Store the head node in a reference variable temp
              So that both poiting to the same object
          */
          Node temp = head;
          /*
              Creating ref variable prev of class Node
              and not pointing to an object
          */
          Node prev = null;
          /*
              If head node itself hold the key to be deleted
          */
          if(temp!=null && temp.data==key)
          {
            head = temp.next; // Changed head
            return;
          }
          /*
              Search for the key to be deleted,
              keep track of previous node as we
              need to change temp.next
          */
          while(temp!=null && temp.data!=key)
          {
              prev = temp;
              temp = temp.next;
          }
          /*
            At the end of the loop if the LinkedList contains the key then,
            temp --> Actually hold the key(reference)
          */
          /*
            If key was not present in the linked list
          */
          if(temp == null)
          {
            return;
          }
          /*
            Unlink the node to be deleted from the linked list
            In this case node to be deleted is temp
          */
          /*
            For example:
            LinkedList contains : 1-->2-->3-->4-->5
            Key to be deleted : 3
            While loop execution:
            1) temp!=null && 1!=key
               Now, prev = 1
                    temp = 2
            2) temp!=null && 2!=key
               Now, prev = 2
                    temp = 3
           3) temp!=null && 3==key --> Condition fails
           Now we can see 'temp', holds the key to be deleted
           After deletion linkedlist should look like below

           LinkedList contains: 1-->2-->4-->5
           You can see that prev.next is linked to temp.next
           so unlink the temp node
           prev.next = temp.next;
          */
          prev.next = temp.next;
      }
      /* Insert a node at the front of the linkedlist */
      public void push(int new_data)
      {
          Node new_node = new Node(new_data);
          new_node.next = head;
          head = new_node;
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
          while(tnode != null)
          {
            System.out.print(tnode.data+" ");
            tnode = tnode.next;
          }
      }

      /*
          Driver program to test the above function.
          Ideally function should be in seperate class.
          Its kept here for code compatibility
      */
      public static void main(String[] args)
      {
          linkedlist llist = new linkedlist();
          /*
            Every node_data is  added to the front of  the list
            i.e., they become the head
          */
          llist.push(5);
          llist.push(4);
          llist.push(3);
          llist.push(2);
          llist.push(1);
          /*
              Linked list contains 1-->2-->3-->4-->5-->NULL
          */
          System.out.println("Created Linked List is:");
          llist.printlist();
          System.out.println();
          /*
            Deletion of Node contains data 3
          */
          llist.deleteNode(3);
          System.out.println("Linked list after deletion:");
          llist.printlist();
      }
 }
