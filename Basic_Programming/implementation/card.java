import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
class solution
{
      public static void main(String[] args)
      {
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();
        int m=scan.nextInt();
        int k=scan.nextInt();//no of decks
        int[] a= new int[k];
        int[] b= new int[k];
        for (int l=0;l<k;l++)
        {
            a[l]=scan.nextInt();
            b[l]=scan.nextInt();
        }
        int x=1,y=1,minx=1,miny=1,count=0;
        for (int l=0;l<k;l++)
        {
            while(((x<n)&&(y<m))||(a[l]<0)||(b[l]<0))
            {
              int tempx=x+a[l];
              int tempy=y+b[l];
              if((tempx<minx)||(tempy<miny))
              {
                break;
              }
              if((tempx<=n)&&(tempy<=m)&&(tempx>minx)&&(tempy>miny))
              {
                x+=a[l];
                y+=b[l];
                count++;
              }
            }
        }
        System.out.println(count);
      }
}
