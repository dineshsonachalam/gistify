//solve only open jdk
import java.util.Scanner;
class TestClass {
public static void main(String args[]) throws Exception
 {
   try (Scanner scanner = new Scanner(System.in)) {
     int size = Integer.parseInt(scanner.nextLine());
     String input = scanner.nextLine();
     String[] array = input.split(" ");
     long result = 1;
     long modValue = (long) (Math.pow(10, 9) + 7);
     for (String item : array) {
       result = (result * Integer.parseInt(item)) % modValue;
     }
System.out.println(result);
} catch (Exception e) {
e.printStackTrace();
}
}
}
