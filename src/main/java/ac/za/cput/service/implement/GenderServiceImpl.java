package ac.za.cput.service.implement;

import ac.za.cput.domain.Gender;
import ac.za.cput.repository.GenderRepository;
import ac.za.cput.repository.implement.GenderRepositoryImpl;
import ac.za.cput.service.GenderService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class GenderServiceImpl implements GenderService {


    public static GenderServiceImpl service = null;
    private GenderRepository repository;

    private GenderServiceImpl(){
        this.repository= GenderRepositoryImpl.getRepository();
    }
    public static GenderServiceImpl getService(){
        if(service == null) service = new GenderServiceImpl();
        return service;
    }

    @Override
    public Set<Gender> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Gender create(Gender gender) {
        return this.repository.create(gender);
    }

    @Override
    public Gender update(Gender gender) {
        return this.repository.update(gender);
    }

    @Override
    public void delete(String gender) {
        repository.delete(gender);
    }

    @Override
    public Gender read(String gender) {
        return this.repository.read(gender);
    }
}
