package newpackage;

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

    public Validate() {
    }

    public int choice(int min, int max) {
        int i;
        while (true) {
            try {
                System.out.print("Enter yout choice: ");
                i = Integer.parseInt(sc.nextLine());
                if (i >= min && i <= max) {
                    return i;
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Choice from " + min + " to " + max);
            }
        }
    }

    public String inID() {
        String s;
        while (true) {
            try {
                System.out.print("Enter ID: ");
                s = sc.nextLine();
                if (!s.isEmpty() && s.matches("^[a-zA-Z0-9]+$")) {
                    return s.toUpperCase();
                } else {
                    System.out.println("ID is string and not empty");
                }
            } catch (Exception e) {
            }
        }
    }

    public String inName() {
        String s;
        while (true) {
            try {
                System.out.print("Enter name: ");
                s = sc.nextLine();
                if (!s.isEmpty() && s.matches("[a-z A-Z]+")) {
                    return s;
                } else {
                    System.out.println("Name can't empty and no have digit");
                }
            } catch (Exception e) {
            }
        }
    }

    public String inCourse() {
        String s;
        while (true) {
            try {
                System.out.print("Enter Course Name: ");
                s = sc.nextLine();
                if (s.equalsIgnoreCase("Java") || s.equalsIgnoreCase(".Net") || s.equalsIgnoreCase("C/C++")) {
                    return s;
                } else {
                    System.out.println("Course not exist");
                }
            } catch (Exception e) {
            }
        }
    }

    public int inSemester() {
        int i;
        while (true) {
            try {
                System.out.print("Enter semeter: ");
                i = Integer.parseInt(sc.nextLine());
                if (i > 0) {
                    return i;
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Semester greater than zero");
            }
        }
    }

    public boolean checkYN() {
        String s;
        while (true) {
            try {
                System.out.print("Do you want to continue(Y/N)?: ");
                s = sc.nextLine();
                if (s.equalsIgnoreCase("y")) {
                    return true;
                } else if (s.equalsIgnoreCase("n")) {
                    return false;
                }
            } catch (Exception e) {
            }
        }
    }

    public boolean checkUD() {
        String s;
        while (true) {
            try {
                System.out.print("Do you want update(U) or delete(D): ");
                s = sc.nextLine();
                if (s.equalsIgnoreCase("u")) {
                    return true;
                } else if (s.equalsIgnoreCase("d")) {
                    return false;
                }
            } catch (Exception e) {
            }
        }
    }

}
