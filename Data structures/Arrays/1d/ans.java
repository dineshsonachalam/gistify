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
    int x= scan.nextInt();
    int[] a= new int[n];
    for (int i=0;i<n;i++)
    {
        a[i]=scan.nextInt();
    }
    int k=0;
    int c=0;
    for (int i=0;i<n;i++)
    {
          if(k==2)
          {
              break;
          }
          if(a[i]<=x)
          {
            c++;
          //  System.out.println("c:"+c);
          }
          else
          {
            k++;
            //System.out.println("k:"+k);
          }
    }
    System.out.println(c);
  }
}
