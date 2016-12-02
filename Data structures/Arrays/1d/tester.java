import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
class solution
{
  public int BinaryToDecimal(int binary)
  {
    int decimal = 0;
    int power=0;
    while(binary!=0)
    {
      int rem = binary%10;
      decimal =(int)(decimal+rem*Math.pow(2,power));
      binary = binary/10;
      power++;
    }
    return decimal;
  }

  public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s=scan.next();
        s = s.replaceAll("0", "x").replaceAll("1", "0").replaceAll("x", "1");

        int result = Integer.parseInt(s);
        //System.out.println(result);
      //  int t=binaryToDecimal(result);
        //now conversion of binary to decimal
        solution sol = new solution();
        int no=  sol.BinaryToDecimal(result);
        System.out.println("Decimal:"+no);

  }
}
