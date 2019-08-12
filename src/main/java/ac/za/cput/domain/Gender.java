package ac.za.cput.domain;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import java.util.Objects;
@EntityScan
public class Gender {
    private String id, genderType;

    private Gender() {
    }

    public String getGenderType() {
        return genderType;
    }

    public String getId() {
        return id;
    }

    public Gender(Builder builder) {

        this.id = builder.id;
        this.genderType = builder.genderType;
    }

    public static class Builder {

        private String id, genderType;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder genderType(String genderType) {
            this.genderType = genderType;
            return this;
        }


        public Builder copy(Gender gender) {
            this.genderType = gender.genderType;
            this.id = gender.id;
            return this;
        }

        public Gender build() {
            return new Gender( this );
        }
    }

    @Override
    public String toString() {
        return "Gender{" +
                "id='" + id + '\'' +
                ", genderType='" + genderType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Gender)) return false;
        Gender gender = (Gender) o;
        return id.equals( gender.id ) &&
                genderType.equals( gender.genderType );
    }

    @Override
    public int hashCode() {
        return Objects.hash( id, genderType );
    }
}