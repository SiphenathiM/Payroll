package ac.za.cput.domain;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import java.util.Objects;
@EntityScan
public class Race {

    private String id, raceName;

    private Race() {
    }

    public String getId() {
        return id;
    }

    public String getRaceName() {
        return raceName;
    }

    public Race(Builder builder) {

        this.id = builder.id;
        this.raceName = builder.raceName;
    }

    public static class Builder {

        private String id, raceName;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder raceName(String raceName) {
            this.raceName = raceName;
            return this;
        }

        public Builder copy(Race race) {
            this.id = race.id;
            this.raceName = race.raceName;
            return this;
        }

        public Race build() {
            return new Race( this );
        }
    }

    @Override
    public String toString() {
        return "Race{" +
                "id='" + id + '\'' +
                ", raceName='" + raceName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Race race = (Race) o;
        return id.equals( race.id ) &&
                raceName.equals( race.raceName );
    }

    @Override
    public int hashCode() {
        return Objects.hash( id, raceName );
    }
}