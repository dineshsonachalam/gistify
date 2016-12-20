import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
class solution
{
  public static void main(String[] args)
  {
    Scanner scan = new  Scanner(System.in);
    int n = scan.nextInt();
    ArrayList<Integer>[] al = new ArrayList[n]; // no of stacks
    for (int i=0;i<n ;i++ )
    {
        al[i] = new ArrayList<>();
    }
    for (int i=0;i<n ;i++ )
    {
        int x = scan.nextInt(); //size of the stack`
        for (int j=0;j<x;j++)
        {
          int val = scan.nextInt();
          al[i].add(val);
        }
    }



    System.out.println("Printing variables");
    for (int i=0;i<n ;i++ )
    {
      Iterator itr = al[i].iterator();
        while (itr.hasNext())
        {
            System.out.println(itr.next());
        }
    }


    int q = scan.nextInt(); //no of queries
    //1st row random height
    //2 to n ascending order height
    boolean flag = false;

    for (int l = 0;l<q ;l++ )
    {

      int v =scan.nextInt();
        if(v==0) //remove fighter
        {
          int k = scan.nextInt();
          int size = al[k-1].size();
          al[k-1].remove(size-1);
          System.out.println("Pop Output:");
          Iterator itr = al[k-1].iterator();
          while (itr.hasNext())
          {
              System.out.println(itr.next());
          }

        }
        else if (v==1) //add fighter
        {
          System.out.println();
            System.out.println("Enter k an h values:");
            int k =scan.nextInt(); //k stack
            int h =scan.nextInt(); //fighter
            al[k-1].add(h);
            System.out.println("Output:");
            Iterator itr = al[k-1].iterator();
            while (itr.hasNext())
            {
                System.out.println(itr.next());
            }

        }

        else if (v==2) //harry wand power
        {
          for (int i =0;i<n;i++)
          {

            for (int j=0;j<al[i].size();j++)
            {
                Iterator<Integer> itr = al[i].iterator();
                while (itr.hasNext())
              {
                int a =itr.next();
                if(i+1<n)
                {
                  Iterator<Integer> itr2 = al[i+1].iterator();
                  for (int k=0;k<al[i+1].size();k++)
                  {
                      while (itr2.hasNext())
                    {


                        int b = itr2.next();
                        
                        if((a+1)==b)
                        {
                          flag = true;
                          System.out.println("True");
                          break;
                        }
                        else {
                          flag = false;
                        }
                    }
                  }
                }
              }
            }
          }
          if (flag)
          {
              System.out.println("yes");
          }
          else
          {
            System.out.println("no");
          }
        }


      }

}

  }
