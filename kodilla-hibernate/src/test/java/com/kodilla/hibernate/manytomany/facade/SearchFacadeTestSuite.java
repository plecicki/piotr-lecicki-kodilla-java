package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class SearchFacadeTestSuite {

    @Autowired
    private SearchFacade searchFacade;

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    public void testSearchFacade() {
        //Given
        List<Employee> employees = createEmployees();
        List<Company> companies = createCompanies();
        createRelationsBetweenEmployeesAndCompanies(employees, companies);;

        for(Employee employee : employees) {
            employeeDao.save(employee);
        }

        //When & Then
        try {
            searchFacade.processSearch("Kot");
        } catch (SearchProcessingException e) {

        }

        //CleanUp
        for (Employee employee : employees) {
            employeeDao.delete(employee);
        }
    }

    private List<Employee> createEmployees() {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Krzysztof", "Kowalski"));
        employees.add(new Employee("Marcin", "Kowalski"));
        employees.add(new Employee("Kotlin", "Nowak"));
        employees.add(new Employee("Adrian", "Puchacki"));
        employees.add(new Employee("Monika", "Kotelniczak"));
        employees.add(new Employee("Kotlin", "Kotelniczak"));
        return employees;
    }

    private List<Company> createCompanies() {
        ArrayList<Company> companies = new ArrayList<>();
        companies.add(new Company("KotBury"));
        companies.add(new Company("KotaraTeatralna"));
        companies.add(new Company("Budimex"));
        return companies;
    }

    private void createRelationsBetweenEmployeesAndCompanies(List<Employee> employees, List<Company> companies) {
        employees.get(0).getCompanies().add(companies.get(0));
        employees.get(0).getCompanies().add(companies.get(1));
        companies.get(0).getEmployees().add(employees.get(0));
        companies.get(1).getEmployees().add(employees.get(0));

        employees.get(1).getCompanies().add(companies.get(0));
        companies.get(0).getEmployees().add(employees.get(1));

        employees.get(3).getCompanies().add(companies.get(2));
        companies.get(2).getEmployees().add(employees.get(3));

        employees.get(4).getCompanies().add(companies.get(1));
        employees.get(4).getCompanies().add(companies.get(2));
        companies.get(1).getEmployees().add(employees.get(4));
        companies.get(2).getEmployees().add(employees.get(4));

        employees.get(5).getCompanies().add(companies.get(2));
        employees.get(5).getCompanies().add(companies.get(0));
        companies.get(2).getEmployees().add(employees.get(5));
        companies.get(0).getEmployees().add(employees.get(5));
    }
}
