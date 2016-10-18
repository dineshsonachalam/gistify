import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.math.*;
class TestClass {
    public static void main(String args[] ) throws Exception {

		Scanner scan= new Scanner(System.in);
		int[] a= new int[5];
        for(int i=0;i<5;i++)
        {
        	a[i]=scan.nextInt();
        }
        for(int i=0;i<3;i++)
        {
          System.out.println(a[i]);
        }
    }
}
