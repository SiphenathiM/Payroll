package ac.za.cput.repository.implement;

import ac.za.cput.domain.Employee;
import ac.za.cput.factory.EmployeeFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeRepositoryImplTest {

    private  EmployeeRepositoryImpl repository;
    private Employee employee;

    @Before
    public void setUp() throws Exception {
        this.repository = (EmployeeRepositoryImpl) EmployeeRepositoryImpl.getRepository();
        this.employee = EmployeeFactory.getEmpName( "Nathi" ,"Mpe");
    }

    @Test
    public void getAll() {
        Set<Employee> employee = this.repository.getAll();
        System.out.println("Fetch employee," + employee);
    }

    @Test
    public void create() {
        Employee created = this.repository.create(this.employee);
        System.out.println("the create, done =" + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.employee);
    }

    @Test
    public void update() {
        String newEmpId = "Sp23";
        Employee updated = new Employee.Builder().id(newEmpId).build();
        System.out.println("the update, done = " + updated );
        this.repository.update(updated);
        Assert.assertEquals(newEmpId,updated.getId());
        getAll();
    }

    @Test
    public void delete() {
        this.repository.delete( employee.getId() );
        getAll();
    }

    @Test
    public void read() {
        Employee read = this.repository.read(employee.getId());
        System.out.println("the read, read = " + read);
        getAll();
        assertNotSame(read,employee);
    }

}