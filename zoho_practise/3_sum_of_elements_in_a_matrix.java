import java.io.*;
import java.util.*;
class solution
{
  public static void main(String args[])
  {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    for(int j=0;j<t;j++)
    {
        int sum = 0;
        int r = scan.nextInt();
        int c = scan.nextInt();
        for(int i= r*c;i>0;i--)
        {
            int temp = scan.nextInt();
            sum+=temp;
        }
        System.out.println(sum);
    }
  }
}
