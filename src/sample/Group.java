package sample;

import java.util.Arrays;
import java.util.Comparator;

public class Group {

    private String groupName;

    public final Student[] students;

    public Group(String groupName, Student[] students) {
        super();
        this.groupName = groupName;
        this.students = students;
    }

    public Group() {
        super();
        students = new Student[10];
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Student[] getStudents() {
        return students;
    }

    public void addStudent(Student student) throws GroupOverflowException {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = student;
                return;
            }
        }
        throw new GroupOverflowException();
    }
    public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                if (students[i].getLastName() == lastName)
                    return students[i];
            }
        }
        throw new StudentNotFoundException();
    }

    public boolean removeStudentByID(int id) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                if (students[i].getId() == id) {
                    students[i] = null;
                    return true;
                }
            }
        }
        return false;
    }

    public void sortStudentsByLastName() {
        Arrays.sort(students, Comparator.nullsFirst(new SortStudentsByLastNameComparator()));
    }

    @Override
    public String toString() {
        String result = "Group " + groupName + System.lineSeparator();
        for (int i = 0; i < students.length; i++) {
            if(students[i]!=null) {
                result+=students[i]+System.lineSeparator();
            }
        }
        return result;
    }
}
