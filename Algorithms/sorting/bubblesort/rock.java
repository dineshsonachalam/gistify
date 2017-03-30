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
        for(int i=0;i<n;i++)
        {
            a[i] = scan.nextInt();
            sum+=a[i];
        }
        int flag = 0;
        for(int i=0;i<n;i++)
        {
            if( (a[i]*n)>sum )
            {
                if(min==0 && flag ==0)
                {
                    min=a[i];
                    flag =1;
                    //System.out.println("Minimum1:"+min);
                }
                else if( (a[i]*n) <min)
                {
                    min = a[i];
                    System.out.println("Minimum2:"+min);
                }
            }
        }
        System.out.println(min);

    }
}
