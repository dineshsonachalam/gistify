import java.util.*;
import java.lang.*;
import java.io.*;

class solution {
    public void print_spiral(int r2,int c2,int a[][])
    {
        int r1 = 0; //starting row index
        int c1 = 0; //starting column index
        int i; //iterator
        /*
            1. Check start_index<column_index
        */
        while( (r1<r2) &&(c1<c2) )
        {
            /*
                2. Printing the 1st row
            */
            for(i=c1;i<c2;i++)
            {
                System.out.print(a[r1][i]+" ");
            }
            r1++; /* Incrementing the row */
            /*
                3. Printing the last column
            */
            for(i=r1;i<r2;i++)
            {
                    System.out.print(a[i][c2-1]+" ");
            }
            c2--; /*Decrementing the last column*/
            /*
                4. Printing the last row
            */
            if(r1<r2)
            {
                    for(i=c2-1;i>=c1;i--)
                    {
                        System.out.print(a[r2-1][i]+" ");
                    }
            }
            r2--; /* Decrementing the last row*/
            /*
                5. Printing the last column
            */
            if(c1<c2)
            {
                for(i=r2-1;i>=r1;i--)
                {
                    System.out.print(a[i][c1]+" ");
                }
                c1++; /* Incrementing the starting column*/
            }
        }
    }
	public static void main (String[] args)
	{
	    Scanner scan = new Scanner(System.in);
	    int r = 4;
	    int c = 4;
	    int[][] a = new int[r][c];
	    int t = scan.nextInt();
	    for(int l=0;l<t;l++)
	   {
	    for(int i=0;i<r;i++)
	    {
	            for(int j=0;j<c;j++)
	            {
	                a[i][j] = scan.nextInt();
	            }
	    }
	    solution sol = new solution();
	    sol.print_spiral(r,c,a);
	    System.out.println();
	   }
	}
}
