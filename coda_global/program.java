import java.io.*;
import java.util.*;
class solution
{
    public static void main(String[] args)
    {
      Scanner scan =new Scanner(System.in);
      String s = scan.next();

      // If length = even->two middle ,odd->1 middle
      String temp_middle ="";
      int mid = s.length()/2;
      char x1= s.charAt(mid-1);
      char x2 = s.charAt(mid);
      if(s.length()%2==0)
      {
        temp_middle+=String.valueOf(x1);
        temp_middle+=String.valueOf(x2);
      }
      int length = s.length();
      int f_space = 0;
      int f_pointer = 0;
      int b_pointer = length - 1;
      int spaces_bet = s.length()-2;
      for(int i=0;i<length;i++)
      {
          //forward spaces

          for(int j=0;j<f_space;j++)
          {
            System.out.print(" ");
          }
          //1.Even
          if(length%2==0)
          {
              if(i==mid-1)
              {
                  //do nothing
              }
              else if(i == mid)
              {
                  f_space -=1;
              }
              else if(i<mid-1)
              {
                  f_space +=1;
              }
              else if(i>mid)
              {
                  f_space -=1;
              }

          }
          //1. Odd
          if(length%2!=0)
          {

              if(i == mid)
              {
                  f_space -=1;
              }
              else if(i<mid)
              {
                  f_space +=1;
              }
              else if(i>mid)
              {
                  f_space -=1;
              }
          }
          // 2. Even printing first no
          if(length%2==0)
        {
          if((i==mid-1) || (i==mid))
          {
              System.out.print(temp_middle);
          }
          else if(i<mid-1)
          {
              System.out.print(s.charAt(f_pointer));
          }
          else if(i>mid)
          {
              System.out.print(s.charAt(b_pointer));
          }
        }

          // 2. Odd printing first  no
          if(length%2!=0)
        {
          if(i<mid)
          {
              System.out.print(s.charAt(f_pointer));
          }
          else if(i==mid)
          {
              System.out.print(s.charAt(f_pointer));
          }
          else if(i>mid)
          {
              System.out.print(s.charAt(b_pointer));
          }
        }


        // 3. Spaces between
        for(int j=0;j<spaces_bet;j++)
        {
            System.out.print(" ");
        }

        //for even
        if(length%2==0)
        {
            if(i==mid)
            {
                spaces_bet = 2;
            }
            else if(i<mid-1)
            {
                spaces_bet = spaces_bet -2;
            }
            else if(i>mid)
            {
                spaces_bet = spaces_bet +2;
            }
        }


      if(i>mid)
      {
        //  System.out.println("spaces between:"+spaces_bet);
      }
        //for odd
        if(length%2!=0)
        {
          if(i==mid)
          {
              spaces_bet = 1;
          }
          else if(i<mid)
          {
              spaces_bet = spaces_bet -2;
          }
          else if(i>mid)
          {
              spaces_bet = spaces_bet +2;
          }

        }
        // 3. backward no for even
        if(length%2==0)
        {

         if(i<mid-1)
          {
              System.out.print(s.charAt(b_pointer));
          }
          else if(i>mid)
          {
              System.out.print(s.charAt(f_pointer));
          }
        }
          // 3. backward no for odd
          if(length%2!=0)
        {
          if(i<mid)
          {
              System.out.print(s.charAt(b_pointer));
          }
          else if(i>mid)
          {
              System.out.print(s.charAt(f_pointer));
          }
        }
        b_pointer--;
        f_pointer++;
        System.out.println();
    }
    }
}
