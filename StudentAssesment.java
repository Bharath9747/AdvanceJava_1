import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

class Assesment{
    String name;
    int grades;

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", grades=" + grades;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrades() {
        return grades;
    }

    public void setGrades(int grades) {
        this.grades = grades;
    }
}
class Student{
    String name;
    List<Assesment> assesmentList;

    @Override
    public String toString() {
        return  "name='" + name + '\'' +
                ", assesmentList=" + assesmentList ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Assesment> getAssesmentList() {
        return assesmentList;
    }

    public void setAssesmentList(List<Assesment> assesmentList) {
        this.assesmentList = assesmentList;
    }
}
public class StudentAssesment {
    public static void main(String[] args) {
        List<String> subjectList = new ArrayList<>(Arrays.asList("Maths","Science","Computer Science"));
        List<Student> studentList = new ArrayList<>();
        int mx = 100,mn =70;
        for(int i=0;i<3;i++){
            List<Assesment> assesmentList = new ArrayList<>();
            for (String s : subjectList) {
                int n = (int)(Math.random()*(mx-mn))+mn;
                Assesment assesment = new Assesment();
                assesment.setGrades(n);
                assesment.setName(s);
                assesmentList.add(assesment);
            }
            Student student = new Student();
            student.setName("ABC"+(i+1));
            student.setAssesmentList(assesmentList);
            studentList.add(student);
        }
        studentList.stream().forEach(System.out::println);
        System.out.println("Highest Score with Student Name : ");

        Map<String ,Student> highestMarkBySubject = studentList.stream()
                .flatMap(student -> student.getAssesmentList().stream())
                .collect(Collectors.toMap(Assesment::getName, Function.identity(),
                        BinaryOperator.maxBy(Comparator.comparingInt(Assesment::getGrades))))
                .values().stream()
                .collect(Collectors.toMap(assesment -> assesment.getName(),
                        assesment -> studentList.stream()
                                .filter(student -> student.getAssesmentList().contains(assesment))
                                .findFirst().orElse(null)));
        highestMarkBySubject.forEach((subject,student)->{
            System.out.println("Subject : "+subject+", Student with highest Mark : "+((student!=null)?student.getName():"None"));
        });

    }
}
