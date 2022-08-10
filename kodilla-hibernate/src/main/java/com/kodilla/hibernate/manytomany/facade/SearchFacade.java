package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchFacade {
    private static final Logger LOGGER = LoggerFactory.getLogger(SearchFacade.class);
    private final CompanyDao companyDao;
    private final EmployeeDao employeeDao;

    @Autowired
    public SearchFacade(CompanyDao companyDao, EmployeeDao employeeDao) {
        this.companyDao = companyDao;
        this.employeeDao = employeeDao;
    }

    public void processSearch(final String partOfName) throws SearchProcessingException {
        List<Employee> foundEmployees = employeeDao.retrieveEmployeesByShortPartOfName(partOfName);
        List<Company> foundCompanies = companyDao.retrieveCompaniesByShortPartOfName(partOfName);

        if (foundEmployees.size() == 0 && foundCompanies.size() == 0) {
            LOGGER.warn("Nothing founded");
            throw new SearchProcessingException(SearchProcessingException.ERR_NOTHING_FOUND);
        }
        printEmployees(foundEmployees);
        printCompanies(foundCompanies);
    }

    private void printCompanies(List<Company> foundCompanies) {
        if (foundCompanies.size() > 0) {
            System.out.println("Found companies:");
            for (Company company: foundCompanies) {
                System.out.println(company.getName());
            }
        } else {
            System.out.println("Didn't find companies");
        }
    }

    private void printEmployees(List<Employee> foundEmployees) {
        if (foundEmployees.size() > 0) {
            System.out.println("Found employees:");
            for (Employee employee: foundEmployees) {
                System.out.println(employee.getFirstname() + " " +
                        employee.getLastname());
            }
        } else {
            System.out.println("Didn't find employees");
        }
    }
}
