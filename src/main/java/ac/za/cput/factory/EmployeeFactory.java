package ac.za.cput.factory;

import ac.za.cput.domain.Employee;
import ac.za.cput.util.Misc;

public class EmployeeFactory {

    public static Employee getEmpName(String empName,String empSurname) {
        return new Employee.Builder()
                .empName(empName)
                .empSurname(empSurname)
                .id( Misc.generateId())
                .build();
    }
}
