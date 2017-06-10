import java.io.*;
import java.util.*;
class solution{


public static void getGoldbachNumbers(int number){
        if((number%2 != 0) && (number>2))
                {
                System.out.println("Please enter an even number.Invalid Input");
                return;
                }
        for(int i=0;i<number/2;i++){

                if( isPrime(number-i) && isPrime(i) )
                        System.out.println("Goldbach numbers are :"+i+" and "+(number -i)+" for "+number);

        }


}

public static boolean isPrime(int number){

        for(int i=2;i<number;i++){
                if(number%i == 0)
                        return false;
        }

        return true;
}

public static void main(String[] args){
getGoldbachNumbers(74);

}



}
