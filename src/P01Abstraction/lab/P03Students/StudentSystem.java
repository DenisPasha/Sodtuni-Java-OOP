package P01Abstraction.lab.P03Students;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> repository;

    public StudentSystem() {
        this.repository = new HashMap<>();
    }

    public Map<String, Student> getRepository() {
        return this.repository;
    }

    public void ParseCommand(String[] studentInfoArr) {

        String command = studentInfoArr[0];

        if (command.equals("Create")) {
            createStudent(studentInfoArr);

        } else if (command.equals("Show")) {
            String name = studentInfoArr[1];
            if (repository.containsKey(name)) {
                Student student = repository.get(name);
                String view = String.format("%s is %s years old.", student.getName(), student.getAge());

                if (student.getGrade() >= 5.00) {
                    view += " Excellent student.";
                } else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50) {
                    view += " Average student.";
                } else {
                    view += " Very nice person.";
                }

                System.out.println(view);
            }
        }
    }

    private void createStudent(String[] studentInfoArr) {
        String name = studentInfoArr[1];
        int age = Integer.parseInt(studentInfoArr[2]);
        double grade = Double.parseDouble(studentInfoArr[3]);

        Student student = new Student(name, age, grade);
        repository.putIfAbsent(name,student);
    }
}
