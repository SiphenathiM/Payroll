package ac.za.cput.service;

import ac.za.cput.domain.Race;

import java.util.Set;

public interface RaceService extends IService< Race,String > {
    Set<Race> getAll();
}
