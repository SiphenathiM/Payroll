package ac.za.cput.service.implement;

import ac.za.cput.domain.Race;
import ac.za.cput.repository.RaceRepository;
import ac.za.cput.repository.implement.RaceRepositoryImpl;
import ac.za.cput.service.RaceService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class RaceServiceImpl implements RaceService {


    public static RaceServiceImpl service = null;
    private RaceRepository repository;

    private RaceServiceImpl(){
        this.repository= RaceRepositoryImpl.getRepository();
    }
    public static RaceServiceImpl getService(){
        if(service == null) service = new RaceServiceImpl();
        return service;
    }

    @Override
    public Set<Race> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Race create(Race race) {
        return this.repository.create(race);
    }

    @Override
    public Race update(Race race) {
        return this.repository.update(race);
    }

    @Override
    public void delete(String race) {
        repository.delete(race);
    }

    @Override
    public Race read(String race) {
        return this.repository.read(race);
    }

}
