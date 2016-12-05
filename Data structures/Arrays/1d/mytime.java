import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
class solution
{
  public static void main(String[] args)
  {
     Queue<Integer> cal=new LinkedList<Integer>();
     Queue<Integer> ideal=new LinkedList<Integer>();
      Scanner scan = new Scanner(System.in);
      int n=scan.nextInt();
      for (int i=0;i<n;i++)
      {
          int temp =scan.nextInt();
          cal.add(temp);
      }

      for (int i=0;i<n;i++)
      {
          int temp =scan.nextInt();
          ideal.add(temp);
      }

      int t = 0;


      while(!(ideal.isEmpty()))
      {

        int temp = ideal.peek();


        int x = cal.peek();

        if(x==temp)
        {
          ideal.poll();
          cal.poll();
          t++;


        }
        else {
          int top =cal.peek();

          int head =  cal.poll();

          cal.add(top); //adding the top --> last
          t++;

        }
      }

      System.out.println(t);
  }
}
