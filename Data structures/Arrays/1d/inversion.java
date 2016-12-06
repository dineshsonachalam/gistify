import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
class solution
{
  int counting_inv(int val,int x,int y,int n ,int[][] a)
  {
    int count=0;
    for (int i=x;i<n;i++)
    {
        for (int j=y;j<n;j++)
        {
            if(val>a[i][j])
            {
              count++;
            }
        }
    }
    return count;
  }

  public static void main(String[] args)
  {

      Scanner scan = new Scanner(System.in);
      int t = scan.nextInt();
      solution sol = new solution();
      for(int l=0;l<t;l++)
      {
          int count =0;
          int n=scan.nextInt();
          int[][] a= new int[n][n];

          for (int i=0;i<n;i++)
          {
              for (int j=0;j<n;j++)
              {
                  a[i][j] = scan.nextInt();

              }
          }
          for (int i=0;i<n;i++)
          {
              for (int j=0;j<n;j++)
              {

                    count+=sol.counting_inv(a[i][j],i,j,n,a);

              }
          }
            System.out.println(count);
        }

  }
}
