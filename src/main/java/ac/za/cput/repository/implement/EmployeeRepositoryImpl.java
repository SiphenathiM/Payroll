package ac.za.cput.repository.implement;

import ac.za.cput.domain.Employee;
import ac.za.cput.repository.EmployeeRepository;

import java.util.HashSet;
import java.util.Set;

public class EmployeeRepositoryImpl implements EmployeeRepository {


    public static EmployeeRepositoryImpl repository = null;
    private Set< Employee > employee;

    private EmployeeRepositoryImpl() {
        employee = new HashSet<>();
    }

    private Employee findEmployee(String Id){
        return this.employee.stream()
                .filter( employee -> employee.getId().trim().equals( Id ) )
                .findAny()
                .orElse( null );
    }

    public static EmployeeRepository getRepository(){
        if (repository == null) repository = new EmployeeRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Employee> getAll() {
        return this.employee;
    }

    @Override
    public Employee create(Employee employee) {
        this.employee.add( employee );
        return employee;
    }

    @Override
    public Employee update(Employee employee) {
        Employee toUpdate = findEmployee( employee.getId() );
        if(toUpdate != null){
            this.employee.remove( toUpdate );
            return create( employee );
        }
        return null;

    }

    public void delete(Double aDouble) {

    }

    public Employee read(Double aDouble) {
        return null;
    }

    public void delete(String Id) {
        Employee airtime = findEmployee( Id );
        if(airtime != null) this.employee.remove( employee );
    }

    public Employee read(String Id) {
        Employee employee = findEmployee( Id );
        return employee;
    }
}
