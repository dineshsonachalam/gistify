/*
LEAP YEAR CONDITION:
1) year is divisible  by 400
2) year is divisible by 4 and not a multiple of 100

*/
import java.io.*;
import java.util.*;
class solution
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int  n = scan.nextInt();
        if(n%400==0)
        {
          System.out.println(n+" "+"is a leap year");
        }
        else if(n%100!=0 && n%4==0)
        {
          System.out.println(n+" "+"is a leap year");
        }
        else
        {
          System.out.println(n+" "+"is not a leap year");
        }

    }
}
