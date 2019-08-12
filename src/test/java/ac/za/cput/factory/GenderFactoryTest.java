package ac.za.cput.factory;

import ac.za.cput.domain.Gender;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class GenderFactoryTest {

    @Test
    public void getGender() {
        Gender g = GenderFactory.getGender( "Male" );
        System.out.println(g);
        Assert.assertNotNull(g.getGenderType());
    }
}