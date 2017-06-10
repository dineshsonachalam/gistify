import java.io.*;
import java.util.*;
class solution
{
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the depth of the pascal triangle:");
        int n = scan.nextInt();
        int[][] a = new int[n][n]; /* 2D array that stores previously generated values */
        /*
            i--> stands for i rows
            j--> stands for j columns
        */
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<=i;j++)
            {
                if( j==i || j==0 ) //for inital starting and ending should be 1
                {
                    a[i][j] = 1;
                    //System.out.print(a[i][j]+" ");
                }
                else // other values are sum of the values just above and left of above
                {
                    a[i][j] = a[i-1][j-1] + a[i-1][j];

                }
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }

    }
}
