import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
class solution
{
  public static void main(String[] args)
  {
      Scanner scan =  new Scanner(System.in);
      int N = scan.nextInt();
      Stack<Integer> st = new Stack<Integer>(); //int conversion
      for (int i=0;i<N ;i++ )
      {
        int size =scan.nextInt();
          for (int j=0;j<size ;j++ )
          {
              int temp = scan.nextInt();
              st[i].add(temp);
          }
      }

      /*
      st.add(1);
      st.add(2);
      st.add(3);
      */
      /*
      Iterator itr = st.iterator();
      while(itr.hasNext())
      {
        System.out.println(itr.next());
      }
      */

  }
}
