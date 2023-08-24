package info.java.utility;

import java.util.List;
import java.util.Map;

public class EmployeeDetails {

    public static Map<String, Double> fetchEmployeeDetailsAsMap() {
        return Map.of(
                "Raj", 14000.0,
                "Ravi", 12000.0,
                "Akash", 10000.0,
                "Rajesh", 9000.0,
                "Abhilasha", 21000.0,
                "Ankit", 17000.0
        );
    }

    public static Map<String, Double> fetchEmployeeDetailsAsMapHavingDuplicateSalary() {
        return Map.of(
                "Raj", 14000.0,
                "Ravi", 12000.0,
                "Akash", 10000.0,
                "Rajesh", 17000.0,
                "Abhilasha", 21000.0,
                "Ankit", 17000.0,
                "Shashank", 12000.0
        );
    }

    public List<Employee> fetchEmployeeDetailsAsList() {
        return List.of(
                new Employee(201, "Anil", 18000.0),
                new Employee(101, "Raj", 14000.0),
                new Employee(401, "Ravi", 12000.0),
                new Employee(301, "Akash", 10000.0),
                new Employee(501, "Rajesh", 9000.0),
                new Employee(601, "Abhilasha", 21000.0),
                new Employee(901, "Ankit", 17000.0),
                new Employee(701, "Deepak", 19000.0)
        );
    }
}
