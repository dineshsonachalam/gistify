import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
// Each element of array fits into integer, but their sum can easily overflow it - 64-bit data types are needed.
class solution
{
  public static void main(String[] args)
{
    Scanner scan = new Scanner(System.in);
    int n=scan.nextInt();
    int[] a= new int[n+1];
    long x=0,y=0,z=0;
    int f=0;
    for (int i=0;i<n;i++)
    {
        a[i]=scan.nextInt();
    }
    for (int i=0 ;i<n ;i++) {
      if(f<n)
      {
        x+=a[f];
      }
      if(f+1<n)
      {
        y+=a[f+1];
      }
      if (f+2<n)
      {
        z+=a[f+2];
      }
      f+=3;

    }

    System.out.println(x+" "+y+" "+z);


  }
}
