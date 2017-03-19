import java.io.*;
import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n =scan.nextInt();

        for(int i =0;i<n;i++)
        {
            int count = 0;
            String s = scan.next();
            s = s.toLowerCase();
              //System.out.println(s);
              for(int j=0;j<s.length();j++)
              {
                if(s.charAt(j)=='a'|| s.charAt(j)=='e' ||s.charAt(j)=='i'||
                  s.charAt(j)=='o' || s.charAt(j)=='u'
                )
                {
                  count++;
                }
              }
              System.out.println(count);
        }


    }
}
