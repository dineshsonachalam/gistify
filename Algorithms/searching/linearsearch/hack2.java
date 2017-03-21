import java.io.*;
import java.util.*;

class solution {
    public static void main(String args[] ) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n =scan.nextInt();
        int p = scan.nextInt(); //alice choice of choosing from list
        int q = scan.nextInt(); //Bob choice of choosing from list
        int[] a= new int[p];
        int[] b = new int[q];
        int size_sum = 0;

        if(p>q)
        {
          size_sum = p;
        }
        else
        {
            size_sum = q;
        }
          int[] sum =new int[size_sum+1];
        for(int i=0;i<p;i++)
        {
          a[i] = scan.nextInt();
        }
        for(int i=0;i<q;i++)
        {
          b[i] = scan.nextInt();
        }

        int count = 0;
        for(int i=0;i<p;i++)
        {
          for (int j=0;j<q;j++)
          {
              sum[count] =(a[i]+b[j]);
          //    System.out.println("sum:"+sum[count]);
          count+=1;


          }
        }
      /*  for(int i=0;i<count;i++)
        {
        //  System.out.println("sum:"+sum[i]);
        }
        */
        int count2 = 0;
        int[] no = new int[100000];

        for(int i=0;i<p;i++) //alice
        {
            int flag2 = 0;
            for(int j=0;j<size_sum;j++) //sum size
            {
              if( (a[i]+sum[j])%n !=0 )
              {

              }
              else
              {
                flag2 = 1;
              }
            }
            if(flag2==0)
            {
              no[count2] = a[i];
              System.out.println("Numbers:"+no[count2]);
              count2++;
            }
        }

        //System.out.println("after b");

        for(int i=0;i<q;i++) //bob
        {
            int flag2 = 0;
            for(int j=0;j<size_sum;j++) //sum size
            {
              if( (b[i]+sum[j])%n !=0 )
              {

              }
              else
              {
                flag2 = 1;
              }
            }
            if(flag2==0)
            {
              no[count2] = b[i];
              System.out.println("Numbers:"+no[count2]);
              count2++;
            }
        }
        
      //  int[] h = new int[count2]; //for storting the count2 values
        /*
        for(int i=0;i<count2;i++)
        {
          h[i] = no[i];
        //  System.out.println("H[i]="+h[i]);
        }
        Arrays.sort(h);

      //  System.out.println(h[0]);
*/

    }
}
