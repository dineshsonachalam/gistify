import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
class solution
{
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
  int test =scan.nextInt();
  for (int q =0;q<test ;q++)
  {


    int n=scan.nextInt();
    int[][] a = new int[n+1][n+1];

    for (int i=1;i<=n;i++)
    {
        String s =scan.next();
        for (int j=1;j<=n;j++)
        {
          char x = s.charAt(j-1);
          int temp = Character.getNumericValue(x);
          a[i][j] = temp;
        }
    }

    /*
    for (int i=1;i<=n ;i++ )
    {
    //    String s =scan.next();
        for (int j=1;j<=n ;j++)
        {

          a[i][j] = scan.nextInt();
        }
    }
    */
    int mid= (n/2)+1;
    int[][] b = new int[n+1][n+1];
    for (int i=1;i<mid;i++)
    {
      for (int j=1;j<=n;j++)
      {
        b[i][j] = a[i][j];
      }
    }
    int[][] c = new int[n+1][n+1];
    //logic for n is even or odd
    if((n%2)!=0)
  {
    int l=1;
    for (int i=n;i>mid;i--)
    {
      int m=1;
      for (int j=1;j<=n;j++)
      {
        c[l][m] = a[i][j];
        m++;
      }
      l++;
    }
  }
  else
  {
    int l=1;
    for (int i=n;i>=mid;i--)
    {
      int m=1;
      for (int j=1;j<=n;j++)
      {
        c[l][m] = a[i][j];
        m++;
      }
      l++;
    }

  }
System.out.println();
System.out.println();
    for (int i=1;i<mid ;i++ )
    {
        for (int j=1;j<=n ;j++)
        {
          //a[i][j] = scan.nextInt();
          System.out.print(b[i][j]+" ");
        }
        System.out.println();
    }
    System.out.println("");
    System.out.println("C:");
    System.out.println();
    for (int i=1;i<mid ;i++ )
    {
        for (int j=1;j<=n ;j++)
        {
          //a[i][j] = scan.nextInt();
          System.out.print(c[i][j]+" ");
        }
        System.out.println();
    }
    //symmetric about x-axis
    boolean x=true;
    System.out.println();
    for (int i=1;i<mid ;i++ )
    {
      if(x)
      {
        for (int j=1;j<=n ;j++)
        {
          System.out.print(b[i][j]+" = "+c[i][j]+" ");
          if(b[i][j]==c[i][j])
          {
            x=true;
          }
          else
          {
            x=false;
            break;
          }
        }
      }
      else
      {
        break;
      }
          System.out.println();
    }
/*
    if (x)
    {
        System.out.println("yes");
    }
    else
    {
      System.out.println("no");
    }
*/
    boolean y = true;
  //now to write logic for y coordinates
    if(x) //only if x coordinates true we should proceed to y coordinates
    {
      System.out.println("D:");
      int d[][] = new int[n+1][n+1];
      int e[][] = new int[n+1][n+1];

      for (int i=1;i<=n;i++)
      {
        for (int j=1;j<mid;j++)
        {
          d[i][j] = a[i][j];
          System.out.print(a[i][j]+" ");
        }
        System.out.println();
      }
      System.out.println();
      System.out.println("E:");
      System.out.println();
      if(n%2!=0)
      {
        int u =1;
        for (int i=1;i<=n;i++)
        {
          int v=1;
          for (int j=n;j>=mid+1;j--)
          {
            e[u][v] = a[i][j];
            v++;
            System.out.print(a[i][j]+" ");
          }
          u++;
          System.out.println();
        }
      }
      else
      {
        int u =1;
        for (int i=1;i<=n;i++)
        {
          int v=1;
          for (int j=n;j>=mid;j--)
          {
            e[u][v] = a[i][j];
            v++;
            System.out.print(a[i][j]+" ");
          }
          u++;
          System.out.println();
        }
      }
      //now check for condition

      for (int i=1;i<=n ;i++ )
      {
          if(y)
        {
          for (int j=1;j<mid ;j++)
          {
            //a[i][j] = scan.nextInt();
          //  System.out.print(c[i][j]+" ");
            if(d[i][j]==e[i][j])
            {
              //  x=true;
            }
            else
            {
              y=false;
              break;
            }
          }
        }
        else
        {
          break;
        }
      }

    }
    else
    {
      y = false;
    }
    if (y)
    {
        System.out.println("yes");
    }
    else
    {
      System.out.println("no");
    }
  }
  }
}
