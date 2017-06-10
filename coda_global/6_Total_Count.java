import java.io.*;
import java.util.*;
class solution
{
    public static void main(String[] args)
    {
      Scanner scan = new Scanner(System.in);
      int t = scan.nextInt();
      for(int i=0;i<t;i++)
      {

        int total_count = 0;
        int n = scan.nextInt();
        int k = scan.nextInt();
        for(int j=0;j<n;j++)
      {
        int no = scan.nextInt();
        int sum = 0 ;
        int count = 0;
      //  System.out.println("Enter K:");

        while(sum<no)
        {
            sum+=k;
            count++;
        }
        total_count+= count;
      }
        //System.out.println(count);
          System.out.println(total_count);
      }

    }
}
