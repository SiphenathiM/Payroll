package ac.za.cput.repository.implement;

import ac.za.cput.domain.Gender;
import ac.za.cput.repository.GenderRepository;

import java.util.HashSet;
import java.util.Set;

public class GenderRepositoryImpl implements GenderRepository {

        public static GenderRepositoryImpl repository = null;
        private Set< Gender > gender;

        private GenderRepositoryImpl() {
            gender = new HashSet<>();
        }

        private Gender findGender(String Id){
            return this.gender.stream()
                    .filter( gender -> gender.getId().trim().equals( Id ) )
                    .findAny()
                    .orElse( null );
        }

        public static GenderRepository getRepository(){
            if (repository == null) repository = new GenderRepositoryImpl();
            return repository;
        }

        @Override
        public Set<Gender> getAll() {
            return this.gender;
        }

        @Override
        public Gender create(Gender gender) {
            this.gender.add( gender );
            return gender;
        }

        @Override
        public Gender update(Gender gender) {
            Gender toUpdate = findGender( gender.getId() );
            if(toUpdate != null){
                this.gender.remove( toUpdate );
                return create( gender );
            }
            return null;

        }

        public void delete(Double aDouble) {

        }

        public Gender read(Double aDouble) {
            return null;
        }

        public void delete(String Id) {
            Gender gender = findGender( Id );
            if(gender != null) this.gender.remove( gender );
        }

        public Gender read(String Id) {
            Gender gender = findGender( Id );
            return gender;
        }
}
