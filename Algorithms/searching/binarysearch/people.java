import java.io.*;
import java.util.*;
class solution
{
  public static void main(String[] args)
  {
      Scanner scan = new Scanner(System.in);
      int n= scan.nextInt();
      int[] a= new int[n]; //soldier power
      for(int i=0;i<n;i++)
      {
        a[i] = scan.nextInt();
      }
      int  b = scan.nextInt(); //total battles
      for (int i=0;i<b;i++)
      {
          int count = 0;
          int sum = 0;
          int no = scan.nextInt();
          for(int j=0;j<n;j++)
          {
            if(a[j]<=no)
            {
              sum+=a[j];
              count+=1;
            }
          }
            System.out.println(count+" "+sum);
      }

  }
}
