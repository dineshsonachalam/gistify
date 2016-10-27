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
    int t=scan.nextInt();
    for(int k=0;k<t;k++)
    {
      int n=scan.nextInt();
      int[][] a= new int[n][n];
      for (int i=0;i<n;i++)
      {
          for (int j=0;j<n ;j++)
          {
              a[i][j]=scan.nextInt();
          }

      }
      int count=0;
      for (int i=0;i<n-1;i++)
      {
        for (int j=i+1;j<n;j++)
        {
          if(a[i]>a[j])
          {
            count++;
          }
        }
      }
      System.out.println(count);
    }
  }
}
