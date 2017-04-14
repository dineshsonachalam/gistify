import java.util.*;
import java.io.*;

class solution {
    //No of possible combination of a string
    //Always to try to implement the program with functions
    public static int combination(String s,int length,int fact)//string,length,fact
    {
        System.out.println("Factorial:"+fact);
        int ptr = 0;
        char[] a = s.toCharArray();
        for(int i = 0 ;i<fact;i++)
        {
          if((ptr+1) == length)
          {
            ptr = 0;
          }
         //swap
         char temp = a[ptr];
         a[ptr] = a[ptr+1];
         a[ptr+1] = temp;
         for(int j=0;j<length;j++)
         {
            System.out.print(a[j]);
         }
           System.out.println();
            ptr++;
        }
        return  fact;

    }
    public static void main(String args[] ) throws Exception {
       Scanner scan = new Scanner(System.in);

       String s = scan.next();
       int length =s.length();
       //factorial
       int fact = 1;
       int x = length;
       System.out.println("x:"+x);
       while(x>1)
       {
         fact = fact*x;

         x=x-1;
       }
      // System.out.println(fact);

      solution ob = new solution();
      int object =ob.combination(s,length,fact); //string,length,fact
      //System.out.println(object);
    }
}
