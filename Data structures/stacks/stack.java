import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
class solution
{
  public static void main(String[] args)  {
      Scanner scan = new Scanner(System.in);
      int n =scan.nextInt();//total no of harry gold coin
      Stack st = new Stack();
      Stack monk = new Stack();
      int[] a = new int[n+1];
      for (int i=n-1;i>=0;i--)
      {

        a[i] =scan.nextInt();

      }
      for (int i=0;i<n ;i++)
      {
        st.add(a[i]);
      }

      int q =scan.nextInt(); //no of queries
      int x =scan.nextInt(); //worth of gold coins
      int sum = 0;
      int count=0;
      int ans =0;
      int flag=0;
      for (int i=0;i<q ;i++)
      {
          String s=scan.next();
          if(s.equals("Harry"))
          {
              int top =(int)st.pop();
              monk.add(top);
              sum+=top;
              count++;
              if(sum==x  && flag==0)
              {
				            flag=1;
				            ans=count;
			        }
          }
          else
          {
              sum-=(int)monk.pop();
              count--;
            //  System.out.println("Monk:"+monk);
          }
      }


      if(flag==1)
      {
        System.out.println(ans);

      }
      else
      {
        System.out.println("-1");
      }
  }
}
