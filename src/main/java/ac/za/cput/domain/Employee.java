package ac.za.cput.domain;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import java.util.Objects;
@EntityScan
public class Employee {

    private String id, empName, empSurname;

    private Employee(){}

    public String getId() {
        return id;
    }

    public String getEmpName() {
        return empName;
    }

    public String getEmpSurname() {
        return empSurname;
    }

    public Employee(Builder builder){

        this.id= builder.id;
        this.empName=builder.empName;
        this.empSurname=builder.empSurname;
    }

    public static class Builder {

        private String id, empName, empSurname;

        public Builder id(String id){
            this.id = id;
            return this;
        }

        public Builder empName(String empName){
            this.empName = empName;
            return this;
        }

        public Builder empSurname(String empSurname){
            this.empSurname = empSurname;
            return this;
        }

        public Builder copy (Employee employee){
            this.id = employee.id;
            this.empName = employee.empName;
            this.empSurname = employee.empSurname;
            return this;
        }

        public Employee build(){
            return new Employee( this );
        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empNumber='" + id + '\'' +
                ", empName='" + empName + '\'' +
                ", empSurname='" + empSurname + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() !=obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return employee.equals(((Employee) obj).getId());
                //empName.equals( employee.empName ) &&
                //empSurname.equals( employee.empSurname );
    }

    @Override
    public int hashCode() {
        return Objects.hash( id );
    }
}
