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
          int size = i+1+counter;
            for(int j=i+1;(j<size)&&(j<s.length());j++)
            {
                char a = s.charAt(j);
                next_no+=String.valueOf(a);
            }
            no+=s.charAt(i);

            n1= Integer.parseInt(no);
            n2 = Integer.parseInt(next_no);


            if((n1-1)==n2 || (n1-2)==n2)
            {

                next_no = "";
                int size1 = i+1+counter;
                for(int j=i+1;(j<size1)&&(j<s.length());j++)
                {
                      char a = s.charAt(j);
                      next_no+=String.valueOf(a);
                }
                n2 = Integer.parseInt(next_no);

                if(n1>2)
                {
                if((n1-1)==n2 || (n1-2)==n2)
                {

                  break;
                }
              }
            }


            next_no ="";
            counter++;
        }

        int no_start = Integer.parseInt(no);

        int no_length = no.length();
        int size_array = s.length()/no_length;
        int[] b = new int[size_array];
        b[0] = no_start;
        int counter2 = 1;
        for(int i=no_length;i<s.length();i=i+no_length)
        {
            int temp_size = i+no_length;
            String temp = "";
            for(int j=i;j<temp_size;j++)
            {
                char a = s.charAt(j);
                temp+=String.valueOf(a);
            }
            b[counter2] = Integer.parseInt(temp);
            counter2++;

        }
/*
        for(int i=0;i<size_array;i++)
        {
            System.out.println(b[i]);
        }
*/
        Arrays.sort(b);
        //To find the remaining element
        int start = b[0];
        int end = b[size_array-1];
        int counter3 = 0;
        for(int i=start;i<=end;i++)
        {
            if(b[counter3] == i)
            {
                //do nothing
                //System.out.println(b[counter3]+"---->"+i);
            }
            else
            {
                //element not present
                System.out.println(i+"-->Element not present");
                break;
            }
            counter3++;
        }
    }
}
