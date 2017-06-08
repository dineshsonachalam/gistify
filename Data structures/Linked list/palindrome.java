/*
    PROBLEM URL: http://www.geeksforgeeks.org/function-to-check-if-a-singly-linked-list-is-palindrome/
*/
import java.io.*;
import java.util.*;
/*
    Creation of a linkedlist node
*/
class Node
{
    Node next;
    /*
        next -> a reference variable of class Node
        not pointing to any object.
    */
    int data;
    /*
        Creating a parametrized constructor when
        a object is being created.
    */
    Node(int d)
    {
        data = d;
        next = null;
    }
}
/*
    LinkedList class
*/
class LinkedList
{
      Node head;
      /*
          head -> is a reference variable not pointing to any
          object.
      */
      /*
          Adding a node element at the end of the list
      */
      public void push(int node_data)
      {
          if(head == null)
          {
            head = new Node(node_data);
            /*
              head -> reference variable pointing to an object
            */
            return ;
          }
          Node new_node = new Node(node_data);
          /*
            new_node -> a reference variable pointing to an object
          */
          Node lastnode = head;
          while(lastnode.next!=null)
          {
            lastnode = lastnode.next;
          }
          new_node.next= null;
          lastnode.next = new_node;
      }
      /*
          Reverse-2nd half of the linkedlist after middle node
      */
      public int reverse()
      {
          Node tnode = head;
          int count = 0;
          while(tnode!=null)
          {
            tnode = tnode.next;
            count++; // LinkedList length
          }
          if(count%2 != 0) //odd then add +1 eg 7 , 7+1 = 8, mid =8/2 = 4
          {
              count = count+1;
          }
          int mid_count = count/2;
          Node middle = head;
          Node next =  null;
          Node prev =  null;



          for(int i=1;i<mid_count;i++)
          {
              middle = middle.next;
                  /*
                  linked list contains
                  1-->2-->3-->4-->5-->null
                  count =5
                  middle = 1
                  mid_count = 3
                  1) i=1 ,1<3
                      middle = middle.next = 2
                  2) i=2 ,2<3
                      middle = middle.next = 3
                  3) i=3,3<3(FALSE)
                */
          }

          System.out.println("Middle:"+middle.data);

          Node current = middle.next;
          while(current != null)
          {
              next = current.next;
              current.next = prev;
              prev = current;
              current = next;
          }
          /*
                linked list contains
                1-->2-->3-->4-->5-->null
                count =5
                middle = 3
                current = 4
                WHILE LOOP Execution:
                1) next = current.next => 5
                   4---next---> prev(NULL)
                   prev = current = 4
                   current = 5

                2) next = current.next => null
                   5---next---> prev(4)
                   prev = current = 5
               middle = 3
               middle.next = 3---next---> prev(5)

               1--->2--->3--->5--->4-->null
          */
          middle.next = prev;
          return mid_count;
      }
      /*
          Now check if the given nodes are palindrome
      */

      public boolean check_palindrome(int mid)
      {
          Node after_mid = head;
          System.out.println("Middle Element:"+mid);
          for(int i=1;i<=mid;i++)
          {
            after_mid = after_mid.next;
          }
          /*
              LinkedList contains
              1--->2--->3--->2--->1-->null

              after_mid = 1
              mid = 3
              For Loop execution:
              1) i=1, 1<=3
                 after_mid = 2

              2) i=2, 2<=3
                 after_mid = 3

              3) i=3, 3<=3
                 after_mid = 2
          */
          Node before_mid = head;
          /*
              Now comparison of before middle element
                                after middle element
          */
          boolean b = true;
          for(int i=1;i<mid;i++)
          {
      //      System.out.println(before_mid.data+"<========>"+after_mid.data);
            if(before_mid.data == after_mid.data)
            {
               //do nothing
            }
            else
            {
              return false; //end
            }
            before_mid = before_mid.next;
            after_mid = after_mid.next;

          }
          return  true; /* return true if its a palindrome*/
      }

      /*
          printing the elements of the linkedlist
      */
      public void printlist()
      {
          Node tnode = head;
          while(tnode != null)
          {
              System.out.print(tnode.data+"----->");
              tnode = tnode.next;
          }
          System.out.print("null");
          System.out.println();
      }

      public static void main(String[] args)
      {
          LinkedList llist =  new LinkedList();
          llist.push(1);
          llist.push(2);
          llist.push(3);
          llist.push(4);
          llist.push(3);
          llist.push(2);
          llist.push(1);
          System.out.println("Elements in LinkedList are:");
          llist.printlist();
          System.out.println("LinkedList after reversing:");
          int middle = llist.reverse();
          llist.printlist();
          Boolean check = llist.check_palindrome(middle);
          if(check)
          {
              System.out.println("Its a palindrome");
          }
          else
          {
              System.out.println("Its not a palindrome");
          }
      }
}
