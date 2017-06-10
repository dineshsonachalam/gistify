import java.io.*;
import java.util.*;
class solution
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        int r = scan.nextInt(); //row
        int c = scan.nextInt(); //column
        Character[][] a = new Character[r][c];
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {

                String s = scan.next();
                a[i][j] = s.charAt(0);
            }
        }
        String x = scan.next(); //letters to be searched
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
          //    System.out.print(a[i][j]+" ");
            }
          //  System.out.println();
        }

        System.out.println();
        int s_row = -1; //element row
        int s_column = -1; //element column

        // Checking of elements from top to bottom from left to right
      for(int k=0;k<r;k++)
      {
        for(int i=0;i<c;i++)
        {
            int ptr = 0;
          //  int r1 = i; // current row
          //  int c1 = c; // total column
          int c1 = i;


            for(int j=k;j<r;j++)
          {
              if(j<x.length())
            {

              int r1 = j; // current row
              ptr = 0;
                if( a[j][c1] == x.charAt(0) ) //first letters match
                {
                    s_row  = j; // j-rows
                    s_column = c1; //c1-columns
                    String temp ="";
                    temp += x.charAt(0); // temp hold 1st letter of string value
                     // incrementing the  loop
                    ptr++; //incrementing the pointer position
                    while(j<r)
                    {
                      j++;
                      System.out.println("ptr:"+ptr);
                      System.out.println("Temp:"+temp);
                      System.out.println("Check:"+x.charAt(ptr)+"===>"+a[j][c1]);
                      char check = x.charAt(ptr);
                      if(a[j][c1] == check) //if 2nd and other letter in string match
                      {
                          char temporary = x.charAt(ptr);
                          temp+=temporary;
                          ptr++; // incrementing pointer position
                      }

                      if(temp.equals(x)) // if string match
                      {
                        System.out.print(s_row+" "+s_column);
                        System.out.println();
                        temp="";
                        s_row = -1;
                        s_column = -1;
                        ptr = 0;
                        break; // terminate the while loop
                      }
                      else if(a[j][c1] != check)
                      {
                          temp = "";
                          s_row = -1;
                          s_column = -1;
                          ptr = 0;
                        //  j++;
                          break;
                      }
                    }



                }
              }
              else
              {
                break;
              }
}
            }
        }


    }
}
