import java.io.*;
import java.util.*;
class solution
{
    public static void main(String[] args)
    {
      Scanner scan = new Scanner(System.in);
      int n = scan.nextInt();
      for(int l=0;l<n;l++)
      {
      String s = scan.next();
      ArrayList<Character> vowList = new ArrayList<Character>();
vowList.add('a');
vowList.add('e');
vowList.add('i');
vowList.add('o');
vowList.add('u');
vowList.add('A');
vowList.add('E');
vowList.add('I');
vowList.add('O');
vowList.add('U');

char[] arr = s.toCharArray();

int i=0;
int j=s.length()-1;

while(i<j){
    if(!vowList.contains(arr[i])){
        i++;
        continue;
    }

    if(!vowList.contains(arr[j])){
        j--;
        continue;
    }

    char t = arr[i];
    arr[i]=arr[j];
    arr[j]=t;

    i++;
    j--;
}
System.out.println(new String(arr));
    }
  }
}
