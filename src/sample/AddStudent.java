package sample;

import java.util.Scanner;


public class AddStudent {

    public Student addStudent() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter student name");
        String name = sc.nextLine();

        System.out.println("Enter student last name");
        String lastName = sc.nextLine();


        System.out.println("Enter gender(male/female");
        String input = sc.nextLine();
        Gender gender = null;
        if (input.equals("male")) {
            gender = Gender.MALE;
        } if (input.equals("female")) {
            gender = Gender.FEMALE;
        }

        System.out.println("Enter group name");
        String groupName = sc.nextLine();

        System.out.println("Enter student id");
        int id = sc.nextInt();

        return new Student(name, lastName, gender, id, groupName);


    }

}
