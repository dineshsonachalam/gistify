/*
Problem B. Tidy Numbers
This contest is open for practice. You can try every problem as many times as you like, though we won't keep track of which problems you solve. Read the Quick-Start Guide to get started.
Small input
5 points
Solve B-small
Large input
15 points
Solve B-large
Problem

Tatiana likes to keep things tidy. Her toys are sorted from smallest to largest, her pencils are sorted from shortest to longest and her computers from oldest to newest. One day, when practicing her counting skills, she noticed that some integers, when written in base 10 with no leading zeroes, have their digits sorted in non-decreasing order. Some examples of this are 8, 123, 555, and 224488. She decided to call these numbers tidy. Numbers that do not have this property, like 20, 321, 495 and 999990, are not tidy.

She just finished counting all positive integers in ascending order from 1 to N. What was the last tidy number she counted?

Input

The first line of the input gives the number of test cases, T. T lines follow. Each line describes a test case with a single integer N, the last number counted by Tatiana.

Output

For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y is the last tidy number counted by Tatiana.

Limits

1 ≤ T ≤ 100.
Small dataset

1 ≤ N ≤ 1000.
Large dataset

1 ≤ N ≤ 1018.
Sample


Input

Output

4
132
1000
7
111111111111111110

Case #1: 129
Case #2: 999
Case #3: 7
Case #4: 99999999999999999




*/










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

      int t = scan.nextInt();
      for (int j=0;j<t;j++)
      {
            int n = scan.nextInt();
            for(int k=n;k>=0;k--)
            {
              int i = k;
              int m = 0;
              int f1 = 0;
              int flag=0;
                    while(i>0) //no 123
                  {
                      if(f1==0)
                      {
                          m = i%10; //remainder 3
                        //  System.out.println("M1:"+m);
                          i = i/10; //quotient 12
                          f1=1;
                      }
                      else if(f1!=0)
                      {
                        int x = i%10; //remainder 2
                        if(m>=x) //3>=2
                        {
                         i=i/10;
                         m =x;
                      //   System.out.println("M2: "+m);
                         if((i/10)<0 && flag==0)
                         {
                        //     System.out.println(i);
                         }
                        }
                        else
                        {

                          flag =1;
                          break;
                        }
                      }

                    }
              if(flag==0)
              {
                                //    Case #1: 129
              System.out.println("Case #" + (j+1) + ": "+k);
                break;
              }
            }
      }


    }
}
