import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
class solution
{
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = br.readLine();
    int N = Integer.parseInt(line);
    int[][] mat1 = new int[1001][1001]; //contains count value for all the plots
    int[][] mat2 = new int[1001][1001]; //to find the overlapping position
    for (int t=1;t<=N;t++)
    {
        String[] query = br.readLine().split(" ");
        int x1 = Integer.parseInt(query[0]);
        int y1 = Integer.parseInt(query[1]);
        int x2 = Integer.parseInt(query[2]);
        int y2 = Integer.parseInt(query[3]);
        int c = Integer.parseInt(query[4]);
        for (int i=x1;i<=x2;i++)
        {
            for (int j=y1;j<=y2;j++)
            {
                if(mat1[i][j]!=0)
                {
                  mat2[i][j] = 1; //for finding the overlapping plots
                }
                mat1[i][j] +=c; //contains price for every plots
            }
        }
        int count=0;
        for (int i=1;i<1001;i++)
        {
            for (int j=1;j<1001;j++)
            {
                if(mat2[i][j]==1)
                {
                  count+=mat1[i][j];
                }
            }
        }
      System.out.println(count);
    }
  }
}
