import java.text.ParseException;
import java.time.LocalDate;
import java.util.*;
import java.text.SimpleDateFormat;
class Employee {
    String name;
    double salary;
    LocalDate doj;

    @Override
    public String toString() {
        return  "name='" + name + '\'' +
                ", salary=" + salary +
                ", doj=" + doj;
    }

    public LocalDate getDoj() {
        return doj;
    }

    public Employee(String name, double salary, LocalDate doj) {
        this.name = name;
        this.salary = salary;
        this.doj = doj;
    }
}
public class Main{
    public static void main(String[] args) throws ParseException {
        List<Employee> employeeList= new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        for (int i=0;i<3;i++){
            String name = sc.next();
            double salary = sc.nextDouble();
            int year = sc.nextInt();
            int month = sc.nextInt();
            int day = sc.nextInt();
            employeeList.add(i,new Employee(name,salary, LocalDate.of(year,month,day)));
        }
        System.out.println(employeeList);
        System.out.println(employeeList.stream().sorted(Comparator.comparing(Employee::getDoj)).findFirst().get().name);
    }
}
