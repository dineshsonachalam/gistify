import java.io.*;
import java.util.*;
class solution
{
    public int power(int n)
    {
        int no = 1;
        if(n==0)
        {
           return 1;
        }
        for(int i=0;i<n;i++)
        {
            no = no*2;
        }
        return no;
    }
    public static void main(String[] args)
    {
       Scanner scan = new  Scanner(System.in);
       solution obj = new solution();
       String s = scan.next();
       int length = s.length();
       int sum = 0;
       int counter = 0;
       for(int i=s.length()-1;i>=0;i--)
       {
          int a= Character.getNumericValue((s.charAt(i)));
          int p = obj.power(counter);
          sum+= (a*p);

          counter++;
       }
       System.out.println(sum);
    }
}
