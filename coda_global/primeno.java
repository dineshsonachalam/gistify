import java.io.*;
import java.util.*;
class solution
{
    public static void main(String args[])
    {
      Scanner scan = new Scanner(System.in);
      System.out.println("Enter the strating and ending position");
      int start_postn = scan.nextInt();
      int end_postn = scan.nextInt();
      int flag;
      /*
        2,3,5,7...etc is a prime no
        1-->(NOT A PRIMENO)
        A primeno is a no which is divisible by itself and 1

      */
      while(start_postn<=end_postn)
      {
          flag = 0;
          for(int i=2;i<=start_postn/2;i++)
          {
              if(start_postn%i==0)
              {
                flag = 1;
                break;
              }
          }
          if(flag == 0)
          {
            System.out.print(start_postn+" ");
          }
          start_postn++;
      }
    }
}
