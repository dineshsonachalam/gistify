import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
class solution
{
  public static void main(String[] args) throws java.lang.Exception
  {
  	BufferedReader inp = new BufferedReader (new InputStreamReader(System.in));
  //  int T= Integer.parseInt(inp.readLine());

  //    Scanner scan = new Scanner(System.in);
      int n = Integer.parseInt(inp.readLine());
      int q = Integer.parseInt(inp.readLine());
      char[] a= new char[n+1];

      String s =inp.readLine();
      for (int i=0;i<n;i++)
      {
          a[i]=s.charAt(i);
      }
      for (int m=0;m<q;m++)
      {

          int l = Integer.parseInt(inp.readLine());
          int r =  Integer.parseInt(inp.readLine());
          int k =  Integer.parseInt(inp.readLine());
          int size = r-l;
          l = l-1;
          r = r-1;
          k = k-1;
          char[] b = new char[size+1];
          for (int i=0;i<=size ;i++)
          {
              b[i]=a[l];
              l++;
          }
          //now we have to sort b[] array lexicographically
          Arrays.sort(b);
          if(k>size)
          {
            System.out.println("Out of range");
          }
          else
          {
            System.out.println(b[k]);
          }
      }
  }
}
