import java.io.*;
import java.util.*;
class solution
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for (int x=0;x<t;x++)
        {
        int n = scan.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++)
        {
            a[i] = scan.nextInt();
        }
          for(int i=0;i<n-1;i++)
          {
              for(int j=i+1;j<n;j++)
              {
                if(a[i]>a[j])
                {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
              }
          }
          for(int i=0;i<n;i++)
          {
              System.out.print(a[i]+" ");
          }
          System.out.println();
        }

    }
}
