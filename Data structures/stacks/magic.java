import java.io.*;
import java.util.*;
class solution
{
  public static void main(String[] args)
  {
      Scanner scan = new Scanner(System.in);
      int[][] a= new int[3][3];
      String str ="";
      for(int i=0;i<3;i++)
      {
        for (int j=0;j<3 ;j++ )
        {
            a[i][j] =scan.nextInt();
            str+=a[i][j];
        }
      }
    //  System.out.println(str);
    int[] b = new int[9];
    int[] temp_mat = new int[9];


    for (int i=0;i<9 ;i++)
    {
        char c= str.charAt(i);
        String s="";
        s+=c;
        int temp = Integer.parseInt(s);
        b[i] = temp;
        temp_mat[i] = temp;
      //  System.out.println(b[i]);
    }
    //Now we have to find the missing number
    int missing_no=0;
    for(int i=1;i<=9;i++)
    {
      int temp_no=0;
      int flag = 0;
      for(int j=0;j<9;j++)
      {
        if(i == b[j])
        {
          flag = 1;
          break;
        }
        temp_no = i;
      }

      if(flag==0)
      {
        missing_no = temp_no;
        break;
      }
    }
  //  System.out.println("missing_no:"+missing_no);
  Arrays.sort(temp_mat);
  int repeated_no = 0;
  for (int i=0;i<9 ;i++ ) {
    //System.out.print(temp_mat[i]+" ");
    if(i>0)
  {
    if(temp_mat[i-1]==temp_mat[i])
    {
      repeated_no = temp_mat[i];
      break;
    }
  }
  }
  //System.out.println("repeated_no:"+repeated_no);
System.out.println(missing_no-repeated_no);



  }
}
