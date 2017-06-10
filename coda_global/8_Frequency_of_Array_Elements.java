import java.io.*;
import java.util.*;
class solution
{
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int i=0;i<t;i++) //test cases
        {
            int n = scan.nextInt();
            int[] a = new int[n]; // a-array
            for(int j=0;j<n;j++)
            {
              a[j] = scan.nextInt();
            }
            Arrays.sort(a);
            int max = a[n-1]; // max
            int[] b = new int[n];
            /*
              Initailize the matrix b to 0
            */
            for(int j=0;j<max;j++)
            {
                b[j] = 0;
            }

            for (int k=0;k<n ;k++)
            {
                //a[k] = scan.nextInt();
                for (int l=1;l<=max;l++)
                {
                    if(a[k] == l)
                    {
                        b[l-1]++;
                    }
                }
            }
            for (int j=0;j<n;j++)
            {
                System.out.print(b[j]+" ");
            }
            System.out.println();
        }
    }
}
