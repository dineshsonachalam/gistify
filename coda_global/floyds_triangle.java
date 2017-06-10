import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
	 Scanner sc =new Scanner (System.in);
	 int t= sc.nextInt();

	for(int c=0;c<t;c++)
	 {
	     int n=sc.nextInt();
	     int a=1;
	     for(int i=1;i<=n;i++){
	         for(int spaces=1;spaces<=n;spaces++){
	             System.out.print(" ");
	         }
	         for(int j=1;j<=i;j++){
	             System.out.printf(" %d",a);
	             a++;
	         }
	        System.out.println();
	     }

	 }
	}
}
