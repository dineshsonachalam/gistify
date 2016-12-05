import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
class solution
{
  public static void main(String[] args)
  {
    //  PriorityQueue<Integer> cal = new PriorityQueue<Integer>();
    //  PriorityQueue<Integer> ideal = new PriorityQueue<Integer>();
     Queue<Integer> cal=new LinkedList<Integer>();
     Queue<Integer> ideal=new LinkedList<Integer>();
      Scanner scan = new Scanner(System.in);
      int n=scan.nextInt();
      for (int i=0;i<n;i++)
      {
          int temp =scan.nextInt();
          cal.add(temp);
      }
      System.out.println ( "cal queue values are: " + cal) ;
      for (int i=0;i<n;i++)
      {
          int temp =scan.nextInt();
          ideal.add(temp);
      }
        System.out.println ( "ideal queue values are: " + ideal) ;
      int t = 0;

      System.out.println();
      System.out.println("Execution starts");
      System.out.println();
      while(!(ideal.isEmpty()))
      {
        System.out.println("Start:");
        int temp = ideal.peek();
      //  System.out.println("Temp:"+temp);
        System.out.println("Temp:"+temp);
        int x = cal.peek();
        System.out.println("x:"+x);
        if(x==temp)
        {
          ideal.poll(); //removing the top element as the process gets executed
          cal.poll();
          t++;
          System.out.println ( "ideal queue values are: " + ideal) ;
          System.out.println();
          System.out.println();

        }
        else {
          int top =cal.peek();
          System.out.println("Top:"+top);
          int head =  cal.poll();   //removing the top element
          System.out.println("Head after polling:"+head);
          cal.add(top); //adding the top --> last
          t++;
          System.out.println ( "cal queue values are: " + cal) ;
          System.out.println();
          System.out.println();
        }
      }

      System.out.println("T:"+t);
  }
}
