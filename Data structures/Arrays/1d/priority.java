import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
class solution {
   public static void main(String args[]) {
   // create priority queue
   PriorityQueue < Integer >  prq = new PriorityQueue < Integer > () ;
   Scanner scan = new Scanner(System.in);
   // insert values in the queue
   for ( int i = 0; i  <  5; i++ ){
  // prq.add (new Integer (i)) ;
    int temp =scan.nextInt();
    prq.add(temp);
   }
      System.out.println ( "Priority queue values are: " + prq) ;
   prq.clear();
      System.out.println ( "Priority queue values are: " + prq) ;
   if(prq.isEmpty())
   {
     System.out.println("Scooby doo! where are you!");
   }

   }
}
