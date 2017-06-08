/*
  ZOHO PREPARATION
*/
import java.io.*;
import java.util.*;
class solution
{


    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        String sub_str = scan.next();
        int size = scan.nextInt();
        int temp = 0;
        char[][] str=new  char[s.length()-1][size];
        for(int i=0;i<s.length()-1;i++)
        {

            for(int j=0;j<size;j++)
            {

               if(temp<s.length())
              {
                char ch = s.charAt(temp);
                str[i][j] = ch;
                temp+=1;
              }
                System.out.print(str[i][j]+" ");
            }

            System.out.println();
        }
        String str_contain="";
        int temp_str_postn = 0;

        int str_count=0; //no of times substring repeated in the given string
        int row_size = s.length()-1;
        int start1=0;
        int start2=0;
        int end1=0;
        int end2=0;
        for(int i=0;i<row_size;i++)//row
        {
            for(int j=0;j<size;j++) //Column
            {


                  char ch = sub_str.charAt(temp_str_postn);

                  /*
                    TOP TO BOTTOM CHECK
                  */
                  if(ch == str[i][j])
                  {
                      boolean flag1 = false;
                      str_contain += ch;
                  //    System.out.println("String contain-->"+str_contain);
                      /*
                          Checking from left to right (row wise but same column)
                      */
                  //    System.out.println("K:"+(j+1)+" "+"Size:"+size);

                      for(int k = i+1;(k<row_size && flag1==false);k++)
                      {

                          System.out.println("Loop executed"+"--StringContain:"+str_contain);
                          System.out.println("I:"+i+" K:"+k);
                          temp_str_postn=temp_str_postn+1;
                          char ch1 = sub_str.charAt(temp_str_postn);
                          System.out.println("Ch1:"+ch1+"--->"+str[k][j]); //k->rows but same column j
                          if(ch1 == str[k][j])
                          {

                              str_contain += ch1;

                              if(str_contain.equals( sub_str ))
                              {
                                  start1 = i;
                                  end1 = j;
                                  System.out.println("Start1:"+start1+" "+"End1:"+end1);
                                  System.out.println("substring present--***->"+sub_str);
                                  start2 = k;
                                  end2 = j;
                                  flag1 = true;
                                  str_count+=1; //
                                  temp_str_postn = 0;
                                  str_contain ="";
                              }

                          }
                          else
                          {
                            temp_str_postn = 0;
                            str_contain ="";
                            flag1 = true;
                          }
                      }
                  }
                  temp_str_postn = 0;
                  /*
                      LEFT TO RIGHT
                  */

                  ch = sub_str.charAt(temp_str_postn);
                  if(ch == str[i][j])
                  {
                      boolean flag1 = false;
                      str_contain += ch;
                  //    System.out.println("String contain-->"+str_contain);
                      /*
                          Checking from left to right (row wise but same column)
                      */
                  //    System.out.println("K:"+(j+1)+" "+"Size:"+size);

                      for(int k = j+1;(k<size && flag1==false);k++)
                      {

                          System.out.println("Loop executed"+"--StringContain:"+str_contain);
                          System.out.println("I:"+i+" K:"+k);
                          temp_str_postn=temp_str_postn+1;
                          char ch1 = sub_str.charAt(temp_str_postn);
                          System.out.println("Ch1:"+ch1+"--->"+str[i][k]); // i -> rows k-> columns
                          if(ch1 == str[i][k])
                          {

                              str_contain += ch1;

                              if(str_contain.equals( sub_str ))
                              {
                                  start1 = i;
                                  end1 = j;
                                  System.out.println("Start1:"+start1+" "+"End1:"+end1);
                                  System.out.println("substring present--***->"+sub_str);
                                  start2 = i;
                                  end2 = k;
                                  flag1 = true;
                                  str_count+=1; //
                                  temp_str_postn = 0;
                                  str_contain ="";
                              }

                          }
                          else
                          {
                            temp_str_postn = 0;
                            str_contain ="";
                            flag1 = true;
                          }
                      }
                  }
                  temp_str_postn = 0;

            }

        }

        if(str_count>1)
        {
            int data = -1;
            System.out.println(data);
        }
        else
        {
            System.out.print(start1+","+end1);
            System.out.println();
            System.out.print(start2+","+end2);
        }
    }
}
