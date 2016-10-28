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
      int t=scan.nextInt();

      for (int x=0;x<t;x++)
      {
        int n=scan.nextInt();
        int b[]= new int[n];
        int a[]= new int[n];
        for(int i=0;i<n;i++)
        {
          b[i]=scan.nextInt();
        }
        for (int i=0;i<n;i++)
        {
          a[i]=scan.nextInt();
        }
        Arrays.sort(a);
        Arrays.sort(b);
        int suma=a[n-1];
        int sumb=b[n-1];

      if(suma==sumb)
        {
          System.out.println("Tie");
        }
        if (sumb>suma)
        {
            System.out.println("Bob");
        }
        if (sumb<suma)
        {
            System.out.println("Alice");
        }
      
      //  System.out.println(b[n-1]);
      //  System.out.println(a[n-1]);
      }

  }
}
