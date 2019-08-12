package ac.za.cput.service.implement;

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
public class EmployeeServiceImplTest {

    private  EmployeeServiceImpl service;
    private Employee employee;

    @Before
    public void setUp() throws Exception {
        this.service = (EmployeeServiceImpl) EmployeeServiceImpl.getService();
        this.employee = EmployeeFactory.getEmpName( "Nathi","Mpe" );
    }

    @Test
    public void getAll() {
        Set<Employee> employee = this.service.getAll();
        System.out.println("Fetch employee," + employee);
    }

    @Test
    public void create() {
        Employee created = this.service.create(this.employee);
        System.out.println("the create, done =" + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.employee);
    }

    @Test
    public void update() {
        String newEmpId = "Sp23";
        Employee updated = new Employee.Builder().id(newEmpId).build();
        System.out.println("the update, done = " + updated );
        this.service.update(updated);
        Assert.assertEquals(newEmpId,updated.getId());
        getAll();
    }

    @Test
    public void delete() {
        this.service.delete( employee.getId() );
        getAll();
    }

    @Test
    public void read() {
        Employee read = this.service.read(employee.getId());
        System.out.println("the read, read = " + read);
        getAll();
        assertNotSame(read,employee);
    }

}