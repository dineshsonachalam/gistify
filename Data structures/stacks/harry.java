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
    //    System.out.println("Enter size of the stack:");
        int x = scan.nextInt(); //size of the stack`
        for (int j=0;j<x;j++)
        {
          int val = scan.nextInt();
          al[i].add(val);
        }
    }



  //  System.out.println("Printing variables");
    for (int i=0;i<n ;i++ )
    {
      Iterator itr = al[i].iterator();
      /*
       while (itr.hasNext())
      {
            System.out.println(itr.next());
      }
      */
    }

    ///System.out.println("Enter no of queries:");
    int q = scan.nextInt(); //no of queries
    //1st row random height
    //2 to n ascending order height
      boolean flag = false;
      int c_count = 1;
      int  a ;
      int  b;

    for (int l = 0;l<q ;l++ )
    {

      int v =scan.nextInt();
        if(v==0) //remove fighter
        {
          int k = scan.nextInt();
          int size = al[k-1].size();
          al[k-1].remove(size-1);
  //        System.out.println("Pop Output:");
          Iterator itr = al[k-1].iterator();
      /*    while (itr.hasNext())
          {
              System.out.println(itr.next());
          }
*/
        }
        else if (v==1) //add fighter
        {
      //    System.out.println();
        //    System.out.println("Enter k an h values:");
            int k =scan.nextInt(); //k stack
            int h =scan.nextInt(); //fighter
            al[k-1].add(h);
        //    System.out.println("Output:");
            Iterator itr = al[k-1].iterator();
        /*    while (itr.hasNext())
            {
                System.out.println(itr.next());
            }
            */
        }

        else if (v==2) //harry wand power
        {

          //now printing the elements in the stack
      //    System.out.println("Stack elements are:");
          for (int i=0;i<n ;i++ )
          {
        //    System.out.println(i+" comparison: ");
            Iterator<Integer> itr1 = al[i].iterator();
          /*
            Iterator<Integer> itr2 = al[i+1].iterator();

              int size = al[i+1].size();
              int[] c = new int[size+1];
              for(int r = 0;r<al[i+1].size();r++)
              {
                 c[r] = itr2.next();
              }
            */


            int counter = 0;
            if(i+1>=n)
            {
              break;
            }
            int size = al[i+1].size();
            int[] c = new int[size+1];


            for(int j =0;j<al[i].size();j++)
            {
              a = itr1.next();
              if (i+1 < n)
              {
                Iterator<Integer> itr2 = al[i+1].iterator();
                flag = false;



                 if (counter==0)
                 {
                    for(int r = 0;r<al[i+1].size();r++)
                    {
                      c[r] = itr2.next();
                      counter++;
                    }
                 }
                  for (int k =0;k<al[i+1].size();k++)
                  {
                    b = c[k];
                    //comparing
                  //  System.out.println(a+" : "+b);
                    //now checking
                    if(a+1 == b)
                    {
                      flag = true;
                      break;
                    }


                  }
              }
              if (flag ==true)
              {
                  break; //break the for loop
              }
            }
          //  System.out.println();
          }


           if (flag)
           {
               System.out.println("YES");
           }
           else
           {
             System.out.println("NO");
           }

        }




        }


      }

}
