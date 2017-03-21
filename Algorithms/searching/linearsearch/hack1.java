import java.io.*;
import java.util.*;

class solution {
    public static void main(String args[] ) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n =scan.nextInt();

        int[] a= new int[n];
        int flag = 0;
        for(int i=0;i<n;i++)
        {
          a[i] = scan.nextInt();
        }
      if(flag==0)
    {
        for(int i=0;i<n;i++)
      {
          if(flag==0)
        {
          for(int j=i+1;j<=n-1;j++)
          {
              //System.out.println(a[i]+"==="+a[j]);
              if(a[i]==a[j])
              {
                flag = 1;
              }
          }
        }
      }
    }
    if(flag==1)
    {
      System.out.println("NO");
    }
    else if(flag==0)
    {
      System.out.println("YES");
    }



    }
}
