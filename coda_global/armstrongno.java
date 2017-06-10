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
        int n = scan.nextInt();
        int temp = n;
        int sum = 0;
        while(n>0)
        {
            int r= n%10; //remainder
            sum+= (r*r*r);
            n = n/10;
        }
        if(temp == sum)
        {
          System.out.println("Yes");
        }
        else
        {
          System.out.println("No");
        }
      }
    }
}
