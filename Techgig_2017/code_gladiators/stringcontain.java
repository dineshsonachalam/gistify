import java.util.*;
import java.io.*;

class solution{
public static void main(String args[]){
String name="bca";
char[] a =name.toCharArray();
Arrays.sort(a);
name="";
for (int i=0;i<3 ;i++ )
{

    name+=a[i];
    System.out.println(name);
}

//System.out.println(name.contains("cba"));

}}
