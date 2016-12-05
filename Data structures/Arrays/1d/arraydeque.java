import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
class solution
{
  public static void main(String[] args) {


  Scanner scan = new Scanner(System.in);
  int n=scan.nextInt();
  int[] a=  new int[n];
  for (int i=0;i<n;i++)
  {
      a[i] = scan.nextInt();
  }

  ArrayDeque<Integer> deque = new ArrayDeque<>();
  for (int i=0;i<n ;i++ )
  {
      if(a[i]!=0)
      {
        deque.push(a[i]);
        /*
        System.out.println("Element pushed:"+a[i]);
        System.out.println();
        System.out.println();
        System.out.println("Stack elements are:");
        */
        /*
        for (int value: deque)
        {
          //  sum+=value;
              System.out.print(value+" ");
        }
        System.out.println();
        */
      }
      if( a[i]==0 && (i!=0)) // i == 0 its first element
      {
        int temp = deque.pop();
    //    System.out.println("Popped element:"+temp);
      //  System.out.println("Element at the peek:"+deque.peek());

      }
  }
  int sum =0;
//  System.out.println("Stack elements are:");
  for (int value: deque)
  {
      sum+=value;
        //System.out.println(value);
  }
 System.out.println(sum);
  }
}
