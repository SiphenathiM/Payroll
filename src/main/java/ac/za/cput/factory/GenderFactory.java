package ac.za.cput.factory;

import ac.za.cput.domain.Gender;
import ac.za.cput.util.Misc;

public class GenderFactory {

    public static Gender getGender(String genderType) {
        return new Gender.Builder()
                .genderType(genderType)
                .id( Misc.generateId())
                .build();
    }
}

