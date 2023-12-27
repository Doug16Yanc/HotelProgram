package entities.persons;

import java.util.Date;

class Individual extends Person {
    private String ssn;
    private Date birthday;
    private String nationality;

    public Individual(int id, String name, String address, String email, String origin,
                      String ssn, Date birthday, String nationality) {
        super(id, name, address, email, origin);
        this.ssn = ssn;
        this.birthday = birthday;
        this.nationality = nationality;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}