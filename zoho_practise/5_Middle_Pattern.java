import java.io.*;
import java.util.*;
class solution
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int n =scan.nextInt();
        for(int j=0;j<n;j++)
      {
        String s = scan.next();
        int spaces = ((s.length() - 1)*2);
        String v= "";
        char[] c = s.toCharArray();
        int mid = s.length()/2;
        int mid_forward = mid;
        int front_forward = 0;
        while( (mid_forward < s.length()) || (front_forward<mid) )
        {
            for (int i=0;i<spaces ;i++ )
            {
                System.out.print(" ");
            }

            if(mid_forward<s.length())
            {
                char temp1 = c[mid_forward];
                v+= String.valueOf(temp1);
                mid_forward++;
            }
            else
            {
                char temp2 = c[front_forward];
                v+= String.valueOf(temp2);
                front_forward++;
            }
            System.out.print(v);
            spaces = spaces - 2;
            System.out.print("$");

        }
          System.out.println();
      }
    }
}
