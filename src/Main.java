
public class Program // Main class
{
    public static void main(String[] args) // Main Function
    {
        float res;
        Developer dev1 = new Developer();
        Developer dev2 = new Developer();
        Task task1 = new Task();
        Task task2 = new Task();
        Project Sigma = new Project();
        Employee em1 = new Employee();
        dev1.first_name = "Vika";
        dev1.second_name = "Bill";
        dev2.first_name = "Pavlo";
        dev2.second_name = "Georg";
        dev1.salary = 1234.34f;
        dev1.rank = "QA";
        dev2.rank = "Mid";
        dev2.salary = 833.65f;
        res = dev1.calculate_salary();
        System.out.printf("Salary %1$s %2$s: %3$s$" + "\r\n", dev1.first_name, dev1.second_name, res);
        res = dev2.calculate_salary();
        System.out.printf("Salary %1$s %2$s: %3$s$" + "\r\n", dev2.first_name, dev2.second_name, res);
        System.out.println();
        System.out.printf("Sick leave %2$s = %1$s" + "\r\n", dev1.ask_sick_leave(), dev1.first_name);
        System.out.printf("Sick leave %2$s = %1$s" + "\r\n", dev2.ask_sick_leave(), dev2.first_name);
        System.out.println();
        Sigma.title = "Sigma";
        task1.title = "Server crash test";
        task1.id = 11;
        task2.title = "Creating site";
        task2.id = 03;
        Sigma.task_list.Add(task1.id);
        Sigma.task_list.Add(task2.id);
        task1.implement_item("Personal Computer");
        task1.implement_item("Pen");
        task2.implement_item("Laptop");
        System.out.printf("Items for %1$s" + "\r\n", task1.title);
        for (String el : task1.items) {
            System.out.printf(" '%1$s' " + "\r\n", el);
        }
        System.out.printf("Items for %1$s" + "\r\n", task2.title);
        for (String el : task2.items) {
            System.out.printf(" '%1$s' " + "\r\n", el);
        }
        private static void YesOrNot (String name, ArrayList < String > listic) // Function for reduction code
        {
            int a = listic.size();
            if (Developer.assign_possibility(listic) == true) {
                System.out.printf("<%1$s Може взяти проект, у нього %2$s Проект(а)>" + "\r\n", name, a);
            } else {
                System.out.printf("<%1$s Не може взяти бiльше проектiв, у нього %2$s Проект(а)>" + "\r\n", name, a);
            }
        }

    }

    public static class Developer extends Employee // class Developer
    {

        public ArrayList<String> Projects = new ArrayList<String>();


        public static void assigned_projects(ArrayList<String> Project) // Show developer projects
        {
            for (String el : Project) {
                System.out.printf("-%1$s " + "\r\n", el);
            }
        }

        public static boolean assign_possibility(ArrayList<String> Project) // checks the developer's workload

        {
            boolean res;
            int els = Project.size();
            if (els >= 3) {
                res = false;
            } else {
                res = true;
            }
            return res;
        }
    }

    public class PersonalInfo // class PersonalInfo
    {
        public int id, position; // About PersonalInfo
        public String first_name, second_name, address, phone_number, email, rank;
        public float salary;
    }

    public static class Employee extends PersonalInfo // abstract class Employee + Progeny class
    {
        public final float calculate_salary() {

            return this.salary * 12;

        }

        public final boolean ask_sick_leave() {
            if (Objects.equals(this.rank, "PM")) {
                return true;
            } else if (Objects.equals(this.rank, "QA")) {
                return true;
            } else {
                return false;
            }
        }
    }

    public class AssigmentManagement extends Project {

    }

    public static class Project extends Employee // class Project
    {
        public String title; // About Project
        private LocalDateTime start_date = LocalDateTime.MIN;
        public ArrayList<Integer> task_list = new ArrayList<Integer>();
        public ArrayList<String> Developers = new ArrayList<String>();
        public int limit;


        public final void assign(String dev_name) // Add developer to project
        {
            this.Developers.add(dev_name);

        }

        public final void unassign(String dev_name) // Remove developer from project
        {
            this.Developers.remove(dev_name);
        }

        public final void get_specific_employees(String dev_name) {
            this.Developers.add(dev_name);
        }
    }
}
public class Assignment extends Task // class Assignment
{
    public HashMap<String, String> received_tasks = new HashMap<String, String>(); // About Assigment
    public boolean is_done;
    public String description,status;


    public static void get_tasks_to_date(String task) // Gets tasks to date
    {

    }
}


public class Task
{
    public int id;
    public String title, status, related_project, comment;
    private LocalDateTime deadline = LocalDateTime.MIN;
    public ArrayList<String> items = new ArrayList<String>();


    public final void implement_item(String item)
    {
        this.items.add(item);
    }

    public final void add_comment(String comment)
    {
        this.comment = comment;
    }
}

public class QA extends Employee
{


    public static void add_ticket(String test)
    {

    }

}

public class ProjectManager extends Employee
{

    public final void employee_requests()
    {
        ask_sick_leave();
    }

    public static void discuss_progress()
    {

    }
}

