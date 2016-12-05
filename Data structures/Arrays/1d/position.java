import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
class solution
{
  public static void main(String[] args) {
    
    Scanner scan = new Scanner(System.in);
    int l=scan.nextInt();
    for (int k=0;k<l ;k++ )
    {


    int n=scan.nextInt();
    int[] a = new int[n+1];
    for (int i=1;i<=n ;i++ )
    {
        a[i]=scan.nextInt();
    }
    int[] b = new int[10000];
    for (int i=1;i<=n ;i++ )
    {
        int front=0;
        int behind=0;
        int temp =i;
        int temp1 =i;
        //calculating front

        while ((temp!=0))
        {
          int t =temp;

            if(temp==1)
            {
              //do nothing
              temp--;

            }
            else if( (a[i]) > (a[t-1]) )
            {
              front++;
              temp--;


            }
            else if ( (a[i]) <= (a[t-1]) )
            {
                front++;

                break;

            }

          }

          //now logic for behind

          while ((temp1!=n+1))
          {
            int t =temp1;

              if(temp1==n)
              {
                //do nothing
                temp1++;

              }
              else if( (a[i]) > (a[t+1]) )
              {
                behind++;
                temp1++;


              }
              else if ( (a[i]) <= (a[t+1]) )
              {
                  behind++;

                  break;

              }

            }



        //    System.out.println(a[i]+" : "+front);
        //    System.out.println(a[i]+" : "+behind);

            int x = front+behind;
            int p = i;
            b[i] =(x*p);
          //  System.out.println();
          }
      //    System.out.println("b values:");
          //index of the winner with max points
          int pos = 0;
          int max = b[1];
        for (int i=1;i<=n ;i++ )
        {
            if(b[i]>max)
            {
              max = b[i];
              pos = i;
            }
        //    System.out.println(b[i]);
        }
        System.out.println(pos);

      }
    }
}
