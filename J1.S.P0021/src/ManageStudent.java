
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hanh
 */
public class ManageStudent {

    private final Validate val = new Validate();
    private final ArrayList<Student> list = new ArrayList<>();
    private final ArrayList<Report> report = new ArrayList<>();

    public ManageStudent() {
    }

    public int menu() {
        System.out.println("========= WELCOME TO STUDENT MANAGEMENT ========");
        System.out.println("1. Create");
        System.out.println("2. Find and Sort");
        System.out.println("3. Update/Delete");
        System.out.println("4. Report");
        System.out.println("5.Display");
        System.out.println("6. Exit");
        return val.choice();
    }

    public ArrayList<Student> getList() {
        return list;
    }

    public void create() {
        String id;
        String name;
        int semester;
        String course;
        while (true) {
            id = val.inID();
            if (val.findIndex(list, id) != -1) {
                System.out.println("ID already exists.");
                continue;
            }
            name = val.inName();
            semester = val.inSemester();
            course = val.inCourse();
            list.add(new Student(id, name, semester, course));
            if (list.size() >= 10) {
                if (!val.checkYN()) {
                    break;
                }
            }
        }
    }

    public void findByName() {
        if (list == null) {
            return;
        }
        ArrayList<Student> result = new ArrayList<>();
        String name = val.inName();
        for (Student s : list) {
            if (s.getStudentName().toLowerCase().contains(name.toLowerCase())) {
                result.add(s);
            }
        }
        if (result == null) {
            System.out.println("Not found " + name);
            return;
        }
        Comparator<Student> c = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getNameOfStudent().compareTo(o2.getNameOfStudent());
            }
        };
        Collections.sort(result, c);
        this.displayList(result);
    }

    public void upOrDel() {
        if (list == null) {
            System.out.println("List is empty");
            return;
        }
        String id = val.inID();
        Student s = val.findByID(list, id);
        if (s == null) {
            System.out.println("Not found student have id: " + id);
            return;
        }
        int index = val.findIndex(list, id);
        int choice = val.checkUD();
        switch (choice) {
            case 1:
                // update
                s = this.update(s);
                list.set(index, s);
                break;
            case 2:
                // delete
                list.remove(s);
                break;
        }
    }

    public Student update(Student s) {
        int choice = 0;
        int semester;
        String str;
        while (choice != 4) {
            System.out.println("====== Update ======");
            System.out.println("1. Update Name");
            System.out.println("2. Update Semester");
            System.out.println("3. Update Course");
            System.out.println("4. Done");
            choice = val.update();
            switch (choice) {
                case 1:
                    str = val.inName();
                    s.setStudentName(str);
                    break;
                case 2:
                    semester = val.inSemester();
                    s.setSemester(semester);
                    break;
                case 3:
                    str = val.inCourse();
                    s.setCourseName(str);
                    break;
                case 4:
                    break;
            }
        }
        return s;
    }

    public void report() {
        String name;
        String course;
        int index;
        Report r;
        for (Student s : list) {
            name = s.getStudentName();
            course = s.getCourseName();
            r = val.getReport(report, name, course);
            if (r == null) {
                report.add(new Report(name, course, 1));
            } else {
                index = val.getIndex(report, name, course);
                r.setTotal(r.getTotal() + 1);
                report.set(index, r);
            }
        }
        Comparator<Report> c = Comparator.comparing(Report::getNameStudent);
        Collections.sort(report, c);
        for (Report re : report) {
            System.out.println(re.getNameStudent() + " | " + re.getCourseName() + " | " + re.getTotal());
        }
    }

    public void displayList(ArrayList<Student> ls) {
        System.out.format("%-10s %-20s %-15s %-15s\n", "ID", "Name", "Semester", "Course Name");
        ls.forEach((s) -> {
            s.display();
        });
    }

    public void add(Student s) {
        list.add(s);
    }

}
