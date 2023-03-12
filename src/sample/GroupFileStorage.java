package sample;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class GroupFileStorage {

    public void saveGroupToCSV(Group gr) throws IOException {
        List<Student> student = gr.getStudents();
        File folder = new File("Students");
        folder.mkdirs();
        try (PrintWriter pw = new PrintWriter(new File(folder, "Group.csv"))) {
            for (int i = 0; i < student.size(); i++) {
                if (student.get(i) != null) {
                    pw.println(student.get(i).getName() + "-" + student.get(i).getLastName() + "-" + student.get(i).getGender()
                            + "-" + student.get(i).getId() + "");
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public Group loadGroupFromCSV(File file) throws IOException {
        Group group = new Group();
        group.setGroupName(file.getName().substring(0, file.getName().lastIndexOf(".")));
        String str = "";
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                str += sc.nextLine() + System.lineSeparator();
            }
        }

        System.out.println(str);

        String[] students = str.split(System.lineSeparator());

        for (int i = 0; i < students.length; i++) {

            String st1 = students[i];
            String[] st = st1.split("[-]");

            try {
                Student student = new Student(st[1], st[0], Gender.valueOf(st[2]), Integer.valueOf(st[3]),
                        file.getName().substring(0, file.getName().indexOf(".")));
                group.addStudent(student);
            } catch (GroupOverflowException e) {
                e.printStackTrace();
            }
        }
        return group;
    }

    public File findFileByGroupName(String groupName, File workFolder) {
        File[] findFile = workFolder.listFiles();
        if (findFile != null) {
            for (int i = 0; i < findFile.length; i++) {
                if (findFile[i].isFile() && findFile[i].getName().equals(groupName)) {
                    System.out.println("file" + groupName + " is find " + workFolder);
                    return findFile[i];
                }
            }
        }
        System.out.println("file" + groupName + " has not found" + workFolder);
        return null;
    }
}
