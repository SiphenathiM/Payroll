package ac.za.cput.service.implement;

import ac.za.cput.domain.Employee;
import ac.za.cput.repository.EmployeeRepository;
import ac.za.cput.repository.implement.EmployeeRepositoryImpl;
import ac.za.cput.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class EmployeeServiceImpl implements EmployeeService {


    public static EmployeeServiceImpl service = null;
    private EmployeeRepository repository;

    private EmployeeServiceImpl(){
        this.repository= EmployeeRepositoryImpl.getRepository();
    }

    public static EmployeeServiceImpl getService(){
        if(service == null) service = new EmployeeServiceImpl();
        return service;
    }

    @Override
    public Set<Employee> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Employee create(Employee employee) {
        return this.repository.create(employee);
    }

    @Override
    public Employee update(Employee employee) {
        return this.repository.update(employee);
    }

    @Override
    public void delete(String employee) {
        repository.delete(employee);
    }

    @Override
    public Employee read(String employee) {
        return this.repository.read(employee);
    }
}
