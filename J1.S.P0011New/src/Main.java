/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hanh
 */
public class Main {
    public static void main(String[] args) {
        Convert con = new Convert();
        int baseIn;
        int baseOut;
        while (true) {     
            baseIn = con.menuIn();
            if(baseIn == 4){
                System.exit(0);
            }
            baseOut = con.menuOut();
            if(baseOut == 4){
                System.exit(0);
            }
            System.out.println();
            con.inValue(baseIn);
            System.out.println();
            System.out.print("Result Convert: ");
            con.convertResult(baseIn, baseOut);
            System.out.println();
        }
    }
}
