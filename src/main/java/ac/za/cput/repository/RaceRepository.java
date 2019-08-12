package ac.za.cput.repository;

import ac.za.cput.domain.Race;

import java.util.Set;

public interface RaceRepository extends IRepository< Race, String > {
    Set<Race> getAll();
}
