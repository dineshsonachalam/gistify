import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int min = 0;
        int sum = 0;
        int[] a = new int[n];
        for(int i=0;i<n;i++)
        {
            a[i] = scan.nextInt();
            sum+=a[i];
        }
        for(int i=0;i<n;i++)
        {
            if( (a[i]*n)>sum )
            {
                if(min<=0)
                {
                    min=a[i];
                }
                else if( (a[i]*n) <=min && min>0 )
                {
                    min = a[i];
                }
            }
        }
        System.out.println(min);

    }
}
