package info.java.stream;

import info.java.utility.EmployeeDetails;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NthHighestSalaryFromMap {

    public static void main(String[] args) {

        Map<String, Double> employeeMap = EmployeeDetails.fetchEmployeeDetailsAsMap();
        Map.Entry<String, Double> nthHighestSalary = getNthHighestSalary(2, employeeMap);
        System.out.println(nthHighestSalary);

        //-------------------- Employee with same salary -------------//

        Map<String, Double> employeeMapDuplicateSalary = EmployeeDetails.fetchEmployeeDetailsAsMapHavingDuplicateSalary();
        Map.Entry<Double, List<String>> nthHighestSalaryFromDuplicate = getNthHighestSalaryFromDuplicate(2, employeeMapDuplicateSalary);
        System.out.println(nthHighestSalaryFromDuplicate);
    }

    public static Map.Entry<String, Double> getNthHighestSalary(int num, Map<String, Double> employeeMap) {
        return employeeMap.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toList())
                .get(num - 1);
    }

    public static Map.Entry<Double, List<String>> getNthHighestSalaryFromDuplicate(int num, Map<String, Double> employeeMapDuplicateSalary) {
        return employeeMapDuplicateSalary.entrySet()
                .stream().collect(Collectors.groupingBy(Map.Entry::getValue,
                        Collectors.mapping(Map.Entry::getKey, Collectors.toList())
                )).entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                .collect(Collectors.toList())
                .get(num - 1);
    }
}
