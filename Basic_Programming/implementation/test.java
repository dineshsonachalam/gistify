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
        for(int r=0;r<t;r++)
      {
        int n = scan.nextInt();
        String s = scan.next();

        for (int i=0;i<n ;i++)
        {
            int no = (int)s.charAt(i);
        //    System.out.println(no);

                    int back_prime_pos = 0;
                    int front_prime_pos = 0;
                    int back_prime = 0;
                    int front_prime= 0;
                    int max = 0;
                    int min = 0;



                      /* forward no--> is a prime*/

                    for (int j=no;j<=90;j++)
                    {
                        int no_check_term = j;
                        int flag =0;
                        int temp_pos = 0;
                        for(int k=2;k<no_check_term;k++)
                        {

                          if(no_check_term%k==0)
                          {
                            flag = 1;
                            break;
                          }
                        }
                        if(flag == 0)
                        {
                          for(int x = no;x<j;x++)
                          {
                            front_prime_pos +=1;
                          }

                          front_prime = j;
                      //    System.out.println("Prime_Forward:"+j);
                          break;
                        }
                    }
                    System.out.println("Front Prime:"+front_prime);
                    System.out.println("Front prime pos:"+front_prime_pos);

                    /*Checking if backward no is a prime*/
                    for (int j=no;j>65;j--)
                    {
                        int no_check_term = j;

                        int flag =0;
                        for(int k=2;k<no_check_term;k++)
                        {

                          if(no_check_term%k==0)
                          {
                            flag = 1;
                            break;
                          }
                        }
                        if(flag == 0)
                        {
                          for(int x = no;x>j;x--)
                          {
                            back_prime_pos +=1;
                          }
                          back_prime = j;
                        //  System.out.println("Prime_Backward:"+j);
                          break;
                        }
                    }
                    if(back_prime_pos==0)
                    {
                      back_prime_pos = 95;
                    }
                    if(front_prime_pos ==0)
                    {
                      front_prime_pos = 95;
                    }
                    System.out.println("Back Prime:"+back_prime);
                   System.out.println("Back prime pos:"+back_prime_pos);
                    System.out.println("Result");
                    if(back_prime_pos == front_prime_pos) //equidistant
                    {
                      char a =(char) back_prime;
                      System.out.print(a);
                    }
                    else if(back_prime_pos>front_prime_pos)
                    {
                      char a =(char) front_prime;
                      System.out.print(a);
                    }
                    else
                    {
                      char a =(char) back_prime;
                      System.out.print(a);
                    }
                    System.out.println();

        }


      //  int no = 82; // A



        /*
        int n = 65;
        for(int i=65;i<=90;i++)
        {
          char temp = (char) i;
          System.out.println(temp);
        }
        */
        System.out.println();
      }
    }
}
