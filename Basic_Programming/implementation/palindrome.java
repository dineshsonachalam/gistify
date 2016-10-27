import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class solution
{
  public static void main(String[] args)
{
    Scanner scan = new Scanner(System.in);
    int n=scan.nextInt();

    for(int i=0;i<n;i++)
    {
      String s=scan.next();
      String reverse = new StringBuffer(s).reverse().toString();
  //    System.out.println(s);
  //    System.out.println(reverse);
      if(s.equals(reverse))
      {
        int t=s.length();
        if(t%2==0)
        {
          System.out.println("YES EVEN");
        }
        else
        {
          System.out.println("YES ODD");
        }
      }
      else
      {
        System.out.println("NO");
      }
    }


  }
}
