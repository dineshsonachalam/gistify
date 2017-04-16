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

       char x1[] = pass.toCharArray();
       Arrays.sort(x1);
       pass = "";
       for(int i=0;i<pass_length;i++)
       {
         pass+=x1[i];
       }




       for (int r=0;r<combination_length;r++)
       {
         int counter = 0;
         String str = "";
         while(counter<pass_length)
         {
           str+=seq.charAt(counter+r);
           counter++;
         }
         //now sort str
         char x2[] = str.toCharArray();
         Arrays.sort(x2);
         str = "";
         for(int i=0;i<pass_length;i++)
         {
           str+=x2[i];
         }
      //   System.out.println(str);
         if(str.contains(pass))
         {
           count++;
        //   System.out.println(str);
         }


       }
       System.out.println(count);
    }
}
