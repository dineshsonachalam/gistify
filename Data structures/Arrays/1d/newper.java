import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
class solution {

    public static void main(String[] args) {

        // Create an alphabet to work with
        char[] alphabet = new char[] {'a','b'};
        // Find all possible combinations of this alphabet in the string size of 3
        StringExcersise sol = new StringExcersise();
        sol.possibleStrings(2, alphabet,"");
      //  StringExcersise.possibleStrings(2, alphabet,"");
    }

} class StringExcersise {

    public static void possibleStrings(int maxLength, char[] alphabet, String curr) {

        // If the current string has reached it's maximum length
        if(curr.length() == maxLength) {
            System.out.println(curr);

        // Else add each letter from the alphabet to new strings and process these new strings again
        } else {
            for(int i = 0; i < alphabet.length; i++) {
              /*
                System.out.println("Curr:"+curr);
                System.out.println("alphabet:"+alphabet[i]);
                String temp = String.valueOf(alphabet[i]);
                int flag=0;
                if(temp.equals(curr))
                {
                flag=1;
                  System.out.println("Yeah bro!");
                }
                */
          //      if(flag==0);

            //    System.out.println("Statementexe");
                String oldCurr = curr;
                curr += alphabet[i];
                possibleStrings(maxLength,alphabet,curr);
                curr = oldCurr;
                System.out.println("Old Curr:"+curr);

            }
        }
    }
}
