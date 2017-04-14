import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
class solution {
    /*
     * Complete the function below.
    */
    public static int GetJumpCount(int input1,int input2,int[] input3)
       {
           int x = input1;
           int y = input2;
           int count = 0;
           int sum = 0;
           for(int i = 0;i<input3.length;i++)
           {
               while(sum<input3[i])
               {
                   sum+=x;
                   if(sum>=x)
                   {
                       count++;
                       break;
                   }
                   sum = sum - y;
                   count++;
               }
               sum = 0;
           }
           System.out.println(count);
           return count;

         }
       public static void main(String[] args) throws IOException{
             Scanner in = new Scanner(System.in);
             int output = 0;
             int ip1 = Integer.parseInt(in.nextLine().trim());
             int ip2 = Integer.parseInt(in.nextLine().trim());
             int ip3_size = 0;
             ip3_size = Integer.parseInt(in.nextLine().trim());
             int[] ip3 = new int[ip3_size];
             int ip3_item;
             for(int ip3_i = 0; ip3_i < ip3_size; ip3_i++) {
                 ip3_item = Integer.parseInt(in.nextLine().trim());
                 ip3[ip3_i] = ip3_item;
             }
             System.out.println(ip1+"   "+ip2+"   "+);
            // output = GetJumpCount(ip1,ip2,ip3);
             System.out.println(String.valueOf(output));
         }
     }
