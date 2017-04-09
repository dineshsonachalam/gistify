import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
class solution
{
    public static void main(String[] args)
    {
      Scanner scan = new Scanner(System.in);

      int t = scan.nextInt();
      for (int j=0;j<t;j++)
      {
            BigInteger n = scan.nextBigInteger();
            BigInteger i = new BigInteger( newValue );
            System.out.println("I:"+i);
          //  BigInteger  bi2 = new BigInteger("3");
          //  BigInteger  k = n.divide(bi2);
          //  System.out.println(k);
            //getting BigInteger

/*

BigInteger i = BigInteger.valueOf(100000L);  // long i = 100000L;
i.compareTo(BigInteger.ONE) > 0              // i > 1
i = i.subtract(BigInteger.ONE)               // i = i - 1



            BigInteger k;

            for(k=n;k>=0;k--)
            {
              BigInteger i,m;
               i = k;
               m = 0;
              int f1 = 0;
              int flag=0;
                    while(i>0) //no 123
                  {
                      if(f1==0)
                      {
                          m = i%10; //remainder 3
                        //  System.out.println("M1:"+m);
                          i = i/10; //quotient 12
                          f1=1;
                      }
                      else if(f1!=0)
                      {
                        int x = i%10; //remainder 2
                        if(m>=x) //3>=2
                        {
                         i=i/10;
                         m =x;
                      //   System.out.println("M2: "+m);
                         if((i/10)<0 && flag==0)
                         {
                        //     System.out.println(i);
                         }
                        }
                        else
                        {

                          flag =1;
                          break;
                        }
                      }

                    }
              if(flag==0)
              {
                                //    Case #1: 129
              System.out.println("Case #" + (j+1) + ": "+k);
                break;
              }
            }
            */
      }


    }
}
