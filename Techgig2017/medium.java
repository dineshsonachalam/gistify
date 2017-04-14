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

       //basic permutation of password

       //factorial
       int fact = 1;
       int ptr = 0;
       int x = pass_length;
       while(x>1)
       {
         fact = fact*x;
         x=x-1;
       }
     //Converting password to char Array
     char[] a = pass.toCharArray();
     int count = 0;
       for (int r=0;r<combination_length;r++)
       {
         int counter = 0;
         String str = "";
         while(counter<pass_length)
         {
           // System.out.print(seq.charAt(counter+i));
           str+=seq.charAt(counter+r);
           counter++;
         }
      //   System.out.println(str);

         //permutation of password
         String perm = "";
         for(int i = 0 ;i<fact;i++)
         {

           if((ptr+1) == pass_length)
           {
             ptr = 0;
           }
          //swap
          char temp = a[ptr];
          a[ptr] = a[ptr+1];
          a[ptr+1] = temp;
          for(int j=0;j<pass_length;j++)
          {
             //System.out.print(a[j]);
             perm+=a[j];
          }
             System.out.println(perm+"_____________"+str);
             ptr++;

             if(perm.equals(str))
             {
               System.out.println();
               System.out.println("Matches:"+perm);
               count++;
             }

             perm =""; //empty the permutation string

         }
         //permutation ends here
         System.out.println();

       }
       System.out.println(count);
    }
}
