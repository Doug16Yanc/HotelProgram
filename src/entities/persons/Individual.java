package entities.persons;

import enumerations.PrivilegeLevel;

import java.util.Date;

public class Individual extends Person {
    private String ssn;
    private String birthday;

    public Individual(){}
    public Individual(int id, String name, String address, String email, String origin, PrivilegeLevel privilegeLevel,
                      String ssn, String birthday) {
        super(id, name, address, email, origin, privilegeLevel);
        this.ssn = ssn;
        this.birthday = birthday;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

}