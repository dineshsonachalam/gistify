import java.io.*;
import java.util.*;
class solution
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        String no = "";
        String next_no ="";
        int counter = 1;
        for(int i=0;i<s.length();i++)
        {
            int n1;
            int n2;
            for(int j=i+1;j<(counter+j);j++)
            {
                char a = s.charAt(j);
                next_no+=String.valueOf(a);
            }
            no+=s.charAt(i);
            n1= Integer.parseInt(no);
            n2 = Integer.parseInt(next_no);
            if((n-1)==n2 || (n-2)==n2)
            {
                next_no = 0;
                for(int j=i+1+1;j<(counter+j);j++)
                {
                    char a = s.charAt(j);
                    next_no+=String.valueOf(a);
                }
                n2 = Integer.parseInt(next_no);
                if((n-1)==n2 || (n-2)==n2)
                {
                  break;
                }
            }
            else
            {
                next_no = "";
            }
            System.out.print("N1:"+n1+" "+"N2:"+n2);
        }
    }
}
