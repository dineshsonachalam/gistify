import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();  // no of integers
        int k = in.nextInt();// k times circular rotation
        int q = in.nextInt(); // no of queries
        int[] a = new int[n];
        for(int i=0;i<n;i++)
            {
            a[(i+k)%n]=in.nextInt();
        }
        for(int i=0;i<q☻;i++)
            {
            System.out.println(a[in.nextInt()]);
        }

    }
}
