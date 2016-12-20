import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
class stackMethods
{
   private int top;
   int size;
   int[] stack;
   public stackMethods(int arraySize)
   {
     size = arraySize;
     stack = new int[size];
     top = -1; //intially top -1 since it is empty
   }
   public void push(int value)
   {
     if(top == size-1) //stack is full
     {
       System.out.println("Stack overflow condition");
     }
     else
     {
       top = top+1;
       stack[top] = value;
     }
   }
   public void pop()
   {
     if(isEmpty()) //stack not equal to empty
     {
       System.out.println("Stack empty condition");
     }
     else
     {
       top = top-1;
     }

   }
   public boolean isEmpty()
   {
         return top == -1;
   }
   public void display()
   {
      for(int i=0;i<=top;i++)
        {
            System.out.print(stack[i]+ " ");
        }
        System.out.println();
    }
}
class solution
{
  public static void main(String[] args)
  {
      stackMethods st = new stackMethods(5);
      st.push(10);
      st.push(2);
      st.push(3);
      st.push(4);
      st.display();
      st.pop();
      st.pop();
      st.pop();
      st.pop();
      st.pop();
      System.out.println();
      st.display();
  }
}
