import java.util.*;
import java.io.*;

class solution {

    public static void main(String args[] ) throws Exception {
       Scanner scan = new Scanner(System.in);
       int n = scan.nextInt(); // password length
       int s = scan.nextInt(); // sequence length
       String a = scan.next(); //password
       String b = scan.next(); //sequence
       String t ="";
       int count = 0;

       for(int x =0;x<s;x++)
      {
       for(int i=x;i<s;i++) //sequence
       {


         int flag = 1;

         for(int j=0;j<n;j++) //password
         {
           int temp = b.charAt(i);

           if( a.charAt(j)==temp)
           {
             flag = 0;
             if(t.length() < n )
           {
             t+=a.charAt(j);
            // System.out.println(a.charAt(j));
             break;
           }
           else
           {
             flag = 1;
             break;
           }

           }



         }

         if(flag==1)
         {
           t="";
         }
         if(t.equals(a))
         {
           count++;
         }
         if(t.length()==n)
         {
           System.out.println(t);
           t="";
         }
         else
         {
          // System.out.println(t);
         }


       }
     }
       System.out.println(count);

    }
}
