package Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamPractice {
    protected static class Employee {
        public final String name;
        public final Integer age;
        public final String jobTitle;
        public final Float salary;

        public Employee(String name, Integer age, String jobTitle, Float salary) {
            this.name = name;
            this.age = age;
            this.jobTitle = jobTitle;
            this.salary = salary;
        }
    }

    public static void main(String[] args) {
        Employee[] employeesArr = {
                new Employee("John", 34, "developer", 80000f),
                new Employee("Hannah", 24, "developer", 95000f),
                new Employee("Bart", 50, "sales executive", 100000f),
                new Employee("Sophie", 49, "construction worker", 40000f),
                new Employee("Darren", 38, "writer", 50000f),
                new Employee("Nancy", 29, "developer", 75000f),
        };

        List<Employee> employees = new ArrayList<>(Arrays.asList(employeesArr));
        Float salariesSum = employees.stream()
                .filter(employee -> "developer".equals(employee.salary))
                .map(employee -> employee.salary)
                .reduce(0f, (x, y) -> x + y);
        System.out.println(salariesSum);

        Map<String, Float> averageSalaryByTitle = employees
                .stream()
                .collect(Collectors.groupingBy((employee) -> employee.jobTitle))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        (currentEntrySet) -> currentEntrySet.getKey(),
                        (currentEntrySet) -> currentEntrySet.getValue()
                                .stream()
                                .map((currentEmployee) -> currentEmployee.salary)
                                .reduce(0f, (acc, employeeSalary) -> acc + employeeSalary)
                                / currentEntrySet.getValue().size()
                ));
        System.out.println("Average salary by title" + averageSalaryByTitle);
    }
}