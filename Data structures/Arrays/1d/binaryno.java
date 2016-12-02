import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
class solution
{
  public int BinaryToDecimal(int binary)
  {
    int decimal = 0;
    int power=0;
    while(binary!=0)
    {
      int rem = binary%10;
      decimal =(int)(decimal+rem*Math.pow(2,power));
      binary = binary/10;
      power++;
    }
    return decimal;
  }

  public static void main(String[] args)
  {

  //  char a[100];
    Scanner scan = new Scanner(System.in);
    int n=scan.nextInt();
    int q =scan.nextInt(); //no of queries

    //get the nos in the array
    int[] a= new int[10000000];

    for (int i=1;i<=n;i++)
    {
          a[i]= scan.nextInt();

    }


    for (int u=0;u<q;u++)
    {
        String s = new String();
        int binary;



        //now check the query input
        int q_i=scan.nextInt();
        if(q_i==1) //1-->flipping the bits
        {
            int k=scan.nextInt(); //the position to flip
            if(a[k]==1)
            {
              a[k]=0;
            }
            else
            {
              a[k]=1;
            }

        }
        else //here we have to display the no is odd or even
        {
              int l=scan.nextInt(); //left position
              int r =scan.nextInt(); //right position

              for (int i=l;i<=r;i++)
              {

                int temp = a[i];
                //converting the array of no into a string
                s += Integer.toString(temp);
              }
              //convert the string into no
              binary =Integer.parseInt(s);
          //    System.out.println("Binary:"+binary);

              solution sol = new solution();
              int no =  sol.BinaryToDecimal(binary);
          //    System.out.println("Decimal:"+no);
              if(no%2==0)
              {
                System.out.println("EVEN");
              }
              else {
                System.out.println("ODD");
              }

        }
    }


  }
}
