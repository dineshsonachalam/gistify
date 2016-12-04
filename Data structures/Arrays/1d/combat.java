import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
class solution
{
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      int t=scan.nextInt();
      for (int l=0;l<t ;l++)
      {
          int n = scan.nextInt(); //no of dwarfs
          int m = scan.nextInt(); //no of hrs spent
          int[] a = new int[n+1];
          for (int j=1;j<=n;j++)
          {
              a[j]=scan.nextInt();
          }
          for (int x=1;x<=m;x++)
          {
              int m_n = a[1];
              int n_m = a[2];
              int o = a[n];
              int p = a[n-1];


              //now logic for the remaining elements
              int[] b = new int[n];
              for (int i=2;i<=n-1;i++)
              {
                  if((a[i+1]==1) && (a[i-1]==1))
                  {
                    b[i]=1;

                  }
                  else
                  {
                    b[i]=0;
                  }
              }
              for (int i=2;i<=n-1;i++)
              {
                  a[i]= b[i];
              }

              //now logic for the corners on left side
              if ( ( m_n ==1 || m_n ==0) && (n_m == 1) )
              {
                a[1]=1;
              }
              else
              {
                a[1]=0;
              }
              //logic for the corner on the right side
              if((o == 1 || o ==0) && (p ==1))
              {
                a[n]=1;
              }
              else
              {
                a[n]=0;
              }
          }
          for (int i=1;i<=n;i++)
          {
              System.out.print(a[i]+" ");
          }
          System.out.println();
      }
   }
}
