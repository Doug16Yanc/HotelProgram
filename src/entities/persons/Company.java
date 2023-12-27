package entities.persons;

import entities.persons.Person;
import lombok.Data;

@Data
public class Company extends Person {
    private String ein;
    public Company(int id, String name, String address, String email, String origin,
                      String ein) {
        super(id, name, address, email, origin);
        this.ein = ein;
    }
}
