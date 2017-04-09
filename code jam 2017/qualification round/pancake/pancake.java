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

      String s = scan.next();
      int[] a= new int[s.length()];
      for(int i=0;i<s.length();i++)
      {
        if(s.charAt(i)=='+')
        {
          a[i] = 1;
          System.out.println(a[i]);
        }
        else
        {
          a[i] = 0;
          System.out.println(a[i]);
        }
      }


    }
}
