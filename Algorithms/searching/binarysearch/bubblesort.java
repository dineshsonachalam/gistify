import java.util.*;
import java.io.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
       Scanner scan = new Scanner(System.in);
       int n =scan.nextInt();
       int sum = 0;
       for(int i=0;i<n;i++)
       {
           int temp = scan.nextInt();
           sum+=temp;
       }
       int p = scan.nextInt();
       int count = 0;
       for(int i=0;i<p;i++)
       {
           int temp = scan.nextInt();
           count+=temp; //patient
       }
       if(sum>count)
       {
           System.out.println("Yes");
       }
       else
       {
           System.out.println("No");
       }


    }
}
