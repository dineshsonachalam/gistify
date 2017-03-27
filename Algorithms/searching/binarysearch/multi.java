import java.io.*;
import java.util.*;
class solution
{
  public static void main(String[] args)
  {
      Scanner scan = new Scanner(System.in);
      System.out.println("Enter size of r1 and c1 of 1st matrix");
      int r1 = scan.nextInt();
      int c1 = scan.nextInt();
      int[][] a= new int[r1][c1];
      for(int i=0;i<r1;i++)
      {
        for (int j=0;j<c1;j++)
        {
          a[i][j] = scan.nextInt();
        }
      }
      System.out.println("Enter size of r2 and c2 of 2nd matrix");

      int r2 = scan.nextInt();
      int c2 = scan.nextInt();
      int[][] b= new int[r2][c2];
      for(int i=0;i<r2;i++)
      {
        for (int j=0;j<c2;j++)
        {
          b[i][j] = scan.nextInt();
        }
      }
      //now check condition

      if(c1!=r2)
      {
        System.out.println("MUltiplication not possible");
      }

        int[][] sum_e = new int[100][100];
        for (int i=0;i<r1;i++)
        {
            int sum =0;
            for(int j=0;j<c2;j++)
            {
                for (int k=0;k<r2;k++)
                {
                    sum= sum+a[i][k]*b[k][j]; //first i rows & k columns-> matrix A

                }
                sum_e[i][j] = sum;
                System.out.print(sum_e[i][j]+" ");

                sum = 0;
            }
            System.out.println();
        }


  }
}
