import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Ainazik","Amangeldieva",18,Gender.FEMALE,500));
        students.add(new Student("Abu-Ali","Alymbekov",20,Gender.MALE,700));
        students.add(new Student("Ilim","Shabdanov",19,Gender.MALE,650));
        students.add(new Student("Aigerim","Bektenova",16,Gender.FEMALE,400));


        students.stream().filter(student -> student.getName().startsWith("A")).forEach(System.out::println);
        students.stream().filter(student -> student.getAge()>15 && student.getMoney()>200 && student.getGender().equals(Gender.MALE)).forEach(System.out::println);
        System.out.println(students.stream().max(Comparator.comparing(Student::getMoney)));
        System.out.println(students.stream().filter(student -> student.getGender().equals(Gender.FEMALE)).max(Comparator.comparing(Student::getMoney)));
        students.stream().map(Student::getName).forEach(System.out::println);
        students.stream().map(student -> student.getMoney()+1000).forEach(System.out::println);
        System.out.println(students.stream().map(student -> student).findFirst());
        System.out.println(students.stream().map(student -> student).count());
        Map<Boolean,List<Student>> studentList = students.stream().collect(Collectors.groupingBy(x -> x.getGender().equals(Gender.MALE)));


    }
}