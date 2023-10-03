/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

/**
 *
 * @author admin
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ManageStudent m = new ManageStudent();
        m.generateStudent();
        while (true) {
            int choice = m.menu();
            switch (choice) {
                case 1:
                    m.create();
                    break;
                case 2:
                    m.findByName();
                    break;
                case 3:
                    m.upOrDel();
                    break;
                case 4:
                    m.report();
                    break;
                case 5:
                    m.displayList(m.getData());
                    break;
                case 6:
                    System.exit(0);
                    break;
            }
        }
    }

}
