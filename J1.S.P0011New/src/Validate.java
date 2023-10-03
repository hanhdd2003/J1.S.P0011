
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hanh
 */
public class Validate {

    private final Scanner sc = new Scanner(System.in);

    public int choice() {
        int i;
        while (true) {
            try {
                System.out.print("Enter your choice: ");
                i = Integer.parseInt(sc.nextLine());
                if (i > 0 && i <= 4) {
                    return i;
                }
                throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.out.println("Enter choice from 1 to 4");
            }
        }
    }

    public String inDecimal() {
        String decimal;
        while (true) {
            try {
                System.out.print("Enter decimal number: ");
                decimal = sc.nextLine();
                if (decimal.matches("^[0-9]+$")) {
                    return decimal;
                }
                throw new Exception();
            } catch (Exception e) {
                System.out.println("Enter digit and greater or equal zero");
            }
        }
    }

    public String inBinary() {
        String binary;
        while (true) {
            try {
                System.out.print("Enter binary number: ");
                binary = sc.nextLine();
                if (binary.matches("^[01]+$")) {
                    return binary;
                }
                throw new Exception();
            } catch (Exception e) {
                System.out.println("Enter all digit have 0 or 1");
            }
        }
    }

    public String inHexadecimal() {
        String hexa;
        while (true) {
            try {
                System.out.print("Enter hexadecimal number: ");
                hexa = sc.nextLine();
                if (!hexa.isEmpty() && hexa.matches("^[0-9a-fA-F]+$")) {
                    return hexa;
                }
                throw new Exception();
            } catch (Exception e) {
                System.out.println("Must enter hexadecimal number");
            }
        }
    }
    
}
