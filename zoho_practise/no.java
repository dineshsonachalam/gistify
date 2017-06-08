import java.io.*;
import java.util.*;
class solution
{
    public static void main(String[] args) {
      Scanner scan = new  Scanner(System.in);
      String s = scan.next();
      String temp = "";
      String no ="";
      for(int i=0;i<s.length();i++)
      {
          if(s.charAt(i)!='{')
          {
                if(s.charAt(i)!=',')
                {  

                    char a = s.charAt(i);
                    temp+=String.valueOf(a);
                    System.out.println(temp);
                    if(s.charAt(i+1)=='}')
                    {
                      no+=temp;
                      temp="";
                      String x ="x";
                      no+=x;
                      break;
                    }
                }
                else if(s.charAt(i)==','||s.charAt(i)=='}')
                {
                    no+= temp;
                    temp = "";
                    String x ="x";
                    no+=x;
                }
          }
      }
      System.out.println(no);
      int length = 0;
      for(int i=0;i<no.length();i++)
      {
          if(no.charAt(i)!='x')
          {
              length = length+1;
          }
      }
      int[] num= new int[length];
      int counter = 0;
      String temp1 = "";
      for(int i=0;i<no.length();i++)
      {
        if(no.charAt(i)!='x')
        {
            temp1+=String.valueOf(no.charAt(i));
        }
        else if(no.charAt(i)=='x')
        {
            int x1 = Integer.parseInt(temp1);
            temp1="";
            num[counter] = x1;
            System.out.println(x1);
            counter++;
        }
      }

      System.out.println();
      for(int i=0;i<length-1;i++)
      {
          for(int j=i+1;j<length;j++)
          {
              if(num[i]>num[j])
              {
                  int temp3 = num[i];
                  num[i] = num[j];
                  num[j] = temp3;
              }
          }
      }
      System.out.println("Sorted elements:");
      for(int i=0;i<length;i++)
      {
        System.out.println(num[i]);
      }
      int forward = 0;
      int backward = length - 1;
      System.out.println();
      for(int i=0;i<length;i++)
      {
          if(i%2==0)
          {
              System.out.print(num[forward]+" ");
              forward++;
          }
          else if(i%2!=0)
          {
              System.out.print(num[backward]+" ");
              backward--;
          }
      }

    }
}
