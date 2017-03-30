import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.*;

class solution {
    public static void main(String args[] ) throws Exception {
        Scanner scan = new Scanner(System.in);

        double a = scan.nextDouble();
        double b = scan.nextDouble();

        int count = 0;
        //int a =scan.nextInt();
        //int b = scan.nextInt();
        double big;
        if(a<b)
        {
            big = a;
        }
        else
        {
            big = b;
        }

        for(double i=1;i<=big;i++)
        {
            if( a%i==0 &&  b%i==0 )
            {
                count++;
            }
        }
        System.out.println(count);
    }
}
