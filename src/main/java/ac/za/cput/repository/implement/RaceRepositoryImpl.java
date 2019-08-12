package ac.za.cput.repository.implement;

import ac.za.cput.domain.Race;
import ac.za.cput.repository.RaceRepository;

import java.util.HashSet;
import java.util.Set;

public class RaceRepositoryImpl implements RaceRepository {

    public static RaceRepositoryImpl repository = null;
    private Set< Race > race;

    private RaceRepositoryImpl() {
        race = new HashSet<>();
    }

    private Race findRace(String Id){
        return this.race.stream()
                .filter( race -> race.getId().trim().equals( Id ) )
                .findAny()
                .orElse( null );
    }

    public static RaceRepository getRepository(){
        if (repository == null) repository = new RaceRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Race> getAll() {
        return this.race;
    }

    @Override
    public Race create(Race race) {
        this.race.add( race );
        return race;
    }

    @Override
    public Race update(Race race) {
        Race toUpdate = findRace( race.getId() );
        if(toUpdate != null){
            this.race.remove( toUpdate );
            return create( race );
        }
        return null;

    }

    public void delete(Double aDouble) {

    }

    public Race read(Double aDouble) {
        return null;
    }

    public void delete(String Id) {
        Race race = findRace( Id );
        if(race != null) this.race.remove( race );
    }

    public Race read(String Id) {
        Race race = findRace( Id );
        return race;
    }

}

