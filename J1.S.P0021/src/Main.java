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
        ManageStudent man = new ManageStudent();
        man.add(new Student("HE1", "Nguyen Van A", 1, "Java"));
        man.add(new Student("HE2", "Nguyen Van B", 2, ".Net"));
        man.add(new Student("HE3", "Nguyen Van C", 3, "C/C++"));
        man.add(new Student("HE4", "Nguyen Van A", 4, "Java"));
        man.add(new Student("HE5", "Nguyen Van A", 2, ".Net"));
        man.add(new Student("HE6", "Nguyen Van C", 3, ".Net"));
        man.add(new Student("HE7", "Nguyen Van B", 2, "Java"));
        man.add(new Student("HE8", "Nguyen Van C", 1, "Java"));
        man.add(new Student("HE9", "Nguyen Van C", 4, "Java"));
        int choice;
        while (true) {
            choice = man.menu();
            switch (choice) {
                case 1:
                    man.create();
                    break;
                case 2:
                    man.findByName();
                    break;
                case 3:
                    man.upOrDel();
                    break;
                case 4:
                    man.report();
                    break;
                case 5:
                    man.displayList(man.getList());
                    break;
                case 6:
                    System.exit(0);
                    break;
            }
        }
    }
}
