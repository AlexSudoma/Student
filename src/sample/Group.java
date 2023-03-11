package sample;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Group group)) return false;
        return Objects.equals(groupName, group.groupName) && Arrays.equals(students, group.students);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(groupName);
        result = 31 * result + Arrays.hashCode(students);
        return result;
    }

    public boolean anExtraStudent(Group group1) {
        for (int i = 0; i < students.length; i++) {
            for (int j = 0; j < students.length; j++) {
                if (i != j && students[i] != null && students[j] != null) {
                    if (students[i].equals(students[j])) {
                        System.out.println("Student " + students[i].getLastName() + " " + students[i].getName() + " the student is already in the group");
                        return true;
                    }
                }
            }
        }
        return false;
    }


}
