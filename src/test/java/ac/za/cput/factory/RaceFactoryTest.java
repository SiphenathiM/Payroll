package ac.za.cput.factory;

import ac.za.cput.domain.Race;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RaceFactoryTest {

    @Test
    public void getRaceName() {
        Race r = RaceFactory.getRaceName( "Black" );
        System.out.println(r);
        Assert.assertNotNull(r.getRaceName());
    }
}