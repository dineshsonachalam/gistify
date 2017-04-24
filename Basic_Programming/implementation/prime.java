import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        if(n>1)
        {
          for (int i=2;i<=n;i++)
          {
              int no = i;
              int flag = 0;
              for(int j=2;j<no;j++)
              {
                if(no%j==0)
                {
                  flag = 1;
                  break;
                }
              }
              if (flag==0)
              {
                  System.out.print(i+" ");
              }
          }
        }

    }
}
