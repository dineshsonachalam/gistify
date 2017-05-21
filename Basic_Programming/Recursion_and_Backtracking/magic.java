import java.io.*;
import java.util.*;
class solution
{
  public static void main(String[] args)
  {
      Scanner scan = new Scanner(System.in);
      int[][] a= new int[3][3];
      String str ="";
      for(int i=0;i<3;i++)
      {
        for (int j=0;j<3 ;j++ )
        {
            a[i][j] =scan.nextInt();
            str+=a[i][j];
        }
      }
      System.out.println(str);
  }
}
