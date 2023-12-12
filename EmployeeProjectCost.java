import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Project{
    String name;
    int cost;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return  "name='" + name + '\'' +
                ", cost=" + cost ;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}

class EmployeeWithProject {
    String name;
    List<Project> projects;

    @Override
    public String toString() {
        return  "name='" + name + '\'' +
                ", projects=" + projects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
public class EmployeeProjectCost {
    public static void main(String[] args) {
        Random random = new Random();
        List<EmployeeWithProject> employeeWithProjectList = new ArrayList<>();
        for(int i=0;i<3;i++)
        {
            int n = random.nextInt(5)+3;
            String name = "ABC"+(i+1);
            List<Project> projectList = new ArrayList<>();
            for(int j=0;j<n;j++){
                Project project = new Project();
                project.setCost(random.nextInt(100)+50);
                project.setName(((char)(j+65))+"");
                projectList.add(project);
            }
            EmployeeWithProject employeeWithProject = new EmployeeWithProject();
            employeeWithProject.setName(name);
            employeeWithProject.setProjects(projectList);
            employeeWithProjectList.add(employeeWithProject);
        }

//        employeeWithProjectList.forEach(System.out::println);
        //Sum of cost of all Projects for each Projects.
//        Map<String,Integer> employeeWithProjectMap = employeeWithProjectList.stream().collect(Collectors.toMap(emp->emp.getName(),emp->emp.getProjects().stream().map(Project::getCost).reduce(0,(a,b)->a+b)));
//        Set<String> employeeNames = employeeWithProjectMap.keySet();
//        for (String employeeName:employeeNames)
//            System.out.println("Name : "+employeeName+"\nCost : "+employeeWithProjectMap.get(employeeName));
        //Integer List as Stream
//        List<Integer> integerList = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
//        System.out.println(integerList.stream().filter(x->x%2!=0).mapToInt(x->x*2).sum());
//        System.out.println(integerList.stream().filter(x->x%2==0).reduce((a,b)->a+b));
        //Get the list of distinct projects
//        employeeWithProjectList.stream().map(EmployeeWithProject :: getProjects).flatMap(Collection :: stream).map(Project :: getName).distinct().forEach(System.out::println);
        //Get the list of distinct projects and cost
//        employeeWithProjectList.stream().forEach(System.out::println);
        Map<String,Integer> employeeWithProjectCostMap = employeeWithProjectList.stream().map(EmployeeWithProject::getProjects).flatMap(Collection::stream).collect(Collectors.toMap(proj->proj.getName(),proj ->proj.getCost(),(cost1,cost2)->cost1));
        System.out.println(employeeWithProjectCostMap);
    }
}
