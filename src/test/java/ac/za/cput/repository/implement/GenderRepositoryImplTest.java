package ac.za.cput.repository.implement;

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
public class GenderRepositoryImplTest {

    private GenderRepositoryImpl repository;
    private Gender gender;

    @Before
    public void setUp() throws Exception {
        this.repository = (GenderRepositoryImpl) GenderRepositoryImpl.getRepository();
        this.gender = GenderFactory.getGender( "Male" );
    }

    @Test
    public void getAll() {
        Set< Gender > gender = this.repository.getAll();
        System.out.println( "In get all," + gender );
    }

    @Test
    public void create() {
        Gender created = this.repository.create( this.gender );
        System.out.println( "the create, done =" + created );
        Assert.assertNotNull( created );
        Assert.assertSame( created, this.gender );
    }

    @Test
    public void update() {

        String newGenderId = "002345";
        Gender updated = new Gender.Builder().id( newGenderId ).build();
        System.out.println( "the update, done = " + updated );
        this.repository.update( updated );
        Assert.assertEquals( newGenderId, updated.getId() );
        getAll();
    }

    @Test
    public void delete() {
        this.repository.delete( gender.getId() );
        getAll();
    }

    @Test
    public void read() {
        Gender read = this.repository.read( gender.getId() );
        System.out.println( "the read, read = " + read );
        getAll();
        assertNotSame( read, gender );
    }

}