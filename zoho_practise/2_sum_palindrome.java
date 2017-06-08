import java.io.*;
import java.util.*;
class solution
{
    public static void main(String[] args)
    {
         Scanner scan = new Scanner(System.in);
         int no = scan.nextInt();

         for(int  i=0;i<no;i++)
         {
            int counter = 5;
            int n = scan.nextInt();
            boolean b = false;
            while(counter>0)
          {
            int sum =0 ;
            int r;
            int temp = n;
            /*
                Check whether the given no is a palindrome
            */
            while(n>0)
            {
                r = n%10; //remainder
                sum =(sum*10)+r; //reverse no
                n = n/10; // elemnting last no
            }
            if(sum==temp)
            {
              System.out.println(sum);
              b = true;
              break;
            }
            else
            {
                n = sum + temp; /* reversed + original value*/
                int final_val_palindrome = n;
                sum = 0;
                r = 0;
                temp = n;
                /*Check if it a palindrome*/
                if(counter == 1)
              {
                while(n>0)
                {
                    r = n%10; //remainder
                    sum =(sum*10)+r; //reverse no
                    n = n/10; // elemnting last no
                }
                if(sum==temp)
                {
                  System.out.println(final_val_palindrome);
                  b = true;
                  break;
                }
              }
                //System.out.println("N:"+n);
            }
              counter--;
          }
          if(b == false)
          {
            System.out.println("-1");
          }

        }
    }
}
