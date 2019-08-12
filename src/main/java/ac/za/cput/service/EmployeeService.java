package ac.za.cput.service;

import ac.za.cput.domain.Employee;

import java.util.Set;

public interface EmployeeService extends IService < Employee,String > {

    Set<Employee> getAll();
}
