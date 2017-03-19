import java.io.*;
import java.util.*;

class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan= new Scanner(System.in);
        int t= scan.nextInt();
        for(int i=0;i<t;i++)
        {
            int m=scan.nextInt();
            int n=scan.nextInt();
            int[] a= new int[n+1];
            for(int j=1;j<=n;j++)
            {
                a[j]=scan.nextInt();
            }
            //now we have to find the position
            for(int x=1;x<=n;x++)
            {
                for(int y=x+1;y<=n;y++)
                {
                    if(a[x]+a[y]==m)
                    {
                        System.out.println(x+" "+y);
                        break;
                    }

                }
            }

        }
    }
}
