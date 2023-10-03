/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Hanh
 */
public class Controller {

    private final ArrayList<Student> listStudent = new ArrayList<>();
    private final ArrayList<Report> listReport = new ArrayList<>();

    public ArrayList<Student> getListStudent() {
        return listStudent;
    }

    public ArrayList<Report> getListReport() {
        return listReport;
    }

    //------------------ funtion 1-------------------------
    public boolean addStudent(String id, String name, int semester, String course) {
        Student s = new Student(id, name, semester, course);
        if (this.checkIDExist(id)) {
            if (this.checkIdAndName(id, name) && this.findIndexStudent(s) == -1) {
                listStudent.add(s);
                return true;
            } else {
                return false;
            }
        } else {
            listStudent.add(s);
            return true;
        }
    }

    //------------------- funtion 2-----------------------
    public ArrayList<Student> findByName(String name) {
        ArrayList<Student> result = new ArrayList<>();
        for (Student s : listStudent) {
            if (s.getStudentName().contains(name)) {
                result.add(s);
            }
        }
        return result;
    }

    public void sortByName(ArrayList<Student> ls) {
        Collections.sort(ls, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getStudentName().compareTo(o2.getStudentName());
            }
        });
    }
  
    //------------------- funtion 3 (update) --------------
    public ArrayList<Student> findByID(String id) {
        ArrayList<Student> result = new ArrayList<>();
        for (Student s : listStudent) {
            if (s.getId().equalsIgnoreCase(id)) {
                result.add(s);
            }
        }
        return result;
    }
    
    //------------------- funtion 3 (Remove)---------------
    public boolean remove(Student s) {
        if (this.findIndexStudent(s) != -1) {
            listStudent.remove(s);
            return true;
        }
        return false;
    }

    //------------------- funtion 4 -----------------------
    public void addReport(String name, String course) {
        int index = this.getIndexReport(name, course);
        if (index == -1) {
            listReport.add(new Report(name, course, 1));
        } else {
            int total = listReport.get(index).getTotal();
            listReport.get(index).setTotal(total + 1);

        }
    }  

    //==================================================
    public int findIndexStudent(Student s) {
        int index = -1;
        int count = 0;
        for (Student a : listStudent) {
            if (a.getId().equalsIgnoreCase(s.getId())
                    && a.getStudentName().equalsIgnoreCase(s.getStudentName())
                    && a.getSemester() == s.getSemester()
                    && a.getCourseName().equalsIgnoreCase(s.getCourseName())) {
                index = count;
            }
            count++;
        }
        return index;
    }

    public boolean checkIDExist(String id) {
        for (Student s : listStudent) {
            if (s.getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean checkIdAndName(String id, String name) {
        for (Student s : listStudent) {
            if (s.getId().equalsIgnoreCase(id) && s.getStudentName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }
    
    public int getIndexReport(String name, String course) {
        int index = -1;
        int count = 0;
        for (Report r : listReport) {
            if (r.getNameStudent().equalsIgnoreCase(name) && r.getCourseName().equalsIgnoreCase(course)) {
                index = count;
            }
            count++;
        }
        return index;
    }
    
    
}
