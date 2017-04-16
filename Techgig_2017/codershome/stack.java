import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class solution {


 public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int [][]a = new int[n][];
        ArrayList<Integer> cube_size = new ArrayList<Integer>();//for new cube_size
        for(int i=0;i<n;i++)
        {
          int temp = scan.nextInt();
          cube_size.add(temp);
          for(int j=0;j<temp;j++)
          {
            a[i][j] = scan.nextInt();
          }
        }
   }
}
