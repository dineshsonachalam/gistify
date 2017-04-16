public static int SolveMagicSquare(int[][] input1)
{
//Write code here
int l =input1.length;

 int m = l; // m-->rows
   int n = l; // n-->columns
   int[][] a = new int[m][n];

   //sum of rows and columns
   int row_sum = 0;
   int flag = 0;
   int prev_row = 0;

   if(m!=n) //rows! = columns(sudoku formation is not possible)
   {
       return 0;
   }

   for(int i=0;i<m;i++)
   {
     prev_row = row_sum;

     row_sum = 0;
     for (int j=0;j<n;j++)
     {
        a[i][j] = input1[i][j];
        if(flag!=1)
        {
          row_sum =  row_sum + a[i][j];
        }
     }
     if( (prev_row!=row_sum) && i!=0 )
     {
        flag = 1;
      //  System.out.println("Rows are not equal");
        return 0;

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

int[] x = new int[m]; //m rows

for(int i=0;i<m;i++)
{
x[i] = a[0][i]; // containing First row values--->used for checking
         //  if all the elements are present in the matrix.
}

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
       //check if all the elemnts are present in the matrix
//<------------------------function starts here--------------------------------------->
       if(flag!=1)
       {
         int f1= 0;

         for(int r=0;r<m;r++)
        {
           if(f1==0)
         {
           if(a[j][i] == x[r])
           {
             flag = 0;
             f1 = 1;
           }
           else
           {
             flag = 1;
           }
         }
       }
       }
//<--------fuction ends here------------------------------------------->
    }
    if( (prev_col!=col_sum) && i!=0 )
    {
       flag = 1;
      // System.out.println("Rows are not equal");
      return 0;

    }
  //  System.out.println("Prev_Col:"+prev_col+"  For i:"+i);
  //  System.out.println("Col_Sum:"+col_sum+"  For i:"+i);

  }

  if( flag==0 )
  {
    return 1;

  }
  else {
    return 0;
  }


}
