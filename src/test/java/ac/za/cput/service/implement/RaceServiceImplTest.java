package ac.za.cput.service.implement;

import ac.za.cput.domain.Race;
import ac.za.cput.factory.RaceFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class RaceServiceImplTest {

    private RaceServiceImpl service;
    private Race race;

    @Before
    public void setUp() throws Exception {
        this.service= RaceServiceImpl.getService();
        this.race = RaceFactory.getRaceName( "Black" );
    }
    @Test
    public void getAll() {
        Set<Race> races = this.service.getAll();
        System.out.println("In get all," + races);
    }

    @Test
    public void create() {
        Race created = this.service.create(this.race);
        System.out.println("the create, done =" + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.race);
    }

    @Test
    public void update() {
        String newRaceId = "sp23";
        Race updated = new Race.Builder().id(newRaceId).build();
        System.out.println("the update, done = " + updated );
        this.service.update(updated);
        Assert.assertEquals(newRaceId,updated.getId());
        getAll();
    }

    @Test
    public void delete() {
        this.service.delete(race.getId());
        getAll();
    }

    @Test
    public void read() {
        Race read = this.service.read(race.getId());
        System.out.println("the read, read = " + read);
        getAll();
        assertNotSame(read,race);
    }
}