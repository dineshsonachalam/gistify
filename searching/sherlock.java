import java.io.*;
import java.util.*;

class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int t=scan.nextInt();



      for(int x=0;x<t;x++)
      {
            int n=scan.nextInt();
            int[] a= new int[n];
            int sum=0;
          for (int i=0;i<n;i++)
          {
              a[i]=scan.nextInt();
              sum+=a[i];
          }
        //  System.out.println("sum:"+sum);
          int left=0;
          boolean match=false;
          for (int i=0;i<n;i++)
          {

              sum-=a[i];
              if(left==sum)
            {

                match=true;
                break;
            }
              left+=a[i];
          }
          if(match)
          {
            System.out.println("YES");
          }
          else
          {
            System.out.println("NO");
          }
        }
  }
}
