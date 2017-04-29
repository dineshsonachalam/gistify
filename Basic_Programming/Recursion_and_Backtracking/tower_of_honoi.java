//working program for tower of honoi

/**
 * Towers of Hanoi
 * Pole are labeled 1, 2,3
 * Each disk is also labeled
 * @author Lars Vogel
 *
 */
 import java.util.Scanner;
class TowersofHanoi {

public void TOH(int n, String start, String aux, String end) {

           if (n == 1) {
               System.out.println(start + " -> " + end);
           } else {
               TOH(n - 1, start, end, aux);
               System.out.println(start + " -> " + end);
               TOH(n - 1, aux, start, end);
           }
}

public static void main(String[] args) {

           TowersofHanoi towersOfHanoi = new TowersofHanoi();

           System.out.print("Enter number of discs: ");
           Scanner scanner = new Scanner(System.in);
           int discs = scanner.nextInt();
           towersOfHanoi.TOH(discs, "A", "B", "C");
}

}
