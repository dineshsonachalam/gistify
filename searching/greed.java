import java.io.*;
import java.util.*;

class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan= new Scanner(System.in);
        int n=scan.nextInt(); // no of flowers to purchase
        int k=scan.nextInt(); // size of your group with you

        int[] a= new int[n];
        int[] b =new int[n];
        for (int i=0;i<n ;i++ )
        {
            b[i]=scan.nextInt();
        }
        Arrays.sort(b);
        int start=0;
        for(int i=n-1;i>=0;i--)
        {
            a[start++]=b[i]; //denotes the cost of the flower
        }
      
        //we have sorted the array
        int count=0;
        int x=0;
        for(int i=0;i<n;i++)
        {
           int sum=0;
           if((i+k)>n)
           {
               for(int j=i;j<n;j++)
               {
                   sum+=a[j];
               }
           }
            else
           {
                for(int j=i;j<i+k;j++)
                {
                    sum+=a[j];
                }
           }
            i=i+k-1;
            count+=sum*((x++)+1);
        }
        System.out.println(count);

    }
}
