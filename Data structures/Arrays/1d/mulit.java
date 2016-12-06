import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
class solution
{
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		int y = scan.nextInt();
		int[][] a = new int[x][y]; //x->row y->
	//	int[][] b = new int[y][x];
		for(int i=0;i<x;i++)
		{
			for(int j=0;j<y;j++)
			{
				a[i][j] =scan.nextInt();
				b[j][i]=a[i][j];
			}
		}
			for(int i=0;i<x;i++)
		{
			for(int j=0;j<y;j++)
			{
				System.out.print(b[i][j]+" ");
			}
			System.out.println();
		}


	}
}
