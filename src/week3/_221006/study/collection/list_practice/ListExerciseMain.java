package week3._221006.study.collection.list_practice;

import java.util.List;

public class ListExerciseMain {
    public static void main(String[] args) {
        ListExercise listExercise = new ListExercise();

        List<Student> students = listExercise.getStudents();

        for (Student student : students) {
            System.out.println(student);
        }
    }
}
