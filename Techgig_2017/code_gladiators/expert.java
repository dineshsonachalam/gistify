import java.util.*;
import java.io.*;

class solution {

    public static void main(String args[] ) throws Exception {
       Scanner scan = new Scanner(System.in);
       int m = scan.nextInt(); // m-->rows
       int n = scan.nextInt(); // n-->columns
       int[][] a = new int[m][n];

       //sum of rows and columns
       int row_sum = 0;
       int flag = 0;
       int prev_row = 0;
       for(int i=0;i<m;i++)
       {
         prev_row = row_sum;

         row_sum = 0;
         for (int j=0;j<n;j++)
         {
            a[i][j] = scan.nextInt();
            if(flag!=1)
            {
              row_sum =  row_sum + a[i][j];
            }
         }
         if( (prev_row!=row_sum) && i!=0 )
         {
            flag = 1;
          //  System.out.println("Rows are not equal");
          System.out.println("0");
            break;
         }
      //   System.out.println("Prev_Sum:"+prev_row+"  For i:"+i);
      //   System.out.println("Row_Sum:"+row_sum+"  For i:"+i);

       }
/*
       if( flag==0 )
       {
         System.out.println("All the rows are  equal");

       }
       else {
         System.out.println("They are not equal");
       }
       System.out.println();
       System.out.println();
*/
      //now for finding column sum

      int col_sum = 0;
      int prev_col = 0;

      for(int i=0;i<m;i++)
      {
        prev_col = col_sum;

        col_sum = 0;
        for (int j=0;j<n;j++)
        {

           if(flag!=1)
           {
             col_sum =  col_sum + a[j][i];
           }
        }
        if( (prev_col!=col_sum) && i!=0 )
        {
           flag = 1;
          // System.out.println("Rows are not equal");
          System.out.println("0");
           break;
        }
      //  System.out.println("Prev_Col:"+prev_col+"  For i:"+i);
      //  System.out.println("Col_Sum:"+col_sum+"  For i:"+i);

      }

      if( flag==0 )
      {
        System.out.println("1");

      }
      /*
      else {
        System.out.println("The cols are not equal");
      }
*/

    }
}
