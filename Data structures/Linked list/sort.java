import java.io.*;
import java.util.*;
class solution
{
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int[][] a= new int [n][n];
    System.out.println("Sorting the nos");
    for(int i=0;i<n;i++)
    {

      a[i][0] = scan.nextInt();

      int temp = 0;
      // 1. Checking if its a perfect square
      int no = a[i][0];
      int sqrt = (int) Math.sqrt(no);
      if(sqrt*sqrt == no)
      {
          temp+=5;
      }
      // 2. Checking if its a multiple of 4 and divisble by 6
      if((no%4==0) && (no%6==0))
      {
        temp+=4;
      }
      // 3. Checking if its a even number
      if(no%2==0)
      {
        temp += 3;
      }
      a[i][1] = temp;

    }

    int size = n-1;
    for(int i=0;i<=size-1;i++)
    for (int j=i+1;j<=size;j++)
    {
        if(a[i][1]>a[j][1])
        {
            int temp = a[i][1];
            a[i][1] = a[j][1];
            a[j][1] = temp;

            int temp1 = a[i][0];
            a[i][0] = a[j][0];
            a[j][0] = temp1;
        }
        else if(a[i][1] == a[j][1])
        {
          if(a[i][0]>a[j][0])
          {
            int temp1 = a[i][0];
            a[i][0] = a[j][0];
            a[j][0] = temp1;
          }
        }
    }
    System.out.println("Sorted elements are:");
    for (int i=size;i>=0;i--)
    {
        System.out.println(a[i][0]);
    }


  }



}
