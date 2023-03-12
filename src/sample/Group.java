package sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Group {

    private String groupName;

    private List<Student> students = new ArrayList<>();

    public Group(String groupName, List<Student> students) {
        super();
        this.groupName = groupName;
        this.students = students;
    }

    public Group() {
        super();
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) throws GroupOverflowException {
        if (students.size() <= 10) {
            students.add(student);
                return;
            }

        throw new GroupOverflowException();
    }
    public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getLastName().equals(lastName)) {
                return students.get(i);
            }
        }
        throw new StudentNotFoundException();
    }

    public boolean removeStudentByID(int id) {
        for (int i = 0; i < students.size(); i++)
            if (students.get(i).getId() == id) {
                students.remove(i);
                return true;
            }

        return false;
    }

    public void sortStudentsByLastName() {
        students.sort(new SortStudentsByLastNameComparator());
    }

       @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(groupName, group.groupName) && Objects.equals(students, group.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupName, students);
    }

    public boolean anExtraStudent(Group group1) {
        for (int i = 0; i < students.size(); i++) {
            for (int j = 0; j < students.size(); j++) {
                if (i != j && students.get(i).equals(students.get(j))) {
                    System.out.println("Student " + students.get(i).getLastName() + " " + students.get(i).getName() + " the student is already in the group");
                        return true;
                    }
                }
            }

        return false;
    }

    @Override
    public String toString() {
        String result = "Group: " + getGroupName() + System.lineSeparator();
        for (int i = 0; i < students.size(); i++) {

            result += (i + 1) + "." + students.get(i) + System.lineSeparator();

        }
        return result;

    }
}
