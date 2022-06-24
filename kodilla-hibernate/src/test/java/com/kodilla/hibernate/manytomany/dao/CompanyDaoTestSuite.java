package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class CompanyDaoTestSuite {

    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;

    @Test
    void testSaveManyToMany() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        //When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        //Then
        assertNotEquals(0, softwareMachineId);
        assertNotEquals(0, dataMaestersId);
        assertNotEquals(0, greyMatterId);

        //CleanUp
        try {
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(dataMaestersId);
            companyDao.deleteById(greyMatterId);
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    void testFindEmployeesByLastname() {
        //Given
        List<Employee> employees = createEmployees();
        List<Company> companies = createCompanies();
        createRelationsBetweenEmployeesAndCompanies(employees, companies);;

        for(Employee employee : employees) {
            employeeDao.save(employee);
        }

        //When
        List<Employee> employeesWithKowalskiLastname = employeeDao.retrieveEmployeesWithThatLastname("Kowalski");

        //Then
        Assertions.assertEquals(2, employeesWithKowalskiLastname.size());
        Assertions.assertEquals("Krzysztof", employeesWithKowalskiLastname.get(0).getFirstname());
        Assertions.assertEquals("Kowalski", employeesWithKowalskiLastname.get(0).getLastname());
        Assertions.assertEquals("Marcin", employeesWithKowalskiLastname.get(1).getFirstname());
        Assertions.assertEquals("Kowalski", employeesWithKowalskiLastname.get(1).getLastname());

        //CleanUp
        for (Employee employee : employees) {
            employeeDao.delete(employee);
        }
    }

    @Test
    void testFindCompaniesByFirstThreeCharacters() {
        //Given
        List<Employee> employees = createEmployees();
        List<Company> companies = createCompanies();
        createRelationsBetweenEmployeesAndCompanies(employees, companies);;

        for(Company company : companies) {
            companyDao.save(company);
        }

        //When
        List<Company> companiesWithFirstThreeCharactersKOT = companyDao.retrieveCompaniesWithTheSameFirstThreeCharacters("Kot");

        //Then
        Assertions.assertEquals(2, companiesWithFirstThreeCharactersKOT.size());
        Assertions.assertEquals("KotBury", companiesWithFirstThreeCharactersKOT.get(0).getName());
        Assertions.assertEquals("KotaraTeatralna", companiesWithFirstThreeCharactersKOT.get(1).getName());

        //CleanUp
        for(Company company : companies) {
            companyDao.delete(company);
        }
    }

    private List<Employee> createEmployees() {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Krzysztof", "Kowalski"));
        employees.add(new Employee("Marcin", "Kowalski"));
        employees.add(new Employee("Maciej", "Nowak"));
        employees.add(new Employee("Adrian", "Puchacki"));
        employees.add(new Employee("Monika", "Nowak"));
        employees.add(new Employee("Monika", "Nowak"));
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
