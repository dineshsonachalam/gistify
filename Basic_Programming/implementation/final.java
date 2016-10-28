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
      Scanner scan= new Scanner(System.in);
      String s=scan.next();
      int l=-1,r=1,u=1,d=-1;
      int x=0,y=0;
      for (int i=0;i<s.length();i++)
      {
        char ch=s.charAt(i);
        if(ch=='L')
        {
          x+=l;
        }
        else if(ch=='R')
        {
          x+=r;
        }
        else if(ch=='U')
        {
          y+=u;
        }
        else if(ch=='D')
        {
          y+=d;
        }
      }
      System.out.println(x+" "+y);
  }
}
