import java.io.*;
import java.util.*;
class solution
{
    public void rotate(int r2,int c2,int a[][],int rotation)
    {
        int row =r2;
        int col = c2;

        System.out.println();
      //  System.out.println();
      for(int t=0;t<rotation;t++)
      {
        int i;
        int r1 = 0; /*starting row*/
        int c1 = 0; /*starting column*/
        r2 = row;
        c2  = col;
        /*
          Initial condition start<end
        */
        int prev;
        int curr;
        while( (r1<r2) && (c1<c2))
        {
            if(r1+1 == r2 || c1+1 == c2)
            {
              break;
            }
            prev = a[r1+1][c2-1];
            /*1. Printing 1st row*/
            for(i=c2-1;i>=c1;i--)
            {
                curr = a[r1][i];
                a[r1][i] = prev;
                prev = curr;
              //  System.out.print(a[r1][i]+" ");
            }
            r1++; /*Incrementing 1st row*/
            /*2. Printing 1st column*/
            for(i=r1;i<r2;i++)
            {
              curr = a[i][c1];
              a[i][c1] = prev;
              prev = curr;
          //    System.out.print(a[i][c1]+" ");
            }
            c1++; /*Incrementing 1st column*/
            if(r1<r2)
            {
                /*3. Printing last row*/
                for(i=c1;i<=c2-1;i++)
                {
                  curr = a[r2-1][i];
                  a[r2-1][i] = prev;
                  prev = curr;
                //  System.out.print(a[r2-1][i]+" ");
                }
            }
            r2--;

            if(c1<c2)
            {
                /* 4. Printing the last column */
                for (i=r2-1;i>=r1;i--)
                {
                    curr = a[i][c2-1];
                    a[i][c2-1] = prev;
                    prev = curr;
                  //  System.out.print(a[i][c2-1]+" ");
                }
            }
            c2--;
        }

        System.out.println();
        System.out.println("Rotation:"+t);
        for (int m=0;m<row;m++)
        {
          for(int n=0;n<col;n++)
          {
              System.out.print(a[m][n]+" ");
          }
          System.out.println();
        }

      }


    }
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        int r= scan.nextInt(); // row
        int c = scan.nextInt(); // column
        int rotation = scan.nextInt(); //no of rotation
        int[][] a= new int[r][c];
        for (int i=0;i<r;i++)
        {
            for (int j=0;j<c;j++)
            {
                a[i][j] = scan.nextInt();
            }
        }
        solution sol = new solution();
        sol.rotate(r,c,a,rotation);

    }
}
