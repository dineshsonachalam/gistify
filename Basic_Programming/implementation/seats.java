import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class solution
{

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for (int x=0;x<n;x++)
        {

        int no = scan.nextInt();
        //to find which column no belongs
        int max = 0; //max element in the no column
        int column_count = 1;
        int temp = 6; //no =19
        while((temp<=no) && no>6)
        {
          temp+=6;
          column_count++;
          if(temp==no)
          {
            max = temp;
            break;
          }
          else if(temp>no)
          {
            max = temp;
            break;
          }
        }
        int no_pos;
        if(no>6)
        {
          no_pos = (max-no)+1;
        }
        else
        {
          no_pos = no; //ascending order
          max = 6;
        }

      //  System.out.println("MAX:"+max);
      //  System.out.println("No Pos:"+no_pos);
    //    System.out.println("column_count:"+column_count);
  //  System.out.println("column_count:"+column_count);
        //finding next element if column_count =odd
        if(column_count%2!=0)
        {
            int diff = max - no;
            int next_start = max + 1;
            int next_no = next_start +diff;
            System.out.print(next_no+" ");
        }
        else
        {
          int diff = max - no;
          int next_start = (max-12) + 1;
          int next_no = next_start +diff;
          System.out.print(next_no+" ");
        }

        if( (no_pos==6) || (no_pos==1))
        {
          System.out.print("WS");
        }
        else if( (no_pos==5) || (no_pos==2))
        {
          System.out.print("MS");
        }
        else if( (no_pos==4) || (no_pos==3))
        {
          System.out.print("AS");
        }
        System.out.println();


      }
    }
}
