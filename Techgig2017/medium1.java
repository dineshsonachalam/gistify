import java.util.*;
import java.io.*;

class solution {

    public static void main(String args[] ) throws Exception {
       Scanner scan = new Scanner(System.in);
       int pass_length = scan.nextInt();
       int seq_length = scan.nextInt();
       String pass = scan.next();
       String seq = scan.next();
       int combination_length = (seq_length - pass_length) + 1;
       int count = 0;
       for (int r=0;r<combination_length;r++)
       {
         int counter = 0;
         String str = "";
         while(counter<pass_length)
         {

           str+=seq.charAt(counter+r);
           counter++;
         }
      //   System.out.println(str);
         if(str.contains(pass))
         {
           count++;
           System.out.println(str);
         }


       }
       System.out.println(count);
    }
}
