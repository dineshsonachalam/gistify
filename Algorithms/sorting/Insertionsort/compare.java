import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

class solution {


    public static void main(String[] args) throws NumberFormatException, IOException
    {
      BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
    int n=Integer.parseInt(br.readLine());
      String[] a= new String[n];
      for (int i=0;i<n;i++ )
      {
          a[i] = br.readLine();
      }
      int count = 0;
      for (int j=0;j<a.length ;j++ )
     {
        count = 0;
          for (int k=j-1;k>=0 ;k-- )
          {
              int check = a[j].compareTo(a[k]);
              if(check>0)
              count++;
          }
          System.out.println(count);
      }

    }
}
