package ac.za.cput.service.implement;

import ac.za.cput.domain.Gender;
import ac.za.cput.factory.GenderFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GenderServiceImplTest {

    private GenderServiceImpl service;
    private Gender gender;

    @Before
    public void setUp() throws Exception {
        this.service = (GenderServiceImpl) GenderServiceImpl.getService();
        this.gender = GenderFactory.getGender( "Male" );
    }

    @Test
    public void getAll() {
        Set< Gender > gender = this.service.getAll();
        System.out.println( "In get all," + gender );
    }

    @Test
    public void create() {
        Gender created = this.service.create( this.gender );
        System.out.println( "the create, done =" + created );
        Assert.assertNotNull( created );
        Assert.assertSame( created, this.gender );
    }

    @Test
    public void update() {

        String newGenderId = "002345";
        Gender updated = new Gender.Builder().id( newGenderId ).build();
        System.out.println( "the update, done = " + updated );
        this.service.update( updated );
        Assert.assertEquals( newGenderId, updated.getId() );
        getAll();
    }

    @Test
    public void delete() {
        this.service.delete( gender.getId() );
        getAll();
    }

    @Test
    public void read() {
        Gender read = this.service.read( gender.getId() );
        System.out.println( "the read, read = " + read );
        getAll();
        assertNotSame( read, gender );
    }
}