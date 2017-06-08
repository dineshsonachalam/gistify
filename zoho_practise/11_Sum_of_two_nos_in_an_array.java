import java.io.*;
import java.util.*;
class solution
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int t =scan.nextInt();
        for (int x=0;x<t ;x++ ) {

        int a1 = scan.nextInt();
        int b2 = scan.nextInt();
        int max = (a1>b2)?a1:b2;
        int[] a = new int[max];
        int[] b = new int[max];
        int[] c = new int[max];
        // intializing both the arrays a[] & b[] to 0
        for (int i=0;i<max;i++)
        {
            a[i] = 0;
            b[i] = 0;
            c[i] = 0;
        }
        int size_a = max - a1;
        int size_b = max - b2;
        for(int i=0;i<a1;i++)
        {
          a[size_a] = scan.nextInt();
            /*
              input 1 2 3
              a[2] = 1
              a[1] = 2
              a[0] = 3
            */
            size_a++;
        }

        for(int i=0;i<b2;i++)
        {
          b[size_b] = scan.nextInt();
            /*
              input 1 2 3
              a[2] = 1
              a[1] = 2
              a[0] = 3
            */
            size_b++;
        }
        int carry = 0;
        int counter = 0;
        for(int i=max-1;i>=0;i--)
        {
            int sum = (a[i]+b[i]) + carry;
            if(sum>9) // there exists a carry
            {
                  carry = sum/10; // you will get quotient
                //  System.out.println("Carry:"+carry);
                //  System.out.print(sum%10); // u will get remainder
                  c[i] = sum%10;
            }
            else if(sum<10)
            {
                c[i] = sum;
          //      System.out.print(sum);
                carry = 0 ;
            }

        }
      //  System.out.println();
      if(carry>0)
    {
      System.out.print(carry+" ");
    }
        for(int i=0;i<max;i++)
        {
            System.out.print(c[i]+" ");
        }



      }




    }
}
