package ac.za.cput.factory;

import ac.za.cput.domain.Employee;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeFactoryTest {

    @Test
    public void getEmpName() {
        Employee e = EmployeeFactory.getEmpName( "Siphenathi","Mpetsheni" );
        System.out.println(e);
        Assert.assertNotNull( e.getEmpName() );
    }
}