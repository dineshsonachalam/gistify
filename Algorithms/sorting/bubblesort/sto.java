import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.*;

class solution {
    public static void main(String args[] ) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int min = 0;
        int sum = 0;
        int[] a = new int[n];
        int[] b = new int[n];
        for(int i=0;i<n;i++)
        {
            a[i] = scan.nextInt();
            sum+=a[i];
        }
        int j =0;
        for(int i=0;i<n;i++)
        {
            if( (a[i]*n)>sum )
            {
               b[j] = a[i];
               if(min<=0)
               {
                 min =b[j];
                 continue;
               }
               else if( (b[j]*n) <= min )
               {
                 min = b[j];
               }
               j++;
            }
        }

      System.out.println(min);

    }
}
