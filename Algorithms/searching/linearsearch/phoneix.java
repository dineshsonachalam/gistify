import java.io.*;
import java.util.*;
class solution
{
  public static void main(String[] args)
  {
      Scanner scan = new Scanner(System.in);
      int n =scan.nextInt(); //total no of convo
      scan.nextLine(); //for inputting nextLine values
      int date = 0; //dating
      int some =0; //no dating
      for(int r=0;r<n;r++)
      {


      String s = scan.nextLine(); //since it include blank spaces include nextLine
      String x =""; //for the girl && boy
      int[] a = new int[s.length()]; //for the girl
      int c1 =0 ; //count for a[]
      int[] b = new int[s.length()]; //for the boy

      for(int i=0;i<s.length();i++)
      {
        if( (s.charAt(i)=='0') || (s.charAt(i)=='1') || (s.charAt(i)=='2') || (s.charAt(i)=='3')
        || (s.charAt(i)=='4') || (s.charAt(i)=='5') || (s.charAt(i)=='6') || (s.charAt(i)=='7')
        || (s.charAt(i)=='8') || (s.charAt(i)=='9')
        )
        {
          x+=s.charAt(i);
        //  System.out.println("x:"+x);
        }
         else if(x.length()>0)
        {
          a[c1] = Integer.valueOf(x); //converting integer to string and assigning it to a[c1]
        //  System.out.println("Values:"+a[c1]);
          x = "";
          c1++;
        }
        if( (x.length()>0) && (i+1==s.length())) // last termination of the program
        {
          a[c1] = Integer.valueOf(x); //converting integer to string and assigning it to a[c1]
        //  System.out.println("Values:"+a[c1]);
          x = "";
          c1++;
        }
      }
    //  System.out.println("Array elements:");

                  if(s.charAt(0)=='G')
                {
                //  System.out.println("Statement Internal executed");
                    for(int i=0;i<c1;i++)
                  {
                    //  System.out.println(a[i]);
                    if(a[i]==19||a[i]==20)
                    {
                      date+=2;
                    }
                    else
                    {
                      some+=2;
                    }
                  }
                }

                else if (s.charAt(0)=='M')
                {
                    for(int i=0;i<c1;i++)
                  {
                    //  System.out.println(a[i]);
                    if(a[i]==19||a[i]==20)
                    {
                      date+=1;
                    }
                    else
                    {
                      some+=1;
                    }
                  }
                }


      }

      if((date-some)>0)
      {
    //    System.out.println("Date value:"+(date-some));
        System.out.println("Date");
      }
      else
      {
    //    System.out.println("Date value:"+(date-some));
          System.out.println("No Date");
      }
  }
  }
