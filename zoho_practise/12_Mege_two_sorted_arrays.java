import java.io.*;
import java.util.*;
class solution
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int j=0;j<t;j++)
        {
        int m1 = scan.nextInt();
        int m2 = scan.nextInt();
        int[] a = new int[m1] ; // a array
        int[] b = new int[m2] ; // b array
        int[] c = new int[m1+m2]; // c array
        int counter = 0;

        for (int i=0;i<m1;i++)
        {
            a[i] = scan.nextInt();
            c[counter] = a[i];
            counter++;

        }
        for(int i=0;i<m2;i++)
        {
            b[i] = scan.nextInt();
            c[counter] = b[i];
            counter++;

        }
        Arrays.sort(c);
        /*
        for(int i=0;i<count_zero;i++)
        {
            System.out.print("0"+" ");
        }
        */
        for(int i=(m1+m2)-1;i>=0;i--)
        {
            System.out.print(c[i]+" ");
        }
      }
    }
}
