package entities.persons;

import entities.persons.Person;
import enumerations.PrivilegeLevel;
public class Company extends Person {
    private String ein;

    public Company(){}
    public Company(int id, String name, String address, String email, String origin, PrivilegeLevel privilegeLevel,
                      String ein) {
        super(id, name, address, email, origin, privilegeLevel);
        this.ein = ein;
    }

    public String getEin() {
        return ein;
    }

    public void setEin(String ein) {
        this.ein = ein;
    }
}
